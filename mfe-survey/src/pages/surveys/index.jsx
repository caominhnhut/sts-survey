import SurveyList from "../../components/survey/SurveyList";
import Typography from "@mui/material/Typography";

const SurveyPage = () => {
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
        Surveys
      </Typography>
      <div style={{ padding: "0 32px" }}>
        <SurveyList />
      </div>
    </>
  );
};

export default SurveyPage;
