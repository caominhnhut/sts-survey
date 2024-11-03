import { SUCCESS_SUFFIX } from "redux-axios-middleware";

const LIST_SURVEYS = "LIST_SURVEYS";
const GET_SURVEY_DETAILS = "GET_SURVEY_DETAILS";
const SUBMIT_SURVEY = "SUBMIT_SURVEY";
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

    // case DELETE_SURVEY:
    //   return state.filter((survey) => survey.id !== action.payload.survey.id);

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
      url: `/api/surveys/${id}/users`,
      method: "POST",
      data: payload,
    },
  },
});

// export const addBook = (book) => {
//   console.log(`${UserService.getUsername()} added the book ${book.title}`);
//   return {
//     type: ADD_SURVEY,
//     payload: {
//       request: {
//         url: "/demo/books",
//         method: "POST",
//         data: book,
//       },
//     },
//   };
// };

// export const deleteBook = (book) => {
//   console.log(`${UserService.getUsername()} deletes the book ${book.title}`);
//   return {
//     type: DELETE_BOOK,
//     payload: {
//       book,
//       request: {
//         url: `/demo/books/${book.id}`,
//         method: "DELETE",
//       },
//     },
//   };
// };
