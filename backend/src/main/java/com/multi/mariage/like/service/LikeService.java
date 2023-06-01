package com.multi.mariage.like.service;

import com.multi.mariage.auth.vo.AuthMember;
import com.multi.mariage.like.domain.Like;
import com.multi.mariage.like.domain.LikeRepository;
import com.multi.mariage.like.dto.request.LikeSaveRequest;
import com.multi.mariage.like.dto.response.LikeCountResponse;
import com.multi.mariage.like.exception.LikeErrorCode;
import com.multi.mariage.like.exception.LikeException;
import com.multi.mariage.member.domain.Member;
import com.multi.mariage.member.service.MemberFindService;
import com.multi.mariage.review.domain.Review;
import com.multi.mariage.review.service.ReviewFindService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class LikeService {
    private final LikeRepository likeRepository;
    private final MemberFindService memberFindService;
    private final ReviewFindService reviewFindService;

    @Transactional
    public LikeCountResponse save(AuthMember authMember, LikeSaveRequest request) {
        Member member = memberFindService.findById(authMember.getId());
        Review review = reviewFindService.findById(request.getReviewId());

        validateReviewAlreadyLiked(authMember.getId(), request.getReviewId());

        Like like = Like.builder()
                .member(member)
                .review(review)
                .build();

        likeRepository.save(like);

        long countByReview = likeRepository.findCountByReview(review);
        return new LikeCountResponse(countByReview);
    }

    @Transactional
    public LikeCountResponse remove(AuthMember authMember, Long reviewId) {
        Like like = likeRepository.findByMemberIdAndReviewId(authMember.getId(), reviewId)
                .orElseThrow(() -> new LikeException(LikeErrorCode.REVIEW_NOT_LIKED));

        Member member = like.getMember();
        Review review = like.getReview();

        member.removeLike(like);
        review.removeLike(like);

        likeRepository.delete(like);

        long countByReview = likeRepository.findCountByReview(review);
        return new LikeCountResponse(countByReview);
    }

    private void validateReviewAlreadyLiked(Long memberId, Long reviewId) {
        boolean isExist = likeRepository.existsByMemberIdAndReviewId(memberId, reviewId);
        if (isExist) {
            throw new LikeException(LikeErrorCode.REVIEW_ALREADY_LIKED);
        }
    }

    public void removeAllByReview(Review review) {
        /* TODO: 2023/06/01 추후 DB에서도 삭제 한다면 이곳에 두고 아니면 review로 이동 */
        review.getLikes().forEach(Like::removeMember);
    }
}
