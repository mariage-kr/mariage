package com.multi.mariage.member.service;

import com.multi.mariage.auth.vo.AuthMember;
import com.multi.mariage.member.domain.Member;
import com.multi.mariage.member.domain.MemberRepository;
import com.multi.mariage.member.dto.response.MyInfoResponse;
import com.multi.mariage.member.dto.response.NicknameResponse;
import com.multi.mariage.member.exception.MemberErrorCode;
import com.multi.mariage.member.exception.MemberException;
import com.multi.mariage.storage.domain.Image;
import com.multi.mariage.storage.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class MemberFindService {

    private final MemberRepository memberRepository;
    private final StorageService storageService;

    public Member findById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new MemberException(MemberErrorCode.MEMBER_IS_NOT_EXISTED));
    }

    public MyInfoResponse findMemberInfo(AuthMember authMember) {
        Member member = findById(authMember.getId());
        String imageName = getImageName(member.getImage());

        String filePath = storageService.getFilePath(imageName);
        return MyInfoResponse.from(member, filePath);
    }

    private String getImageName(Image image) {
        return image != null ? image.getName() : "profile.png";
    }

    public NicknameResponse findMemberNickname(AuthMember authMember) {
        Member member = findById(authMember.getId());
        return new NicknameResponse(member.getNickname());
    }
}
