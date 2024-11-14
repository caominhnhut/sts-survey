import SurveyList from "../../../components/Survey/SurveyList";
import UserService from "../../../services/UserService";
import PageHeader from "../../../components/Common/PageHeader";

const SurveyPage = () => {
  const isAdmin = UserService.hasAdminRole();

  return (
    <>
      <PageHeader title="Surveys" />
      <div style={{ padding: "0 32px" }}>
        <SurveyList />
      </div>
    </>
  );
};

export default SurveyPage;
