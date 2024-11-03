import Typography from "@mui/material/Typography";
import SurveyDetailsForm from "../../components/survey/SurveyDetailsForm";
const SurveyDetailsPage = () => {
  return (
    <>
      <Typography
        variant="h5"
        sx={{
          fontWeight: "semibold",
          backgroundColor: "white",
          padding: "12px",
          mb: 4,
          pl: 4,
        }}
      >
        Survey Details
      </Typography>
      <div style={{ padding: "0 32px" }}>
        <SurveyDetailsForm />
      </div>
    </>
  );
};

export default SurveyDetailsPage;
