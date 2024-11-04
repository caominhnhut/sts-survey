import SurveyList from "../../../components/Survey/SurveyList";
import Typography from "@mui/material/Typography";

const SurveyPage = () => {
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
        Surveys
      </Typography>
      <div style={{ padding: "0 32px" }}>
        <SurveyList />
      </div>
    </>
  );
};

export default SurveyPage;
