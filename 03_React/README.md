# React 관련 메모

-  [리액트 강의문서](https://react.vlpt.us/)
-  React. 후에 클론이나 풀한 프로젝트에 node_module 설치하는법

   > npm i 로 package.json 안에 설정되어있는 모듈을 설치할 수 있다.

-  Prettier - code formatter

   > VsCode 에서 확장으로 설피는 개인으로 작업할때.
   > 공동작업등으로 공유가 필요할때는 프로젝트에 직접 설치할 수 있다.
   > npm i -D(개발자전용) prettier / yarn add -D prettier
   > 해당 프로젝트의 루트에 .prettierrc 로 설정을 조절가능

-  ESLint

   > 문법의 오류를 고쳐준다. prettier와 겹치는부분 있음.
   > VsCode 확장과 프로젝트 직접설치 둘다 필요.
   > npm i -D eslint / yarn add -D eslint
   > 해당 프로젝트의 루트에 .eslintrc.js 로 설정 조절가능.

-  크롬 익스텐션. React Developer Tools

-  Ref

   > HTML의 id 속성과 비슷. DOM을 직접적으로 조정해야할때 사용한다.
   >
   > 1. 특정 input 태그에 포커스를 주어야할 떄
   > 2. 스크롤 박스를 조정해야할 때
   > 3. Canvas 요소에 그림을 그릴 때

-  리액트의 작업 흐름 (after 16.3)

   > 1. Mounting
   >    > 1. constructor / 초기 state 생성. hook일경우 useState 를 사용한다.
   >    > 2. getDerivedStateFromProps / props로 받아온값을 state 에 동기화시킨다.
   > 2. Updating
   > 3. UnMounting

-  Single Page Application (SPA)

   > 기존의 방법과 달리 페이지 로드시 필요한 모든 파일을 한번에 받아온 후, 필요에 따라 데이터만을 서버에서 받아와 바꾼다. 초기 로드에 시간이 걸릴 수 있지만 이후에는 빠름.

-  React Router
   > index.js 에서 최상위 태그를 BrowserRouter로 바꿔줘야 하는듯
   > app.js 에서 최상위를 Routes, 아래에 Route 사용?

- 데이터 바인딩
   > 1. ajax (JQuery 로드 필수)
   > 2. fetch (기본적으로 ie에서 사용불가)
   > 3. axios (node.js 권장)