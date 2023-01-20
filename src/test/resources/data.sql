--DATA FOR STUDENTS TABLE
INSERT INTO STUDENTS VALUES ('Bret',    'Steadman', 'steadman1', 'steadman1@email.com', 2L);
INSERT INTO STUDENTS VALUES ('William', 'Louise',   'louise1',   'louise1@email.com',   3L);
INSERT INTO STUDENTS VALUES ('Henry',   'Cash',     'cash1',     'cash1@email.com',     4L);
INSERT INTO STUDENTS VALUES ('John',    'Marvin',   'marvin1',   'marvin1@email.com',   5L);

--DATA FOR STUDENTS TABLE
INSERT INTO TEACHERS VALUES ('Bret',    'Steadman', 'steadman1', 'steadman1@email.com', 2L);
INSERT INTO TEACHERS VALUES ('William', 'Louise',   'louise1',   'louise1@email.com',   3L);
INSERT INTO TEACHERS VALUES ('Henry',   'Cash',     'cash1',     'cash1@email.com',     4L);
INSERT INTO TEACHERS VALUES ('John',    'Marvin',   'marvin1',   'marvin1@email.com',   5L);

--DATA FOR QUIZ TABLE
INSERT INTO QUIZZES VALUES (2L, 'History Quiz', 10);
INSERT INTO QUIZZES VALUES (3L, 'Math Quiz',    9);
INSERT INTO QUIZZES VALUES (4L, 'Science Quiz', 8);
INSERT INTO QUIZZES VALUES (5L, 'Writing Quiz', 7);

--DATA FOR QUIZQUESTIONS TABLE
INSERT INTO QUIZQUESTIONS VALUES (2L, 6L, 'Is Joe Biden President?', 'True',  'False');
INSERT INTO QUIZQUESTIONS VALUES (3L, 7L, 'Is 4+4 = 2', 'True', 'False');
INSERT INTO QUIZQUESTIONS VALUES (4L, 8L, 'Is America a nation?', 'True', 'False');
INSERT INTO QUIZQUESTIONS VALUES (5L, 9L, 'Did John Milton write Paradise Lost?', 'Yes', 'No');
INSERT INTO QUIZQUESTIONS VALUES (5L, 1L, 'Is John Milton Alive?', 'Yes', 'No');