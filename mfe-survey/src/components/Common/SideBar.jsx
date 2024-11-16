import { Menu, Sidebar } from "react-mui-sidebar";
import SpaceDashboardIcon from "@mui/icons-material/SpaceDashboard";
import SettingsIcon from "@mui/icons-material/Settings";
import { useLocation, useNavigate } from "react-router-dom";
import RenderOnAdminRole from "./RenderOnAdminRole";

const SideBar = () => {
  const location = useLocation();
  const navigate = useNavigate();

  return (
    <div className="sidebar-container">
      <Sidebar showProfile={false}>
        <Menu subHeading="">
          <div
            className={`${location.pathname === "/" ? "selected" : ""} custom-menu-item`}
            onClick={() => navigate("/")}
          >
            <SpaceDashboardIcon /> Dashboard
          </div>
          <RenderOnAdminRole>
            <div
              className={`${location.pathname === "/manage-survey" ? "selected" : ""} custom-menu-item`}
              onClick={() => navigate("/manage-survey")}
            >
              <SettingsIcon /> Configuration
            </div>
          </RenderOnAdminRole>
        </Menu>
      </Sidebar>
    </div>
  );
};

export default SideBar;
