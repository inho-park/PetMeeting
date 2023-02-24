import './PetMeetingMarket.css'
import PetMeetingFooter from "./PetMeetingFooter";
import CatFood1 from './img/CatFood1.jpg'
import  CatTower1 from './img/CatTower1.jpg'
const PetMeetingMarket = () => {
    return(
        <div>
            <div className="Market">
                <p id="MarketTitle">펫 물건 장터</p>
                <div id="Search">
                    <input id="SearchText" type="text" placeholder="검색어를 입력하세요"/>
                    <button id="SearchSubmit" type="submit">검색</button>
                </div>
                <div className="MarketPreview">
                    <div id="MarketPreview1">
                        <img id="MarketPreviewImg" src={CatFood1}/>
                        <p id="MarketPreviewText">(미개봉)고양이 사료<br/>10000원</p>
                    </div>
                    <div id="MarketPreview2">
                        <img id="MarketPreviewImg" src={CatTower1}/>
                        <p id="MarketPreviewText">(실사용 1회) 캣타워<br/>50000원</p>
                    </div>
                    <div id="MarketPreview2">
                        <img id="MarketPreviewImg" src={CatFood1}/>
                        <p id="MarketPreviewText">(미개봉) 고양이 사료<br/>10000원</p>
                    </div>
                    <div id="MarketPreview2">
                        <img id="MarketPreviewImg" src={CatTower1}/>
                        <p id="MarketPreviewText">(실사용 1회) 캣타워<br/>50000원</p>
                    </div>
                    <div id="MarketPreview2">
                        <img id="MarketPreviewImg" src={CatFood1}/>
                        <p id="MarketPreviewText">(미개봉)고양이 사료<br/>10000원</p>
                    </div>
                </div>
                <div className="MarketPreviewRe">
                    <div id="MarketPreview1">
                        <img id="MarketPreviewImg" src={CatFood1}/>
                        <p id="MarketPreviewText">(미개봉)고양이 사료<br/>10000원</p>
                    </div>
                    <div id="MarketPreview2">
                        <img id="MarketPreviewImg" src={CatTower1}/>
                        <p id="MarketPreviewText">(실사용 1회) 캣타워<br/>50000원</p>
                    </div>
                    <div id="MarketPreview2">
                        <img id="MarketPreviewImg" src={CatFood1}/>
                        <p id="MarketPreviewText">(미개봉) 고양이 사료<br/>10000원</p>
                    </div>
                    <div id="MarketPreview2">
                        <img id="MarketPreviewImg" src={CatTower1}/>
                        <p id="MarketPreviewText">(실사용 1회) 캣타워<br/>50000원</p>
                    </div>
                    <div id="MarketPreview2">
                        <img id="MarketPreviewImg" src={CatFood1}/>
                        <p id="MarketPreviewText">(미개봉)고양이 사료<br/>10000원</p>
                    </div>
                </div>
                <div className="MarketPreviewRe">
                    <div id="MarketPreview1">
                        <img id="MarketPreviewImg" src={CatFood1}/>
                        <p id="MarketPreviewText">(미개봉)고양이 사료<br/>10000원</p>
                    </div>
                    <div id="MarketPreview2">
                        <img id="MarketPreviewImg" src={CatTower1}/>
                        <p id="MarketPreviewText">(실사용 1회) 캣타워<br/>50000원</p>
                    </div>
                    <div id="MarketPreview2">
                        <img id="MarketPreviewImg" src={CatFood1}/>
                        <p id="MarketPreviewText">(미개봉) 고양이 사료<br/>10000원</p>
                    </div>
                    <div id="MarketPreview2">
                        <img id="MarketPreviewImg" src={CatTower1}/>
                        <p id="MarketPreviewText">(실사용 1회) 캣타워<br/>50000원</p>
                    </div>
                    <div id="MarketPreview2">
                        <img id="MarketPreviewImg" src={CatFood1}/>
                        <p id="MarketPreviewText">(미개봉)고양이 사료<br/>10000원</p>
                    </div>
                </div>
            </div>
            <PetMeetingFooter/>
        </div>

    )
}

export default PetMeetingMarket