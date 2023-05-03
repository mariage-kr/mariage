package com.multi.mariage.member.service;

import com.multi.mariage.auth.dto.AuthMember;
import com.multi.mariage.member.domain.Member;
import com.multi.mariage.member.domain.MemberRepository;
import com.multi.mariage.member.domain.embedded.Email;
import com.multi.mariage.member.domain.embedded.Name;
import com.multi.mariage.member.domain.embedded.Nickname;
import com.multi.mariage.member.domain.embedded.Password;
import com.multi.mariage.member.dto.request.MemberSignupRequest;
import com.multi.mariage.member.dto.request.UpdateNicknameRequest;
import com.multi.mariage.member.dto.response.UpdateImageResponse;
import com.multi.mariage.member.dto.response.UpdateNicknameResponse;
import com.multi.mariage.member.exception.MemberErrorCode;
import com.multi.mariage.member.exception.MemberException;
import com.multi.mariage.storage.domain.Image;
import com.multi.mariage.storage.service.StorageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final StorageService storageService;

    @Transactional
    public Member signup(MemberSignupRequest request) {
        Email email = Email.of(request.getEmail());

        validateEmailIsNotDuplicated(email);

        Member member = Member.builder()
                .name(Name.of(request.getName()))
                .email(email)
                .password(Password.encrypt(request.getPassword(), passwordEncoder))
                .nickname(Nickname.of(request.getNickname()))
                .birth(request.getBirth())
                .build();

        return memberRepository.save(member);
    }

    private void validateEmailIsNotDuplicated(Email email) {
        if (memberRepository.existsByEmail(email)) {
            throw new MemberException(MemberErrorCode.SIGNUP_INVALID_EMAIL);
        }
    }

    @Transactional
    public void withdrawalByMember(AuthMember authMember) {
        Member member = findById(authMember.getId());
        memberRepository.delete(member);
    }

    private Member findById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new MemberException(MemberErrorCode.MEMBER_IS_NOT_EXISTED));
    }

    @Transactional
    public UpdateImageResponse updateImage(AuthMember authMember, MultipartFile file) {
        Member member = findById(authMember.getId());

        if (hasImage(member)) {
            remove(member);
        }

        Image image = storageService.save(file);
        member.updateImage(image);

        String filePath = storageService.getFilePath(image.getName());
        return new UpdateImageResponse(filePath);
    }

    public void removeImage(AuthMember authMember) {
        Member member = findById(authMember.getId());

        if (hasImage(member)) {
            remove(member);
            return;
        }

        throw new MemberException(MemberErrorCode.MEMBER_HAS_NOT_PROFILE_IMAGE);
    }

    private void remove(Member member) {
        storageService.remove(member.getImage());
        member.updateImage(null);
    }

    private boolean hasImage(Member member) {
        return member.getImage() != null;
    }

    @Transactional
    public UpdateNicknameResponse updateNickname(AuthMember authMember, UpdateNicknameRequest request) {
        Member member = findById(authMember.getId());
        Nickname nickname = Nickname.of(request.getNickname());

        member.updateNickname(nickname);

        return UpdateNicknameResponse.from(member);
    }
}
