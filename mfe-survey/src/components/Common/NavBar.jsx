import * as React from "react";
import AppBar from "@mui/material/AppBar";
import Box from "@mui/material/Box";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import Button from "@mui/material/Button";
import IconButton from "@mui/material/IconButton";
import UserService from "../../services/UserService";
import AssignmentIcon from "@mui/icons-material/Assignment";
import { useNavigate } from "react-router-dom";

export default function ButtonAppBar() {
  const navigate = useNavigate();
  return (
    <Box sx={{ flexGrow: 1 }}>
      <AppBar className="navbar">
        <Toolbar>
          <IconButton
            size="large"
            edge="start"
            color="inherit"
            aria-label="menu"
            sx={{ mr: 2 }}
          >
            <AssignmentIcon />
          </IconButton>
          <Typography
            variant="h6"
            component="div"
            sx={{ flexGrow: 1, cursor: "pointer" }}
            onClick={() => navigate("/")}
          >
            <span style={{ color: "black", fontWeight: "bold" }}>STS</span>{" "}
            <span style={{ color: "#74b915", fontWeight: "bold" }}>Survey</span>
          </Typography>
          <div style={{ display: "flex", alignItems: "center", gap: "12px" }}>
            <div className="">
              Signed in as <b>{UserService.getUsername()}</b>
            </div>
            <Button variant="text" onClick={() => UserService.doLogout()}>
              Logout
            </Button>
          </div>
        </Toolbar>
      </AppBar>
    </Box>
  );
}
