--------------------------------------------------------
--  파일이 생성됨 - 화요일-1월-19-2021   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table BOARD
--------------------------------------------------------

  CREATE TABLE "BANG"."BOARD" 
   (	"BNO" NUMBER, 
	"TITLE" VARCHAR2(150 BYTE), 
	"BDATE" DATE DEFAULT SYSDATE, 
	"BCOUNT" NUMBER DEFAULT 0, 
	"WRITER" VARCHAR2(25 BYTE), 
	"CONTENT" VARCHAR2(500 BYTE), 
	"BLIKE" NUMBER DEFAULT 0, 
	"BHATE" NUMBER DEFAULT 0
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into BANG.BOARD
SET DEFINE OFF;
Insert into BANG.BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (2,'TEST',to_date('21/01/05','RR/MM/DD'),26,'admin','내용이다',0,0);
Insert into BANG.BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (4,'ㅁㅁㅁ',to_date('21/01/05','RR/MM/DD'),19,'aaaa','ㅁㅁㅁㅁ',2,1);
Insert into BANG.BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (5,'ㅁ',to_date('21/01/05','RR/MM/DD'),7,'aaaa','ㅁ',0,0);
Insert into BANG.BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (25,'aaaa',to_date('21/01/06','RR/MM/DD'),107,'aaaa','안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요',0,0);
Insert into BANG.BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (26,'안녕하세요',to_date('21/01/06','RR/MM/DD'),12,'aaaa','안녕하세요1
안녕하세요2
안녕하세요3',0,0);
Insert into BANG.BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (27,'안녕하세요',to_date('21/01/06','RR/MM/DD'),81,'aaaa','안녕하세요1
안녕하세요2
안녕하세요3',2,1);
Insert into BANG.BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (28,'bb',to_date('21/01/06','RR/MM/DD'),17,'bbbb','bb
bb
bb',1,0);
Insert into BANG.BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (29,'bb',to_date('21/01/06','RR/MM/DD'),10,'bbbb','bb   sss 
bbsss                      dddd
bb',1,0);
Insert into BANG.BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (30,'haha',to_date('21/01/06','RR/MM/DD'),20,'bbbb','haha               

kkkkkk',2,2);
Insert into BANG.BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (31,'aaa',to_date('21/01/06','RR/MM/DD'),30,'aaaa','aaa     abbbbbb',4,11);
Insert into BANG.BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (32,'asd',to_date('21/01/06','RR/MM/DD'),3,'bbbb','asd',1,0);
Insert into BANG.BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (33,'a',to_date('21/01/06','RR/MM/DD'),10,'aaaa','ahaha',0,1);
Insert into BANG.BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (61,'cccc',to_date('21/01/08','RR/MM/DD'),17,'cccc','cccc',0,1);
Insert into BANG.BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (83,'공지1',to_date('21/01/11','RR/MM/DD'),7,'asdf','공지내용1',2,0);
Insert into BANG.BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (0,'zzzzzzzzzzzzzzzzzzz',to_date('21/01/06','RR/MM/DD'),20,'admin','zzzzzzzzzzzzzzzzzzz',0,0);
Insert into BANG.BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (22,'바보',to_date('21/01/06','RR/MM/DD'),3,'admin','멍청이',0,0);
Insert into BANG.BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (23,'바보',to_date('21/01/06','RR/MM/DD'),2,'admin','멍청이',0,0);
Insert into BANG.BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (24,'바보',to_date('21/01/06','RR/MM/DD'),10,'admin','ㅁ',0,0);
Insert into BANG.BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (85,'TEST',to_date('21/01/05','RR/MM/DD'),26,'admin','내용이다',0,0);
Insert into BANG.BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (86,'zzzzzzzzzzzzzzzzzzz',to_date('21/01/06','RR/MM/DD'),20,'admin','zzzzzzzzzzzzzzzzzzz',0,0);
Insert into BANG.BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (87,'바보',to_date('21/01/06','RR/MM/DD'),3,'admin','멍청이',0,0);
Insert into BANG.BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (88,'바보',to_date('21/01/06','RR/MM/DD'),2,'admin','멍청이',0,0);
Insert into BANG.BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (89,'바보',to_date('21/01/06','RR/MM/DD'),11,'admin','ㅁ',0,0);
Insert into BANG.BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (90,'fghfgh',to_date('21/01/06','RR/MM/DD'),42,'admin','gfgggg',23,206);
Insert into BANG.BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (91,'asd',to_date('21/01/06','RR/MM/DD'),1,'admin','619645
',0,0);
Insert into BANG.BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (92,'asdasd',to_date('21/01/06','RR/MM/DD'),6,'admin','1456632',0,0);
Insert into BANG.BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (93,'abc',to_date('21/01/06','RR/MM/DD'),1,'admin','.',0,0);
Insert into BANG.BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (94,'룰루룰루루',to_date('21/01/06','RR/MM/DD'),6,'admin','야호',2,0);
Insert into BANG.BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (95,'왜안됭',to_date('21/01/06','RR/MM/DD'),3,'admin','?',17,0);
Insert into BANG.BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (96,'cbvcvb',to_date('21/01/07','RR/MM/DD'),0,'admin','we235wte',0,0);
Insert into BANG.BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (98,'gsdfg',to_date('21/01/08','RR/MM/DD'),0,'admin','sdfgsdfg',0,0);
Insert into BANG.BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (99,'mnmmm',to_date('21/01/08','RR/MM/DD'),0,'admin','mmmmm',0,0);
Insert into BANG.BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (100,'bbbb',to_date('21/01/11','RR/MM/DD'),0,'admin','bbbbbbbb',0,0);
Insert into BANG.BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (101,'bbbb',to_date('21/01/11','RR/MM/DD'),0,'admin','bbbbbbbb',0,0);
Insert into BANG.BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (102,'bbbb',to_date('21/01/11','RR/MM/DD'),0,'admin','bbbbbbbb',0,0);
Insert into BANG.BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (103,'bbbb',to_date('21/01/11','RR/MM/DD'),0,'admin','bbbbbbbb',0,0);
Insert into BANG.BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (104,'nm,n,nm,',to_date('21/01/11','RR/MM/DD'),3,'admin','nm,nm,n',0,0);
Insert into BANG.BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (105,'vvvv',to_date('21/01/11','RR/MM/DD'),2,'admin','vvvvvv',0,0);
Insert into BANG.BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (106,'어려웡ㅠ',to_date('21/01/11','RR/MM/DD'),2,'admin','아냐 할수 있어!',1,0);
Insert into BANG.BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (107,'히히히',to_date('21/01/11','RR/MM/DD'),10,'admin','ㅎㅎㅎ',1,1);
Insert into BANG.BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (108,'실험',to_date('21/01/11','RR/MM/DD'),3,'admin','어디보자',0,0);
Insert into BANG.BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (121,'제목1',to_date('21/01/18','RR/MM/DD'),0,'aaaa','내용1',0,0);
Insert into BANG.BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (122,'제목1',to_date('21/01/18','RR/MM/DD'),1,'aaaa','내용1',0,0);
Insert into BANG.BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (123,'제목1',to_date('21/01/18','RR/MM/DD'),2,'aaaa','내용1',0,0);
--------------------------------------------------------
--  DDL for Index SYS_C007243
--------------------------------------------------------

  CREATE UNIQUE INDEX "BANG"."SYS_C007243" ON "BANG"."BOARD" ("BNO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table BOARD
--------------------------------------------------------

  ALTER TABLE "BANG"."BOARD" ADD PRIMARY KEY ("BNO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table BOARD
--------------------------------------------------------

  ALTER TABLE "BANG"."BOARD" ADD CONSTRAINT "FK_WRITER_BRD_MEMID" FOREIGN KEY ("WRITER")
	  REFERENCES "BANG"."MEMBER" ("ID") ENABLE;
