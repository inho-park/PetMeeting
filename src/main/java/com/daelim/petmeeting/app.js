const express = require('express');
const app = express();
const bodyParser = require('body-parser');
const cors = require('cors');

app.use(cors());
// 익스프레스에서 body에서 데이터를 꺼내 사용하기 위해서는 body-parser가 필요함
//client에서 body에 데이터를 보내면 꺼내 사용하게 해주는 parser

app.use(bodyParser.json()); // for parsing application/json
app.use(bodyParser.urlencoded({ extended: true })); // for parsing 

let id = 2; // id는 고유하므로 데이터 들어올때마다 증가하도록
const todoList =[
  {
  id:1,
  text:'할일',
  done:false,//할일 안함!!
},
]; //todoList라는 샘플데이터를 서버 메모리에 저장

app.get('/', function (req, res) {
  res.send('Hello World');
});

app.get('/api/todo', (req,res) => {
  res.json(todoList); //json형식으로 보내기. .
}); //api/todo에 GET요청하면 todoList를 리턴하는 함수실행

//todoList추가
app.post('/api/todo', (req,res) => {
  const {text,done} = req.body; //프론트에서는 body에 데이터({text,done})를 담아서 보내고 받기 위해서 req.body에 데이터가 들어있음
  console.log('req.body:', req.body);
  todoList.push({
    id: id++,
    text,
    done,
  });
  return res.send('success');
}); //post요청하면 데이터 추가

app.listen(4000, () => {
  console.log('server start');
});

