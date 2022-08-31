DROP TABLE EMPLOYEE;
DROP TABLE DEPARTMENT;

-- DEPARTMENT 테이블 생성
CREATE TABLE DEPARTMENT(
    DEPT_NO   NUMBER            NOT NULL,
    DEPT_NAME VARCHAR2(15 BYTE) NOT NULL,
    LOCATION  VARCHAR2(15 BYTE) NOT NULL
);

-- EMPLOYEE 테이블 생성
CREATE TABLE EMPLOYEE(
    EMP_NO    NUMBER            NOT NULL,
    NAME      VARCHAR2(20 BYTE) NOT NULL,
    DEPART    NUMBER            NULL,
    POSITION  VARCHAR2(20 BYTE) NULL,
    GENDER    CHAR(2)           NULL,
    HIRE_DATE DATE              NULL, 
    SALARY    NUMBER            NULL
);

-- 기본키
ALTER TABLE DEPARTMENT 
    ADD CONSTRAINT PK_DEPARTMENT PRIMARY KEY(DEPT_NO);
ALTER TABLE EMPLOYEE 
    ADD CONSTRAINT PK_EMPLOYEE PRIMARY KEY(EMP_NO);

-- 외래키
ALTER TABLE EMPLOYEE 
    ADD CONSTRAINT FK_EMPLOYEE_DEPARTMENT FOREIGN KEY(DEPART) 
        REFERENCES DEPARTMENT(DEPT_NO)
            ON DELETE SET NULL;


-- 부서 테이블에서 사용할 부서_시퀀스
DROP SEQUENCE DEPARTMENT_SEQ;
CREATE SEQUENCE DEPARTMENT_SEQ
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 100
    NOCACHE
    NOCYCLE;

-- 부서 테이블에 행(Row) 삽입
INSERT INTO DEPARTMENT
    (DEPT_NO, DEPT_NAME, LOCATION)
VALUES
    (DEPARTMENT_SEQ.NEXTVAL, '영업부', '대구');
INSERT INTO DEPARTMENT
    (DEPT_NO, DEPT_NAME, LOCATION)
VALUES
    (DEPARTMENT_SEQ.NEXTVAL, '인사부', '서울');
INSERT INTO DEPARTMENT
    (DEPT_NO, DEPT_NAME, LOCATION)
VALUES
    (DEPARTMENT_SEQ.NEXTVAL, '총무부', '대구');
INSERT INTO DEPARTMENT
    (DEPT_NO, DEPT_NAME, LOCATION)
VALUES
    (DEPARTMENT_SEQ.NEXTVAL, '기획부', '서울');

-- 작업의 완료
COMMIT;


-- 사원 테이블에서 사용할 사원_시퀀스
DROP SEQUENCE EMPLOYEE_SEQ;
CREATE SEQUENCE EMPLOYEE_SEQ
    START WITH 1001
    NOCACHE;

-- 사원 테이블에 행(Row) 삽입
INSERT INTO 
    EMPLOYEE
VALUES
    (EMPLOYEE_SEQ.NEXTVAL, '구창민', 1, '과장', 'M', '95/05/01', 5000000);
INSERT INTO
    EMPLOYEE
VALUES
    (EMPLOYEE_SEQ.NEXTVAL, '김민서', 1, '사원', 'F', '17/09/01', 2000000);
INSERT INTO
    EMPLOYEE
VALUES
    (EMPLOYEE_SEQ.NEXTVAL, '이은영', 2, '부장', NULL, '90-09-01', 5500000);
INSERT INTO
    EMPLOYEE
VALUES
    (EMPLOYEE_SEQ.NEXTVAL, '한성일', 2, '과장', 'M', '93-04-01', 5000000);
    
--******************************************************************************
/*

    [20] 서브쿼리
    - 정의        : SELECT 안에 SELECT가 있는것
    - 시행순서    : 서브쿼리가 먼저 실행되고, 이후 메인쿼리가 실행
    - 형태        : 서브쿼리는 메인 쿼리에 괄호()를 이용해서 포함시킴
    - 사용되는 절에 따른 구분
        1) SELECT절  : 스칼라 서브쿼리  결과 : (단일)
        2) FROM절    : 인라인뷰         결과 : (다중)
        3) WHERE절   : 서브쿼리         결과 : (단일, 다중)
    - 서브쿼리 결과에 따른 구분
        1) 단일 행 서브쿼리 
            의미 : 서브쿼리 결과가 하나
            경우 : PK나 UNIQUE 칼럼에 동등비교결과, 함수의 결과      -- 서브쿼리 조건이 PK/UNIQUE가 아니면 다중행 서브쿼리 **
            특징 : 단일행 연산자를 사용(=, !=, >, >=, <, <=) **************
        2) 다중 행 서브쿼리
            서브쿼리 결과가 2개 이상      -- "single-row subquery returns more than one row" 오류 발생시
            FROM절에나 WHERE절에서 사용
            다중행 연산자를 사용(IN, ANY, ALL 등)
      
          
*/      
-- 1. 사원번호가 1001인 사원과 같은 직급(POSITION)을 가진 사원 조회하기
SELECT EMP_NO, NAME, DEPART, GENDER, POSITION, HIRE_DATE, SALARY
  FROM EMPLOYEE
 WHERE POSITION = (SELECT POSITION                      -- * 단일행 서브쿼리는 = 사용
                     FROM EMPLOYEE                      -- * 하위쿼리는 메인쿼리와 동등비교(=) 반드시 POSITION을 반환
                    WHERE EMP_NO = 1001);               -- * EMP_NO는 PK이므로 단일행 서브쿼리(어디쿼리인지 알수있는)
            
            
--2. 급여(SALARY)가 가장 높은 사원 조회하기
SELECT EMP_NO, NAME, DEPART, GENDER, POSITION, HIRE_DATE, SALARY
  FROM EMPLOYEE
 WHERE SALARY = (SELECT MAX(SALARY)
                   FROM EMPLOYEE);      -- 서브쿼리가 함수이므로 단일행 서브쿼리 
                   
                   
-- 3. 부서번호가 1인 부서와 같은 지역에 있는 부서정보를 조회하기
SELECT DEPT_NO, DEPT_NAME, LOCATION
  FROM DEPARTMENT
 WHERE LOCATION IN (SELECT LOCATION
                    FROM DEPARTMENT
                   WHERE DEPT_NO = 1); 


-- 4. 평균급여 이상을 받는 사원 조회하기
SELECT EMP_NO, NAME, DEPART, GENDER, POSITION, HIRE_DATE, SALARY
  FROM EMPLOYEE 
 WHERE SALARY >= (SELECT AVG(SALARY)
                   FROM EMPLOYEE
                  ); 

-- 5. 평균근속기간 이상을 근무한 사원 조회하기
--  1) 일수 계산 : SYSDATE - HIRE_DATE
--  2) 개월 계산 : MONTHS_BETWEEN(SYSDATE, HIRE_DATE) => 개월수가 나올 뿐 둘의 용도와 의미는 같다
SELECT EMP_NO, NAME, DEPART, GENDER, POSITION, HIRE_DATE, SALARY
  FROM EMPLOYEE 
 WHERE MONTHS_BETWEEN(SYSDATE, HIRE_DATE) >= (SELECT AVG(MONTHS_BETWEEN(SYSDATE, HIRE_DATE))
                   FROM EMPLOYEE
                   ); 
                   
            

-- 6. 부서번호가 2인 부서 근무하는 사원들의 직급과 일치하는 직급을 가진 사원 조회하기
SELECT EMP_NO, NAME, DEPART, GENDER, POSITION, HIRE_DATE, SALARY 
  FROM EMPLOYEE
 WHERE POSITION IN (SELECT POSITION 
                     FROM EMPLOYEE
                    WHERE DEPART = 2); -- "single-row subquery returns more than one row"(반환값이 복수, PK값이 아님)
   
    -- * 조건으로 사용할 칼럼이 PK, UNIQUE가 아닐때 : 다중서브쿼리
    -- * 서브쿼리문의 반환값이 2개 이상이므로 단일연산자 = 이 아닌 다중연산자 IN을 사용
    --(다중행서브쿼리의 IN사용)
    -- * 반환되는 행의 개수가 1개면 단일행 서브쿼리, 행의 개수가 2개 이상이면 다중행 서브쿼리
    
-- TIP) 단일행/다중행 상관없이 동등비교는 IN 연산으로 수행가능

--------------------------------------------------------------------------------


-- 7. 부서명이 '영업부'인 부서에 근무하는 사원 조회하기
SELECT EMP_NO, NAME, DEPART, GENDER, POSITION, HIRE_DATE, SALARY 
  FROM EMPLOYEE
 WHERE DEPART IN (SELECT DEPT_NO            -- * 사원 비교니까 직원번호 비교
                 FROM DEPARTMENT
                WHERE DEPT_NAME = '영업부'); -- DEPT_NAME이 PK가 아니기 때문에 (실제 행의 개수가 1개인건 상관없이) 다중행취급

SELECT E.EMP_NO, E.NAME, E.DEPART, E.GENDER, E.POSITION, E.HIRE_DATE, E.SALARY 
  FROM DEPARTMENT D INNER JOIN EMPLOYEE E
    ON D.DEPT_NO = E.DEPART
 WHERE D.DEPT_NAME = '영업부';   


--------------------------------------------------------------------------------


-- 8. 직급이 '과장'인 사원들이 근무하는 부서 조회하기

SELECT DEPT_NO, DEPT_NAME, LOCATION
  FROM DEPARTMENT
 WHERE DEPT_NO IN (SELECT DEPART        -- PK가 들어가야한다 이런거 상관없음!
                     FROM EMPLOYEE   
                    WHERE POSITION = '과장'); 

SELECT DEPT_NO, DEPT_NAME, LOCATION
  FROM DEPARTMENT D INNER JOIN EMPLOYEE E
    ON D.DEPT_NO = E.DEPART
 WHERE POSITION = '과장';
 
--------------------------------------------------------------------------------
 
-- 9. 부서번호가 1인 부서에 근무하는 사원들의 급여보다 더 많은 급여를 받는 사원 조회하기
-- 2000000, 5000000 둘중 하나의 급여보다 많이 받으면 조회하기
SELECT EMP_NO, NAME, DEPART, GENDER, POSITION, HIRE_DATE, SALARY 
  FROM EMPLOYEE
 WHERE SALARY > (SELECT MIN(SALARY)
                    FROM EMPLOYEE
                   WHERE DEPART = 1);
                   -- * WHERE SALARY > ANY(2000000. 5000000)
                   -- SALARY가 200만보다 크거나 500만보다 크면됨(OR개념)


-- 10. 부서번호가 1인 부서에 근무하는 사원들의 급여보다 더 많은 급여를 받는 사원 조회하기
-- (모든급여(2000000, 5000000) 와 비교해서 많이 받으면 조회하기

SELECT EMP_NO, NAME, DEPART, GENDER, POSITION, HIRE_DATE, SALARY 
  FROM EMPLOYEE
 WHERE SALARY > (SELECT MAX(SALARY)
                    FROM EMPLOYEE
                   WHERE DEPART = 1);
                   -- * WHERE SALARY > ALL(2000000. 5000000)
                   -- SALARY가 200만보다 크고 500만보다 크면됨(AND개념)
                   
                   
                   -- * ANY는 OR, ALL은 AND개념
                   -- * ANY, ALL이 잘 안쓰이는 이유(몰라도 무관)
                   -- 1) WHERE SALARY > ANY(2000000. 5000000)           * 2, 5000000 둘중 하나보다 커야함
                   -- =>       SALARY > (SELECT MIN(2000000, 5000000)   = 2000000만 있어도된다
                   -- 2) WHERE SALARY > ALL(2000000. 5000000)           * 2, 5000000 둘다보다 커야함
                   -- =>       SALARY > (SELECT MAX(2000000, 5000000)   = 5000000만 있어도된다    
                   
                   
--------------------------------------------------------------------------------

/*WHERE 절의 서브쿼리*/

-- 1. 전체 사원수의 인원수, 급여합계/평균/최대/최소 조회하기
SELECT
         (SELECT COUNT(*) FROM EMPLOYEE)
       , (SELECT SUM(SALARY) FROM EMPLOYEE)
       , (SELECT AVG(SALARY) FROM EMPLOYEE) 
       , (SELECT MAX(SALARY) FROM EMPLOYEE)
       , (SELECT MIN(SALARY) FROM EMPLOYEE)
   FROM DUAL;                                   -- EMPLOYEE에서 전부 꺼내써서 DUAL   

-- 2. 부서번호가 1인 부서와 같은 지역에서 근무하는 사원 조회하기

SELECT E.EMP_NO, E.NAME, E.DEPART, D.DEPT_NAME
  FROM DEPARTMENT D INNER JOIN EMPLOYEE E
    ON D.DEPT_NO = E.DEPART
 WHERE D.LOCATION = (SELECT LOCATION
                        FROM DEPARTMENT
                       WHERE DEPT_NO = 1); 
                       
-- 스칼라 서브쿼리 접근(조인의 문법과 유사) -----------------------------------------중요X, JOIN으로 해결가능
-- => 스칼라 서브쿼리는 일치하지않는 정보도 NULL로 처리해서 가져옴(OUTER JOIN)
-- => 스칼라 서브쿼리와 동일한 방식의 조인은 '외부조인'임

SELECT 
        E.EMP_NO
       ,E.NAME
       ,E.DEPART
       ,(SELECT D.DEPT_NAME
           FROM DEPARTMENT D
          WHERE D.DEPT_NO = E.DEPART          -- 다른 테이블에서 가져올 것만 별도로 작성
            AND D.DEPT_NO = 1)
  FROM 
        EMPLOYEE E;
        
       
SELECT E.EMP_NO, E.NAME, E.DEPART, D.DEPT_NAME
  FROM DEPARTMENT D RIGHT OUTER JOIN EMPLOYEE E
    ON D.DEPT_NO = E.DEPART
 WHERE D.LOCATION = (SELECT LOCATION
                        FROM DEPARTMENT
                       WHERE DEPT_NO = 1); 
       


----------------------------------------------------------------------------- 
-- * 서브쿼리 종류 정리
--  1) WHERE절(단일, 다중), 2) SELECT절, 3) FROM절(다중)



-- 4. FROM 절의 서브쿼리 : 인라인뷰 (다중)
/*
    * 인라인뷰
    - FROM절에서 사용하는 서브쿼리를 의미
    - 인라인뷰는 주로 테이블 형식
    - 인라인뷰에 별명을 주고 사용함
    - 인라인뷰에서 조회한 컬럼만 메인 쿼리에서 조회할 수 있음 *
    - SELECT문의 실행순서를 바꿀때 사용(인라인뷰를 쓰는 이유)
    (서브쿼리 안에서 ORDER BY를 쓰면 메인 쿼리의 SELECT보다 먼저 쓸 수 있다)
*/
-- 1) 인라인뷰 원리(매우 중요, 목록보기 구현 ************************************************************************)

SELECT A.EMP_NO, A.NAME, A.POSITION     -- * (2) 따라서 메인 쿼리에도 동일한 칼럼 작성
  FROM (SELECT EMP_NO, NAME, POSITION   -- * (1) 인라인 뷰가 조회한 칼럼만 작성가능
          FROM EMPLOYEE
         WHERE DEPART = 1) A;           -- * 인라인 뷰의 별명이 A로 지음
          
























