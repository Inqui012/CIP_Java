import useInputs from './useImputs'

const Info_hook = () => {
   // 외부에 커스텀 훅을 만들어놓고 불러와서 실행시킨다.
   // 실행내용은 reduce와 똑같음. 그저 파일을 나눠났을뿐임.
   const [state, onChange] = useInputs({
      name: '',
      alias: '',
   })
   const { name, alias } = state
   return (
      <div>
         <hr />
         <h1>Info_hook</h1>
         <div>
            <input name="name" value={name} onChange={onChange} />
            <input name="alias" value={alias} onChange={onChange} />
         </div>
         <div>
            <div>
               <b>NAME : {name}</b>
            </div>
            <div>
               <b>ALIAS : {alias}</b>
            </div>
         </div>
      </div>
   )
}

export default Info_hook
