import { Provider } from "react-redux";
import { BrowserRouter } from "react-router-dom";
import RenderOnAuthenticated from "../Common/RenderOnAuthenticated";
import UserLayout from "../../layouts/UserLayout";
import SurveyRoutes from "../../routes/SurveyRoutes";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

const App = ({ store }) => {
  return (
    <Provider store={store}>
      <BrowserRouter>
        <div className="container">
          <ToastContainer position="bottom-left" />
          <RenderOnAuthenticated>
            <UserLayout>
              <SurveyRoutes />
            </UserLayout>
          </RenderOnAuthenticated>
        </div>
      </BrowserRouter>
    </Provider>
  );
};

export default App;
