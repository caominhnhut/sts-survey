import axios from "axios";
import { createRoot } from "react-dom/client";
import { applyMiddleware, createStore } from "redux";
import axiosMiddleware from "redux-axios-middleware";
import thunk from "redux-thunk";
import App from "./components/App/App";
import rootReducer from "./redux";
import UserService from "./services/UserService";
import "./index.scss";

// HTTP
const _axios = axios.create({
  baseURL: "http://localhost:8181",
});
_axios.interceptors.request.use((config) => {
  if (UserService.isLoggedIn()) {
    const cb = () => {
      config.headers.Authorization = `Bearer ${UserService.getToken()}`;
      return Promise.resolve(config);
    };
    return UserService.updateToken(cb);
  }
});

// REDUX STORE
const _middleware = applyMiddleware(thunk, axiosMiddleware(_axios));
const store = createStore(rootReducer, _middleware);

// APP
const renderApp = () =>
  createRoot(document.getElementById("app")).render(<App store={store} />);

UserService.initKeycloak(renderApp);
