import { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';

import { ProductDetailType } from '@/@types/product';
import { requestProductDetailInfo } from '@/apis/request/product';
import ProductContent from '@/components/Detail/ProductContent/ProductContent';
import Pairing from '@/components/Detail/Pairing/Pairing';
import Review from '@/components/Detail/Review/Review';

import * as S from './Detail.styled';

function Detail() {
  const productId: string = useParams().id!;
  const [detailData, setDetailData] = useState<ProductDetailType>();
  const [loading, setLoading] = useState(false);

  const fetchDetailData = () => {
    setLoading(true);
    requestProductDetailInfo(productId)
      .then(data => {
        setDetailData(data);
      })
      .catch(error => {
        console.error('요청한 정보를 가져올 수 없습니다.', error);
      })
      .finally(() => {
        setLoading(false);
      });
  };

  useEffect(() => {
    const toTop = () => {
      window.scroll({
        top: 0,
      });
    };
    toTop();
    fetchDetailData();
  }, []);

  if (loading) {
    return;
  }

  return (
    <S.Container>
      {detailData && (
        <>
          <ProductContent {...detailData.content} />
          <Pairing
            foodCountRanking={detailData.foodCountRanking}
            foodRateRanking={detailData.foodRateRanking}
          />
          <Review
            id={detailData.productId}
            name={detailData.content.name}
            level={detailData.content.level}
            country={detailData.content.country}
            countryId={detailData.content.countryId}
            rating={detailData.rating}
          />
        </>
      )}
    </S.Container>
  );
}

export default Detail;
