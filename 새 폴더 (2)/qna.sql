--------------------------------------------------------
--  ������ ������ - ȭ����-1��-19-2021   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table QNA
--------------------------------------------------------

  CREATE TABLE "BANG"."QNA" 
   (	"QID" NUMBER, 
	"TITLE" VARCHAR2(100 BYTE), 
	"CONTENT" VARCHAR2(4000 BYTE), 
	"WRITER" VARCHAR2(25 BYTE), 
	"QDATE" DATE DEFAULT SYSDATE, 
	"STATUS" NUMBER DEFAULT 0, 
	"RESPONSE" VARCHAR2(4000 BYTE) DEFAULT ''
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into BANG.QNA
SET DEFINE OFF;
Insert into BANG.QNA (QID,TITLE,CONTENT,WRITER,QDATE,STATUS,RESPONSE) values (1,'a','a','a',to_date('21/01/13','RR/MM/DD'),1,null);
Insert into BANG.QNA (QID,TITLE,CONTENT,WRITER,QDATE,STATUS,RESPONSE) values (2,'a','a','a',to_date('21/01/13','RR/MM/DD'),2,null);
Insert into BANG.QNA (QID,TITLE,CONTENT,WRITER,QDATE,STATUS,RESPONSE) values (3,'a','a','aaaa',to_date('21/01/13','RR/MM/DD'),2,'�亯�Ϸ�');
Insert into BANG.QNA (QID,TITLE,CONTENT,WRITER,QDATE,STATUS,RESPONSE) values (7,'����1','����1','aaaa',to_date('21/01/13','RR/MM/DD'),0,null);
Insert into BANG.QNA (QID,TITLE,CONTENT,WRITER,QDATE,STATUS,RESPONSE) values (8,'����1','����1','aaaa',to_date('21/01/13','RR/MM/DD'),0,null);
Insert into BANG.QNA (QID,TITLE,CONTENT,WRITER,QDATE,STATUS,RESPONSE) values (9,'����1','����1','aaaa',to_date('21/01/13','RR/MM/DD'),0,null);
Insert into BANG.QNA (QID,TITLE,CONTENT,WRITER,QDATE,STATUS,RESPONSE) values (10,'����1','����1','aaaa',to_date('21/01/13','RR/MM/DD'),0,null);
Insert into BANG.QNA (QID,TITLE,CONTENT,WRITER,QDATE,STATUS,RESPONSE) values (21,'����1','���ǳ���1','bbbb',to_date('21/01/14','RR/MM/DD'),0,null);
Insert into BANG.QNA (QID,TITLE,CONTENT,WRITER,QDATE,STATUS,RESPONSE) values (22,'asd','asd','aaaa',to_date('21/01/14','RR/MM/DD'),0,null);
Insert into BANG.QNA (QID,TITLE,CONTENT,WRITER,QDATE,STATUS,RESPONSE) values (23,'asd','asd','aaaa',to_date('21/01/14','RR/MM/DD'),0,null);
Insert into BANG.QNA (QID,TITLE,CONTENT,WRITER,QDATE,STATUS,RESPONSE) values (24,'asd','asd','aaaa',to_date('21/01/14','RR/MM/DD'),0,'����');
Insert into BANG.QNA (QID,TITLE,CONTENT,WRITER,QDATE,STATUS,RESPONSE) values (25,'asd','asd','aaaa',to_date('21/01/14','RR/MM/DD'),0,'
-------------------------------------------
�ȳ��ϼ���');
Insert into BANG.QNA (QID,TITLE,CONTENT,WRITER,QDATE,STATUS,RESPONSE) values (26,'asd','asd','aaaa',to_date('21/01/14','RR/MM/DD'),0,'����');
Insert into BANG.QNA (QID,TITLE,CONTENT,WRITER,QDATE,STATUS,RESPONSE) values (27,'1','1','bbbb',to_date('21/01/14','RR/MM/DD'),0,null);
Insert into BANG.QNA (QID,TITLE,CONTENT,WRITER,QDATE,STATUS,RESPONSE) values (28,'2','2','bbbb',to_date('21/01/14','RR/MM/DD'),0,null);
Insert into BANG.QNA (QID,TITLE,CONTENT,WRITER,QDATE,STATUS,RESPONSE) values (29,'3','3','bbbb',to_date('21/01/14','RR/MM/DD'),0,null);
Insert into BANG.QNA (QID,TITLE,CONTENT,WRITER,QDATE,STATUS,RESPONSE) values (30,'4','4','bbbb',to_date('21/01/14','RR/MM/DD'),0,null);
Insert into BANG.QNA (QID,TITLE,CONTENT,WRITER,QDATE,STATUS,RESPONSE) values (31,'5','5','bbbb',to_date('21/01/14','RR/MM/DD'),0,'ddd');
Insert into BANG.QNA (QID,TITLE,CONTENT,WRITER,QDATE,STATUS,RESPONSE) values (32,'5','5','bbbb',to_date('21/01/14','RR/MM/DD'),0,null);
Insert into BANG.QNA (QID,TITLE,CONTENT,WRITER,QDATE,STATUS,RESPONSE) values (33,'5','5','bbbb',to_date('21/01/14','RR/MM/DD'),0,null);
Insert into BANG.QNA (QID,TITLE,CONTENT,WRITER,QDATE,STATUS,RESPONSE) values (34,'5','5','bbbb',to_date('21/01/14','RR/MM/DD'),1,null);
Insert into BANG.QNA (QID,TITLE,CONTENT,WRITER,QDATE,STATUS,RESPONSE) values (36,'����','����','aaaa',to_date('21/01/14','RR/MM/DD'),1,'
-------------------------------------------
�ȳ��ϼ���-------------------------------------------
�ȳ��ϼ���

����
-------------------------------------------
-------------------------------------------
�ȳ��ϼ���-------------------------------------------
�ȳ��ϼ���

���줷������
-------------------------------------------
-------------------------------------------
�ȳ��ϼ���-------------------------------------------
�ȳ��ϼ���

����
-------------------------------------------
-------------------------------------------
�ȳ��ϼ���-------------------------------------------
�ȳ��ϼ���

���줷������
-------------------------------------------
������������
-------------------------------------------
�ȳ��ϼ���-------------------------------------------
�ȳ��ϼ���

����
-------------------------------------------
-------------------------------------------
�ȳ��ϼ���-------------------------------------------
�ȳ��ϼ���

���줷������
-------------------------------------------
-------------------------------------------
�ȳ��ϼ���-------------------------------------------
�ȳ��ϼ���

����
-------------------------------------------
-------------------------------------------
�ȳ��ϼ���-------------------------------------------
�ȳ��ϼ���

���줷������
-------------------------------------------
������������
��������
-------------------------------------------
�ȳ��ϼ���-------------------------------------------
�ȳ��ϼ���

���줷������
-------------------------------------------
-------------------------------------------
�ȳ��ϼ���-------------------------------------------
�ȳ��ϼ���

���줷������
-------------------------------------------
-------------------------------------------
�ȳ��ϼ���-------------------------------------------
�ȳ��ϼ���

����
-------------------------------------------
-------------------------------------------
�ȳ��ϼ���-------------------------------------------
�ȳ��ϼ���

���줷������
-------------------------------------------
������������
-------------------------------------------
�ȳ��ϼ���-------------------------------------------
�ȳ��ϼ���

����
-------------------------------------------
-------------------------------------------
�ȳ��ϼ���-------------------------------------------
�ȳ��ϼ���

���줷������
-------------------------------------------
-------------------------------------------
�ȳ��ϼ���-------------------------------------------
�ȳ��ϼ���

����
-------------------------------------------
-------------------------------------------
�ȳ��ϼ���-------------------------------------------
�ȳ��ϼ���

���줷������
-------------------------------------------
������������
��������
');
--------------------------------------------------------
--  DDL for Index SYS_C007251
--------------------------------------------------------

  CREATE UNIQUE INDEX "BANG"."SYS_C007251" ON "BANG"."QNA" ("QID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table QNA
--------------------------------------------------------

  ALTER TABLE "BANG"."QNA" ADD PRIMARY KEY ("QID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
