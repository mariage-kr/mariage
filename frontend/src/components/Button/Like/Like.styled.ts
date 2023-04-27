import styled from '@emotion/styled';

interface Props {
  liked: boolean;
}

interface TextProps {
  liked: boolean;
  children: React.ReactNode;
}

const Button = styled.button<Props>`
  background: ${(props) => (props.liked ? '#bb2649' : 'white')};
  text-align: center;
  padding: 12px 30px;
  border-radius: 10px;
  border-style: none;
  box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.5);
  margin: 10px;
`;

const Number = styled.span<TextProps>`
color: ${(props) => (props.liked ? 'white' : 'black')};
margin: 0 5px;
font-size: 17px;
`;

const Container = styled.div`
text-align: center;
display: flex;
align-items: center;
`;

export { Button, Number, Container };
