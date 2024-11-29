import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { createSelector } from "reselect";
import { allSurveys } from "../../../redux/surveysReducer";
import SurveyCardItem from "./SurveyCardItem";
import Grid from "@mui/material/Grid2";

const SurveyList = () => {
  const dispatch = useDispatch();
  const surveys = useSelector(
    createSelector(
      (store) => store.surveysReducer,
      (state) => state.surveys,
    ),
  );

  useEffect(() => {
    dispatch(allSurveys());
  }, []); // eslint-disable-line react-hooks/exhaustive-deps

  return (
    <Grid container spacing={{ xs: 1, md: 2 }}>
      {surveys.map((survey, index) => (
        <Grid size="6" key={index}>
          <SurveyCardItem survey={survey} />
        </Grid>
      ))}
    </Grid>
  );
};

export default SurveyList;
