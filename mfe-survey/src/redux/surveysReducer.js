import { SUCCESS_SUFFIX } from "redux-axios-middleware";

const LIST_SURVEYS = "LIST_SURVEYS";
const GET_SURVEY_DETAILS = "GET_SURVEY_DETAILS";
const SUBMIT_SURVEY = "SUBMIT_SURVEY";
export const CLEAR_SURVEY_RESULT = "CLEAR_SURVEY_RESULT";

const initialState = {
  surveys: [],
  surveyDetails: {},
  surveyResult: {},
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
