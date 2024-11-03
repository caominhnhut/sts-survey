import { useEffect, useState } from "react";
import { useDispatch } from "react-redux";
import { getSurveyDetails, submitSurvey } from "../../../redux/surveysReducer";
import { useParams } from "react-router-dom";
import { useSelector } from "react-redux";
import { createSelector } from "reselect";
import Question from "./Question";

const SurveyDetailsForm = () => {
  const { id } = useParams();
  const dispatch = useDispatch();

  const [answers, setAnswers] = useState({});

  const surveyDetails = useSelector(
    createSelector(
      (store) => store.surveysReducer,
      (state) => state.surveyDetails,
    ),
  );

  const surveyResult = useSelector(
    createSelector(
      (store) => store.surveysReducer,
      (state) => state.surveyResult,
    ),
  );

  useEffect(() => {
    dispatch(getSurveyDetails(id));
  }, []);

  const handleAnswerChange = (question, answer) => {
    const { id: questionId, answerType } = question;

    if (answerType === "TEXT") {
      setAnswers((prevAnswers) => ({
        ...prevAnswers,
        [questionId]: answer,
      }));
    } else if (answerType === "SINGLE") {
      setAnswers((prevAnswers) => ({
        ...prevAnswers,
        [questionId]: [+answer], // +answer to convert id from string to number
      }));
    } else if (answerType === "MULTI") {
      setAnswers((prevAnswers) => {
        let newAnswer = prevAnswers[questionId] || [];
        let answerId = +answer;

        if (newAnswer.includes(answerId)) {
          newAnswer = newAnswer.filter((id) => id !== answerId);
        } else {
          newAnswer.push(answerId);
        }

        return {
          ...prevAnswers,
          [questionId]: newAnswer,
        };
      });
    }
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const payload = { questionAnswers: [] };

    Object.keys(answers).forEach((questionId) => {
      const answer = answers[questionId];
      const isTextAnswer = typeof answer === "string";

      if (isTextAnswer) {
        payload.questionAnswers.push({
          questionId: +questionId,
          answerText: answers[questionId],
        });
      } else {
        payload.questionAnswers.push({
          questionId: +questionId,
          answerIds: answers[questionId],
        });
      }
    });

    dispatch(submitSurvey(id, payload));
  };

  return (
    <div>
      <h2>{surveyDetails.name}</h2>
      <p>{surveyDetails.description}</p>

      <form onSubmit={handleSubmit}>
        {surveyDetails.questions?.map((question, index) => (
          <Question
            key={question.id}
            question={question}
            index={index + 1}
            handleAnswerChange={handleAnswerChange}
          />
        ))}

        <button
          type="submit"
          style={{
            padding: "8px 16px",
            backgroundColor: "#1976d2",
            color: "white",
            border: "none",
            borderRadius: "4px",
          }}
        >
          Submit Survey
        </button>
      </form>
    </div>
  );
};

export default SurveyDetailsForm;
