import PetMeetingHeader from "./js/PetMeetingHeader";
import PetMeetingFooter from "./js/PetMeetingFooter";
import PetMeetingTopBanner from "./js/PetMeetingTopBanner";
import PetMeetingBestShow from "./js/PetMeetingBestShow";
import PetMeetingCompany from "./js/PetMeetingCompany";

function App() {
  return (
    <div>
        <PetMeetingHeader/>
        <PetMeetingTopBanner />
        <PetMeetingBestShow />
        <PetMeetingFooter />
        {/*<PetMeetingCompany />*/}

    </div>
  );
}

export default App;
