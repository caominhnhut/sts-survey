import { Route, Routes } from "react-router-dom";
import SurveyPage from "../pages/surveys/index";
import SurveyDetailsPage from "../pages/survey-details/index";

const SurveyRoutes = () => (
  <>
    <Routes>
      <Route exact path="/" element={<SurveyPage />} />
      <Route exact path="/surveys/:id" element={<SurveyDetailsPage />} />
    </Routes>
  </>
);

export default SurveyRoutes;
