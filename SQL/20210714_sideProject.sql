drop table iorder;
drop table member;
drop table product;
update member set pw='1234', name='홍길순', post=3030, address='서울 신촌', addresss='먹자골목', phonenum='01056789088', email='bbb@bbb.com' where id='test';
insert into member values(member_idx_seq.nextval, 'test2', '1111', '홍길동', 330, '신촌', '로데오', '01055550000', 'asd@asd.com');
select * from member;
delete from member where pw='1234';
-- member 테이블
CREATE TABLE  MEMBER (
                                IDX NUMBER CONSTRAINT MEMBER_IDX_PK PRIMARY KEY,
                                ID VARCHAR2(40) CONSTRAINT MEMBER_ID_NN NOT NULL,
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
insert into product values (10, '반바지', '2000', 5, '상의', 'PNG', 'ASD', 'ASD', '하의');
select * from product;
select max(icode) from product;
drop table product;
select * from product where icode=1;
select * from product where category='상의';

                              
                              
CREATE TABLE IORDER (           oidx NUMBER(6) CONSTRAINT ORDER_OCODE_PK PRIMARY KEY,
                                ICODE NUMBER(6) CONSTRAINT ORDER_ICODE_FK REFERENCES PRODUCT(ICODE) NOT NULL,
                                ID VARCHAR2(40) CONSTRAINT ORDER_ID_NN NOT NULL,
                                ONAME  VARCHAR2(50)CONSTRAINT ORDER_NAME_NN NOT NULL ,
                                OPRICE  INTEGER ,
                                OPHOTO VARCHAR2(50) DEFAULT 'photo.png',
                                ODATE  DATE DEFAULT SYSDATE,
                                count Integer
                              ) ;
drop table iorder;
select * from iorder;
insert into iorder values(iorder_oidx_seq.nextval, 1, 'test1', '덩크', '8000', 'photo.png', sysdate, 1) where icode=1;

--시퀀스 삭제
drop sequence member_idx_seq ;
drop sequence comment_dix_seq;
drop sequence iorder_oidx_seq ;


--시퀀스 생성
create sequence member_idx_seq ;
create sequence comment_dix_seq;
create sequence iorder_oidx_seq ;
                              

--iorder dml -- oidx, ordercode, icode,idx,orderdate,count,price
insert into iorder values (iorder_oidx_seq.nextval, '', 1,3,sysdate,5,10000);
insert into iorder values (iorder_oidx_seq.nextval, '', 1,4,'21/06/22',5,10000);
insert into iorder values (iorder_oidx_seq.nextval, '', 1,4,'21/05/22',5,10000);


commit;
              

              
select * from iorder;
select * from member;
select * from product;

select to_char(sysdate, 'YYYY/MM/DD/HH:MI:SS') from dual;

SELECT SYSDATE FROM DUAL;

select id from member order by id desc;

-- 게시판 테이블
CREATE TABLE BBS(
    BBSNUM NUMBER PRIMARY KEY,
    BBSTITLE VARCHAR2(50),
    ID VARCHAR2(20),
    BBSDATE DATE DEFAULT SYSDATE,
    BBSHIT NUMBER,
    BBSCONTENT VARCHAR2(2048)
);

DELETE from bbs where bbsnum=5;
select * from bbs order by bbsnum desc;
select * from bbs;
insert into bbs values (1, '안녕하세요', test, sysdate, 0, '뭐이색기야', 1, 1, 0);
DROP TABLE BBS;
select max(bbsnum) from bbs;
select bbsnum, bbstitle, id, bbsdate, bbshit from bbs order by bbsgroup, bbsstep asc;

-- 댓글 테이블
CREATE TABLE COMMENTS(
    CNUM NUMBER PRIMARY KEY,
    CBBSNUM NUMBER,
    COMMENTID VARCHAR2(20),
    COMMENTDATE DATE DEFAULT SYSDATE,
    COMMENTPARENT NUMBER,
    COMMENTCONTENT VARCHAR2(2048)
);

drop table comments;
select * from comments;
delete from comments where cnum=243;
select * from comments where cbbsnum=4;
select * from comments where cbbsnum=1 start with commentparent=0 connect by prior cnum=commentparent;
insert into comments values(2, 2, 'test', sysdate, 2, '안녕하세요');
update comments set commentcontent='ffff' where cnum=4;


-- CART 테이블
CREATE TABLE CART(
    CARTNUM NUMBER PRIMARY KEY,
    CARTCODE NUMBER,
    ID VARCHAR2(20),
    COUNT NUMBER
);

-- SELECT
SELECT * FROM CART;

