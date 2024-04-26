DROP SCHEMA IF EXISTS "public" CASCADE;

CREATE SCHEMA "public";

CREATE
EXTENSION IF NOT EXISTS "uuid-ossp";

DROP TYPE IF EXISTS skill_level;
CREATE TYPE skill_level AS ENUM ('BASIC', 'INTERMEDIATE', 'ADVANCED');

DROP TYPE IF EXISTS difficulty;
CREATE TYPE difficulty AS ENUM ('EASY', 'MEDIUM', 'HARD');

DROP TYPE IF EXISTS qtype;
CREATE TYPE qtype AS ENUM ('MULTIPLE_CHOICE', 'SHORT_ANSWER', 'CODE', 'ESSAY');

DROP TYPE IF EXISTS grade_method;
CREATE TYPE grade_method AS ENUM ('QUIZ_GRADEHIGHEST', 'QUIZ_GRADEAVERAGE', 'QUIZ_ATTEMPTFIRST', 'QUIZ_ATTEMPTLAST');

DROP TYPE IF EXISTS type;
CREATE TYPE type AS ENUM ('TEXT_ONLINE', 'FILE', 'BOTH');

DROP TYPE IF EXISTS overdue_handling;
CREATE TYPE overdue_handling AS ENUM ('AUTOSUBMIT', 'GRACEPERIOD', 'AUTOABANDON');

DROP TYPE IF EXISTS status;
CREATE TYPE status AS ENUM ('SUBMITTED', 'NOT_SUBMITTED');

DROP TYPE IF EXISTS notification_event_type;
CREATE TYPE notification_event_type AS ENUM ('USER', 'COURSE');

DROP TYPE IF EXISTS notification_component_type;
CREATE TYPE notification_component_type AS ENUM ('ASSIGNMENT', 'EXAM', 'POST', 'CONTEST', 'REMINDER');

DROP TABLE IF EXISTS "public".user CASCADE;
CREATE TABLE "public".user
(
    id         uuid                     DEFAULT gen_random_uuid() NOT NULL,
    email      text UNIQUE NOT NULL,
    dob        date,
    first_name text,
    last_name  text,
    phone      text,
    address    text,
    avatar_url text,
    last_login TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    is_deleted boolean DEFAULT '0',
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT user_pkey PRIMARY KEY (id)

);
DROP TABLE IF EXISTS "public".organization CASCADE;
CREATE TABLE "public".organization
(
    id          uuid DEFAULT gen_random_uuid() NOT NULL,
    description text,
    name        text                           NOT NULL,
    api_key     text                           NOT NULL,
    moodle_url  text                           NOT NULL,
    CONSTRAINT organization_pkey PRIMARY KEY (id)
);

DROP TABLE IF EXISTS "public".question_bank_category CASCADE;
CREATE TABLE "public".question_bank_category
(
    id            uuid                     DEFAULT gen_random_uuid() NOT NULL,
    "name"        text                                               NOT NULL,
    "description" text,
    "created_by"  uuid                                               NOT NULL,
    "updated_by"  uuid                                               NOT NULL,
    "created_at"  TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    "updated_at"  TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT question_bank_category_pkey PRIMARY KEY (id),
    CONSTRAINT question_bank_category_created_by_fkey FOREIGN KEY (created_by)
        REFERENCES "public".user (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT question_bank_category_updated_by_fkey FOREIGN KEY (updated_by)
        REFERENCES "public".user (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE cascade
);

DROP TABLE IF EXISTS "public".question CASCADE;
CREATE TABLE "public".question
(
    "id"                        uuid                      DEFAULT gen_random_uuid() NOT NULL,
    "org_id"                    uuid             NOT NULL,
    "name"                      text             NOT NULL,
    "question_text"             text             NOT NULL,
    "general_feedback"          text             NOT NULL,
    "default_mark"              double precision NOT NULL,
    "created_by"                uuid             NOT NULL,
    "updated_by"                uuid             NOT NULL,
    "created_at"                TIMESTAMP WITH TIME ZONE  DEFAULT CURRENT_TIMESTAMP,
    "updated_at"                TIMESTAMP WITH TIME ZONE  DEFAULT CURRENT_TIMESTAMP,
    "is_question_bank"          boolean          NOT NULL DEFAULT '0',
    "question_bank_category_id" uuid,
    "qtype"                     qtype            NOT NULL,
    "difficulty"                difficulty       NOT NULL,
    PRIMARY KEY ("id"),
    CONSTRAINT question_created_by_fkey FOREIGN KEY (created_by)
        REFERENCES "public".user (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT question_updated_by_fkey FOREIGN KEY (updated_by)
        REFERENCES "public".user (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE cascade,
    CONSTRAINT question_question_bank_category_id_fkey FOREIGN KEY (question_bank_category_id)
        references "public".question_bank_category (id) MATCH SIMPLE
        on update CASCADE

);
DROP TABLE IF EXISTS "public".course CASCADE;
CREATE TABLE "public".course
(
    id          uuid    DEFAULT gen_random_uuid() NOT NULL,
    name        text UNIQUE,
    visible     boolean DEFAULT '1',
    course_type text,
    created_by  uuid,
    updated_by  uuid,
    created_at  TIMESTAMP WITH TIME ZONE,
    updated_at  TIMESTAMP WITH TIME ZONE,
    CONSTRAINT course_pkey PRIMARY KEY (id),
    CONSTRAINT course_created_by_fkey FOREIGN KEY (created_by)
        REFERENCES "public".user (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT course_updated_by_fkey FOREIGN KEY (updated_by)
        REFERENCES "public".user (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);
DROP TABLE IF EXISTS "public".post CASCADE;

CREATE TABLE "public".post
(
    id            uuid                     DEFAULT gen_random_uuid() NOT NULL,
    course_id     uuid    NOT NULL,
    title         text    NOT NULL,
    summary       text,
    content       text,
    publish_state boolean NOT NULL         DEFAULT '1',
    created_by    uuid,
    updated_by    uuid,
    created_at    TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at    TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT post_pkey PRIMARY KEY (id),
    CONSTRAINT post_course_id_fkey FOREIGN KEY (course_id)
        REFERENCES "public".course (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT post_created_by_fkey FOREIGN KEY (created_by)
        REFERENCES "public".user (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT post_updated_by_fkey FOREIGN KEY (updated_by)
        REFERENCES "public".user (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);
DROP TABLE IF EXISTS "public".course_user CASCADE;

CREATE TABLE "public".course_user
(
    id        uuid DEFAULT gen_random_uuid() NOT NULL,
    user_id   uuid                           NOT NULL,
    course_id uuid                           NOT NULL,
    CONSTRAINT course_user_pkey PRIMARY KEY (id),
    CONSTRAINT course_user_user_id_fkey FOREIGN KEY (user_id)
        REFERENCES "public".user (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT course_user_course_fkey FOREIGN KEY (course_id)
        REFERENCES "public".course (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);
DROP TABLE IF EXISTS "public".exam CASCADE;

CREATE TABLE "public".exam
(
    id                 uuid                      DEFAULT gen_random_uuid() NOT NULL,
    course_id          uuid             NOT NULL,
    name               text             NOT NULL,
    intro              text,
    score              double precision NOT NULL DEFAULT '0',
    max_score          double precision NOT NULL DEFAULT '0',
    time_open          TIMESTAMP WITH TIME ZONE,
    time_close         TIMESTAMP WITH TIME ZONE,
    time_limit         INTEGER,
    overdue_handling   overdue_handling NOT NULL DEFAULT 'AUTOABANDON',
    can_redo_questions boolean          NOT NULL DEFAULT '0',
    max_attempts       bigint           NOT NULL DEFAULT '0',
    shuffle_answers    boolean          NOT NULL DEFAULT '0',
    grade_method       grade_method     NOT NULL DEFAULT 'QUIZ_GRADEHIGHEST',
    created_at         TIMESTAMP WITH TIME ZONE  DEFAULT CURRENT_TIMESTAMP,
    updated_at         TIMESTAMP WITH TIME ZONE  DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT exam_pkey PRIMARY KEY (id),
    CONSTRAINT exam_course_id_fkey FOREIGN KEY (course_id)
        REFERENCES "public".course (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS "public".exam_question CASCADE;
CREATE TABLE "public".exam_question
(
    id          uuid DEFAULT gen_random_uuid() NOT NULL,
    exam_id     uuid                           NOT NULL,
    question_id uuid                           NOT NULL,
    CONSTRAINT exam_question_pkey PRIMARY KEY (id),
    CONSTRAINT exam_question_exam_id_fkey FOREIGN KEY (exam_id)
        REFERENCES "public".exam (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT exam_question_question_id_fkey FOREIGN KEY (question_id)
        REFERENCES "public".question (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS "public".exam_submission CASCADE;
CREATE TABLE "public".exam_submission
(
    id          uuid            DEFAULT gen_random_uuid() NOT NULL,
    exam_id     uuid   NOT NULL,
    user_id     uuid   NOT NULL,
    submit_count bigint NOT NULL DEFAULT '0',
    start_time  TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    submit_time TIMESTAMP WITH TIME ZONE DEFAULT NULL,
    status status NOT NULL DEFAULT 'NOT_SUBMITTED',
    CONSTRAINT exam_submission_pkey PRIMARY KEY (id),
    CONSTRAINT exam_submission_exam_id_fkey FOREIGN KEY (exam_id)
        REFERENCES "public".exam (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT exam_submission_user_id_fkey FOREIGN KEY (user_id)
        REFERENCES "public".user (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS "public".exam_question_submission CASCADE;
CREATE TABLE "public".exam_question_submission
(
    id                 uuid                      DEFAULT gen_random_uuid() NOT NULL,
    user_id            uuid             NOT NULL,
    exam_question_id uuid             NOT NULL,
    AI_assessment text,
    pass_status        bigint           NOT NULL DEFAULT '0',
    grade              double precision NOT NULL,
    content            text,
    right_answer       text             NOT NULL,
    num_file           bigint           NOT NULL,
    status bigint NOT NULL DEFAULT '0',
    CONSTRAINT exam_question_submission_pkey PRIMARY KEY (id),
    CONSTRAINT exam_question_submission_user_id_fkey FOREIGN KEY (user_id)
        REFERENCES "public".USER (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT exam_question_submission_exam_submission_id_fkey FOREIGN KEY (exam_question_id)
        REFERENCES "public".exam_question (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);
DROP TABLE IF EXISTS "public".assignment CASCADE;
CREATE TABLE "public".assignment
(
    id         uuid                      DEFAULT gen_random_uuid() NOT NULL,
    course_id  uuid             NOT NULL,
    title      text             NOT NULL,
    intro      text,
    score      double precision NOT NULL DEFAULT '0',
    max_score  double precision NOT NULL DEFAULT '0',
    time_open  TIMESTAMP WITH TIME ZONE,
    time_close TIMESTAMP WITH TIME ZONE,
    time_limit TIMESTAMP WITH TIME ZONE,
    type       type             NOT null,
    visible    boolean          NOT NULL DEFAULT '0',
    CONSTRAINT assignment_pkey PRIMARY KEY (id),
    CONSTRAINT assignment_course_id_fkey FOREIGN KEY (course_id)
        REFERENCES "public".course (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS "public".question_submission CASCADE;
CREATE TABLE "public".question_submission
(
    id                 uuid                      DEFAULT gen_random_uuid() NOT NULL,
    user_id            uuid             NOT NULL,
    exam_submission_id uuid             NOT NULL,
    question_id        uuid             NOT NULL,
    pass_status        bigint           NOT NULL DEFAULT '0',
    grade              double precision NOT NULL,
    content            text,
    right_answer       text             NOT NULL,
    num_file           bigint           NOT NULL,
    CONSTRAINT question_submission_pkey PRIMARY KEY (id),
    CONSTRAINT question_submission_user_id_fkey FOREIGN KEY (user_id)
        REFERENCES "public".USER (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT question_submission_exam_submission_id_fkey FOREIGN KEY (exam_submission_id)
        REFERENCES "public".exam_submission (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT question_submission_question_id_fkey FOREIGN KEY (question_id)
        REFERENCES "public".question (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS "public".submission_assignment CASCADE;
CREATE TABLE "public".submission_assignment
(
    id            uuid DEFAULT gen_random_uuid() NOT NULL,
    user_id       uuid                           NOT NULL,
    assignment_id uuid                           NOT NULL,
    pass_status   bigint                         NOT NULL,
    grade         double precision               NOT NULL,
    content       text                           NOT NULL,
    submit_time   timestamp without time zone NOT NULL,
    CONSTRAINT submission_assignment_pkey PRIMARY KEY (id),
    CONSTRAINT submission_assignment_user_id_fkey FOREIGN KEY (user_id)
        REFERENCES "public".user (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT submission_assignment_assignment_id_fkey FOREIGN KEY (assignment_id)
        REFERENCES "public".assignment (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS "public".submission_assignment_file CASCADE;
CREATE TABLE "public".submission_assignment_file
(
    id                       uuid DEFAULT gen_random_uuid() NOT NULL,
    submission_assignment_id uuid                           NOT NULL,
    num_file                 bigint                         NOT NULL,
    CONSTRAINT submission_assignment_file_pkey PRIMARY KEY (id),
    CONSTRAINT submission_assignment_file_submission_assignment_id_fkey FOREIGN KEY (submission_assignment_id)
        REFERENCES "public".submission_assignment (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);


DROP TABLE IF EXISTS "public".submission_assignment_onlinetext CASCADE;
CREATE TABLE "public".submission_assignment_onlinetext
(
    id                       uuid DEFAULT gen_random_uuid() NOT NULL,
    submission_assignment_id uuid                           NOT NULL,
    content                  text                           NOT NULL,
    CONSTRAINT submission_assignment_onlinetext_pkey PRIMARY KEY (id),
    CONSTRAINT submission_assignment_onlinetext_submission_assignment_id_fkey FOREIGN KEY (submission_assignment_id)
        REFERENCES "public".submission_assignment (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);


DROP TABLE IF EXISTS "public".webhook_api_function CASCADE;
CREATE TABLE "public".webhook_api_function
(
    "id"          uuid DEFAULT gen_random_uuid() NOT NULL,
    "area"        text                           NOT NULL,
    "name"        text                           NOT NULL,
    "description" text                           NOT NULL,
    CONSTRAINT webhook_api_function_pkey PRIMARY KEY (id)
);

DROP TABLE IF EXISTS "public".webhook_function_organization CASCADE;
CREATE TABLE "public".webhook_function_organization
(
    "id"                      uuid DEFAULT gen_random_uuid() NOT NULL,
    "org_id"                  uuid                           NOT NULL,
    "webhook_api_function_id" uuid                           NOT NULL,
    CONSTRAINT webhook_function_organization_pkey PRIMARY KEY (id),
    CONSTRAINT webhook_function_organization_organizationn_id_fkey FOREIGN KEY (org_id)
        REFERENCES "public".organization (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT webhook_function_organization_webhook_api_function_id_fkey FOREIGN KEY (webhook_api_function_id)
        REFERENCES "public".webhook_api_function (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE

);
DROP TABLE IF EXISTS "public".call_moodle_api_function CASCADE;
CREATE TABLE "public".call_moodle_api_function
(
    "id"         uuid DEFAULT gen_random_uuid() NOT NULL,
    "area"       text                           NOT NULL,
    "name"       text                           NOT NULL,
    "decription" text                           NOT NULL,
    CONSTRAINT call_moodle_api_function_pkey PRIMARY KEY (id)
);

DROP TABLE IF EXISTS "public".call_organization CASCADE;
CREATE TABLE "public".call_organization
(
    "id"                   uuid DEFAULT gen_random_uuid() NOT NULL,
    "org_id"               uuid                           NOT NULL,
    "call_api_function_id" uuid                           NOT NULL,
    CONSTRAINT call_organization_pkey PRIMARY KEY (id),
    CONSTRAINT call_organization_organizationn_id_fkey FOREIGN KEY (org_id)
        REFERENCES "public".organization (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT call_organization_call_api_function_id_fkey FOREIGN KEY (call_api_function_id)
        REFERENCES "public".call_moodle_api_function (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS "public".notification CASCADE;

CREATE TABLE "public".notification
(
    id uuid DEFAULT uuid_generate_v4() NOT NULL,
    user_id_from uuid,
    user_id_to uuid NOT NULL,
    subject text,
    full_message text,
    small_message text,
    component notification_component_type DEFAULT 'REMINDER',
    event_type notification_event_type NOT NULL,
    context_url text,
    context_url_name text,
    is_read bool DEFAULT FALSE NOT NULL,
    time_read TIMESTAMP WITH TIME ZONE,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT notification_pkey PRIMARY KEY (id),
    CONSTRAINT notification_user_id_from_fkey FOREIGN KEY (user_id_from)
        REFERENCES "public".user (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT notification_user_id_to_fkey FOREIGN KEY (user_id_to)
        REFERENCES "public".user (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS "public".calendar_event CASCADE;

CREATE TABLE "public".calendar_event
(
    id uuid DEFAULT uuid_generate_v4() NOT NULL,
    name text,
    description text,
    event_type notification_event_type NOT NULL,
    start_time TIMESTAMP WITH TIME ZONE NOT NULL,
    end_time TIMESTAMP WITH TIME ZONE,
    user_id uuid NOT NULL,
    course_id uuid,
    component notification_component_type DEFAULT 'REMINDER',
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT calendar_event_pkey PRIMARY KEY (id),
    CONSTRAINT calendar_event_created_by_fkey FOREIGN KEY (user_id)
        REFERENCES "public".user (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);