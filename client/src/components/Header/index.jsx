import * as S from './styles'

export default function Header({ text, ...rest }) {
  return (
    <S.Container {...rest} >
      {text}
    </S.Container>
  )
}
