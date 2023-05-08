import * as S from './SearchFilter.styled';
import SelectBox from './SelectBox/SelectBox';
import RangeMultiSlider_M_Star from '@/components/RangeMultiSlider_M/RangeMultiSlider_M_Star';
import RangeMultiSlider_M_ABV from '@/components/RangeMultiSlider_M/RangeMultiSlider_M_ABV';

function SearchFilter() {
  return (
    <S.Container>
      <S.Wrapper>
        <S.Inner>
          <S.Left>
            <S.Drinks>
              <S.FilterTitle>주종</S.FilterTitle>
              <SelectBox/>
            </S.Drinks>
          </S.Left>
          <S.Right>
            <S.StarRate>
              <S.FilterTitle css={S.FilterTitle2}>별점</S.FilterTitle>
              <S.RangeMultiSlider>
                <RangeMultiSlider_M_Star
                  min={0}
                  max={50}
                  onChange={({ min, max }: { min: number; max: number }) =>
                    console.log(`min = ${min}, max = ${max}`)
                  }
                />
              </S.RangeMultiSlider>
            </S.StarRate>
            <S.ABV>
              <S.FilterTitle css={S.FilterTitle2}>도수</S.FilterTitle>
              <S.RangeMultiSlider>
                <RangeMultiSlider_M_ABV
                  min={0}
                  max={70}
                  onChange={({ min, max }: { min: number; max: number }) =>
                    console.log(`min = ${min}, max = ${max}`)
                  }
                />
              </S.RangeMultiSlider>
            </S.ABV>
          </S.Right>
        </S.Inner>
        <S.Bottom>
          <S.FindButton type={'submit'}>Find</S.FindButton>
        </S.Bottom>
      </S.Wrapper>
    </S.Container>
  );
}

export default SearchFilter;