import { ProductContentType, ProductDetailType } from '@/@types/product';
import { axios } from '@/apis/axios';

import ProductContent from '@/components/Detail/ProductContent/ProductContent';
import Pairing from '@/components/Detail/Pairing/Pairing';
import Review from '@/components/Detail/Review/Review';

import * as S from './Detail.styled';
import { useState, useEffect } from 'react';

function Detail() {
  const [detailData, setDetailData] = useState<ProductDetailType>();
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    const fetchDetailData = () => {
      setLoading(true);
      axios
        .get('/api/product/detail/3')
        .then(response => {
          setDetailData(response.data);
        })
        .catch(error => {
          console.error('요청한 정보를 가져올 수 없습니다.', error);
        })
        .finally(() => {
          setLoading(false);
        });
    };
    fetchDetailData();
  }, []);
  const productData: ProductContentType = {
    id: 1,
    img: 'https://i.esdrop.com/d/f/CeyD9bnnT5/9XYNAZN4ZB.png',
    flagImg: 'https://i.esdrop.com/d/f/CeyD9bnnT5/OT0QaqYDkx.png',
    country: 'Japan',
    name: '산토리 위스키 가쿠빈 :suntory whisky kakubin',
    level: 40.0,
    reviewRate: 4.6,
    content:
      '생산량 순위에서 압도적인 1위를 차지하는 일본의 가장 대중적인 위스키 중 하나로 야마자키와 하쿠슈 증류소의 몰트 위스키 원주와 자체 생산한 그레인 위스키와 배합하여 생산한다. 주로 미즈와리나 하이볼용으로 사용된다. 0000 0000 000000 00000 000000 00000000',
  };
  console.log(detailData);
  if (loading) {
    return <p>로딩중입니다.</p>;
  }
  return (
    <S.Container>
      <ProductContent {...detailData} />
      <Pairing />
      <Review {...productData} />
    </S.Container>
  );
}

export default Detail;
