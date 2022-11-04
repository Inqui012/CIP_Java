import React from 'react'
// 라이브러리 필요
import styled, { css } from 'styled-components'

// Box 라는 태그로 사용할 수 있는 스타일이 지정된 div 를 생성. 백틱사용
// jsx 문법 기억하기. 값이 있느냐 없느냐로 참/거짓 판단해서 출력하는듯.
// 콤포넌트 안에서 변수를 생성해서 사용하기 때문에 다른 콤포넌트와 충돌할 걱정이 없음.
const Box = styled.div`
   background: ${props => props.color || 'papayawhip'};
   padding: 1rem;
   display: flex;
   width: 1000px;
   margin: 0 auto;
`

// 상위처럼 지정된 스타일을 확장시키는것도 가능
// 기본 틀을 위와 같고 일부만 변경해서 사용할 수 있다.
const Box02 = styled(Box)`
   background: green;
`

const Button = styled.button`
   background: white;
   color: black;
   border-radius: 4px;
   padding: 0.5rem;
   display: flex;
   align-items: center;
   justify-content: center;
   box-sizing: border-box;
   font-size: 1rem;
   font-weight: 600;

   &:hover {
      background: rgba(255, 255, 255, 0.9);
   }
   // iverted 값이 있을경우에만 적용
   ${props =>
      props.inverted &&
      css`
         background: none;
         border: 2px solid white;
         color: white;
         &:hover {
            background: white;
            color: black;
         }
      `};
   // css 선택자. + 바로 뒤에오는 태그
   & + button {
      margin-left: 1rem;
   }
`
// retrun 이 아님.
const StyledComponent = () => (
   // 상위에서 선언한 Box라는 이름의 div.
   // 이것도 콤포넌트 취급이라 props 를 줄 수 있다.
   <>
      <Box color="black">
         <Button>안녕하세요</Button>
         <Button inverted={true}>테두리만</Button>
      </Box>
      <Box>Dosen't have Props</Box>
      <Box02>Extented</Box02>
   </>
)

export default StyledComponent
