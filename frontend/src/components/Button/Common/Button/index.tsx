import * as S from './index.styled';

interface ButtonProps {
  type?: 'button' | 'submit' | 'reset';
  style?: React.CSSProperties;
  onClick?: (e?: React.FormEvent) => void;
  children?: string | JSX.Element | JSX.Element[];
  disabled?: boolean;
}

function Button({
  type = 'button',
  onClick,
  children,
  disabled = false,
  ...props
}: ButtonProps) {
  return (
    <button {...props} type={type} onClick={onClick} disabled={disabled}>
      {children}
    </button>
  );
}

export default Button;
