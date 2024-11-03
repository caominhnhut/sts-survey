import * as React from "react";
import Card from "@mui/material/Card";
import CardActions from "@mui/material/CardActions";
import CardContent from "@mui/material/CardContent";
import Button from "@mui/material/Button";
import Typography from "@mui/material/Typography";
import EventNoteIcon from "@mui/icons-material/EventNote";
import { useNavigate } from "react-router-dom";

export default function SurveyCardItem({ survey }) {
  const navigate = useNavigate();
  return (
    <Card
      sx={{
        width: "300px",
        borderRadius: "12px",
        height: "100%",
      }}
    >
      <CardContent>
        <Typography
          variant="h6"
          component="div"
          sx={{
            fontSize: 14,
            color: "text.secondary",
            mb: 0.3,
            display: "flex",
          }}
        >
          <EventNoteIcon sx={{ mr: 1 }} /> Survey
        </Typography>
        <Typography
          gutterBottom
          sx={{
            color: "text.primary",
            fontWeight: "bold",
            fontSize: 16,
            mb: 0,
          }}
        >
          {survey.name}
        </Typography>
        <Typography sx={{ color: "text.secondary", fontSize: 12, mb: 1.5 }}>
          {survey.questions.length} questions
        </Typography>
        <Typography
          sx={{
            color: "text.secondary",
            fontSize: 12,
          }}
          className="three-lines-text"
        >
          {survey.description}
        </Typography>
      </CardContent>
      <CardActions sx={{ justifyContent: "right" }}>
        <Button size="large" onClick={() => navigate(`/surveys/${survey.id}`)}>
          TAKE SURVEY
        </Button>
      </CardActions>
    </Card>
  );
}
