import SubmitResult from "../../../components/Survey/SubmitResult";
import Typography from "@mui/material/Typography";

const index = () => {
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
        Submit Result
      </Typography>
      <SubmitResult />
    </>
  );
};

export default index;
