create table student_tb
(
    id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(255) NOT NULL UNIQUE,
    AGE  INT          NOT NULL
);