--------------------------------------------------------
--  파일이 생성됨 - 화요일-1월-19-2021   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table BOARD_FILE_LIST
--------------------------------------------------------

  CREATE TABLE "BANG"."BOARD_FILE_LIST" 
   (	"BNO" NUMBER, 
	"WRITER" VARCHAR2(25 BYTE), 
	"FILENAME" VARCHAR2(100 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into BANG.BOARD_FILE_LIST
SET DEFINE OFF;
Insert into BANG.BOARD_FILE_LIST (BNO,WRITER,FILENAME) values (141,'aaaa','master.png');
Insert into BANG.BOARD_FILE_LIST (BNO,WRITER,FILENAME) values (142,'aaaa','bronze.png');
Insert into BANG.BOARD_FILE_LIST (BNO,WRITER,FILENAME) values (143,'aaaa','bronze.png');
Insert into BANG.BOARD_FILE_LIST (BNO,WRITER,FILENAME) values (144,'aaaa','vip.png');
Insert into BANG.BOARD_FILE_LIST (BNO,WRITER,FILENAME) values (144,'aaaa','vvip.png');
Insert into BANG.BOARD_FILE_LIST (BNO,WRITER,FILENAME) values (144,'aaaa','bronze.png');
--------------------------------------------------------
--  Ref Constraints for Table BOARD_FILE_LIST
--------------------------------------------------------

  ALTER TABLE "BANG"."BOARD_FILE_LIST" ADD CONSTRAINT "FK_BFL_BNO" FOREIGN KEY ("BNO")
	  REFERENCES "BANG"."BOARD" ("BNO") ENABLE;
  ALTER TABLE "BANG"."BOARD_FILE_LIST" ADD CONSTRAINT "FK_BFL_WRITER" FOREIGN KEY ("WRITER")
	  REFERENCES "BANG"."MEMBER" ("ID") ENABLE;
