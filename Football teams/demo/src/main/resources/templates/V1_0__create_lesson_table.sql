CREATE SEQUENCE LESSONS_SEQUENCE START WITH 1 INCREMENT BY 1;
CREATE TABLE IF NOT EXISTS LESSONS (
    ID int NOT NULL PRIMARY KEY,
    NAME varchar(20),
    CONTENT varchar(50),
    DURATION double
)