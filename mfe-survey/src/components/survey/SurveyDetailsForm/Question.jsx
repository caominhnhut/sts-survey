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
          }}
          placeholder="Enter your answer..."
          onChange={(e) => handleAnswerChange(question, e.target.value)}
        />
      );
    }
    if (question.answerType === "SINGLE") {
      return (
        <div>
          {question.answers.map((answer) => (
            <div key={answer.id} style={{ marginBottom: "8px" }}>
              <input
                type="radio"
                id={`answer-${answer.id}`}
                name={`question-${question.id}`}
                onChange={(e) => handleAnswerChange(question, e.target.value)}
                value={answer.id}
              />
              <label
                htmlFor={`answer-${answer.id}`}
                style={{ marginLeft: "8px" }}
              >
                {answer.name}
              </label>
            </div>
          ))}
        </div>
      );
    }
    if (question.answerType === "MULTI") {
      return (
        <div>
          {question.answers.map((answer) => (
            <div key={answer.id} style={{ marginBottom: "8px" }}>
              <input
                type="checkbox"
                id={`answer-${answer.id}`}
                name={`question-${question.id}`}
                value={answer.id}
                onChange={(e) => handleAnswerChange(question, e.target.value)}
              />
              <label
                htmlFor={`answer-${answer.id}`}
                style={{ marginLeft: "8px" }}
              >
                {answer.name}
              </label>
            </div>
          ))}
        </div>
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
