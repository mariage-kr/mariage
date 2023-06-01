import styled from '@emotion/styled';

const Container = styled.div`
  display: flex;
  justify-content: space-between;
  width: 80%;
  margin: 50px auto;

  @media (max-width: 1000px) {
    flex-flow: wrap;
  }
`;

const AniWrapper = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;

  scale: calc(1);
`;

const Aside = styled.div`
  width: 20%;
  min-width: 300px;

  @media (max-width: 1200px) {
    min-width: 250px;
  }

  @media (max-width: 1000px) {
    width: 100%;
    margin: 0;
  }
`;

const Contents = styled.div`
  position: relative;
  width: 75%;

  @media (max-width: 1000px) {
    width: 100%;
    margin: 50px 0;
  }
`;

const Count = styled.p`
  margin-top: 0;
  font-size: 0.9rem;
`;

const Color = styled.span`
  font-size: 0.9rem;
  color: #bb2649;
`;

const ContentHeaderWrapper = styled.div`
  display: flex;
`;

const ContentWrapper = styled.div`
  margin-top: -20px;
`;

const Target = styled.div`
  border: 1px solid red;
  height: 30px;
`;

export {
  Container,
  AniWrapper,
  Aside,
  Contents,
  Count,
  Color,
  ContentHeaderWrapper,
  ContentWrapper,
  Target,
};
