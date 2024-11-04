import {
  Radio,
  RadioGroup,
  FormControlLabel,
  FormControl,
  Checkbox,
} from "@mui/material";

const Question = ({ question, index, handleAnswerChange }) => {
  const renderAnswerByQuestionType = () => {
    if (question.answerType === "TEXT") {
      return (
        <textarea
          rows={4}
          style={{
            width: "100%",
            padding: "8px",
            borderRadius: "4px",
            border: "1px solid #e0e0e0",
            boxSizing: "border-box",
            fontSize: "16px",
            backgroundColor: "rgb(246, 246, 246)",
          }}
          placeholder="Enter your answer..."
          onChange={(e) => handleAnswerChange(question, e.target.value)}
        />
      );
    }
    if (question.answerType === "SINGLE") {
      return (
        <FormControl>
          <RadioGroup
            onChange={(e) => handleAnswerChange(question, e.target.value)}
          >
            {question.answers.map((answer) => (
              <FormControlLabel
                control={<Radio />}
                value={answer.id}
                label={answer.name}
              />
            ))}
          </RadioGroup>
        </FormControl>
      );
    }
    if (question.answerType === "MULTI") {
      return (
        <FormControl>
          {question.answers.map((answer) => (
            <FormControlLabel
              control={<Checkbox />}
              value={answer.id}
              label={answer.name}
              onChange={(e) => handleAnswerChange(question, e.target.value)}
            />
          ))}
        </FormControl>
      );
    }
  };

  return (
    <div
      style={{
        marginBottom: "20px",
        backgroundColor: "white",
        borderRadius: "8px",
        border: "1px solid #e0e0e0",
      }}
    >
      {/* Question header */}
      <div
        style={{
          display: "flex",
          borderBottom: "1px solid #e0e0e0",
          padding: "20px",
        }}
      >
        <div style={{ height: "100%", width: "30px", fontWeight: 600 }}>
          {index}
        </div>
        <div>
          <div>
            <h4 style={{ margin: 0, fontWeight: 500 }}>{question.name}</h4>
          </div>
          <div>
            <h5 style={{ margin: 0, fontWeight: 500 }}>
              {question.description ? `(${question.description})` : ""}
            </h5>
          </div>
        </div>
      </div>
      {/* Answer */}
      <div style={{ padding: "20px 46px" }}>{renderAnswerByQuestionType()}</div>
    </div>
  );
};

export default Question;
