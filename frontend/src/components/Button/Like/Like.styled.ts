import styled from '@emotion/styled';

interface Props {
  liked?: boolean;
}

interface TextProps {
  liked: boolean;
  children: React.ReactNode;
}

// TODO: 페이지 내에서 사용 시 스타일 수정
const Button = styled.button<Props>`
  background: ${props => (props.liked ? '#bb2649' : 'white')};
  text-align: center;
  margin: 5px;
  padding: 12px 17px;
  border-radius: 10px;
  border-style: none;
  box-shadow: 1px 1px 3px #9C94D055;

  &:hover {
    box-shadow: 1.5px 1.5px 3px #9C94D0;
  }

  @media (max-width: 1100px) { padding: 10px 15px; }
`;

const Number = styled.span<TextProps>`
  color: ${props => (props.liked ? 'white' : 'black')};
  margin-left: 5px;
  font-size: 14px;
`;

const Container = styled.div`
  text-align: center;
  display: flex;
  align-items: center;
`;

export { Button, Number, Container };
