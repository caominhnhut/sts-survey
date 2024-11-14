import React from "react";
import Typography from "@mui/material/Typography";
const PageHeader = ({ title, children }) => {
  return (
    <Typography
      variant="h5"
      sx={{
        fontWeight: "bold",
        backgroundColor: "white",
        padding: "12px",
        mb: 4,
        pl: 4,
        color: "#74b915",
      }}
    >
      {title || children}
    </Typography>
  );
};

export default PageHeader;
