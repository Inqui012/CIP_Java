import React from 'react';
// NAV에 링크를 거는 콤포넌트
import styled from 'styled-components'
import { NavLink } from 'react-router-dom';

const categories = [
  {
    name: 'all',
    text: '전체보기',
  },
  {
    name: 'business',
    text: '비즈니스',
  },
  {
    name: 'entertainment',
    text: '엔터테인먼트',
  },
  {
    name: 'health',
    text: '건강',
  },
  {
    name: 'science',
    text: '과학',
  },
  {
    name: 'sports',
    text: '스포츠',
  },
  {
    name: 'technology',
    text: '기술',
  },
];

const CategoriesBlock = styled.div`
  display: flex;
  padding: 1rem;
  width: 768px;
  margin: 0 auto;
  @media screen and (max-width: 768px) {
    width: 100%;
    overflow-x: auto;
  }
`;

// 콤포넌트에 스타일을 줄 때에는 ().
const Category = styled(NavLink)`
  font-size: 1.125rem;
  cursor: pointer;
  white-space: pre;
  text-decoration: none;
  color: inherit;
  padding-bottom: 0.25rem;
  &:hover {
    color: #495057;
  }
  &.active {
    font-weight: 600;
    border-bottom: 2px soild #22b8cf;
    color: #22b8cf;
    &:hover {
      color: #3bc9db;
    }
  }
  & + & {
    margin-left: 1rem;
  }
`;

const Categorys = () => {
    return (
        <CategoriesBlock>
            {/* 위에있는 객체배열 */}
            {categories.map((c) => (
                // key 에는 객체의 name 값을 입력. to 로 params 의 경로를 바꿔줌
                // {isActive} = NavLink 에서 제공해주는 값. 메뉴가 현재 선택되어 있는지 판단.
                <Category key={c.name} className={({ isActive }) => (isActive ? 'active' : undefined)} to={c.name === 'all' ? '/' : `/${c.name}`}>
                {/* 메뉴 하나하나를 생성하는거기 때문에 text 값으로 메뉴생성 */}
                    {c.text}
                </Category>
            ))}
        </CategoriesBlock>
    );
}

export default Categorys;
