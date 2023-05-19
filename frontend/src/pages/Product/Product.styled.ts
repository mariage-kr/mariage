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

const Aside = styled.div`
  width: 20%;
  min-width: 300px;
  margin: 0 20px;

  @media (max-width: 1200px) {
    min-width: 200px;
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

export { Container, Aside, Contents };
