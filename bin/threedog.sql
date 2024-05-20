-- 테이블 생성
CREATE TABLE users (
   uNo int auto_increment primary key,
   uId varchar(30) NOT NULL,
   uPw varchar(50) NOT NULL,
   uName varchar(10) NOT NULL,
   uPhone varchar(50) NOT NULL,
   uZipCode varchar(50) NOT NULL,
   uAddress varchar(150) NOT NULL,
   uDetailAddress varchar(150) NOT NULL,
   uPoint int NULL,
   uProfile varchar(300) NULL
);

CREATE TABLE business (
   bNo int auto_increment primary key,
   bId varchar(30) NOT NULL,
   bPw varchar(50) NOT NULL,
   bNum varchar(50) NOT NULL,
   bZipCode varchar(50) NOT NULL,
   bAddress varchar(150) NOT NULL,
   bdAddress varchar(150) NOT NULL,
   bPhone varchar(50) NOT NULL,
   title varchar(150) NULL,
   subTitle varchar(150) NULL,
   logo varchar(300) NULL,
   slideImg varchar(300) NULL,
   cutImg varchar(300) NULL,
   utilTime varchar(500) NULL
);

CREATE TABLE dog (
   dogNo int auto_increment primary key,
   dogName varchar(50) NOT NULL,
   kind varchar(50) NOT NULL,
   weight double NOT NULL,
   birth varchar(50) NOT NULL,
   gender varchar(10) NOT NULL,
   neutering boolean NULL,
   experience boolean NULL,
   bite int NULL,
   memo varchar(500) NULL,
   dogImg varchar(300) NULL,
   size varchar(10) NOT NULL,
   skin boolean NULL,
   heart boolean NULL,
   marking boolean NULL,
   mounting boolean NULL
);

CREATE TABLE beautylist (
   beautyNo int auto_increment primary key,
   sizeDiv varchar(50) NOT NULL,
   weightDiv varchar(50) NOT NULL,
   beauty varchar(50) NOT NULL
);

CREATE TABLE review (
   rNo int auto_increment primary key,
   bNo int NOT NULL,
   uNo int NOT NULL,
   star int NOT NULL,
   rContent varchar(500) NOT NULL,
   rDate datetime NOT NULL,
   FOREIGN KEY (bNo) REFERENCES business(bNo),
   FOREIGN KEY (uNo) REFERENCES users(uNo)
);

CREATE TABLE reserve (
   rsNo int auto_increment primary key,
   bNo int NOT NULL,
   dogNo int NOT NULL,
   rsDate datetime NOT NULL,
   rsTime time NOT NULL,
   signImg varchar(300) NOT NULL,
   expectedPrice int NOT NULL,
   attitude varchar(300) NULL,
   rCondition varchar(300) NULL,
   tangle varchar(300) NULL,
   disliked varchar(300) NULL,
   bath varchar(300) NULL,
   surcharge int NULL,
   message varchar(300) NULL,
   curruntWeight double NULL,
   FOREIGN KEY (bNo) REFERENCES business(bNo),
   FOREIGN KEY (dogNo) REFERENCES dog(dogNo)
);

CREATE TABLE price (
   priceNo int auto_increment primary key,
   beautyNo int NOT NULL,
   bNo int NULL,
   onePrice int NULL,
   FOREIGN KEY (beautyNo) REFERENCES beautylist(beautyNo)
);

CREATE TABLE homeimg (
   hiNo int auto_increment primary key,
   bNo int NOT NULL,
   saveName varchar(300) NULL,
   orgName varchar(300) NULL,
   fileSize int NULL,
   filePath varchar(500) NULL,
   category int NULL,
   cutContents varchar(500) NULL,
   FOREIGN KEY (bNo) REFERENCES business(bNo)
);

CREATE TABLE designer (
   dNo int auto_increment primary key,
   bNo int NOT NULL,
   dName varchar(10) NULL,
   introduce varchar(500) NULL,
   dProfile varchar(300) NULL,
   FOREIGN KEY (bNo) REFERENCES business(bNo)
);

CREATE TABLE reviewimg (
   riNo int auto_increment primary key,
   rNo int NOT NULL,
   saveName varchar(300) NULL,
   orgName varchar(300) NULL,
   fileSize int NULL,
   filePath varchar(500) NULL,
   FOREIGN KEY (rNo) REFERENCES review(rNo)
);

CREATE TABLE afterImg (
   aiNo int auto_increment primary key,
   rsNo int NOT NULL,
   saveName varchar(200) NULL,
   orgName varchar(300) NULL,
   fileSize varchar(300) NULL,
   filePath varchar(300) NULL,
   FOREIGN KEY (rsNo) REFERENCES reserve(rsNo)
);

CREATE TABLE rsPrice (
   rspNo int auto_increment primary key,
   rsNo int NOT NULL,
   priceNo int NOT NULL,
   FOREIGN KEY (rsNo) REFERENCES reserve(rsNo),
   FOREIGN KEY (priceNo) REFERENCES price(priceNo)
);

CREATE TABLE push (
   pushNo int auto_increment primary key,
   rsNo int NOT NULL,
   pushTime time NULL,
   FOREIGN KEY (rsNo) REFERENCES reserve(rsNo)
);

CREATE TABLE point (
   pNo int auto_increment primary key,
   uNo int NOT NULL,
   pDate varchar(50) NOT NULL,
   pDiv boolean NOT NULL,
   rsNum int NULL,
   rvNum int NULL,
   usePoint int NULL,
   FOREIGN KEY (uNo) REFERENCES users(uNo)
);
