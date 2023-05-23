import styled from '@emotion/styled';
import { Link } from 'react-router-dom';

const Container = styled.div`
  display: flex;
  justify-content: center;
  height: 100px;
  border-bottom: 1px solid #00000033;
`;

const Logo = styled.div`
  display: flex;
  width: 10%;
  min-width: 144px;
  position: relative;
  align-items: center;
  justify-content: center;

  @keyframes animate {
  0%,
  100% {
    clip-path: polygon(
      0% 45%,
      16% 44%,
      33% 50%,
      54% 60%,
      70% 61%,
      84% 59%,
      100% 52%,
      100% 100%,
      0% 100%
    );
  }

  50% {
    clip-path: polygon(
      0% 60%,
      15% 65%,
      34% 66%,
      51% 62%,
      67% 50%,
      84% 45%,
      100% 46%,
      100% 100%,
      0% 100%
    );
  }
}
`;

const Header = styled.h1`
  color: #fff;
  position: absolute;
  top: -10%;
  left: 0;
  text-shadow: 1px 1px 10px #9c94d033;
  font-size: 2.7rem;

  &:nth-child(1) {
    color: transparent;
    -webkit-text-stroke: 2px #9c94d055;
  }
  &:nth-child(2) {
    color: #9c94d0;
    animation: animate 4s ease-in-out infinite;
  }
`; 

const Nav = styled.div`
  display: flex;
  align-items: center;
  width: 15%;
  min-width: 192px;
`;

const Profile = styled.div`
  display: flex;
  align-items: center;
  justify-content: flex-end;
  width: 15%;
  min-width: 144px;
`;

const StyledLink = styled(Link)`
  text-decoration: none;
  color: black;
  width: auto;
  min-width: 100px;
`;

export { Container, Logo, Header, Nav, Profile, StyledLink };
