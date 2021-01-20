--------------------------------------------------------
--  파일이 생성됨 - 수요일-1월-20-2021   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table BOARD_FILE_LIST
--------------------------------------------------------

  CREATE TABLE "BANG"."BOARD_FILE_LIST" 
   (	"BNO" NUMBER, 
	"WRITER" VARCHAR2(25 BYTE), 
	"PATH" VARCHAR2(100 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into BANG.BOARD_FILE_LIST
SET DEFINE OFF;
Insert into BANG.BOARD_FILE_LIST (BNO,WRITER,PATH) values (175,'aaaa','C:\fileupload\aaaa\hate.png');
--------------------------------------------------------
--  Ref Constraints for Table BOARD_FILE_LIST
--------------------------------------------------------

  ALTER TABLE "BANG"."BOARD_FILE_LIST" ADD CONSTRAINT "FK_BFL_BNO" FOREIGN KEY ("BNO")
	  REFERENCES "BANG"."BOARD" ("BNO") ON DELETE CASCADE ENABLE;
  ALTER TABLE "BANG"."BOARD_FILE_LIST" ADD CONSTRAINT "FK_BFL_WRITER" FOREIGN KEY ("WRITER")
	  REFERENCES "BANG"."MEMBER" ("ID") ON DELETE CASCADE ENABLE;
