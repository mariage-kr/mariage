import styled from '@emotion/styled';

const Container = styled.div`
  height: 400px;
`;

const LoadingAnimation = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  height: 400px;

  flex-direction: column;

  scale: calc(1.5);
`;

const NoProductsAnimation = styled.div`
  width: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
  height: 400px;

  flex-direction: column;
`;

const AniWrapper = styled.div`
  width: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
`;

const Text = styled.p`
  margin-top: 175px;
  font-size: 1.6rem;
`;

export { Container, LoadingAnimation, NoProductsAnimation, AniWrapper, Text };
