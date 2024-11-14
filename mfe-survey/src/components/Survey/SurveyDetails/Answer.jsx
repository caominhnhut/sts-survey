import {
  TextField,
  FormControl,
  InputLabel,
  Box,
  Switch,
  IconButton,
} from "@mui/material";
import DeleteIcon from "@mui/icons-material/Delete";

const Answer = ({ answer, renderCount, questionType, onUpdate, onRemove }) => {
  return (
    <Box
      sx={{
        ml: 2,
        p: 2,
        border: "1px solid #eee",
        borderRadius: 1,
        mb: 1,
      }}
    >
      <div
        style={{
          display: "flex",
          justifyContent: "space-between",
          alignItems: "center",
        }}
      >
        <h4>Answer {renderCount}</h4>
        <IconButton onClick={onRemove} color="error">
          <DeleteIcon />
        </IconButton>
      </div>

      <TextField
        fullWidth
        label="Answer"
        value={answer.name}
        onChange={(e) => onUpdate("name", e.target.value)}
        margin="normal"
        multiline={questionType === "TEXT"}
        rows={5}
        required
      />

      <FormControl fullWidth margin="normal">
        <Box display="flex" alignItems="center" gap={1}>
          <Switch
            checked={answer.isCorrect}
            onChange={(e) => onUpdate("isCorrect", e.target.checked)}
            color="primary"
          />
          <InputLabel sx={{ position: "relative", transform: "none" }}>
            Correct Answer
          </InputLabel>
        </Box>
      </FormControl>
    </Box>
  );
};

export default Answer;
