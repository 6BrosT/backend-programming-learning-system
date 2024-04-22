--INSERT INTO public.user(id, email, dob, first_name, last_name, phone, address, avatar_url, last_login, is_deleted)
--VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb45', 'khanhndq2002@gmail.com', '01/01/2002', 'Khanh', 'Nguyen', '123456789', '227 Nguyen Van Cu', 'temp url', '2021-07-01 00:00:00', false);
--
--INSERT INTO public.organization(id, name, description, api_key, moodle_url)
--VALUES
--    ('d215b5f8-0249-4dc5-89a3-51fd148cfb45', 'Codecademy', 'Codecademy is an American online interactive platform that offers free coding classes in 12 different programming languages including Python, Java, JavaScript (jQuery, AngularJS, React.js), Ruby, SQL, and Sass, as well as markup languages HTML and CSS.', 'temp API key', 'temp moodle url'),
--    ('d215b5f8-0249-4dc5-89a3-51fd148cfb46', 'Coursera', 'Coursera is an American massive open online course provider founded in 2012 by Stanford University computer science professors Andrew Ng and Daphne Koller that offers massive open online courses, specializations, degrees, professional and mastertrack courses.', 'temp API key', 'temp moodle url');
--
--INSERT INTO public.question(id, org_id, difficulty, name, question_text, general_feedback, default_mark, qtype, created_by, updated_by)
--VALUES
--    ('b6484e21-6937-489c-b031-b71767994221', 'd215b5f8-0249-4dc5-89a3-51fd148cfb45', 'HARD', 'Question Pants', 'Question Mouse Text', 'Question Tuna feedback', 1, 'CODE', 'd215b5f8-0249-4dc5-89a3-51fd148cfb45', 'd215b5f8-0249-4dc5-89a3-51fd148cfb45'),
--    ('b6484e21-6937-489c-b031-b71767994233', 'd215b5f8-0249-4dc5-89a3-51fd148cfb45', 'EASY', 'Question Handle', 'Question Wire Text', 'Question Gold feedback', 1, 'ESSAY', 'd215b5f8-0249-4dc5-89a3-51fd148cfb45', 'd215b5f8-0249-4dc5-89a3-51fd148cfb45'),
--    ('b6484e21-6937-489c-b031-b71767994132', 'd215b5f8-0249-4dc5-89a3-51fd148cfb45', 'MEDIUM', 'Question hihi', 'Question Wow Text', 'Question Amazing feedback', 1, 'SHORT_ANSWER', 'd215b5f8-0249-4dc5-89a3-51fd148cfb45', 'd215b5f8-0249-4dc5-89a3-51fd148cfb45'),
--    ('b6484e21-6937-489c-b031-b71767994735', 'd215b5f8-0249-4dc5-89a3-51fd148cfb45', 'HARD', 'Question haha', 'Question Speaker Text', 'Question Good Job feedback', 1, 'MULTIPLE_CHOICE', 'd215b5f8-0249-4dc5-89a3-51fd148cfb45', 'd215b5f8-0249-4dc5-89a3-51fd148cfb45');
--
--INSERT INTO public.answer_of_question(id, question_id, feedback, answer, fraction)
--VALUES
--    ('d215b5f8-0249-4dc5-89a3-51fd148cfb15', 'b6484e21-6937-489c-b031-b71767994221', 'Correct', 'print(Hello World)', 1),
--    ('d215b5f8-0249-4dc5-89a3-51fd148cfb64', 'b6484e21-6937-489c-b031-b71767994233', 'Wrong', 'Essat 1', 1),
--    ('d215b5f8-0249-4dc5-89a3-51fd148cfb86', 'b6484e21-6937-489c-b031-b71767994233', 'Wow', 'p p p)', 1),
--    ('d215b5f8-0249-4dc5-89a3-51fd148cfb25', 'b6484e21-6937-489c-b031-b71767994233', 'Good', 'essay t12', 1),
--    ('d215b5f8-0249-4dc5-89a3-51fd148cfb69', 'b6484e21-6937-489c-b031-b71767994132', 'Bad', 'short answer t12', 1),
--    ('d215b5f8-0249-4dc5-89a3-51fd148cfe63', 'b6484e21-6937-489c-b031-b71767994735', 'Hihi', 'multi 1', 1),
--    ('d215b5f8-0249-4dc5-89a3-51fd148cff62', 'b6484e21-6937-489c-b031-b71767994735', 'huhu', 'multi 2', 1),
--    ('d215b5f8-0249-4dc5-89a3-51fd148cff20', 'b6484e21-6937-489c-b031-b71767994735', 'haha', 'multi 3', 1);