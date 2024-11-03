-- #1
INSERT INTO public.survey (name, description, perform_timeout, pass_correct_answer_number, status) VALUES ('General Knowledge', 'This survey is used for testing your general knowledge about Work Ethics, Society, Universe.', 900000, 2, 'ACTIVE');

INSERT INTO public.question (name, description, answer_type, status) VALUES ('Công ty có quy đnh ấm đánh nhau, nhưng bạn phát sinh mâu thuẫn với đồng nghiệp, đồng nghiệp muốn đánh bạn thì bạn phải làm thế nào?', null, 'SINGLE', 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('Đợi ở cổng công ty', null, 1, false, 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('Chạy', null, 1, false, 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('Đánh', null, 1, false, 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('Báo cấp trên', null, 1, true, 'ACTIVE');

INSERT INTO public.question (name, description, answer_type, status) VALUES ('Select Top 3 biggest cities in Vietnam.', null, 'MULTI', 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('Ho Chi Minh', null, 2, true, 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('Ha Noi', null, 2, true, 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('Da Nang', null, 2, true, 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('Binh Duong', null, 2, false, 'ACTIVE');

INSERT INTO public.question (name, description, answer_type, status) VALUES ('What is the capital of France?', null, 'SINGLE', 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('Paris', null, 3, true, 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('Rome', null, 3, false, 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('Berlin', null, 3, false, 'ACTIVE');

INSERT INTO public.question (name, description, answer_type, status) VALUES ('Select the colors of the French flag.', null, 'MULTI', 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('Blue', null, 4, true, 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('White', null, 4, true, 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('Red', null, 4, true, 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('Green', null, 4, false, 'ACTIVE');

INSERT INTO public.question (name, description, answer_type, status) VALUES ('What are your thoughts on the importance of general knowledge?', 'Please share your opinion on why general knowledge matters.', 'TEXT', 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('<Some keyword could be used for checking TEXT type>', null, 5, true, 'ACTIVE');

INSERT INTO public.survey_question (survey_id, question_id) VALUES (1, 1);
INSERT INTO public.survey_question (survey_id, question_id) VALUES (1, 2);
INSERT INTO public.survey_question (survey_id, question_id) VALUES (1, 3);
INSERT INTO public.survey_question (survey_id, question_id) VALUES (1, 4);
INSERT INTO public.survey_question (survey_id, question_id) VALUES (1, 5);
----------------------------------------------------------------------------------------------------
-- #2
INSERT INTO public.survey (name, description, perform_timeout, pass_correct_answer_number, status) VALUES ('Science Trivia', 'Questions about basic scientific facts.', 900000, 2, 'ACTIVE');

INSERT INTO public.question (name, description, answer_type, status) VALUES ('Water boils at what temperature in Celsius?', null, 'SINGLE', 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('100°C', null, 6, true, 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('90°C', null, 6, false, 'ACTIVE');

INSERT INTO public.question (name, description, answer_type, status) VALUES ('Which of these are gases at room temperature?', null, 'MULTI', 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('Oxygen', null, 7, true, 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('Carbon Dioxide', null, 7, true, 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('Mercury', null, 7, false, 'ACTIVE');

INSERT INTO public.question (name, description, answer_type, status) VALUES ('Describe any interesting scientific fact you know.', 'Share an intriguing science fact.', 'TEXT', 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('<Some keyword could be used for checking TEXT type>', null, 8, true, 'ACTIVE');

INSERT INTO public.survey_question (survey_id, question_id) VALUES (2, 6);
INSERT INTO public.survey_question (survey_id, question_id) VALUES (2, 7);
INSERT INTO public.survey_question (survey_id, question_id) VALUES (2, 8);
----------------------------------------------------------------------------------------------------
-- #3
INSERT INTO public.survey (name, description, perform_timeout, pass_correct_answer_number, status) VALUES ('Geography Basics', 'General geography knowledge survey.', 900000, 2, 'ACTIVE');

INSERT INTO public.question (name, description, answer_type, status) VALUES ('Which country has the largest population?', null, 'SINGLE', 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('China', null, 9, true, 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('India', null, 9, false, 'ACTIVE');

INSERT INTO public.question (name, description, answer_type, status) VALUES ('Select continents from the list below.', null, 'MULTI', 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('Asia', null, 10, true, 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('Europe', null, 10, true, 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('Greenland', null, 10, false, 'ACTIVE');

INSERT INTO public.question (name, description, answer_type, status) VALUES ('Explain why geographical knowledge is important in today''s world.', 'Provide your insights on the significance of geography.', 'TEXT', 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('<Some keyword could be used for checking TEXT type>', null, 11, true, 'ACTIVE');

INSERT INTO public.survey_question (survey_id, question_id) VALUES (3, 9);
INSERT INTO public.survey_question (survey_id, question_id) VALUES (3, 10);
INSERT INTO public.survey_question (survey_id, question_id) VALUES (3, 11);
----------------------------------------------------------------------------------------------------
-- #4
INSERT INTO public.survey (name, description, perform_timeout, pass_correct_answer_number, status) VALUES ('Literature and Arts', 'Knowledge of famous books and art.', 900000, 2, 'ACTIVE');

INSERT INTO public.question (name, description, answer_type, status) VALUES ('Who wrote ''Pride and Prejudice''?', null, 'SINGLE', 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('Jane Austen', null, 12, true, 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('Charles Dickens', null, 12, false, 'ACTIVE');

INSERT INTO public.question (name, description, answer_type, status) VALUES ('Which of these are styles of painting?', null, 'MULTI', 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('Impressionism', null, 13, true, 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('Cubism', null, 13, true, 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('Jesus', null, 13, false, 'ACTIVE');

INSERT INTO public.question (name, description, answer_type, status) VALUES ('Share your favorite piece of literature or art and why it resonates with you.', 'Describe a work of art or literature you admire.', 'TEXT', 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('<Some keyword could be used for checking TEXT type>', null, 14, true, 'ACTIVE');

INSERT INTO public.survey_question (survey_id, question_id) VALUES (4, 12);
INSERT INTO public.survey_question (survey_id, question_id) VALUES (4, 13);
INSERT INTO public.survey_question (survey_id, question_id) VALUES (4, 14);
----------------------------------------------------------------------------------------------------
-- #5
INSERT INTO public.survey (name, description, perform_timeout, pass_correct_answer_number, status) VALUES ('Sports Trivia', 'Knowledge about different sports and athletes.', 900000, 2, 'ACTIVE');

INSERT INTO public.question (name, description, answer_type, status) VALUES ('Which country hosted the 2016 Summer Olympics?', null, 'SINGLE', 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('Brazil', null, 15, true, 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('Japan', null, 15, false, 'ACTIVE');

INSERT INTO public.question (name, description, answer_type, status) VALUES ('Which of these are Olympic sports?', null, 'MULTI', 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('Basketball', null, 16, true, 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('Golf', null, 16, true, 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('Shooting', null, 16, false, 'ACTIVE');

INSERT INTO public.question (name, description, answer_type, status) VALUES ('Describe a memorable sports event you watched.', 'Share details of a sports event that stands out to you.', 'TEXT', 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('<Some keyword could be used for checking TEXT type>', null, 17, true, 'ACTIVE');

INSERT INTO public.survey_question (survey_id, question_id) VALUES (5, 15);
INSERT INTO public.survey_question (survey_id, question_id) VALUES (4, 16);
INSERT INTO public.survey_question (survey_id, question_id) VALUES (4, 17);
----------------------------------------------------------------------------------------------------
-- #6
INSERT INTO public.survey (name, description, perform_timeout, pass_correct_answer_number, status) VALUES ('Health and Wellness', 'Knowledge about health practices.', 900000, 2, 'ACTIVE');

INSERT INTO public.question (name, description, answer_type, status) VALUES ('What vitamin is produced when skin is exposed to sunlight?', null, 'SINGLE', 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('Vitamin D', null, 18, true, 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('Vitamin C', null, 18, false, 'ACTIVE');

INSERT INTO public.question (name, description, answer_type, status) VALUES ('Select healthy lifestyle habits.', null, 'MULTI', 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('Regular exercise', null, 19, true, 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('Eating vegetables', null, 19, true, 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('Eating junk food', null, 19, false, 'ACTIVE');

INSERT INTO public.question (name, description, answer_type, status) VALUES ('Explain why mental health is as important as physical health.', 'Provide your thoughts on the importance of mental health.', 'TEXT', 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('<Some keyword could be used for checking TEXT type>', null, 20, true, 'ACTIVE');

INSERT INTO public.survey_question (survey_id, question_id) VALUES (6, 18);
INSERT INTO public.survey_question (survey_id, question_id) VALUES (6, 19);
INSERT INTO public.survey_question (survey_id, question_id) VALUES (6, 20);
----------------------------------------------------------------------------------------------------
