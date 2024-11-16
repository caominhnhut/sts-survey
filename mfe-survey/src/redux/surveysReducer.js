import { SUCCESS_SUFFIX } from "redux-axios-middleware";

const LIST_SURVEYS = "LIST_SURVEYS";
const GET_SURVEY_DETAILS = "GET_SURVEY_DETAILS";
const SUBMIT_SURVEY = "SUBMIT_SURVEY";
export const CLEAR_SURVEY_RESULT = "CLEAR_SURVEY_RESULT";
const CREATE_SURVEY = "CREATE_SURVEY";
const UPDATE_SURVEY = "UPDATE_SURVEY";
const CONFIG_SURVEY = "CONFIG_SURVEY";
export const CLEAR_NEW_SURVEY_ID = "CLEAR_NEW_SURVEY_ID";

const initialState = {
  surveys: [],
  surveyDetails: {},
  surveyResult: {},
  configSurvey: {},
  newSurveyId: null,
};

const surveysReducer = (state = initialState, action) => {
  switch (action.type) {
    case LIST_SURVEYS + SUCCESS_SUFFIX:
      return { ...state, surveys: action.payload.data?.data || [] };

    case GET_SURVEY_DETAILS + SUCCESS_SUFFIX:
      return { ...state, surveyDetails: action.payload.data?.data || {} };

    case SUBMIT_SURVEY + SUCCESS_SUFFIX:
      return { ...state, surveyResult: action.payload.data?.data || {} };

    case CLEAR_SURVEY_RESULT:
      return { ...state, surveyResult: {} };

    case CREATE_SURVEY + SUCCESS_SUFFIX:
      const surveyId = action.payload.headers.get("x-id");
      return { ...state, surveyDetails: {}, newSurveyId: surveyId };

    case CLEAR_NEW_SURVEY_ID:
      return { ...state, newSurveyId: null };

    case GET_SURVEY_DETAILS + SUCCESS_SUFFIX:
      return { ...state, surveyDetails: action.payload.data?.data || {} };

    case UPDATE_SURVEY + SUCCESS_SUFFIX:
      return { ...state, surveyDetails: action.payload.data?.data || {} };

    case CONFIG_SURVEY + SUCCESS_SUFFIX:
      return { ...state, configSurvey: action.payload.data?.data || {} };

    default:
      return state;
  }
};

export default surveysReducer;

export const allSurveys = () => ({
  type: LIST_SURVEYS,
  payload: {
    request: {
      url: "/api/surveys",
    },
  },
});

export const getSurveyDetails = (id) => ({
  type: GET_SURVEY_DETAILS,
  payload: {
    request: {
      url: `/api/surveys/${id}`,
    },
  },
});

export const getConfigSurvey = (id) => ({
  type: CONFIG_SURVEY,
  payload: {
    request: {
      url: `/api/surveys/${id}/config`,
    },
  },
});

export const submitSurvey = (id, payload) => ({
  type: SUBMIT_SURVEY,
  payload: {
    request: {
      url: `/api/users/surveys/${id}`,
      method: "POST",
      data: payload,
    },
  },
});

export const createSurvey = (payload) => ({
  type: CREATE_SURVEY,
  payload: {
    request: {
      url: "/api/surveys",
      method: "POST",
      data: payload,
    },
  },
});

export const updateSurvey = (id, payload) => ({
  type: UPDATE_SURVEY,
  payload: {
    request: {
      url: `/api/surveys/${id}`,
      method: "PATCH",
      data: payload,
    },
  },
});
