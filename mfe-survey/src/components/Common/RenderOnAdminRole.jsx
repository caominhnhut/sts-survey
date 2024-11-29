import UserService from "../../services/UserService";

const RenderOnAdminRole = ({ showNotAllowed, children }) => {
  return UserService.hasAdminRole() ? (
    children
  ) : showNotAllowed ? (
    <>You are not authorized to access this page</>
  ) : null;
};

RenderOnAdminRole.propTypes = {};

export default RenderOnAdminRole;
