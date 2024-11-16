import { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { useParams } from "react-router-dom";
import { createSelector } from "reselect";
import { TextField, Button } from "@mui/material";
import AddIcon from "@mui/icons-material/Add";
import {
  createSurvey,
  updateSurvey,
  getConfigSurvey,
} from "../../../redux/surveysReducer";
import Question from "./Question";
import cloneDeep from "lodash/cloneDeep";
import { toast } from "react-toastify";
import { useNavigate } from "react-router-dom";

const ANSWER_TYPES = {
  SINGLE: "SINGLE",
  MULTI: "MULTI",
  TEXT: "TEXT",
};

const DEFAULT_ANSWER = {
  name: "",
  isCorrect: false,
};

const DEFAULT_CORRECT_ANSWER = {
  name: "",
  isCorrect: true,
};

const DEFAULT_QUESTION = {
  name: "",
  description: "",
  answerType: ANSWER_TYPES.SINGLE,
  answers: [DEFAULT_CORRECT_ANSWER],
};

const SurveyDetailsForm = () => {
  const { id } = useParams();
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const [formData, setFormData] = useState({
    name: "",
    description: "",
    performTimeout: 900000, // 15 minutes in milliseconds
    passCorrectAnswerNumber: 1,
    questions: [DEFAULT_QUESTION],
  });

  const surveyDetailsConfig = useSelector(
    createSelector(
      (store) => store.surveysReducer,
      (state) => state.configSurvey,
    ),
  );

  const newSurveyId = useSelector(
    createSelector(
      (store) => store.surveysReducer,
      (state) => state.newSurveyId,
    ),
  );

  useEffect(() => {
    if (newSurveyId && !id) {
      // IS CREATING - AFTER CREATE SUCCESS
      navigate(`/surveys/${newSurveyId}/edit`);
    } else if (id && newSurveyId) {
      // IS EDITING - AFTER CREATE SUCCESS
      dispatch({ type: CLEAR_NEW_SURVEY_ID });
    }
  }, [newSurveyId]);

  useEffect(() => {
    if (id) {
      dispatch(getConfigSurvey(id));
    }
  }, [id]);

  useEffect(() => {
    if (id && surveyDetailsConfig?.id) {
      setFormData(surveyDetailsConfig);
    }
  }, [surveyDetailsConfig]);

  const handleSubmit = (e) => {
    e.preventDefault();

    // Transform the data to match the DTO structure
    const payload = {
      ...formData,
      questions: [],
    };
    delete payload.id;
    delete payload.status;
    let remainingQuestionAfterSubmit = formData.questions.length;

    for (let question of formData.questions) {
      // DON'T TRY TO UNDERSTAND THIS CODE.
      // FROM THE BEGINNING THERE ARE 2 PEOPLE UNDERSTAND THIS, GOD AND ME, I'M PRETTY SURE THAT NOW IT'S ONLY GOD LEFT.
      if (question.isDeleted) {
        --remainingQuestionAfterSubmit;
        // IF DELETED QUESTION IS NOT EXISTED IN DB, THEN SKIP
        if (!question.id) {
          continue;
        }
      }

      // ADD TO PAYLOAD PROCESS
      const mappedQuestion = {
        ...question,
        answers: [],
      };

      delete mappedQuestion.status;
      for (let answer of question.answers) {
        if (answer.isDeleted && !answer.id) {
          continue;
        }

        mappedQuestion.answers.push({
          ...answer,
        });
      }

      payload.questions.push(mappedQuestion);
    }

    if (remainingQuestionAfterSubmit === 0) {
      toast.error("Please add at least one question");
      return;
    }

    if (remainingQuestionAfterSubmit < formData.passCorrectAnswerNumber) {
      toast.error("Remaining questions is NOT ENOUGH to pass the survey");
      return;
    }

    if (id) {
      dispatch(updateSurvey(id, payload));
      toast.success("Survey updated successfully");
    } else {
      dispatch(createSurvey(payload));
      toast.success("Survey created successfully");
    }
  };

  const addQuestion = () => {
    setFormData({
      ...formData,
      questions: [...formData.questions, { ...DEFAULT_QUESTION }],
    });
  };

  const addAnswer = (questionIndex) => {
    const newQuestions = cloneDeep(formData.questions);
    newQuestions[questionIndex].answers.push({ ...DEFAULT_ANSWER });
    setFormData({ ...formData, questions: newQuestions });
  };

  const removeQuestion = (index) => {
    const newQuestions = cloneDeep(formData.questions);
    const deletingQuestion = newQuestions[index];
    if (deletingQuestion) {
      deletingQuestion.isDeleted = true;
    }
    setFormData({ ...formData, questions: newQuestions });
  };

  const removeAnswer = (questionIndex, answerIndex) => {
    const newQuestions = cloneDeep(formData.questions);
    const deletingQuestion = newQuestions[questionIndex];
    if (deletingQuestion.answers) {
      deletingQuestion.answers[answerIndex].isDeleted = true;
    }
    setFormData({ ...formData, questions: newQuestions });
  };

  const updateQuestion = (index, field, value) => {
    const newQuestions = cloneDeep(formData.questions);
    const updatingQuestion = newQuestions[index];
    if (updatingQuestion) {
      if (field === "answerType" && value === ANSWER_TYPES.SINGLE) {
        updatingQuestion.answers.forEach((answer) => {
          answer.isCorrect = false;
        });
      }

      updatingQuestion[field] = value;
    }
    setFormData({ ...formData, questions: newQuestions });
  };

  const updateAnswer = (questionIndex, answerIndex, field, value) => {
    const newQuestions = cloneDeep(formData.questions);
    const updatingQuestion = newQuestions[questionIndex];

    if (
      field === "isCorrect" &&
      updatingQuestion.answerType === "SINGLE" &&
      !!value
    ) {
      updatingQuestion.answers.forEach((answer) => {
        answer.isCorrect = false;
      });
    }
    newQuestions[questionIndex].answers[answerIndex][field] = value;
    setFormData({ ...formData, questions: newQuestions });
  };

  function renderQuestions() {
    let renderCount = 0;
    return formData.questions.map((question, qIndex) => {
      if (question.isDeleted) {
        return <></>;
      }

      renderCount++;
      return (
        <Question
          key={`question-${qIndex}`}
          renderCount={renderCount}
          question={question}
          index={qIndex}
          onUpdate={(field, value) => updateQuestion(qIndex, field, value)}
          onRemove={() => removeQuestion(qIndex)}
          onAddAnswer={() => addAnswer(qIndex)}
          onUpdateAnswer={(aIndex, field, value) =>
            updateAnswer(qIndex, aIndex, field, value)
          }
          onRemoveAnswer={(aIndex) => removeAnswer(qIndex, aIndex)}
        />
      );
    });
  }

  return (
    <form onSubmit={handleSubmit}>
      <div className="section">
        <h3 style={{ display: "inline-block" }}>Survey details</h3>

        <TextField
          fullWidth
          label="Survey Name"
          value={formData.name}
          onChange={(e) => setFormData({ ...formData, name: e.target.value })}
          margin="none"
          required
        />

        <TextField
          fullWidth
          label="Description"
          value={formData.description}
          onChange={(e) =>
            setFormData({ ...formData, description: e.target.value })
          }
          margin="normal"
          multiline
          rows={3}
        />

        <TextField
          type="number"
          label="Pass Correct Answer Number"
          value={formData.passCorrectAnswerNumber}
          inputProps={{ min: 1 }}
          onChange={(e) =>
            setFormData({
              ...formData,
              passCorrectAnswerNumber: parseInt(e.target.value),
            })
          }
          margin="normal"
          required
        />
      </div>
      <div
        style={{
          position: "sticky",
          top: "100px",
          display: "flex",
          justifyContent: "flex-end",
          zIndex: 1000,
          marginTop: "2rem",
        }}
      >
        <Button
          variant="contained"
          startIcon={<AddIcon />}
          onClick={addQuestion}
        >
          Add Question
        </Button>
      </div>

      {renderQuestions()}

      <Button
        type="submit"
        variant="contained"
        style={{
          margin: "2rem 0",
          float: "right",
        }}
        className="primary-button"
      >
        {id ? "Update Survey" : "Create Survey"}
      </Button>
    </form>
  );
};

export default SurveyDetailsForm;
