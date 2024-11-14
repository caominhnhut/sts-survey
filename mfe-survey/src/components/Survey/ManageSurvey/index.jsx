import { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { createSelector } from "reselect";
import { allSurveys } from "../../../redux/surveysReducer";
import {
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Paper,
  IconButton,
  Button,
  TextField,
} from "@mui/material";
import AddIcon from "@mui/icons-material/Add";
import ArrowForwardIcon from "@mui/icons-material/ArrowForward";
import { useNavigate } from "react-router-dom";

const ManageSurvey = () => {
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const [searchKeyword, setSearch] = useState("");

  const surveys = useSelector(
    createSelector(
      (store) => store.surveysReducer,
      (state) => state.surveys,
    ),
  );

  const filteredSurveys = !searchKeyword
    ? surveys
    : surveys.filter((survey) => {
        let isMatch = false;
        const searchStrings = [
          `${survey.id}`,
          survey.name,
          survey.description,
          survey.status,
        ];
        for (const searchString of searchStrings) {
          if (
            searchString.toLowerCase().includes(searchKeyword.toLowerCase())
          ) {
            isMatch = true;
            continue;
          }
        }

        return isMatch;
      });

  useEffect(() => {
    dispatch(allSurveys());
  }, []); // eslint-disable-line react-hooks/exhaustive-deps

  return (
    <>
      <div style={{ display: "flex", justifyContent: "space-between" }}>
        <TextField
          label="Search"
          style={{ width: "20rem" }}
          size="small"
          className="search-input"
          onChange={(e) => setSearch(e.target.value)}
        />
        <Button
          variant="contained"
          startIcon={<AddIcon />}
          onClick={() => navigate("/surveys/new")}
          style={{
            marginBottom: "1rem",
          }}
          className="primary-button"
        >
          Create Survey
        </Button>
      </div>
      <TableContainer component={Paper}>
        <Table sx={{ minWidth: 650 }} aria-label="survey table">
          <TableHead>
            <TableRow>
              <TableCell>ID</TableCell>
              <TableCell>Name</TableCell>
              <TableCell>Description</TableCell>
              <TableCell align="center">Status</TableCell>
              <TableCell align="right">Actions</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {filteredSurveys.map((survey) => (
              <TableRow
                key={survey.id}
                sx={{ "&:last-child td, &:last-child th": { border: 0 } }}
              >
                <TableCell component="th" scope="row">
                  {survey.id}
                </TableCell>
                <TableCell>{survey.name}</TableCell>
                <TableCell>{survey.description}</TableCell>
                <TableCell>
                  {survey.status === "ACTIVE" ? (
                    <div className="badge active-status">Active</div>
                  ) : (
                    <div className="badge inactive-status">Inactive</div>
                  )}
                </TableCell>
                <TableCell align="right">
                  <IconButton
                    color="primary"
                    onClick={() => navigate(`/surveys/${survey.id}/edit`)}
                  >
                    <ArrowForwardIcon />
                  </IconButton>
                </TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    </>
  );
};

export default ManageSurvey;
