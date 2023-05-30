import styled from '@emotion/styled';

type Select = {
  select: boolean;
};

const Container = styled.div`
  position: absolute;
  top: 0;
  right: 0;
  width: 140px;
  display: flex;
  flex-direction: row;

  @media (max-width: 1000px) {
    right: -17%;
    width: 300px;
  }
`;

const Btn = styled.button<Select>`
  position: relative;
  width: 70px;
  padding-bottom: 5px;
  font-size: 1rem;
  background-color: transparent;
  transition: all 0.15s;
  color: ${prop => (prop.select ? '#bb2649' : '#000')};
  font-weight: ${prop => (prop.select ? 'bold' : 'normal')};
  

  &:hover {
    color: #bb2649;
  }

  @media (max-width: 1000px) {
    width: 85px;
    padding-left: 10px;
  }
`;

export { Container, Btn };
