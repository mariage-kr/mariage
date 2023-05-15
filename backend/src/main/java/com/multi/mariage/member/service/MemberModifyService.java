package com.multi.mariage.member.service;

import com.multi.mariage.auth.vo.AuthMember;
import com.multi.mariage.member.domain.Member;
import com.multi.mariage.member.domain.MemberRepository;
import com.multi.mariage.member.domain.embedded.Email;
import com.multi.mariage.member.domain.embedded.Name;
import com.multi.mariage.member.domain.embedded.Nickname;
import com.multi.mariage.member.domain.embedded.Password;
import com.multi.mariage.member.dto.request.MemberSignupRequest;
import com.multi.mariage.member.dto.request.UpdateNicknameRequest;
import com.multi.mariage.member.dto.request.UpdatePasswordRequest;
import com.multi.mariage.member.dto.response.UpdateImageResponse;
import com.multi.mariage.member.dto.response.UpdateNicknameResponse;
import com.multi.mariage.member.exception.MemberErrorCode;
import com.multi.mariage.member.exception.MemberException;
import com.multi.mariage.storage.domain.Image;
import com.multi.mariage.storage.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Transactional
@Service
public class MemberModifyService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final StorageService storageService;
    private final MemberFindService memberFindService;

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

    public void withdrawalByMember(AuthMember authMember) {
        Member member = memberFindService.findById(authMember.getId());
        memberRepository.delete(member);
    }

    public UpdateImageResponse updateImage(AuthMember authMember, MultipartFile file) {
        Member member = memberFindService.findById(authMember.getId());

        if (hasImage(member)) {
            remove(member);
        }

        Image image = storageService.save(file);
        member.updateImage(image);

        String filePath = storageService.getFilePath(image.getName());
        return new UpdateImageResponse(filePath);
    }

    public void removeImage(AuthMember authMember) {
        Member member = memberFindService.findById(authMember.getId());

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

    public UpdateNicknameResponse updateNickname(AuthMember authMember, UpdateNicknameRequest request) {
        Member member = memberFindService.findById(authMember.getId());
        Nickname nickname = Nickname.of(request.getNickname());

        member.updateNickname(nickname);

        return UpdateNicknameResponse.from(member);
    }

    public void updatePassword(AuthMember authMember, UpdatePasswordRequest request) {
        validateSamePassword(request);

        Member member = memberFindService.findById(authMember.getId());
        confirmPassword(member, request.getPassword());

        member.updatePassword(Password.encrypt(request.getNewPassword(), passwordEncoder));
    }

    private void confirmPassword(Member member, String password) {
        if (passwordEncoder.matches(password, member.getPassword())) {
            return;
        }
        throw new MemberException(MemberErrorCode.MEMBER_WRONG_PASSWORD);
    }

    private void validateSamePassword(UpdatePasswordRequest request) {
        if (request.getPassword().equals(request.getNewPassword())) {
            throw new MemberException(MemberErrorCode.MEMBER_PASSWORD_IS_SAME);
        }
    }
}
