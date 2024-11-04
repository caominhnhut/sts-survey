import { Sidebar, Menu, MenuItem } from "react-mui-sidebar";
import SpaceDashboardIcon from "@mui/icons-material/SpaceDashboard";
import { useNavigate, useLocation } from "react-router-dom";

const SideBar = () => {
  const location = useLocation();
  const navigate = useNavigate();

  return (
    <Sidebar width={"270px"} showProfile={false}>
      <Menu subHeading="">
        <div
          className={`${location.pathname === "/" ? "selected" : ""} custom-menu-item`}
          onClick={() => navigate("/")}
        >
          <SpaceDashboardIcon /> Dashboard
        </div>
      </Menu>
    </Sidebar>
  );
};

export default SideBar;
