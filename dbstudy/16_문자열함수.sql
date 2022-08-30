-- [문자열 함수]

-- 1. 대소문자 변환
--  1) UPPER(칼럼)    : 칼럼의 데이터를 모두 대문자로 변환
--  2) LOWER(칼럼)    : 칼럼의 데이터를 모두 소문자로 변환
--  3) INITCAP(칼럼)  : INITIAL CAPITAL(첫글자만 대문자, 나머지는 소문자)

--ex)
SELECT 
    EMAIL, LOWER(EMAIL), INITCAP(EMAIL)
   FROM
    EMPLOYEES;

-- FIRST_NAME 칼럼에서 'JAMES' 조회하기
SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME 
    FROM EMPLOYEES
   WHERE FIRST_NAME = INITCAP('JAMES');     -- INITCAP을 통해 해당 데이터의 형식에 맞춰서 출력
   
-- 2. 길이구하기
--  1) LENGTH(칼럼)   : 글자수 반환
--  2) LENGTHB(칼럼)  : 바이트 수 반환
-- * 한글하고 영어는 바이트 수가 다르기 때문에 LENGTHB를 사용하기도 함
SELECT 
    LENGTH('HELLO'), LENGTHB('HELLO'),  -- 5 / 5
    LENGTH('안녕'), LENGTHB('안녕')     -- 2 / 6
    FROM EMPLOYEES;