import styled from '@emotion/styled';
import { css } from '@emotion/react';

const Container = styled.div`
  width: 40.625rem;
  margin: 50px auto;
`;

const Profile = styled.div`
  display: flex;
  width: 100%;
`;

const Image = styled.div`
  width: 30%;
  padding: 30px 0;
`;

const ProfileImg = styled.img`
  width: 150px;
  height: 150px;
  margin: 0 auto;
  border: 1px solid #333;
  border-radius: 50%;
`;

const Info = styled.div`
  width: 50%;
  height: 220px;
  margin: 0 auto;
  padding: 50px 0;
`;
const Name = styled.p`
  font-size: 1.5rem;
  font-weight: 500;
`;

const Email = styled.span`
  font-size: 0.9rem;
  color: #888;
`;

const Birth = styled.p`
  color: #888;
`;

const BtnStyle = css`
  display: inline-block;
  width: 150px;
  margin: 20px 0;
  margin-right: 10px;
  padding: 5px 10px;
  border: 1px solid #9c94d0;
  border-radius: 15px;
  background-color: #fff;

  &:hover {
    color: #fff;
    background-color: #9c94d0;
  }
`;

const NicknameWrap = styled.div`
  width: 90%;
  margin: 0 auto;
`;

const Label = styled.p`
  margin: 5px auto;
  font-size: 14px;
`;

const Nickname = styled.input`
  width: 100%;
  height: 40px;
  margin: 0 auto;
  padding: 5px;
  border: 1px solid;
  border-radius: 10px;
  font-size: 1.1rem;
`;

const BtnSubmit = styled.button`
  display: block;
  width: 150px;
  margin: 20px auto;
  padding: 10px;
  border-radius: 10px;
  text-align: center;
  font-size: 1rem;
  background: #9c94d0;
  color: #fff;
`;

export {
  Container,
  Profile,
  Image,
  ProfileImg,
  Info,
  Name,
  Email,
  Birth,
  BtnStyle,
  NicknameWrap,
  Label,
  Nickname,
  BtnSubmit,
};
