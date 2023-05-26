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
  display: flex;
  align-items: center;
  justify-content: center;
  height: 400px;

  flex-direction: column;
`;

const AniWrapper = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;

  scale: calc(3);
`;

const Text = styled.p`
  margin-top: 180px;

  font-size: 1.6rem;
`;

export { Container, LoadingAnimation, NoProductsAnimation, AniWrapper, Text };
