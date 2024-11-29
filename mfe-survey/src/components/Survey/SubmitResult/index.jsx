import { useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";
import { createSelector } from "reselect";
import { CLEAR_SURVEY_RESULT } from "../../../redux/surveysReducer";
import Button from "@mui/material/Button";
import { useNavigate } from "react-router-dom";
const SubmitResult = () => {
  const navigate = useNavigate();
  const dispatch = useDispatch();
  const surveyResult = useSelector(
    createSelector(
      (store) => store.surveysReducer,
      (state) => state.surveyResult,
    ),
  );
  const surveyDetails = useSelector(
    createSelector(
      (store) => store.surveysReducer,
      (state) => state.surveyDetails,
    ),
  );

  useEffect(() => {
    return () => dispatch({ type: CLEAR_SURVEY_RESULT });
  }, []);

  if (!Object.keys(surveyResult).length) {
    return <h2 style={{ marginLeft: "32px" }}>Result not found</h2>;
  }

  return (
    <div style={{ display: "flex", justifyContent: "center" }}>
      <section
        style={{
          backgroundColor: "white",
          padding: "16px 32px",
          margin: "32px",
          borderRadius: "12px",
          border: "1px solid #e0e0e0",
          maxWidth: "650px",
        }}
      >
        <h2
          className="header"
          style={{
            color: "#3f4e58",
            textAlign: "left",
            fontWeight: "500",
            marginTop: 0,
          }}
        >
          Your survey has been submitted successfully.
        </h2>
        <div
          className="result-content"
          style={{
            display: "flex",
            alignItems: "center",
            justifyContent: "center",
          }}
        >
          <table className="result-table">
            <tbody>
              <tr>
                <th>Total questions</th>
                <td>{surveyResult.totalQuestion}</td>
              </tr>
              <tr>
                <th>Pass correct answer number</th>
                <td>{surveyResult.passCorrectAnswerNumber}</td>
              </tr>
              <tr>
                <th>Cover correct answer number</th>
                <td>{surveyResult.coverCorrectAnswerNumber}</td>
              </tr>
              <tr>
                <th>Pass percentage</th>
                <td>{surveyResult.passPercentage}%</td>
              </tr>
              <tr>
                <th>Cover percentage</th>
                <td>{surveyResult.coverPercentage}%</td>
              </tr>
              <tr>
                <th>Result</th>
                <td>
                  <span
                    className={`${surveyResult.result === "PASS" ? "pass" : "fail"}`}
                    style={{ fontWeight: 500 }}
                  >
                    {surveyResult.result === "PASS" ? "Pass" : "Fail"}
                  </span>
                </td>
              </tr>
            </tbody>
          </table>
        </div>
        <Button
          style={{ width: "100%", marginTop: "20px" }}
          onClick={() => {
            dispatch({ type: CLEAR_SURVEY_RESULT });
            navigate(`/surveys/${surveyDetails.id}`);
          }}
        >
          Retake survey
        </Button>
      </section>
    </div>
  );
};

export default SubmitResult;
