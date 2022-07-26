DROP TABLE NATION CASCADE CONSTRAINTS;
DROP TABLE EVENT CASCADE CONSTRAINTS;
DROP TABLE SCHEDULE CASCADE CONSTRAINTS;
DROP TABLE PLAYER CASCADE CONSTRAINTS;

CREATE TABLE NATION(
    N_CODE NUMBER(3) NOT NULL,
    N_NAME VARCHAR2(30 BYTE) NOT NULL,
    N_PARTI_PERSON NUMBER,
    N_PARTI_EVENT NUMBER,
    N_PREV_RANK NUMBER,
    N_CURR_RANK NUMBER
);

CREATE TABLE EVENT(
    E_CODE NUMBER NOT NULL,
    E_NAME VARCHAR2(30 BYTE) NOT NULL,
    E_FIRST_YEAR NUMBER(4),
    E_INFO VARCHAR2(100 BYTE)
);

CREATE TABLE PLAYER(
    P_CODE NUMBER(3) NOT NULL,
    P_NAME VARCHAR2(30 BYTE) NOT NULL,
    N_CODE NUMBER(3) NOT NULL,
    E_CODE NUMBER NOT NULL,
    P_RANK NUMBER,
    P_AGE NUMBER(3)
);

CREATE TABLE SCHEDULE(
    S_NO NUMBER(3) NOT NULL,
    N_CODE NUMBER(3) NOT NULL,
    E_CODE NUMBER,
    S_START_DATE DATE,
    S_END_DATE DATE,
    S_INFO VARCHAR2(100 BYTE)
);

-- 기본키
ALTER TABLE NATION ADD CONSTRAINT PK_NATION PRIMARY KEY(N_CODE);
    
ALTER TABLE EVENT ADD CONSTRAINT PK_EVENT PRIMARY KEY(E_CODE);
    
ALTER TABLE SCHEDULE ADD CONSTRAINT PK_SCHEDULE PRIMARY KEY(S_NO);
    
ALTER TABLE PLAYER ADD CONSTRAINT PK_PLAYER PRIMARY KEY(P_CODE);
    

-- 외래키
ALTER TABLE SCHEDULE 
    ADD CONSTRAINT FK_SCHEDULE_NATION FOREIGN KEY(N_CODE)
        REFERENCES NATION(N_CODE)
            ON DELETE SET NULL;

ALTER TABLE SCHEDULE
    ADD CONSTRAINT FK_SCHEDULE_EVENT FOREIGN KEY(E_CODE)
        REFERENCES EVENT(E_CODE)
            ON DELETE SET NULL;

ALTER TABLE PLAYER
    ADD CONSTRAINT FK_PLAYER_NATION FOREIGN KEY(N_CODE)
        REFERENCES NATION(N_CODE)
            ON DELETE CASCADE;
        
ALTER TABLE PLAYER 
    ADD CONSTRAINT FK_PLAYER_EVENT FOREIGN KEY(E_CODE)
        REFERENCES EVENT(E_CODE)
            ON DELETE CASCADE;
            
            -- * X는 SETNULL, O는 CASCADE










