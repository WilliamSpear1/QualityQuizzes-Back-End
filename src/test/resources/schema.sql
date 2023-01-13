create table STUDENTS (
    FIRSTNAME varchar(255),
    LASTNAME varchar(255),
    USERNAME varchar(255),
    EMAIL varchar(255),
    STUDENTID int,
    primary key(STUDENTID)
);

create table TEACHERS (
    FIRSTNAME varchar(255),
    LASTNAME varchar(255),
    USERNAME varchar(255),
    EMAIL varchar(255),
    TEACHERID int,
    primary key(TEACHERID)
);

create table QUIZZES (
    QUIZID int,
    QUIZSIZE int,
    QUIZNAME varchar(255),
    primary key(QUIZID)
);