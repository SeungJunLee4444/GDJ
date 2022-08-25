/*
1. DML 활용
=> DML은 ROW, 레코드를 관리하는 쿼리문이다
    1) INSERT   : 행 추가
    => INSERT INTO 테이블명(칼럼명) VARLUES(VALUE);
    ex) INSERT INTO NATION(CODE, NAME, NUMBER)
            VALUE(1, 'KOREA', 50);
    
    2) UPDATE   : 행 갱신
    => UPDATE 테이블명 SET CONTENT(칼럼1 = 값1, 칼럼2 = 값2...) WHERE 조건식;    - * WHERE절은 반드시 작성되어야함
    ex) UPTATE NATION SET NUMBER = 40 WHERE CODE = 1;
    (NATION 테이블을 업데이트하라, NUMBER 칼럼의 값을 40으로, 칼럼 CODE가 1인
      * WHERE절을 생략하면 전체를 같은 내용으로 수정하겠다는 뜻?
    
    3) DELETE   : 행 삭제
    => DELETE FROM TABLE WHERE(CONDITION);
      * WHERE절을 생략하면 전체를 지우겠다는 뜻

2. 트렌잭션
=> 여러개의 DML을 여러 작업을 처리할때 하나의 작업 단위로 처리하는 것을 말한다
=> 작업이 시작되면 반드시 종료해야 하는 작업단위다
=> 중간에 멈추면 아무것도 안된채로 되돌아감

* 거래를 예시로 들때, 특정 누군가에게 입금하면 누군가가 입금받을 수 있는 두개의 과정은 뗄수없는 거래의 최소단위인데 이를 트랜젝션

1) 제어명령
  (1) COMMIT : 지금까지 변경한 내용을 영구적으로 저장하고 종료
  (2) ROLBACK : 지금까지 변경한 내용을 취소하고 트랜잭션 종료

* DCL(DATACONTROLLANG) : GRANT, REVOKE

3. DDL과 DML의 차이
1) 대상    : DB OBJECT       /    ROW
            (테이블, 유저..)         
2) 커밋유무 : X              /     O 
3) 
*/





































