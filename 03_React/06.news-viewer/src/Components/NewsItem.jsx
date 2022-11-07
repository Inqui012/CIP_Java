import React from 'react';
import styled from 'styled-components';

const NewsItemBlock = styled.div`
  display: flex;
  .thumbnail {
    margin-right: 1rem;
    img {
      display: block;
      width: 160px;
      height: 100px;
      object-fit: cover;
    }
  }
  .contents {
    h2 {
      margin: 0;
      a {
        color: black;
      }
    }
    p {
      margin: 0;
      line-height: 1.5;
      margin-top: 0.5rem;
      white-space: normal;
    }
  }
  & + & {
    margin-top: 3rem;
  }
`;
// newslist 에서 넘겨받은 props
const NewsItem = ({ article }) => {
    // newsapi에서 받아온 article 객체속에 지정된 키들.
    const { title, description, url, urlToImage } = article;
    return (
        <NewsItemBlock>
            {/* urlToImage에 값이 있으면 생성. 없으면 이미지를 생성하지 않음. */}
            {urlToImage && (
                <div className='thumbnail'>
                    {/* rel="noopener noreferrer" 새창으로 띄울때 보안 취약점 방지 및 성능 향상 */}
                    <a href={url} target="_blank" rel="noopener noreferrer">
                        <img src={urlToImage} alt="thumbnail" />
                    </a>
                </div>
            )}
            <div className='contents'>
                <h2>
                    <a href={url} target="_blank" rel="noopener noreferrer">
                        {title}
                    </a>
                </h2>
                <p>
                    {description}
                </p>
            </div>
        </NewsItemBlock>
    );
}

export default NewsItem;
