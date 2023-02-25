import PetMeetingHeader from "./PetMeetingHeader";
import PetMeetingFooter from "./PetMeetingFooter";
import './PetMeetingPetShow.css';
import Pet1 from './img/Pet1.jpg'
import Cat2 from './img/Cat2.jpg'

const PetMeetingPetShow = () => {
    return(
        <div>

            <div className="PetShow">
                <p id="PetShowTitle">펫 자랑 게시판</p>
                <div id="Search">
                    <input id="SearchText" type="text" placeholder="검색어를 입력하세요"/>
                    <button id="SearchSubmit" type="submit">검색</button>
                </div>
                <div className="PetShowPreview">
                    <div id="PetShowPreview1">
                        <img id="PetShowPreviewImg" src={Pet1}/>
                        <p id="PetShowPreviewText">우리집 개냥이들 사진!!</p>
                    </div>
                    <div id="PetShowPreview2">
                        <img id="PetShowPreviewImg" src={Cat2}/>
                        <p id="PetShowPreviewText">고양이 눈빛!!</p>
                    </div>
                    <div id="PetShowPreview2">
                        <img id="PetShowPreviewImg" src={Pet1}/>
                        <p id="PetShowPreviewText">우리집 개냥이들 사진!!</p>
                    </div>
                    <div id="PetShowPreview2">
                        <img id="PetShowPreviewImg" src={Cat2}/>
                        <p id="PetShowPreviewText">고양이 눈빛!!</p>
                    </div>
                    <div id="PetShowPreview2">
                        <img id="PetShowPreviewImg" src={Pet1}/>
                        <p id="PetShowPreviewText">우리집 개냥이들 사진!!</p>
                    </div>
                </div>
                <div className="PetShowPreviewRe">
                    <div id="PetShowPreview1">
                        <img id="PetShowPreviewImg" src={Pet1}/>
                        <p id="PetShowPreviewText">우리집 개냥이들 사진!!</p>
                    </div>
                    <div id="PetShowPreview2">
                        <img id="PetShowPreviewImg" src={Cat2}/>
                        <p id="PetShowPreviewText">고양이 눈빛!!</p>
                    </div>
                    <div id="PetShowPreview2">
                        <img id="PetShowPreviewImg" src={Pet1}/>
                        <p id="PetShowPreviewText">우리집 개냥이들 사진!!</p>
                    </div>
                    <div id="PetShowPreview2">
                        <img id="PetShowPreviewImg" src={Cat2}/>
                        <p id="PetShowPreviewText">고양이 눈빛!!</p>
                    </div>
                    <div id="PetShowPreview2">
                        <img id="PetShowPreviewImg" src={Pet1}/>
                        <p id="PetShowPreviewText">우리집 개냥이들 사진!!</p>
                    </div>
                </div>
                <div className="PetShowPreviewRe">
                    <div id="PetShowPreview1">
                        <img id="PetShowPreviewImg" src={Pet1}/>
                        <p id="PetShowPreviewText">우리집 개냥이들 사진!!</p>
                    </div>
                    <div id="PetShowPreview2">
                        <img id="PetShowPreviewImg" src={Cat2}/>
                        <p id="PetShowPreviewText">고양이 눈빛!!</p>
                    </div>
                    <div id="PetShowPreview2">
                        <img id="PetShowPreviewImg" src={Pet1}/>
                        <p id="PetShowPreviewText">우리집 개냥이들 사진!!</p>
                    </div>
                    <div id="PetShowPreview2">
                        <img id="PetShowPreviewImg" src={Cat2}/>
                        <p id="PetShowPreviewText">고양이 눈빛!!</p>
                    </div>
                    <div id="PetShowPreview2">
                        <img id="PetShowPreviewImg" src={Pet1}/>
                        <p id="PetShowPreviewText">우리집 개냥이들 사진!!</p>
                    </div>
                </div>
                <PetMeetingFooter />
            </div>
        </div>
    )
}
export default PetMeetingPetShow