import '../css/PetMeetingTopBanner.css'
import Banner1 from '../img/Banner1.jpg'
import Cat1 from '../img/Cat1.jpg'
import Dog1 from '../img/Dog1.jpg'
import PetMeetingLogin from "./PetMeetingLogin";
import {NavLink, Route, Routes} from "react-router-dom";
const PetMeetingTopBanner = () => {
  return(
      <div className="TopBanner">
          <div id="HeaderBanner">
              <img id="HeaderBannerImg" src={Banner1}/>
          </div>
          <div className="MidBanner">
              <img id="MidBannerImg1" src={Cat1}/>
              <div className="MidText">
                  <p id="MidTopText">
                      펫미팅은 애완동물들의 사교, 교제<br />
                      애견인들의 소통을 응원합니다.
                  </p>
                  <NavLink to="/PetMeetingLogin">
                      <div id="MidBottomText">
                          <p id="MidBottomText1">
                              로그인
                          </p>
                      </div>
                  </NavLink>
              </div>
              <img id="MidBannerImg2" src={Dog1}/>
          </div>
          <Routes>
              <Route path="/PetMeetingLogin" element={<PetMeetingLogin/>} />
          </Routes>
      </div>
  )
}

export default PetMeetingTopBanner