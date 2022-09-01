/**
    
        1. PL/SQL
            - 오라클의 프로그래밍 처리가 가능한 SQL
            - 프로그래밍 형식
                [DECLARE]
                    [변수선언]
                BEGIN 
                    수행할 쿼리문
                END;
            - PL/SQL의 데이터(변수, 상수)는 서버메시지로 출력
            - 서버메시지 출력을 위해서 최초 1회 설정해줄 데이터가 있음(디폴트 SET SERVEROUTPUT OFF)
            - SET SERVEROUTPUT ON;
            
            
            * 순서
            1. 기초데이터 작성
            2. 서버메시지 출력기능 
                => SET SERVEROUTPUT ON;
                
            3. 변수선언
                => (1) DECLARE 
                    변수명1 변수타입;
                    변수명2 변수타입;
                   (2) 참조변수 : 특정 칼럼의 타입을 그대로 이용
                     => 테이블명.칼럼명%TYPE
                     
            4. 변수대입 서버메시지 출력
                => BEGIN 
                   (1) 변수값 대입( := )
                    변수명1 := '';
                    변수명2 := 숫자;
                   (2) 출력
                    DBMS_OUTPUT.PUT_LINE(출력문);
                   (3) 참조변수 활용
                    => 다른 테이블의 값을 참조하여 해당 변수에 대입  
                    DECLARE : 변수명 참조할 테이블.참조할 칼럼%TYPE;
                    BEGIN   : SELECT 칼럼 INTO 변수 FROM 테이블 WHERE 조건식
                    
                    * 변수종류
                    1) 스칼라 변수
                    2) 참조변수
                    3) 참조변수 활용
                    4) 레코드 변수
                    5) 행변수
            
*/



-- 기초데이터 준비
-- ex) HR 계정의 EMPLOYEES 테이블을 SCOTT 계정으로 복사해오기

CREATE TABLE EMPLOYEES AS (SELECT * 
                             FROM HR.EMPLOYEES);

-- 기본키, 외래키는 안넘어왔으니 직접 추가(기본키만)
ALTER TABLE EMPLOYEES
    ADD CONSTRAINT PK_EMPLOYEES PRIMARY KEY(EMPLOYEE_ID);
        
-- 서버메시지 출력 가능 상태로 변경
SET SERVEROUTPUT ON;

-- 서버메시지 출력
BEGIN
    DBMS_OUTPUT.PUT_LINE('HELLO'); -- HELLO 출력 후 줄바꿈
END;    

--------------------------------------------------------------------------------

-- 2. 스칼라 변수 선언
--  - 스칼라 변수 : 직접 타입을 명시하는 변수
--  - 대입연산자 : 콜론(:=)
--  - 변수선언은 DECLARE에서 처리
DECLARE 
    -- 스칼라 변수선언
    NAME VARCHAR(20 BYTE);
    AGE NUMBER(3);
BEGIN 
    NAME := '이승준';
    AGE := 27;
    DBMS_OUTPUT.PUT_LINE('내 이름은 ' || NAME || '입니다.');
    DBMS_OUTPUT.PUT_LINE('내 나이는 ' || AGE || '살 입니다.');
END;    

--------------------------------------------------------------------------------

-- 3. 참조변수 선언                                                               *
--      - 참조변수 : 특정 칼럼의 타입을 그대로 사용하는 변수
--      - 선언방법 : 테이블명.칼럼명%TYPE

DECLARE 
        NAME EMPLOYEES.FIRST_NAME%TYPE;
BEGIN 
        NAME := '이승준';
        DBMS_OUTPUT.PUT_LINE('내 이름은' || NAME || '입니다');
END; 

--------------------------------------------------------------------------------

-- 4. 참조변수 활용
-- 테이블의 데이터를 읽어 참조변수에 저장
-- SELECT 칼럼 INTO 변수 FROM 테이블 WHERE 조건식                                 *

-- 문제. EMPLOYEE_ID가 100인 회원의 FIRST_NAME, LAST_NAME, SALARY 정보를 참조변수에 저장


DECLARE 
    F_NAME EMPLOYEES.FIRST_NAME%TYPE;
    L_NAME EMPLOYEES.LAST_NAME%TYPE;
    V_SALARY EMPLOYEES.SALARY%TYPE;
BEGIN
    SELECT 
        FIRST_NAME, LAST_NAME, SALARY INTO F_NAME, L_NAME, V_SALARY
      FROM EMPLOYEES
     WHERE EMPLOYEE_ID = 100;
    DBMS_OUTPUT.PUT_LINE(F_NAME || L_NAME || V_SALARY);
END;

--------------------------------------------------------------------------------

-- 5. 레코드 변수 선언
--  => 레코드      : 필드의 모임, DB에서 레코드는 행(ROW)          * 클래스 = 레코드, 필드(객체) : 칼럼
--  => 레코드 변수 : 여러 칼럼을 동시에 저장하는 변수
--  => 레코드 변수 정의와 선언과정으로 진행

DECLARE 
    -- 1) 레코드 변수 타입정의
    TYPE MY_TYPE IS RECORD(
        V_FNAME EMPLOYEES.FIRST_NAME%TYPE,
        V_LNAME EMPLOYEES.LAST_NAME%TYPE,
        V_SALARY EMPLOYEES.SALARY%TYPE
        );
    -- 2) 레코드 변수 선언    
        V_ROW MY_TYPE;              -- * V_ROW는 위의 변수3개가 모인것
BEGIN
    SELECT
            FIRST_NAME, LAST_NAME, SALARY
      INTO  V_ROW
      FROM  EMPLOYEES
     WHERE  EMPLOYEE_ID = 100;
DBMS_OUTPUT.PUT_LINE(V_ROW.V_FNAME || V_ROW.V_LNAME || V_ROW.V_SALARY);
END;

--------------------------------------------------------------------------------

-- 6. 행 변수
-- => 행(ROW) 전체를 저장할 수 있는 타입
-- => 선언방법 : 테이블%ROWTYPE

DECLARE
    V_ROW EMPLOYEES%ROWTYPE;    -- 행 변수정의
BEGIN
    SELECT
        *           -- 행 변수선언
      INTO V_ROW
      FROM EMPLOYEES
     WHERE EMPLOYEE_ID = 100;
DBMS_OUTPUT.PUT_LINE(V_ROW.FIRST_NAME || V_ROW.LAST_NAME || V_ROW.SALARY);
END;

-- 7. IF
/**
    IF 조건식 THEN
        실행문
    ELSIF 조건식 THEN
        실행문
    ELSE
        실행문
    END IF;    

*/

-- 1) 성인/ 미성년자
DECLARE
    AGE NUMBER(3);
    RESULT VARCHAR2(20 BYTE);                                               --    * RESULT도 정의해줘야한다
BEGIN
    AGE := 45;
    IF AGE >= 20 THEN
        RESULT := '성인';
    ELSE
        RESULT := '미성년자';
    END IF;    
    DBMS_OUTPUT.PUT_LINE(AGE || '살은' || RESULT || '이다');
END;    

-- 2) 학점(A,B,C,D,F)
DECLARE
    SCORE NUMBER(3);
    RESULT VARCHAR2(20 BYTE);
BEGIN
    SCORE := 50;
    IF SCORE >= 90 THEN
        RESULT := 'A';
    ELSIF SCORE >= 80 THEN
        RESULT := 'B';
    ELSIF SCORE >= 70 THEN
        RESULT := 'C';
    ELSIF SCORE >= 60 THEN
        RESULT := 'D';
    ELSE    
        RESULT := 'F';
    END IF;
    DBMS_OUTPUT.PUT_LINE(SCORE || '점은' || RESULT || '등급이다');
END;    


-- 3) EMPLOYEE_ID가 150인 사원의 연봉을 참조하여
-- 15000이상이면 '고연봉', 10000 이상이면 '중연봉', 나머지는 '저연봉'
DECLARE
    SAL EMPLOYEES.SALARY%TYPE;
    RES VARCHAR2(20 BYTE);
BEGIN
     SELECT SALARY
     INTO SAL
     FROM EMPLOYEES
    WHERE EMPLOYEE_ID = 150;
    IF SAL >= 15000 THEN
        RES := '고연봉';
    ELSIF SAL >= 10000 THEN
        RES := '중연봉';
    ELSE
        RES := '저연봉'; 
    END IF;  
     DBMS_OUTPUT.PUT_LINE(SAL || '는' || RES || '입니다');
END;     




DECLARE 
    F_NAME EMPLOYEES.FIRST_NAME%TYPE;
    L_NAME EMPLOYEES.LAST_NAME%TYPE;
    V_SALARY EMPLOYEES.SALARY%TYPE;





    


