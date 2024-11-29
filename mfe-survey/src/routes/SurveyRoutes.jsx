import { Route, Routes } from "react-router-dom";
import SurveyPage from "../pages/Survey/SurveyList/index";
import TakeSurveyPage from "../pages/Survey/TakeSurvey/index";
import SubmitResult from "../pages/Survey/SubmitResult/index";
import SurveyDetailsPage from "../pages/Survey/SurveyDetails/index";
import ManageSurveyPage from "../pages/Survey/ManageSurvey/index";
import RenderOnAdminRole from "../components/Common/RenderOnAdminRole";

const SurveyRoutes = () => (
  <>
    <Routes>
      <Route exact path="/" element={<SurveyPage />} />
      <Route exact path="/surveys/:id" element={<TakeSurveyPage />} />
      <Route exact path="/surveys/result" element={<SubmitResult />} />
      <Route
        exact
        path="/surveys/new"
        element={
          <RenderOnAdminRole showNotAllowed={true}>
            <SurveyDetailsPage />
          </RenderOnAdminRole>
        }
      />
      <Route
        exact
        path="/surveys/:id/edit"
        element={
          <RenderOnAdminRole showNotAllowed={true}>
            <SurveyDetailsPage />
          </RenderOnAdminRole>
        }
      />
      <Route
        exact
        path="/manage-survey"
        element={
          <RenderOnAdminRole showNotAllowed={true}>
            <ManageSurveyPage />
          </RenderOnAdminRole>
        }
      />
    </Routes>
  </>
);

export default SurveyRoutes;
