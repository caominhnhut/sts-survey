import * as React from "react";
import AppBar from "@mui/material/AppBar";
import Box from "@mui/material/Box";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import Button from "@mui/material/Button";
import IconButton from "@mui/material/IconButton";
import UserService from "../services/UserService";

export default function ButtonAppBar() {
  return (
    <Box sx={{ flexGrow: 1 }}>
      <AppBar position="static">
        <Toolbar>
          <IconButton
            size="large"
            edge="start"
            color="inherit"
            aria-label="menu"
            sx={{ mr: 2 }}
          ></IconButton>
          <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
            STS Survey
          </Typography>
          <div className="">
            <div className="">
              Signed in as <b>{UserService.getUsername()}</b>
            </div>
            <Button color="inherit" onClick={() => UserService.doLogout()}>
              Logout
            </Button>
          </div>
        </Toolbar>
      </AppBar>
    </Box>
  );
}
