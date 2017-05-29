--------------------------------------------------------
--  File created - Monday-May-29-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table EVENT
--------------------------------------------------------

  CREATE TABLE "UBIS"."EVENT" 
   (	"ID" NUMBER, 
	"NAME" VARCHAR2(200 BYTE), 
	"EVENT_DATE" TIMESTAMP (6), 
	"DESCRIPTION" CLOB, 
	"AVAILABLE_TICKETS" NUMBER, 
	"TICKET_PRICE" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" 
 LOB ("DESCRIPTION") STORE AS BASICFILE (
  TABLESPACE "SYSTEM" ENABLE STORAGE IN ROW CHUNK 8192 RETENTION 
  NOCACHE LOGGING 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)) ;
--------------------------------------------------------
--  DDL for Table EVENT_TICKET
--------------------------------------------------------

  CREATE TABLE "UBIS"."EVENT_TICKET" 
   (	"EVENT_ID" NUMBER, 
	"TICKET_ID" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table TICKET
--------------------------------------------------------

  CREATE TABLE "UBIS"."TICKET" 
   (	"ID" NUMBER, 
	"OWNER" VARCHAR2(250 BYTE), 
	"BOUGHT_AT" DATE, 
	"IS_CANCELED" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Sequence EVENT_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "UBIS"."EVENT_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence TICKET_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "UBIS"."TICKET_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 32 NOCACHE  NOORDER  NOCYCLE ;
REM INSERTING into UBIS.EVENT
SET DEFINE OFF;
Insert into UBIS.EVENT (ID,NAME,EVENT_DATE,AVAILABLE_TICKETS,TICKET_PRICE) values (1,'CodeCamp',to_timestamp('03-MAY-17 08.00.04.056000000 AM','DD-MON-RR HH.MI.SSXFF AM'),48,30);
Insert into UBIS.EVENT (ID,NAME,EVENT_DATE,AVAILABLE_TICKETS,TICKET_PRICE) values (3,'Concert Les Elephants Bizzare',to_timestamp('02-AUG-16 12.00.00.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),44,50);
Insert into UBIS.EVENT (ID,NAME,EVENT_DATE,AVAILABLE_TICKETS,TICKET_PRICE) values (4,'Stand Up Silviu Gherman',to_timestamp('31-MAY-17 01.05.11.161000000 AM','DD-MON-RR HH.MI.SSXFF AM'),37,20);
REM INSERTING into UBIS.EVENT_TICKET
SET DEFINE OFF;
Insert into UBIS.EVENT_TICKET (EVENT_ID,TICKET_ID) values (1,3);
Insert into UBIS.EVENT_TICKET (EVENT_ID,TICKET_ID) values (1,1);
Insert into UBIS.EVENT_TICKET (EVENT_ID,TICKET_ID) values (1,2);
Insert into UBIS.EVENT_TICKET (EVENT_ID,TICKET_ID) values (1,4);
Insert into UBIS.EVENT_TICKET (EVENT_ID,TICKET_ID) values (1,5);
Insert into UBIS.EVENT_TICKET (EVENT_ID,TICKET_ID) values (1,6);
Insert into UBIS.EVENT_TICKET (EVENT_ID,TICKET_ID) values (1,7);
Insert into UBIS.EVENT_TICKET (EVENT_ID,TICKET_ID) values (1,8);
Insert into UBIS.EVENT_TICKET (EVENT_ID,TICKET_ID) values (1,9);
Insert into UBIS.EVENT_TICKET (EVENT_ID,TICKET_ID) values (3,10);
Insert into UBIS.EVENT_TICKET (EVENT_ID,TICKET_ID) values (3,11);
Insert into UBIS.EVENT_TICKET (EVENT_ID,TICKET_ID) values (3,12);
Insert into UBIS.EVENT_TICKET (EVENT_ID,TICKET_ID) values (3,13);
Insert into UBIS.EVENT_TICKET (EVENT_ID,TICKET_ID) values (3,14);
Insert into UBIS.EVENT_TICKET (EVENT_ID,TICKET_ID) values (3,15);
Insert into UBIS.EVENT_TICKET (EVENT_ID,TICKET_ID) values (1,16);
Insert into UBIS.EVENT_TICKET (EVENT_ID,TICKET_ID) values (3,17);
Insert into UBIS.EVENT_TICKET (EVENT_ID,TICKET_ID) values (3,18);
Insert into UBIS.EVENT_TICKET (EVENT_ID,TICKET_ID) values (1,19);
Insert into UBIS.EVENT_TICKET (EVENT_ID,TICKET_ID) values (1,20);
Insert into UBIS.EVENT_TICKET (EVENT_ID,TICKET_ID) values (3,21);
Insert into UBIS.EVENT_TICKET (EVENT_ID,TICKET_ID) values (3,22);
Insert into UBIS.EVENT_TICKET (EVENT_ID,TICKET_ID) values (4,23);
Insert into UBIS.EVENT_TICKET (EVENT_ID,TICKET_ID) values (4,24);
Insert into UBIS.EVENT_TICKET (EVENT_ID,TICKET_ID) values (3,25);
Insert into UBIS.EVENT_TICKET (EVENT_ID,TICKET_ID) values (3,26);
Insert into UBIS.EVENT_TICKET (EVENT_ID,TICKET_ID) values (3,27);
Insert into UBIS.EVENT_TICKET (EVENT_ID,TICKET_ID) values (1,28);
Insert into UBIS.EVENT_TICKET (EVENT_ID,TICKET_ID) values (1,29);
Insert into UBIS.EVENT_TICKET (EVENT_ID,TICKET_ID) values (4,30);
Insert into UBIS.EVENT_TICKET (EVENT_ID,TICKET_ID) values (4,31);
REM INSERTING into UBIS.TICKET
SET DEFINE OFF;
Insert into UBIS.TICKET (ID,OWNER,BOUGHT_AT,IS_CANCELED) values (1,'FirstOwner',to_date('01-JAN-15','DD-MON-RR'),null);
Insert into UBIS.TICKET (ID,OWNER,BOUGHT_AT,IS_CANCELED) values (2,'Vasile',to_date('01-JAN-70','DD-MON-RR'),null);
Insert into UBIS.TICKET (ID,OWNER,BOUGHT_AT,IS_CANCELED) values (3,'Vasile',to_date('01-JAN-70','DD-MON-RR'),null);
Insert into UBIS.TICKET (ID,OWNER,BOUGHT_AT,IS_CANCELED) values (4,'Vasile',to_date('01-JAN-70','DD-MON-RR'),null);
Insert into UBIS.TICKET (ID,OWNER,BOUGHT_AT,IS_CANCELED) values (5,'Vasile',to_date('01-JAN-70','DD-MON-RR'),null);
Insert into UBIS.TICKET (ID,OWNER,BOUGHT_AT,IS_CANCELED) values (6,'Vasile',to_date('01-JAN-70','DD-MON-RR'),null);
Insert into UBIS.TICKET (ID,OWNER,BOUGHT_AT,IS_CANCELED) values (7,'Vasile',to_date('01-JAN-70','DD-MON-RR'),null);
Insert into UBIS.TICKET (ID,OWNER,BOUGHT_AT,IS_CANCELED) values (8,'Vasile',to_date('01-JAN-70','DD-MON-RR'),null);
Insert into UBIS.TICKET (ID,OWNER,BOUGHT_AT,IS_CANCELED) values (29,'Valerio',to_date('28-MAY-17','DD-MON-RR'),0);
Insert into UBIS.TICKET (ID,OWNER,BOUGHT_AT,IS_CANCELED) values (30,'Valerio',to_date('28-MAY-17','DD-MON-RR'),0);
Insert into UBIS.TICKET (ID,OWNER,BOUGHT_AT,IS_CANCELED) values (31,'Valerio',to_date('28-MAY-17','DD-MON-RR'),0);
Insert into UBIS.TICKET (ID,OWNER,BOUGHT_AT,IS_CANCELED) values (27,'Robert',to_date('27-MAY-17','DD-MON-RR'),null);
Insert into UBIS.TICKET (ID,OWNER,BOUGHT_AT,IS_CANCELED) values (28,'Valerio',to_date('28-MAY-17','DD-MON-RR'),0);
--------------------------------------------------------
--  DDL for Index EVENT_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "UBIS"."EVENT_PK" ON "UBIS"."EVENT" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index TICKET_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "UBIS"."TICKET_PK" ON "UBIS"."TICKET" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table EVENT
--------------------------------------------------------

  ALTER TABLE "UBIS"."EVENT" ADD CONSTRAINT "EVENT_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "UBIS"."EVENT" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "UBIS"."EVENT" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table EVENT_TICKET
--------------------------------------------------------

  ALTER TABLE "UBIS"."EVENT_TICKET" MODIFY ("TICKET_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TICKET
--------------------------------------------------------

  ALTER TABLE "UBIS"."TICKET" ADD CONSTRAINT "TICKET_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "UBIS"."TICKET" MODIFY ("ID" NOT NULL ENABLE);
