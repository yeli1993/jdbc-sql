jdbc执行sql语句
===============
sql创建表：
---------
CREATE TABLE student(`stuId` INT(11) AUTO_INCREMENT PRIMARY KEY,`stuNo` VARCHAR(20) NOT NULL,`stuName` VARCHAR(20) NOT NULL,`stuSex` CHAR(2) NOT NULL,`stuAge` INT(11) NOT NULL);

CREATE TABLE course (`couId` INT(11) AUTO_INCREMENT PRIMARY KEY,`couNo` VARCHAR(20) NOT NULL,`couName` VARCHAR(20) NOT NULL,`couTeacher` VARCHAR(20) NOT NULL);

CREATE TABLE s_course(`sId` INT(11) AUTO_INCREMENT PRIMARY KEY,`couName` VARCHAR(20) NOT NULL,`stuNo` VARCHAR(20) NOT NULL);
