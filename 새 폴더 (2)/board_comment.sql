--------------------------------------------------------
--  파일이 생성됨 - 화요일-1월-19-2021   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table BOARD_COMMENT
--------------------------------------------------------

  CREATE TABLE "BANG"."BOARD_COMMENT" 
   (	"CNO" NUMBER, 
	"BNO" NUMBER, 
	"CONTENT" VARCHAR2(1500 BYTE), 
	"CDATE" DATE DEFAULT SYSDATE, 
	"WRITER" VARCHAR2(25 BYTE), 
	"CLIKE" NUMBER DEFAULT 0, 
	"CHATE" NUMBER DEFAULT 0
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into BANG.BOARD_COMMENT
SET DEFINE OFF;
Insert into BANG.BOARD_COMMENT (CNO,BNO,CONTENT,CDATE,WRITER,CLIKE,CHATE) values (22,25,'cccc',to_date('21/01/08','RR/MM/DD'),'cccc',0,0);
Insert into BANG.BOARD_COMMENT (CNO,BNO,CONTENT,CDATE,WRITER,CLIKE,CHATE) values (41,27,'안녕하세요',to_date('21/01/11','RR/MM/DD'),'cccc',0,0);
Insert into BANG.BOARD_COMMENT (CNO,BNO,CONTENT,CDATE,WRITER,CLIKE,CHATE) values (42,27,'하이요',to_date('21/01/11','RR/MM/DD'),'cccc',0,0);
Insert into BANG.BOARD_COMMENT (CNO,BNO,CONTENT,CDATE,WRITER,CLIKE,CHATE) values (43,27,'안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요',to_date('21/01/11','RR/MM/DD'),'cccc',0,0);
Insert into BANG.BOARD_COMMENT (CNO,BNO,CONTENT,CDATE,WRITER,CLIKE,CHATE) values (44,27,'하이하이하이하이하이하이하이하이하이하이하이하이하이하이하이하이하이하이하이하이하이하이하이하이하이하이하이하이',to_date('21/01/11','RR/MM/DD'),'bbbb',0,0);
Insert into BANG.BOARD_COMMENT (CNO,BNO,CONTENT,CDATE,WRITER,CLIKE,CHATE) values (45,27,'하이하이하이하이하이하이하이하이하이하이하이하이하이하이하이하이하이하이하이하이하이하이하이하이하이하이하이하이하이하이하이하이하이하이하이하이하이하이하이하이하이하이하이하이하이하이',to_date('21/01/11','RR/MM/DD'),'bbbb',0,0);
Insert into BANG.BOARD_COMMENT (CNO,BNO,CONTENT,CDATE,WRITER,CLIKE,CHATE) values (46,4,'하이요',to_date('21/01/11','RR/MM/DD'),'aaaa',0,0);
Insert into BANG.BOARD_COMMENT (CNO,BNO,CONTENT,CDATE,WRITER,CLIKE,CHATE) values (47,83,'공지 확인',to_date('21/01/11','RR/MM/DD'),'cccc',0,0);
Insert into BANG.BOARD_COMMENT (CNO,BNO,CONTENT,CDATE,WRITER,CLIKE,CHATE) values (61,31,'하이요',to_date('21/01/12','RR/MM/DD'),'aaaa',0,0);
Insert into BANG.BOARD_COMMENT (CNO,BNO,CONTENT,CDATE,WRITER,CLIKE,CHATE) values (62,107,'ㅑㅑ',to_date('21/01/12','RR/MM/DD'),'aaaa',0,0);
Insert into BANG.BOARD_COMMENT (CNO,BNO,CONTENT,CDATE,WRITER,CLIKE,CHATE) values (63,31,'헬로우',to_date('21/01/12','RR/MM/DD'),'aaaa',0,0);
Insert into BANG.BOARD_COMMENT (CNO,BNO,CONTENT,CDATE,WRITER,CLIKE,CHATE) values (64,107,'dd',to_date('21/01/12','RR/MM/DD'),'cccc',0,0);
Insert into BANG.BOARD_COMMENT (CNO,BNO,CONTENT,CDATE,WRITER,CLIKE,CHATE) values (65,90,'좋아요',to_date('21/01/12','RR/MM/DD'),'bbbb',0,0);
--------------------------------------------------------
--  DDL for Index SYS_C007245
--------------------------------------------------------

  CREATE UNIQUE INDEX "BANG"."SYS_C007245" ON "BANG"."BOARD_COMMENT" ("CNO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table BOARD_COMMENT
--------------------------------------------------------

  ALTER TABLE "BANG"."BOARD_COMMENT" ADD PRIMARY KEY ("CNO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table BOARD_COMMENT
--------------------------------------------------------

  ALTER TABLE "BANG"."BOARD_COMMENT" ADD CONSTRAINT "FK_BNO_BCOM_BRDBNO" FOREIGN KEY ("BNO")
	  REFERENCES "BANG"."BOARD" ("BNO") ENABLE;
  ALTER TABLE "BANG"."BOARD_COMMENT" ADD CONSTRAINT "FK_WRITER_BCOM_MEMID" FOREIGN KEY ("WRITER")
	  REFERENCES "BANG"."MEMBER" ("ID") ENABLE;
