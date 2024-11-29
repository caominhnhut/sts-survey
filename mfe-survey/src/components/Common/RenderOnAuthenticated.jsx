import UserService from "../../services/UserService";

const RenderOnAuthenticated = ({ children }) =>
  UserService.isLoggedIn() ? children : UserService.doLogin();

export default RenderOnAuthenticated;
