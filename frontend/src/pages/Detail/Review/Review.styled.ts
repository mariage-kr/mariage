import styled from '@emotion/styled';
import { css } from '@emotion/react';

const Container = styled.div`
  margin: 0 auto;
  overflow: hidden;
`;

const Left = styled.div`
  float: left;
  width: 75%;
`;

const Right = styled.div`
  float: right;
  width: 25%;
`;

const EditBtn = styled.button`
  border-radius: 5px;
  box-sizing: border-box;
  box-shadow: 1px 1px 3px #00000030;
  background-color: #9C94D0;
  width: 85%;
  height: 50px;
  margin: 30px 0 0 30px;
  padding: 0;
  text-align : center;
  color: #fff;
  cursor: pointer;
  transition: 250ms;
  
  &:hover {
    box-shadow: 1.5px 1.5px 3px #9C94D0;
    transform: scale(1.05);
  } 
`;

const Edit = styled.div`
  display: inline-block;
  vertical-align: bottom;
  margin: 0 5px;
  font-size: 1.1rem;
`;

const editi = css`
  width: 25px;
  height: 25px;
`;

const EditIcon = styled.img`
  width: 100%;
  height: 100%;
  object-fit: cover;
  margin: 0 10px 0 0;
`;

const ReviewEdit = styled.div`
  z-index: 1;
  /* position: fixed;
  top: 0;
  left: 0; */
  width: 100%;
  height: 100vh;
`;

export {
  Container,
  Left,
  Right,
  EditBtn,
  EditIcon,
  editi,
  Edit,
  ReviewEdit
};