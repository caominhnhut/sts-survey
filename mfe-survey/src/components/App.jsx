import { Provider } from "react-redux";
import { BrowserRouter } from "react-router-dom";
import RenderOnAuthenticated from "./RenderOnAuthenticated";
import UserLayout from "../layouts/UserLayout";
import SurveyRoutes from "../routes/SurveyRoutes";

const App = ({ store }) => (
  <Provider store={store}>
    <BrowserRouter>
      <div className="container">
        <RenderOnAuthenticated>
          <UserLayout>
            <SurveyRoutes />
          </UserLayout>
        </RenderOnAuthenticated>
      </div>
    </BrowserRouter>
  </Provider>
);

export default App;
