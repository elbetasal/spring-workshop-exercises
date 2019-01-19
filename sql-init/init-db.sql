USE feedback;

CREATE TABLE STUDENT(
   ID   INT NOT NULL AUTO_INCREMENT,
   NAME VARCHAR(20) NOT NULL,
   AGE  INT NOT NULL,
   PRIMARY KEY (ID)
);

CREATE TABLE ADDRESS(
  ADDRESS VARCHAR (255) NOT NULL,
  CITY VARCHAR (255) NOT NULL ,
  ZIP_CODE INT NOT NULL,
  STUDENT_ID INT NOT NULL
);

CREATE TABLE BOOK (
   ID   BIGINT AUTO_INCREMENT PRIMARY KEY,
   NAME VARCHAR(20) NOT NULL,
   ISBN VARCHAR (20) NOT NULL,
   STUDENT_ID INT NOT NULL

);