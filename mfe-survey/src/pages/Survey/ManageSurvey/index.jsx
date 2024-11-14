import SurveyList from "../../../components/Survey/SurveyList";
import UserService from "../../../services/UserService";
import PageHeader from "../../../components/Common/PageHeader";
import ManageSurvey from "../../../components/Survey/ManageSurvey";
const ManageSurveyPage = () => {
  const isAdmin = UserService.hasAdminRole();

  return (
    <>
      <PageHeader title="Surveys configuration" />
      <div style={{ padding: "0 32px" }}>
        <ManageSurvey />
      </div>
    </>
  );
};

export default ManageSurveyPage;
