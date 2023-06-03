import styled from '@emotion/styled';
import { Link } from 'react-router-dom';

type Props = {
  timer: number;
};

const Container = styled.div`
  position: fixed;
  z-index: 10000;

  display: flex;
  align-items: center;
  justify-content: center;

  bottom: 5%;
  left: 50%;
  transform: translateX(-50%);

  border-radius: 7px;

  padding: 0 3rem;

  background: #bb2329;
  opacity: 0;

  text-align: center;

  @keyframes show {
    0% {
      opacity: 0;
    }

    50% {
      opacity: 1;
    }

    75% {
      opacity: 1;
    }

    100% {
      opacity: 0;
    }
  }

  animation: show 3.5s;
`;

const Text = styled.p`
  color: #fff;
  font-size: 1.1rem;
`;

const LinkText = styled(Link)`
  color: #fff;
  font-size: 1.1rem;

  margin-left: 1rem;

  text-decoration: none;
`;

const BtnText = styled.div`
  color: #fff;
  font-size: 1.1rem;

  margin-left: 1rem;

  cursor: pointer;
`;

export { Container, Text, LinkText, BtnText };
