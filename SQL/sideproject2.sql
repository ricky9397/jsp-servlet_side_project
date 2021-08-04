-- drop
drop table iorder;
drop table member;
drop table product;
drop table bbs;
drop table COMMENTS;

--select
select * from member;
select * from product;
select * from iorder;
select * from bbs;
select * from comments;

-- member 테이블
CREATE TABLE  MEMBER (
                                ID VARCHAR2(40) CONSTRAINT MEMBER_ID_PK PRIMARY KEY,
                                PW VARCHAR2(20)CONSTRAINT MEMBER_PW_NN NOT NULL,
                                NAME  VARCHAR2(20)CONSTRAINT MEMBER_NAME_NN NOT NULL ,
                                POST NUMBER CONSTRAINT MEMBER_POST_NN NOT NULL,
                                ADDRESS VARCHAR2(100)CONSTRAINT MEMBER_ADDRESS1_NN NOT NULL,
                                ADDRESSS VARCHAR2(100)CONSTRAINT MEMBER_ADDRESS2_NN NOT NULL,
                                PHONENUM  VARCHAR2(40)CONSTRAINT MEMBER_NUM_NN NOT NULL,
                                EMAIL VARCHAR2(100)CONSTRAINT MEMBER_EMAIL_NN NOT NULL
                              ) ;

-- 상품 테이블          
CREATE TABLE  PRODUCT (
                                ICODE NUMBER(6) CONSTRAINT PRODUCT_ICODE_PK PRIMARY KEY,
                                INAME  VARCHAR2(50)CONSTRAINT PRODUCT_NAME_NN NOT NULL ,
                                IPRICE  INTEGER , 
                                COUNT INTEGER,
                                IPHOTO VARCHAR2(50) DEFAULT 'photo.png',
                                CONTENT1 VARCHAR2(100),
                                CONTENT2 VARCHAR2(100),
                                CONTENT3 VARCHAR2(100)
                              ) ;          
                              
-- 주문 테이블                              
CREATE TABLE IORDER (           oidx NUMBER(6) CONSTRAINT ORDER_OCODE_PK PRIMARY KEY,
                                ICODE NUMBER(6) CONSTRAINT ORDER_ICODE_FK REFERENCES PRODUCT(ICODE) NOT NULL,
                                ID VARCHAR2(40) CONSTRAINT ORDER_ID_NN REFERENCES MEMBER(ID) NOT NULL,
                                ONAME  VARCHAR2(50)CONSTRAINT ORDER_NAME_NN NOT NULL ,
                                OPRICE  INTEGER ,
                                OPHOTO VARCHAR2(50) DEFAULT 'photo.png',
                                ODATE  DATE DEFAULT SYSDATE,
                                count Integer
                              ) ;


-- 게시판 테이블
CREATE TABLE BBS(
    BBSNUM NUMBER PRIMARY KEY,
    BBSTITLE VARCHAR2(50) NOT NULL,
    ID VARCHAR2(20) NOT NULL,
    BBSDATE DATE DEFAULT SYSDATE,
    BBSHIT NUMBER,
    BBSCONTENT VARCHAR2(2048) NOT NULL,
    PHOTO VARCHAR2(50) DEFAULT 'photo.png'
);


-- 댓글 테이블
CREATE TABLE COMMENTS(
    CNUM NUMBER PRIMARY KEY,
    CBBSNUM NUMBER REFERENCES BBS(BBSNUM) NOT NULL,
    COMMENTID VARCHAR2(20) NOT NULL,
    COMMENTDATE DATE DEFAULT SYSDATE,
    COMMENTCONTENT VARCHAR2(2048)
);

--시퀀스 삭제
drop sequence comment_dix_seq;
drop sequence iorder_oidx_seq ;


--시퀀스 생성
create sequence comment_dix_seq;
create sequence iorder_oidx_seq ;

commit;
              



