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

  scale: calc(4);
`;

const Text = styled.p`
  margin-top: -10px;
  scale: calc(0.25);
`;

export { Container, LoadingAnimation, NoProductsAnimation, Text };
