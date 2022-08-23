/* 1. 테이블 데이터 타입 
    CHAR(size)      : 고정 길이 문자타입(1~2000byte 크기)         // * char과 varchar2의 차이(용량, 속도)
    VARCHAR2(size)  : 가변 길이 문자타입(1~4000byte 크기)         // varchar2는 가변성이라 문자열에 따라 길이가 변하기 때문에,
                                                                // 편리하지만 작업에 딜레이가 생김, char은 고정길이라 정해진 길이를 벗어나면 오류가 발생한다
    Number(p,s)     : 정밀도(p), 스케일(s)로 표현되는 숫자타입 
                      -정밀도(p)  : 정수 + 소수점 모두 포함하는 전체 유효숫자(0제외 *)
                      -스케일(s)  : 소수점 자리 수 
                    ex) NUMBER(3)   : 최대 3자리 정수(실수X)
                        NUMBER(5,2) : 전체 5자리(.제외 소수점자리포함), 소수점 2자리 실수(최대값 123.45)
                        NUMBER(2,2) : 1 미만의 소수점 2자리 실수(0.12)
                        NUMBER      : 최대 38자리 숫자(22바이트)
*/

/* 2. 테이블 생성
   1) 제약조건의 이름을 지정하지 않는 방법(SYS로 시작하는 임의의 제약조건이름이 지정)
   2) 제약조건의 이름을 지정하는 방법
*/

/* 3. 제약조건 생성
   1) 테이블 생성할 때 함께 지정
   2) 테이블 생성 후 테이블 수정하면서 지정(아직못함 + 외래키)
*/

/* 4. 제약조건을 가진 데이터사전
   1. DBA_CONSTRAINTS
   2. USER_CONSTRAINTS  : 현재 접속한 사용자가 만든 제약조건 확인가능(BDA, USER, ALL은 전부 테이블명)
   3. ALL_CONSTRAINTS
*/

-- USER_CONSTRAINTS 테이블의 구조를 확인
DESCRIBE SYS.USER_CONSTRAINTS
-- (SYS는 생략가능)
-- * 출력하기 : 실행할 문을 블록잡고 ctrl + 엔터(커서만 둬도 된다)

--USER_CONSTRAINTS 테이블의 CONSTRAINTS_NAME 칼럼 확인법 : TABLE에서 CONSTRAINT(제약사항) 확인하는법
SELECT CONSTRAINT_NAME FROM USER_CONSTRAINTS;
--> USER 유저의 제약사항으로부터 제약사항 이름을 가져오라?

-- 1. 제약조건 이름 없이 테이블 만들기
DROP TABLE USER_TBL;    --TABLE 삭제 * 테이블은 한번 돌리면 수정이 불가하나, DROP까지 블록잡고 돌리면 수정할 수 있다
CREATE TABLE USER_TBL(
    USER_ID VARCHAR2(30 BYTE) NOT NULL PRIMARY KEY,
    USER_PW VARCHAR2(30 BYTE) NOT NULL,
    USER_NAME VARCHAR2(30 BYTE) NULL,                --NULL : 빈칸이여도 문제없다
    USER_AGE NUMBER(3) NULL CHECK(USER_AGE BETWEEN 0 AND 100),    --NUMBER : 최대 세자리수(0과 100사이 CHECK 0, 100포함)
    USER_ADDR VARCHAR2(30 BYTE) NULL,                             --
    USER_TEL CHAR(13 BYTE) NULL UNIQUE,              -- -(하이푼 포함 13바이트)
    USER_GEN CHAR(1 BYTE) NULL                       -- UNIQUE : 중복허가X
); 
--> 두번 실행하면 실패 : 이미 있어서

-- 2. 제약조건 이름없이 테이블 만들기 2번쨰 (NULL을 제외한 나머지 제약조건을 아래로 빼기)

DROP TABLE USER_TBL;   
CREATE TABLE USER_TBL(
    USER_ID VARCHAR2(30 BYTE) NOT NULL,
    USER_PW VARCHAR2(30 BYTE) NOT NULL,
    USER_NAME VARCHAR2(30 BYTE) NULL,             
    USER_AGE NUMBER(3) NULL,
    USER_ADDR VARCHAR2(30 BYTE) NULL,               
    USER_TEL CHAR(13 BYTE) NULL,            
    USER_GEN CHAR(1 BYTE) NULL,                     
    PRIMARY KEY(USER_ID),
    CHECK(USER_AGE BETWEEN 0 AND 100),
    UNIQUE(USER_TEL)
); 

-- 3. 제약조건이름 지정하며 테이블만들기
DROP TABLE USER_TBL;    
CREATE TABLE USER_TBL(
    USER_ID VARCHAR2(30 BYTE) NOT NULL CONSTRAINT PK_USER_TBL PRIMARY KEY,
    USER_PW VARCHAR2(30 BYTE) NOT NULL,
    USER_NAME VARCHAR2(30 BYTE) NULL,               
    USER_AGE NUMBER(3) NULL CONSTRAINT CK_USER_AGE CHECK(USER_AGE BETWEEN 0 AND 100),   
    USER_ADDR VARCHAR2(30 BYTE) NULL,                            
    USER_TEL CHAR(13 BYTE) NULL CONSTRAINT UQ_USER_TEL UNIQUE,             
    USER_GEN CHAR(1 BYTE) NULL                      
); 

-- 4. 제약조건이름 지정하며 테이블 만들기 2번쨰 **
DROP TABLE USER_TBL;   
CREATE TABLE USER_TBL(
    USER_ID VARCHAR2(30 BYTE) NOT NULL, -- 칼럼들
    USER_PW VARCHAR2(30 BYTE) NOT NULL,
    USER_NAME VARCHAR2(30 BYTE) NULL,             
    USER_AGE NUMBER(3) NULL,
    USER_ADDR VARCHAR2(30 BYTE) NULL,               
    USER_TEL CHAR(13 BYTE) NULL,            
    USER_GEN CHAR(1 BYTE) NULL,                     
    CONSTRAINT PK_USER_TBL PRIMARY KEY(USER_ID),                -- 제약조건이 기본키(기본키)
    CONSTRAINT CK_USER_AGE CHECK(USER_AGE BETWEEN 0 AND 100),   -- 제약조건이 CHECK(칼럼)
    CONSTRAINT UQ_USER_TEL UNIQUE(USER_TEL)                     -- 제약조건이 중복X(칼럼)
    
); 


