import TakeSurveyForm from "../../../components/Survey/TakeSurveyForm";
import PageHeader from "../../../components/Common/PageHeader";

const TakeSurveyPage = () => {
  return (
    <>
      <PageHeader title="Survey Details" />
      <div style={{ padding: "0 32px" }}>
        <TakeSurveyForm />
      </div>
    </>
  );
};

export default TakeSurveyPage;
