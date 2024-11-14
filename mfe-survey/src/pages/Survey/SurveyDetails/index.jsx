import SurveyDetailsForm from "../../../components/Survey/SurveyDetails";
import { useParams } from "react-router-dom";
import PageHeader from "../../../components/Common/PageHeader";

const SurveyDetailsPage = () => {
  const { id } = useParams();

  return (
    <>
      <PageHeader title={id ? "Edit Survey" : "Create Survey"} />
      <div style={{ padding: "0 32px" }}>
        <SurveyDetailsForm />
      </div>
    </>
  );
};

export default SurveyDetailsPage;
