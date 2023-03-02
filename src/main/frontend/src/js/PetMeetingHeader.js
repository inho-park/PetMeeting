import { Link, NavLink, Route, Routes } from "react-router-dom";
import '../css/PetMeetingHeader.css'
import Logo from '../img/logo.png'
import PetMeetingLogin from './PetMeetingLogin'
import PetMeetingMarket from "./PetMeetingMarket";
import PetMeetingPetShow from "./PetMeetingPetShow";
import PetMeetingHome from "./PetMeetingHome";
import PetMeetingCompany from "./PetMeetingCompany";
const PetMeetingHeader = () => {
    return(
        <div>
            <ul className = "all">
                <li>
                    <NavLink to="/PetMeetingHome">
                        <img className="LogoImg" src={Logo}/>
                    </NavLink>
                </li>
                <li>
                    <NavLink to="/PetMeetingPetShow">
                        펫 자랑 게시판
                    </NavLink>
                </li>
                <li>
                    <NavLink to="/PetMeetingMarket">
                        펫 커뮤니케이션 게시판
                    </NavLink>
                </li>
                <li>
                    <NavLink to="/PetMeetingLogin">
                        PetMeetingLogin
                    </NavLink>
                </li>
            </ul>
                <Routes>
                    <Route path="/PetMeetingLogin" element={<PetMeetingLogin/>} />
                    <Route path="/PetMeetingMarket" element={<PetMeetingMarket/>} />
                    <Route path="/PetMeetingPetShow" element={<PetMeetingPetShow/>} />
                    <Route path="/PetMeetingHome" element={<PetMeetingHome />} />
                    <Route path="PetMeetingCompany" element={<PetMeetingCompany/>} />
                </Routes>
        </div>
    )
}
export default PetMeetingHeader