INSERT INTO public.survey (name, description, perform_timeout, pass_correct_answer_number, status) VALUES ('General Knowledge', 'This survey is used for testing your general knowledge about Work Ethics, Society, Universe.', 900000, 2, 'ACTIVE');

INSERT INTO public.question (name, description, answer_type, status) VALUES ('Công ty có quy đnh ấm đánh nhau, nhưng bạn phát sinh mâu thuẫn với đồng nghiệp, đồng nghiệp muốn đánh bạn thì bạn phải làm thế nào?', null, 'SINGLE', 'ACTIVE');
INSERT INTO public.question (name, description, answer_type, status) VALUES ('Select Top 3 biggest cities in Vietnam.', null, 'MULTI', 'ACTIVE');
INSERT INTO public.question (name, description, answer_type, status) VALUES ('Hãy nêu cảm nghĩ của bạn về độ hiệu quả của bài test!', 'Vui lòng nhập câu trả lời vào bên dưới.', 'TEXT', 'ACTIVE');

INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('Đợi ở cổng công ty', null, 1, false, 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('Chạy', null, 1, false, 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('Đánh', null, 1, false, 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('Báo cấp trên', null, 1, true, 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('Ho Chi Minh', null, 2, true, 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('Ha Noi', null, 2, true, 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('Da Nang', null, 2, true, 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('Binh Duong', null, 2, false, 'ACTIVE');
INSERT INTO public.question_answer (name, description, question_id, is_correct, status) VALUES ('<Some keyword could be used for checking TEXT type>', null, 3, true, 'ACTIVE');

INSERT INTO public.survey_question (survey_id, question_id) VALUES (1, 1);
INSERT INTO public.survey_question (survey_id, question_id) VALUES (1, 2);
INSERT INTO public.survey_question (survey_id, question_id) VALUES (1, 3);
