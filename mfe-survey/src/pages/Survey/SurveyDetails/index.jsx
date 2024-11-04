import Typography from "@mui/material/Typography";
import SurveyDetailsForm from "../../../components/Survey/SurveyDetailsForm";
const SurveyDetailsPage = () => {
  return (
    <>
      <Typography
        variant="h5"
        sx={{
          fontWeight: "bold",
          backgroundColor: "white",
          padding: "12px",
          mb: 4,
          pl: 4,
          color: "#4c7b9f",
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
