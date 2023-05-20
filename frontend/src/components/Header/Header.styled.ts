import styled from '@emotion/styled';
import { Link } from 'react-router-dom';

const Container = styled.div`
  height: 100px;
  padding: 0 10%;
  border-bottom: 1px solid #00000033;
`;

const Logo = styled.div`
  float: left;
  width: 15%;
  height: 100%;
  box-sizing: border-box;
  position: relative;

  @media (max-width:1400px) { width: 17%; }
  @media (max-width:1250px) { width: 18%; }
  @media (max-width:1160px) { width: 20%; }
  @media (max-width:1065px) { width: 22%; }
  
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
  top: -10px;
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
  float: left;
  width: 20%;
  min-width: 160px;
  margin-top: 20px;
  box-sizing: border-box;

  @media (max-width:1160px) { width: 15%; }
`;

const Profile = styled.div`
  display: flex;
  align-items: center;
  justify-content: flex-end;
  width: 15%;
  min-width: 144px;
`;

const SearchArea = styled.div`
  float: left;
  width: 30%;
  min-width: 220px;
  margin-top: 25px;
  box-sizing: border-box;

  @media (max-width:1065px) { width: 28%; }
`;

const UserArea = styled.div`
  float: right;
  width: 25%;
  margin-top: 20px;
  box-sizing: border-box;

  @media (max-width:1310px) { width: 30%; }
  @media (max-width:1005px) { width: 28%; }
`;

const StyledLink = styled(Link)`
  text-decoration: none;
  color: black;
  width: auto;
  min-width: 100px;
`;

export { Container, Logo, Header, Nav, Profile, SearchArea, UserArea, StyledLink };
