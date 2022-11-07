import styled from "styled-components";
import NewsItem from "./NewsItem";
import axios from "axios";
import { useState, useEffect } from 'react';

const NewsListBlock = styled.div`
  box-sizing: border-box;
  padding-bottom: 3rem;
  width: 768px;
  margin: 0 auto;
  margin-top: 2rem;
  @media screen and (max-width: 768px) {
    width: 100%;
    padding-left: 1rem;
    padding-right: 1rem;
  }
`;

// NewsPage 에서 보내주는 props
const NewsList = ({ category }) => {
    const [articles, setArticles] = useState(null);
    const [loading, setLoading] = useState(false);

    // 콤포넌트가 렌더링 될 때마다 실행
    useEffect(() => {
        // 비동기함수로 지정
        const fetchData = async () => {
            // 로딩중임을 표시
            setLoading(true);
            // 원하는 구성을 실행하고 에러가 발생할경우 catch 문을 실행
            try {
                // axios 에서 받아온 api 에 표시할 쿼리스트링을 지정하는듯
                // category 목록은 newsapi 에서 제공하는 목록이네. 임의설정 아님.
                const query = (category === 'all' ? '' : `&category=${category}`)
                // axios로 데이터를 받아오는데 비동기 실행중에서 이 데이터 로드가 끝날때까지 await 한다.
                const response = await axios.get(`https://newsapi.org/v2/top-headlines?country=kr${query}&apiKey=648f856c05414927bd4297c97486d713`)
                // newsapi 에서 받아오는 데이터는 articles 객체키 안에 배열형식으로 들어가있네
                setArticles(response.data.articles)
            } catch (e) {
                // 에러가 났을경우
                console.log('error')
            }
            setLoading(false)
        }
        // 선언한 함수를 실행
        fetchData();
    // 받아오는 props category 가 바뀔 때만 실행한다 
    }, [category])

    if (loading) {
        return <NewsListBlock>Now Loading...</NewsListBlock>
    }
    // articles 가 false => 빈값일때
    if (!articles) {
        return null;
    }
    return (
        <NewsListBlock>
            {articles.map((article) => (
                // newsitem 콤포넌트에 넘겨줄 article props를 설정한다
                <NewsItem key={article.url} article={article}></NewsItem>
        ))}
        </NewsListBlock>
    );
}

export default NewsList;
