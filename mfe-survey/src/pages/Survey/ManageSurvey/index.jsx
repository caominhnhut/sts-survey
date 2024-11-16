import PageHeader from "../../../components/Common/PageHeader";
import ManageSurvey from "../../../components/Survey/ManageSurvey";

const ManageSurveyPage = () => {
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
