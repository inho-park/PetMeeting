import '../css/PetMeetingLogin.css'
import LogoLarge from '../img/LogoLarge.png'
import {Route} from "react-router-dom";


const PetMeetingLogin = () => {
    return(
        <div>
            <div id="LogInImg">
                <img id="LogInImg" src={LogoLarge}/>
            </div>
            <form id="LogInput">
                아이디 : <input id="LogInId" type="text" placeholder="아이디를 입력하세요."/> <br/>
                비밀번호 : <input id="LogInPassword" type="password" placeholder="비밀번호를 입력하세요."/><br/>
                <button id="LoginButton" type="submit">로그인</button>
                <br/>
                    <button id="FindId" type="submit">아이디 찾기</button>
                    <button id="FindPassword" type="submit">비밀번호 찾기</button>

                    <button id="NewMember" type="submit">회원가입 하기</button>
            </form>

        </div>
    )
}

export default PetMeetingLogin