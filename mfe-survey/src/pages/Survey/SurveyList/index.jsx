import SurveyList from "../../../components/Survey/SurveyList";
import PageHeader from "../../../components/Common/PageHeader";

const SurveyPage = () => {
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
