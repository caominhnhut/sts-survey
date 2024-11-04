import { Route, Routes } from "react-router-dom";
import SurveyPage from "../pages/Survey/SurveyList/index";
import SurveyDetailsPage from "../pages/Survey/SurveyDetails/index";
import SubmitResult from "../pages/Survey/SubmitResult/index";

const SurveyRoutes = () => (
  <>
    <Routes>
      <Route exact path="/" element={<SurveyPage />} />
      <Route exact path="/surveys/:id" element={<SurveyDetailsPage />} />
      <Route exact path="/surveys/result" element={<SubmitResult />} />
    </Routes>
  </>
);

export default SurveyRoutes;
