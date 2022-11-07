import React from 'react';
import Categorys from '../Components/Categorys';
import NewsList from '../Components/NewsList';
import { useParams } from 'react-router-dom';

const NewsPage = () => {
    const params = useParams();
    // params 가 빈값일경우 "all"을 저장.
    // params 객체 의 category 키에 url의 문자열을 저장하고 이걸 category 변수에 저장.
    const category = params.category || "all";

    return (
        <>
            <Categorys />
            <NewsList category={category} />
        </>
    );
}

export default NewsPage;
