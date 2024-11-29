import {
  Box,
  Button,
  FormControl,
  FormHelperText,
  IconButton,
  InputLabel,
  MenuItem,
  Select,
  TextField,
} from "@mui/material";
import DeleteIcon from "@mui/icons-material/Delete";
import AddIcon from "@mui/icons-material/Add";
import Answer from "./Answer";

const ANSWER_TYPES = {
  SINGLE: "SINGLE",
  MULTI: "MULTI",
  TEXT: "TEXT",
};

const Question = ({
  renderCount,
  index,
  question,
  onUpdate,
  onRemove,
  onAddAnswer,
  onUpdateAnswer,
  onRemoveAnswer,
}) => {
  const isAnyAnswerCorrect = question.answers.some(
    (answer) => answer.isCorrect && !answer.isDeleted,
  );

  function renderAnswer() {
    let renderAnsCount = 0;
    return question.answers.map((answer, aIndex) => {
      if (answer.isDeleted) {
        return <></>;
      }

      renderAnsCount++;
      return (
        <Answer
          key={`q[${index}]answer-${aIndex}`}
          renderCount={renderAnsCount}
          answer={answer}
          index={aIndex}
          questionType={question.answerType}
          onUpdate={(field, value) => onUpdateAnswer(aIndex, field, value)}
          onRemove={() => onRemoveAnswer(aIndex)}
        />
      );
    });
  }
  return (
    <Box
      sx={{
        mt: 3,
        p: 2,
        border: "1px solid #ddd",
        borderRadius: 1,
        backgroundColor: "white",
      }}
      className="section"
    >
      <div
        style={{
          display: "flex",
          justifyContent: "space-between",
          alignItems: "center",
        }}
      >
        <h3>Question {renderCount}</h3>
        <IconButton onClick={onRemove} color="error">
          <DeleteIcon />
        </IconButton>
      </div>

      <TextField
        fullWidth
        label="Question"
        value={question.name}
        onChange={(e) => onUpdate("name", e.target.value)}
        margin="normal"
        required
      />

      <TextField
        fullWidth
        label="Question Description"
        value={question.description}
        onChange={(e) => onUpdate("description", e.target.value)}
        margin="normal"
        multiline
        rows={2}
      />

      <FormControl fullWidth margin="normal">
        <InputLabel>Answer Type</InputLabel>
        <Select
          value={question.answerType}
          label="Answer Type"
          onChange={(e) => onUpdate("answerType", e.target.value)}
        >
          <MenuItem value={ANSWER_TYPES.SINGLE}>Single Choice</MenuItem>
          <MenuItem value={ANSWER_TYPES.MULTI}>Multiple Choices</MenuItem>
          <MenuItem value={ANSWER_TYPES.TEXT}>Text</MenuItem>
        </Select>
        {!isAnyAnswerCorrect && (
          <FormHelperText error>
            At least one answer must be correct
          </FormHelperText>
        )}
      </FormControl>

      <Box sx={{ mt: 2, mb: 2 }}>
        <Button
          variant="outlined"
          size="small"
          startIcon={<AddIcon />}
          onClick={onAddAnswer}
        >
          Add Answer
        </Button>
      </Box>

      {renderAnswer()}
    </Box>
  );
};

export default Question;
