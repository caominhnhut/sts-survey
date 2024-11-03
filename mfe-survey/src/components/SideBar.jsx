import { Sidebar, Menu, MenuItem } from "react-mui-sidebar";
import SpaceDashboardIcon from "@mui/icons-material/SpaceDashboard";

const SideBar = () => {
  return (
    <Sidebar width={"270px"} showProfile={false}>
      <Menu subHeading="">
        <MenuItem
          link="/"
          badge="true"
          badgeContent="New"
          icon={<SpaceDashboardIcon />}
        >
          Dashboard
        </MenuItem>
      </Menu>
    </Sidebar>
  );
};

export default SideBar;
