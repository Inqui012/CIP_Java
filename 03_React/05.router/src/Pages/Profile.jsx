import React from 'react'
import { useParams } from 'react-router-dom'

// URL Parameter = 주로 id, 이름 등으로 특정 데이터를 조회할 때 사용
// 쿼리스트링 = 키워드 검색, 페이지이동, 정렬방식등 데이터 조회에 필요한 정보를 전달
const data = {
   student01: {
      name: 'doe',
      info: 'jone',
   },
   student02: {
      nema: 'kim',
      info: 'pota',
   },
}

const Profile = () => {
   // URL에서 얻은 파라메터를 객체형태로 저장한다.
   // 앞단에어 지정한 username 이라는 키값에 실제 지정된 student01 를 저장함.
   const params = useParams()
   // app.js 에서 받아오는 형식을 /Profiles/:username 으로 지정했기 때문에
   // :username 에 지정된 객체 키값을 받아와서 데이터를 참조한다.
   const profile = data[params.username]
   return (
      <div>
         <h1>PROIFLE</h1>
         {profile ? (
            <div>
               <h2>NAME : {profile.name}</h2>
               <h2>INFO : {profile.info}</h2>
            </div>
         ) : (
            <p>NONE</p>
         )}
      </div>
   )
}

export default Profile
