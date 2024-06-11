
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
   latitude DECIMAL(10, 8),
   longitude DECIMAL(11, 8),
   bTime varchar(300) NULL,
   bMaster varchar(30) NULL,
   isChange BOOLEAN DEFAULT 0
);
-- 0은 false, 1은 true


CREATE TABLE dog (
   dogNo int auto_increment primary key,
   uNo int,
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
   mounting boolean NULL,
   CONSTRAINT fk_user_dog FOREIGN KEY (uNo) REFERENCES users(uNo)
);

CREATE TABLE beautylist (
   beautyNo int auto_increment primary key,
   sizeDiv varchar(50) NOT NULL,
   weightDiv varchar(50) NOT NULL,
   beauty varchar(50) NOT NULL
);

CREATE TABLE reserveTime (
   rtNo int auto_increment primary key,
   bNo int not null,
   rtDate datetime Null,
   rtTime time NULL,
   rtFinish boolean,
   CONSTRAINT fk_reserveTime_business FOREIGN KEY (bNo) REFERENCES business(bNo)
);

CREATE TABLE reserve (
   rsNo int auto_increment primary key,
   dogNo int NOT NULL,
   rtNo int,
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
   CONSTRAINT fk_reserveTime_dog FOREIGN KEY (dogNo) REFERENCES dog(dogNo),
   CONSTRAINT fk_reserveTime_reserve FOREIGN KEY (rtNo) REFERENCES reserveTime(rtNo)
); 

-- 외래키 이름 찾기
-- SELECT CONSTRAINT_NAME FROM information_schema.KEY_COLUMN_USAGE WHERE TABLE_NAME = 'reserve' AND COLUMN_NAME = 'bNo';
-- SHOW CREATE TABLE reserve;
-- 포링키 해제
-- ALTER TABLE reserve DROP FOREIGN KEY reserve_ibfk_1;


CREATE TABLE review (
   rNo int auto_increment primary key,
   bNo int NOT NULL,
   uNo int NOT NULL,
   rsNo int,
   star int NOT NULL,
   rContent varchar(500) NOT NULL,
   rDate datetime NOT NULL,
   views int not  null default 0,
   CONSTRAINT fk_review_business FOREIGN KEY (bNo) REFERENCES business(bNo),
   CONSTRAINT fk_review_users FOREIGN KEY (uNo) REFERENCES users(uNo),
   CONSTRAINT fk_review_reserve FOREIGN KEY (rsNo) REFERENCES reserve(rsNo)
);

CREATE TABLE price (
   priceNo int auto_increment primary key,
   beautyNo int NOT NULL,
   bNo int NULL,
   onePrice int NULL,
   CONSTRAINT fk_price_beautylist FOREIGN KEY (beautyNo) REFERENCES beautylist(beautyNo)
);

CREATE TABLE homeimg (
   hiNo int auto_increment primary key,
   bNo int NOT NULL,
   saveName varchar(300) NULL,
   category int NULL,
   CONSTRAINT fk_homeimg_business FOREIGN KEY (bNo) REFERENCES business(bNo)
);

CREATE TABLE designer (
   dNo int auto_increment primary key,
   bNo int NOT NULL,
   dName varchar(10) NULL,
   introduce varchar(500) NULL,
   dProfile varchar(300) NULL,
   job varchar(100) Null,
   CONSTRAINT fk_designer_business FOREIGN KEY (bNo) REFERENCES business(bNo)
);

CREATE TABLE reviewimg (
   riNo int auto_increment primary key,
   rNo int NOT NULL,
   saveName varchar(300) NULL,
   CONSTRAINT fk_reviewimg_review FOREIGN KEY (rNo) REFERENCES review(rNo)
); 

CREATE TABLE afterImg (
   aiNo int auto_increment primary key,
   rsNo int NOT NULL,
   saveName varchar(200) NULL,
   CONSTRAINT fk_afterImg_reserve FOREIGN KEY (rsNo) REFERENCES reserve(rsNo)
);

CREATE TABLE rsPrice (
   rspNo int auto_increment primary key,
   rsNo int NOT NULL,
   priceNo int NOT NULL,
   rtNo int not null,
   CONSTRAINT fk_rsPrice_reserve FOREIGN KEY (rsNo) REFERENCES reserve(rsNo),
   CONSTRAINT fk_rsPrice_price FOREIGN KEY (priceNo) REFERENCES price(priceNo),
   CONSTRAINT fk_rsPrice_reserveTime FOREIGN KEY (rtNo) REFERENCES reserveTime(rtNo) ON DELETE CASCADE
);

CREATE TABLE push (
   pushNo int auto_increment primary key,
   rsNo int NOT NULL,
   pushTime time NULL,
   CONSTRAINT fk_push_reserve FOREIGN KEY (rsNo) REFERENCES reserve(rsNo)
);

CREATE TABLE point (
   pNo int auto_increment primary key,
   uNo int NOT NULL,
   pDate varchar(50) NOT NULL,
   pDiv boolean NOT NULL,
   rsNum int NULL,
   rvNum int NULL,
   usePoint int NULL,
   CONSTRAINT fk_point_users FOREIGN KEY (uNo) REFERENCES users(uNo)
);

create table notice(
   no int auto_increment primary key,
   title varchar(100) not null,
   content text null,
   reg_date date not null,
   uNo int not null,
    constraint notice_fk foreign key(uNo) references users(uNo)
);

drop table notice;
drop table point;
drop table push;
drop table rsPrice;
drop table afterImg;
drop table reviewimg;
drop table designer;
drop table homeimg;
drop table price;
drop table review;
drop table reserve;
drop table reserveTime;
drop table beautylist;
drop table dog;
drop table business;
drop table users;

-- 소형견 몸무게별 목록 추가 
insert into beautylist values(null, '소형견','2kg이하','목욕');
insert into beautylist values(null, '소형견','2kg이하','부분');
insert into beautylist values(null, '소형견','2kg이하','목욕+부분');
insert into beautylist values(null, '소형견','2kg이하','얼굴+부분+목욕');
insert into beautylist values(null, '소형견','2kg이하','기본전체미용');

insert into beautylist values(null, '소형견','2kg~5kg','목욕');
insert into beautylist values(null, '소형견','2kg~5kg','부분');
insert into beautylist values(null, '소형견','2kg~5kg','목욕+부분');
insert into beautylist values(null, '소형견','2kg~5kg','얼굴+부분+목욕');
insert into beautylist values(null, '소형견','2kg~5kg','기본전체미용');

insert into beautylist values(null, '소형견','5kg~8kg','목욕');
insert into beautylist values(null, '소형견','5kg~8kg','부분');
insert into beautylist values(null, '소형견','5kg~8kg','목욕+부분');
insert into beautylist values(null, '소형견','5kg~8kg','얼굴+부분+목욕');
insert into beautylist values(null, '소형견','5kg~8kg','기본전체미용');

insert into beautylist values(null, '소형견','8kg~10kg','목욕');
insert into beautylist values(null, '소형견','8kg~10kg','부분');
insert into beautylist values(null, '소형견','8kg~10kg','목욕+부분');
insert into beautylist values(null, '소형견','8kg~10kg','얼굴+부분+목욕');
insert into beautylist values(null, '소형견','8kg~10kg','기본전체미용');

-- 중형견 몸무게별 목록 추가 
insert into beautylist values(null, '중형견','5kg이하','목욕');
insert into beautylist values(null, '중형견','5kg이하','부분');
insert into beautylist values(null, '중형견','5kg이하','목욕+부분');
insert into beautylist values(null, '중형견','5kg이하','얼굴+부분+목욕');
insert into beautylist values(null, '중형견','5kg이하','기본전체미용');

insert into beautylist values(null, '중형견','5kg~8kg','목욕');
insert into beautylist values(null, '중형견','5kg~8kg','부분');
insert into beautylist values(null, '중형견','5kg~8kg','목욕+부분');
insert into beautylist values(null, '중형견','5kg~8kg','얼굴+부분+목욕');
insert into beautylist values(null, '중형견','5kg~8kg','기본전체미용');

insert into beautylist values(null, '중형견','8kg~10kg','목욕');
insert into beautylist values(null, '중형견','8kg~10kg','부분');
insert into beautylist values(null, '중형견','8kg~10kg','목욕+부분');
insert into beautylist values(null, '중형견','8kg~10kg','얼굴+부분+목욕');
insert into beautylist values(null, '중형견','8kg~10kg','기본전체미용');

insert into beautylist values(null, '중형견','10kg~12kg','목욕');
insert into beautylist values(null, '중형견','10kg~12kg','부분');
insert into beautylist values(null, '중형견','10kg~12kg','목욕+부분');
insert into beautylist values(null, '중형견','10kg~12kg','얼굴+부분+목욕');
insert into beautylist values(null, '중형견','10kg~12kg','기본전체미용');

-- 특수견 몸무게별 목록 추가 
insert into beautylist values(null, '특수견','5kg이하','목욕');
insert into beautylist values(null, '특수견','5kg이하','부분');
insert into beautylist values(null, '특수견','5kg이하','목욕+부분');
insert into beautylist values(null, '특수견','5kg이하','얼굴+부분+목욕');
insert into beautylist values(null, '특수견','5kg이하','스포팅');
insert into beautylist values(null, '특수견','5kg이하','가위컷');

insert into beautylist values(null, '특수견','5kg~8kg','목욕');
insert into beautylist values(null, '특수견','5kg~8kg','부분');
insert into beautylist values(null, '특수견','5kg~8kg','목욕+부분');
insert into beautylist values(null, '특수견','5kg~8kg','얼굴+부분+목욕');
insert into beautylist values(null, '특수견','5kg~8kg','스포팅');
insert into beautylist values(null, '특수견','5kg~8kg','가위컷');

insert into beautylist values(null, '특수견','8kg이상','목욕');
insert into beautylist values(null, '특수견','8kg이상','부분');
insert into beautylist values(null, '특수견','8kg이상','목욕+부분');
insert into beautylist values(null, '특수견','8kg이상','얼굴+부분+목욕');
insert into beautylist values(null, '특수견','8kg이상','스포팅');
insert into beautylist values(null, '특수견','8kg이상','가위컷');

-- 추가요금
insert into beautylist values(null, '추가요금','무관','가위컷');
insert into beautylist values(null, '추가요금','무관','엉킴');
insert into beautylist values(null, '추가요금','무관','기장');
insert into beautylist values(null, '추가요금','무관','특수얼굴컷');
insert into beautylist values(null, '추가요금','무관','염색');
insert into beautylist values(null, '추가요금','무관','초과무게');



