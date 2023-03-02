import '../css/PetMeetingFooter.css'
import PetMeetingCompany from "./PetMeetingCompany"
import { Route, Routes } from "react-router-dom";

const PetMeetingFooter = () => {
    return (
        <footer>
            <div id="bottomMenu">
                <ul>
                    <li>
                        <a href="/PetMeetingCompany">
                            <p>회사 소개</p>
                        </a>
                    </li>
                    <li>
                        <a href="https://policy.naver.com/policy/privacy.html">개인정보처리방침 (네이버와 동일)</a>
                    </li>
                </ul>
            </div>
            <div id="company">
                <h3>contact</h3>
                <p>경기도 안양시 동안구 임곡로 29<br />
                    전화번호 : 010-8028-7565<br/>
                    EMAIL : tntn211@naver.com
                </p>
            </div>
            <Routes>
                <Route path="PetMeetingCompany" element={<PetMeetingCompany/>} />
            </Routes>
        </footer>
    )
}

export default PetMeetingFooter