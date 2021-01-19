--------------------------------------------------------
--  파일이 생성됨 - 화요일-1월-19-2021   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table MEMBER
--------------------------------------------------------

  CREATE TABLE "BANG"."MEMBER" 
   (	"ID" VARCHAR2(25 BYTE), 
	"PASS" VARCHAR2(100 BYTE), 
	"NAME" VARCHAR2(20 BYTE), 
	"AGE" NUMBER, 
	"GRADE" NUMBER DEFAULT 1
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into BANG.MEMBER
SET DEFINE OFF;
Insert into BANG.MEMBER (ID,PASS,NAME,AGE,GRADE) values ('bbbb','bbbbb','bbbb',12,1);
Insert into BANG.MEMBER (ID,PASS,NAME,AGE,GRADE) values ('cccc','cccc','cccc',1,1);
Insert into BANG.MEMBER (ID,PASS,NAME,AGE,GRADE) values ('admin','admin','admin',10,0);
Insert into BANG.MEMBER (ID,PASS,NAME,AGE,GRADE) values ('kkkk','kkkk','kkkk',11,1);
Insert into BANG.MEMBER (ID,PASS,NAME,AGE,GRADE) values ('asd','12341234','asd',123,1);
Insert into BANG.MEMBER (ID,PASS,NAME,AGE,GRADE) values ('asdf','asdfasdf','asd',12,0);
Insert into BANG.MEMBER (ID,PASS,NAME,AGE,GRADE) values ('Z1773','123456','강병헌',49,1);
Insert into BANG.MEMBER (ID,PASS,NAME,AGE,GRADE) values ('Z6298','123456','김동수',50,1);
Insert into BANG.MEMBER (ID,PASS,NAME,AGE,GRADE) values ('Q3297','123456','김시우',6,3);
Insert into BANG.MEMBER (ID,PASS,NAME,AGE,GRADE) values ('T4369','123456','김준래',47,1);
Insert into BANG.MEMBER (ID,PASS,NAME,AGE,GRADE) values ('Q8675','123456','박셩우',34,3);
Insert into BANG.MEMBER (ID,PASS,NAME,AGE,GRADE) values ('A6252','123456','박병상',2,1);
Insert into BANG.MEMBER (ID,PASS,NAME,AGE,GRADE) values ('M2454','123456','박정현',27,1);
Insert into BANG.MEMBER (ID,PASS,NAME,AGE,GRADE) values ('aaaaa','ssss','aa',1,1);
Insert into BANG.MEMBER (ID,PASS,NAME,AGE,GRADE) values ('P3478','123456','이원구',43,4);
Insert into BANG.MEMBER (ID,PASS,NAME,AGE,GRADE) values ('W4354','123456','정성수',50,3);
Insert into BANG.MEMBER (ID,PASS,NAME,AGE,GRADE) values ('L4082','123456','정희우',46,4);
Insert into BANG.MEMBER (ID,PASS,NAME,AGE,GRADE) values ('B7249','123456','조성수',26,3);
Insert into BANG.MEMBER (ID,PASS,NAME,AGE,GRADE) values ('S3150','123456','주지우',31,1);
Insert into BANG.MEMBER (ID,PASS,NAME,AGE,GRADE) values ('T6388','123456','최승수',51,2);
Insert into BANG.MEMBER (ID,PASS,NAME,AGE,GRADE) values ('S6278','123456','한상오',31,2);
Insert into BANG.MEMBER (ID,PASS,NAME,AGE,GRADE) values ('W4392','123456','이지원',39,4);
Insert into BANG.MEMBER (ID,PASS,NAME,AGE,GRADE) values ('S2298','123456','김희연',65,3);
Insert into BANG.MEMBER (ID,PASS,NAME,AGE,GRADE) values ('F1193','123456','노소정',33,3);
Insert into BANG.MEMBER (ID,PASS,NAME,AGE,GRADE) values ('E6882','123456','손지해',28,3);
Insert into BANG.MEMBER (ID,PASS,NAME,AGE,GRADE) values ('I5201','123456','정다혜',41,2);
Insert into BANG.MEMBER (ID,PASS,NAME,AGE,GRADE) values ('I9870','123456','장세이',42,2);
Insert into BANG.MEMBER (ID,PASS,NAME,AGE,GRADE) values ('O1546','123456','장희은',63,2);
Insert into BANG.MEMBER (ID,PASS,NAME,AGE,GRADE) values ('T6396','123456','남혜미',52,2);
Insert into BANG.MEMBER (ID,PASS,NAME,AGE,GRADE) values ('K6985','123456','유민주',49,1);
Insert into BANG.MEMBER (ID,PASS,NAME,AGE,GRADE) values ('N1462','123456','원소은',512,4);
Insert into BANG.MEMBER (ID,PASS,NAME,AGE,GRADE) values ('aaaa','aaaa','aaaaa',12,1);
--------------------------------------------------------
--  DDL for Index SYS_C007217
--------------------------------------------------------

  CREATE UNIQUE INDEX "BANG"."SYS_C007217" ON "BANG"."MEMBER" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table MEMBER
--------------------------------------------------------

  ALTER TABLE "BANG"."MEMBER" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "BANG"."MEMBER" MODIFY ("PASS" NOT NULL ENABLE);
