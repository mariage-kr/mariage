import { useState, useEffect, useRef } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import ReviewList from '@/components/Review/ReviewList';
import { ReviewPageType, reviewProfileType } from '@/@types/review';
import { requestReviewProfile } from '@/apis/request/member';
import { requestLikeReview, requestWriteReview } from '@/apis/request/review';
import useUserInfo from '@/hooks/useUserInfo';
import useIntersectionObserver from '@/hooks/useIntersectionObserver';
import { PagingType } from '@/@types/paging';
import { PAGING } from '@/constants/rule';
import { SORT } from '@/constants/option';
import DataLoading from '@/components/Animation/DataLoading';
import { BROWSER_PATH } from '@/constants/path';
import useSnack from '@/hooks/useSnack';

import * as S from './Review.styled';
import NoReviews from '@/components/NoReviews/NoReviews';

function Review() {
  const queryParam = new URLSearchParams(location.search);
  const navigate = useNavigate();
  const { infoSnackbar } = useSnack();
  const option = queryParam.get('option');
  const [tabMenu, setTabMenu] = useState(0);

  const [reviewProfile, setReviewProfile] = useState<reviewProfileType>({
    nickname: '',
    email: '',
    imagePath: '',
    reviews: 0,
    likes: 0,
  });

  /* 유저 정보 요청 */
  const { id } = useParams();
  const getMyInfo = async (memberId: number) => {
    await requestReviewProfile(memberId)
      .then(response => {
        setReviewProfile(response.data);
      })
      .catch(error => {
        console.log(error);
      });
  };

  useEffect(() => {
    const memberId: number = Number.parseInt(id!);
    getMyInfo(memberId);
  }, [id]);

  // 숫자 데이터 콤마 넣기
  const reviewCount = reviewProfile.reviews
    .toString()
    .replace(/\B(?=(\d{3})+(?!\d))/g, ',');
  const likeCount = reviewProfile.likes
    .toString()
    .replace(/\B(?=(\d{3})+(?!\d))/g, ',');

  /* 페이징 */
  const { userInfo } = useUserInfo();
  const [pageNumber, setPageNumber] = useState<number>(1);
  const [loading, setLoading] = useState<boolean>(false);
  const [hasMore, setHasMore] = useState<boolean>(true);
  const [reviews, setReviews] = useState<PagingType<ReviewPageType>>({
    contents: [],
    pageNumber: 1,
    totalCount: 0,
    totalPages: 0,
    pageSize: PAGING.PAGE_SIZE,
    firstPage: true,
    lastPage: false,
  });
  const memberId: number = Number.parseInt(id!);

  /* 해당 유저의 리뷰 가져오기 */
  const fetchMyReview = async () => {
    if (!hasMore) {
      infoSnackbar('리뷰가 더 이상 존재하지 않습니다.');
      return;
    }
    setLoading(true);
    await requestWriteReview(pageNumber, memberId, userInfo?.id)
      .then(data => {
        setReviews(prev => ({
          ...data,
          contents: [...prev.contents, ...data.contents],
        }));
        setHasMore(data.lastPage === false);
      })
      .finally(() => {
        setLoading(false);
      });
  };

  /* 해당 유저의 좋아요한 리뷰 가져오기 */
  const fetchLikeReview = async () => {
    if (!hasMore) {
      infoSnackbar('리뷰가 더 이상 존재하지 않습니다.');
      return;
    }
    setLoading(true);
    await requestLikeReview(pageNumber, memberId, userInfo?.id)
      .then(data => {
        setReviews(prev => ({
          ...data,
          contents: [...prev.contents, ...data.contents],
        }));
        setHasMore(data.lastPage === false);
      })
      .finally(() => {
        setLoading(false);
      });
  };

  const target = useRef(null);

  const [observe, unobserve] = useIntersectionObserver(() => {
    setPageNumber(prev => prev + 1);
  });

  useEffect(() => {
    if (loading) {
      unobserve(target.current);
    } else {
      observe(target.current);
    }
  }, [loading]);

  useEffect(() => {
    if (option === SORT.REVIEW.LIKE) {
      fetchLikeReview();
    } else {
      fetchMyReview();
    }
  }, [pageNumber]);

  const goReview = (option: string) => {
    navigate(`${BROWSER_PATH.REVIEW}/${id}?option=${option}`);
    window.location.reload();
  };

  return (
    <S.Container>
      <S.TopNav>
        <S.NavWrapper>
          <S.Nav 
            css={option !== SORT.REVIEW.LIKE ? S.ActiveTab : S.LinkStyle}
            onClick={() => goReview(SORT.REVIEW.RATING)}
          >
            작성한 리뷰
          </S.Nav>
          <S.Nav 
            css={option === SORT.REVIEW.LIKE ? S.ActiveTab : S.LinkStyle}
            onClick={() => goReview(SORT.REVIEW.LIKE)}
          >
            좋아요한 리뷰
          </S.Nav>
        </S.NavWrapper>
      </S.TopNav>
      <S.Main>
        <S.Profile>
          <S.ProfileLeft>
            <S.ProfileImg src={reviewProfile.imagePath} />
          </S.ProfileLeft>
          <S.ProfileRight>
            <S.NameEmail css={S.name}>{reviewProfile.nickname}</S.NameEmail>
            <S.NameEmail css={S.email}>#{reviewProfile.email}***</S.NameEmail>
            <S.Reviews>
              <S.Title>Reviews</S.Title>
              <S.Count>{reviewCount}</S.Count>
            </S.Reviews>
            <S.Likes>
              <S.Title>Likes</S.Title>
              <S.Count>{likeCount}</S.Count>
            </S.Likes>
          </S.ProfileRight>
        </S.Profile>
      </S.Main>
      {reviews.contents.length !== 0 ? (
        reviews.contents.map((review: ReviewPageType) => (
          <ReviewList
            key={review.reviewInfo.id}
            reviewInfo={review.reviewInfo}
            productInfo={review.productInfo}
          />
        ))
      ) : (
        <NoReviews />
      )}
      <S.Target ref={target} />
      {loading && (
        <S.AniWrapper>
          <DataLoading />
        </S.AniWrapper>
      )}
    </S.Container>
  );
}

export default Review;
