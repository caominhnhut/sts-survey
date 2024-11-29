CREATE TABLE IF NOT EXISTS survey
(
    survey_id                  BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name                       VARCHAR(255) NOT NULL,
    description                VARCHAR(255),
    perform_timeout            BIGINT DEFAULT 900000,
    pass_correct_answer_number INTEGER      NOT NULL,
    status                     VARCHAR(20)  NOT NULL DEFAULT 'ACTIVE'
);

CREATE TABLE IF NOT EXISTS question
(
    question_id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name        TEXT        NOT NULL,
    description TEXT,
    answer_type VARCHAR(20) NOT NULL,
    status      VARCHAR(20) NOT NULL DEFAULT 'ACTIVE'
);

CREATE TABLE IF NOT EXISTS question_answer
(
    question_answer_id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name               TEXT        NOT NULL,
    description        TEXT,
    question_id        BIGINT,
    is_correct          BOOLEAN DEFAULT FALSE,
    status             VARCHAR(20) NOT NULL DEFAULT 'ACTIVE'
);

CREATE TABLE IF NOT EXISTS survey_question
(
    survey_question_id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    survey_id          BIGINT,
    question_id        BIGINT
);

CREATE TABLE IF NOT EXISTS survey_history
(
    survey_history_id           BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    survey_id                   BIGINT,
    username                    VARCHAR(255)  NOT NULL,
    submit_date                 TIMESTAMP,
    total_question              INTEGER       NOT NULL,
    pass_correct_answer_number  INTEGER       NOT NULL,
    cover_correct_answer_number INTEGER       NOT NULL,
    pass_percentage             NUMERIC(5, 2) NOT NULL,
    cover_percentage            NUMERIC(5, 2) NOT NULL,
    result                      VARCHAR(20)   NOT NULL
);

CREATE TABLE IF NOT EXISTS survey_history_log
(
    survey_history_log_id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    survey_history_id     BIGINT,
    question_id           BIGINT,
    question_answer_id    BIGINT,
    question_answer_text  TEXT
);

-- Add constraints, foreign key
ALTER TABLE question_answer
    ADD CONSTRAINT fk_questionanswer_question FOREIGN KEY (question_id) REFERENCES question (question_id);
CREATE INDEX idx_questionanswer_question ON question_answer (question_id);

ALTER TABLE survey_question
    ADD CONSTRAINT fk_surveyquestion_survey FOREIGN KEY (survey_id) REFERENCES survey (survey_id);
ALTER TABLE survey_question
    ADD CONSTRAINT fk_surveyquestion_question FOREIGN KEY (question_id) REFERENCES question (question_id);
CREATE INDEX idx_surveyquestion_survey ON survey_question (survey_id);

ALTER TABLE survey_history
    ADD CONSTRAINT fk_surveyhistory_survey FOREIGN KEY (survey_id) REFERENCES survey (survey_id);
CREATE INDEX idx_surveyhistory_survey_username ON survey_history (survey_id, username);

ALTER TABLE survey_history_log
    ADD CONSTRAINT fk_surveyhistorylog_surveyhistory FOREIGN KEY (survey_history_id) REFERENCES survey_history (survey_history_id);
ALTER TABLE survey_history_log
    ADD CONSTRAINT fk_surveyhistorylog_question FOREIGN KEY (question_id) REFERENCES question (question_id);
ALTER TABLE survey_history_log
    ADD CONSTRAINT fk_surveyhistorylog_questionanswer FOREIGN KEY (question_answer_id) REFERENCES question_answer (question_answer_id);
CREATE INDEX idx_surveyhistorylog_surveyhistory ON survey_history_log (survey_history_id);
