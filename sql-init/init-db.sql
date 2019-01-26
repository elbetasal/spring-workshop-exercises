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
  STUDENT_ID INT NOT NULLerform_login
);

CREATE TABLE BOOK (
   ID   BIGINT AUTO_INCREMENT PRIMARY KEY,
   NAME VARCHAR(20) NOT NULL,
   ISBN VARCHAR (20) NOT NULL,
   STUDENT_ID INT NOT NULL

);

CREATE TABLE users (
  username VARCHAR(45) NOT NULL ,
  password VARCHAR(60) NOT NULL ,
  enabled TINYINT NOT NULL DEFAULT 1 ,
  PRIMARY KEY (username)
  );

CREATE TABLE user_roles (
  user_role_id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(45) NOT NULL,
  role varchar(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  UNIQUE KEY uni_username_role (role,username),
  KEY fk_username_idx (username),
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username)
);




