

import axios from 'axios';

// fetch


import {useEffect, useState} from 'react';
function App() {
  const[todoList, setTodoList] = useState(null);

  const fetchData = () => {
    // axios
    // axios.get('http://localhost:4000/api/todo').then((response)=>{
    //   setTodoList(response.data); //async await사용해 더 간단하게도 가능
    // })
    fetch('http://localhost:4000/api/todo')
    .then((response)=> response.json())
    .then((data)=> setTodoList(data));
  };

  useEffect(() => {
    // fetch('http://localhost:4000/api/todo')
    // .then((response)=> response.json())
    //  // 첫번째응답값:json형태변환, 데이터값:todolist데이터
    // .then((data)=> setTodoList(data));
    fetchData(); 
  }, []); // 처음 랜더링 될때만 실행

  //데이터 추가
  const onSubmitHandler = (e)=> {
    e.preventDefault(); //기본동작막기
    const text = e.target.text.value;
    const done = e.target.done.checked;
    fetch('http://localhost:4000/api/todo',{
      method:'POST',
      headers:{
        'Content-Type':'application/json',
      },
      body:JSON.stringify({
        text,
        done,
      }),
    })//데이터 받아오고 클릭했을 때 서버에 요청
    .then(() => 
    // fetch('http://localhost:4000/api/todo')
    // .then((response)=> response.json())
    // .then((data)=> setTodoList(data))
    fetchData()
    );
  }

  return (
       <div className="App">
         <h1>TODO LIST</h1>
         <form onSubmit={onSubmitHandler}>
          <input name='text'/>
          <input name='done' type='checkbox'/>
          <input type="submit" value='추가'/>
         </form>
         {todoList?.map((todo => //optional chaing을 통해 todo가 없을 땐 undefined를 만들어 랜더링 되지 않도록 
      <div key={todo.id} style={{display:'flex'}}>
          <div>{todo.id}</div>
          <div>{todo.text}</div>
          <div>{todo.done ? "Y" : "N"}</div>
        </div>
        ))}
         </div>
  );
  
}

export default App;
