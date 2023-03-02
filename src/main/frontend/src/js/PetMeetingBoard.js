import React, {useState, useEffect,useRef } from 'react';
import '../css/PetMeetingBoard.css'
const PetMeetingBoard = () => {
    const [data, setdata] = useState([]); //게시판의 모든 데이터를 보관해 둘 useState입니다.
    const [inputs, setInputs] = useState('');//추가할 텍스트를 입력할 인풋 박스 값입니다.
    const [Modifyinputs, setModifyInputs] = useState('');//추가할 텍스트를 입력할 인풋 박스 값입니다.

    const onChange = (e) => { // 추가할 데이터 설정
        const { name, value } = e.target
        setInputs(value);
    }
    const onChangeModify = (e) => {// 수정할 데이터 설정
        const { name, value } = e.target
        setModifyInputs(value);
    }
    function addData(){ //데이터 추가
        let newData = []
        for(let i=0; i<data.length;i++){
            newData = [...newData, data[i]]
        }
        newData = [...newData,{text:inputs,Idx:data.length,ModifyState:false}]
        console.log(newData);
        setdata(newData);
    }

    function deleteData(GetIdx){ //데이터 삭제
        setdata(data.filter(data => data.Idx !== GetIdx));
    }


    function ModifyData(GetData){ //데이터 수정
        let newArr = [];
        for(let i=0; i<data.length;i++){
            if(data[i].Idx=== GetData.Idx){
                newArr = [...newArr,{text:Modifyinputs,Idx:GetData.Idx,ModifyState:false}];
            }else{
                newArr = [...newArr,data[i]];
            }
            setdata(newArr);
        }
    }

    function OnOffModifyInput(GetData){ //수정 버튼 눌렀을 때, div -> input or input -> div로 바꾸는 함수
        let newArr = [];
        for(let i=0; i<data.length;i++){
            if(data[i].Idx=== GetData.Idx){
                if(GetData.ModifyState === false){
                    newArr = [...newArr,{text:GetData.text,Idx:GetData.Idx,ModifyState:true}];
                }else{
                    newArr = [...newArr,{text:GetData.text,Idx:GetData.Idx,ModifyState:false}];
                }
            }else{
                newArr = [...newArr,data[i]];
            }
            setdata(newArr);
        }
    }

    return (
        <div className="App">
            <h1>모달창 예제</h1>
            <div style={{display:"flex"}}>
                <input onChange={onChange}></input>
                <button onClick={addData}>추가</button>
            </div>
            {data.map((data,i) => (
                <div style={{display:"flex", border:"1px solid", width:"400px"}}>
                    {data.ModifyState ===true ?
                        <div>
                            <textarea onChange={onChangeModify} >{data.text}</textarea>
                            <button onClick={(e)=>{ModifyData(data, e)}}>수정</button>
                            <button onClick={(e)=>{OnOffModifyInput(data, e)}}>취소</button>
                        </div>

                        :
                        <div>
                            <div>{data.text}</div>
                            <button onClick={(e)=>{OnOffModifyInput(data, e)}}>수정</button>
                            <button onClick={(e)=>{deleteData(data.Idx, e)}}>삭제</button>
                        </div>
                    }


                </div>
            ))
            }
        </div>
    );
}
export default PetMeetingBoard
