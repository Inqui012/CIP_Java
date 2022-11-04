import React from 'react'
// 외부에 작성한 모듈scss 를 불러온다.
import styles from './CssModule.module.scss'

// 바인딩해주네.
const CSSModule = () => {
   // css Module 에서 클래스명을 자동생성하는데 이때 랜덤숫자를 붙여줘서
   // 클래스명이 같아도 충돌이 일어나지 않게 방지해준다.
   console.log(styles)
   return (
      // 모듈에서 일반적으로 작성한 클래스 속성들은 객체처럼 불러와야한다.
      <div className={styles.wrapper}>
         {/* :global 로 지정한 내부의 클래스들은 클래스명으로 불러올 수 있다. */}
         안녕하세요, 저는 <span className="something">CSS Module!</span>
      </div>
   )
}

export default CSSModule
