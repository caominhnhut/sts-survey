-- #7
INSERT INTO public.survey (name, description, perform_timeout, pass_correct_answer_number, status) VALUES ('History Quiz', 'Testing knowledge of historical events.', 900000, 2, 'ACTIVE');

INSERT INTO public.question (name, description, answer_type, status) VALUES ('Who was the first president of the United States?', null, 'SINGLE', 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('George Washington', null, 21, true, 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('Thomas Jefferson', null, 21, false, 'ACTIVE');

INSERT INTO public.question (name, description, answer_type, status) VALUES ('Which of these events happened in 1776?', null, 'MULTI', 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('American Declaration of Independence', null, 22, true, 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('Something happened', null, 22, true, 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('French Revolution', null, 22, false, 'ACTIVE');

INSERT INTO public.question (name, description, answer_type, status) VALUES ('Discuss the impact of historical events on modern society.', 'Share your thoughts on how history shapes today.', 'TEXT', 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('<Some keyword could be used for checking TEXT type>', null, 23, true, 'ACTIVE');

INSERT INTO public.survey_question (survey_id, question_id) VALUES (7, 21);
INSERT INTO public.survey_question (survey_id, question_id) VALUES (7, 22);
INSERT INTO public.survey_question (survey_id, question_id) VALUES (7, 23);
----------------------------------------------------------------------------------------------------
-- #8
INSERT INTO public.survey (name, description, perform_timeout, pass_correct_answer_number, status) VALUES ('Mathematics', 'Basic math questions.', 900000, 2, 'ACTIVE');

INSERT INTO public.question (name, description, answer_type, status) VALUES ('What is 5 + 7?', null, 'SINGLE', 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('12', null, 24, true, 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('11', null, 24, false, 'ACTIVE');

INSERT INTO public.question (name, description, answer_type, status) VALUES ('Select all prime numbers.', null, 'MULTI', 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('2', null, 25, true, 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('5', null, 25, true, 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('4', null, 25, false, 'ACTIVE');

INSERT INTO public.question (name, description, answer_type, status) VALUES ('Describe any real-world application of math you find useful.', 'Explain a way you use math in daily life.', 'TEXT', 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('<Some keyword could be used for checking TEXT type>', null, 26, true, 'ACTIVE');

INSERT INTO public.survey_question (survey_id, question_id) VALUES (8, 24);
INSERT INTO public.survey_question (survey_id, question_id) VALUES (8, 25);
INSERT INTO public.survey_question (survey_id, question_id) VALUES (8, 26);
----------------------------------------------------------------------------------------------------
-- #9
INSERT INTO public.survey (name, description, perform_timeout, pass_correct_answer_number, status) VALUES ('Technology', 'Knowledge about modern technology.', 900000, 2, 'ACTIVE');

INSERT INTO public.question (name, description, answer_type, status) VALUES ('What does CPU stand for?', null, 'SINGLE', 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('Central Processing Unit', null, 27, true, 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('Central Power Unit', null, 27, false, 'ACTIVE');

INSERT INTO public.question (name, description, answer_type, status) VALUES ('Select computer programming languages.', null, 'MULTI', 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('Python', null, 28, true, 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('Java', null, 28, true, 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('HTML', null, 28, false, 'ACTIVE');

INSERT INTO public.question (name, description, answer_type, status) VALUES ('How do you think technology impacts society?', 'Share your views on technology''s societal influence.', 'TEXT', 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('<Some keyword could be used for checking TEXT type>', null, 29, true, 'ACTIVE');

INSERT INTO public.survey_question (survey_id, question_id) VALUES (9, 27);
INSERT INTO public.survey_question (survey_id, question_id) VALUES (9, 28);
INSERT INTO public.survey_question (survey_id, question_id) VALUES (9, 29);
----------------------------------------------------------------------------------------------------
-- #10
INSERT INTO public.survey (name, description, perform_timeout, pass_correct_answer_number, status) VALUES ('Environmental Awareness', 'Test knowledge on environmental practices.', 900000, 2, 'ACTIVE');

INSERT INTO public.question (name, description, answer_type, status) VALUES ('What gas do plants absorb from the atmosphere?', null, 'SINGLE', 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('Carbon dioxide', null, 30, true, 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('Oxygen', null, 30, false, 'ACTIVE');

INSERT INTO public.question (name, description, answer_type, status) VALUES ('Which of the following can be recycled?', null, 'MULTI', 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('Paper', null, 31, true, 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('Glass', null, 31, true, 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('Gun', null, 31, false, 'ACTIVE');

INSERT INTO public.question (name, description, answer_type, status) VALUES ('Discuss ways individuals can help protect the environment.', 'Share actions people can take to be environmentally friendly.', 'TEXT', 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('<Some keyword could be used for checking TEXT type>', null, 32, true, 'ACTIVE');

INSERT INTO public.survey_question (survey_id, question_id) VALUES (10, 30);
INSERT INTO public.survey_question (survey_id, question_id) VALUES (10, 31);
INSERT INTO public.survey_question (survey_id, question_id) VALUES (10, 32);
----------------------------------------------------------------------------------------------------
