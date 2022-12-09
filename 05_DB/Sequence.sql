CREATE TABLE ACADEMY_A (
    STUDENT_NO NUMBER PRIMARY KEY,
    STUDENT_NAME VARCHAR2(20) NOT NULL
);

-- CREATE SEQUENCE 시퀀스이름 INCREMENT BY 값1 START WITH 값2 MINVALUE 값3 MAXVALUE 값4 (OPTION);
-- 시퀀스. 컬럼에서 일정 값으로 자동으로 증가하는 값을 편하게 설정하기 위해서 생성하는 하나의... 기능?
-- 옵션은 영어 의미 그대로이고. 기본형태는 증가이지만 음수를 주면 감소도 가능.
-- NOCYCLE / CYCLE 시퀀스 값이 최댓값에 도달했을 경우의 옵션. 반복설정을 주면 1부터 다시 시작하고 안주면...?
-- NOCACHE / CACHE 캐시를 사용하여 미리 시퀀스값을 할당할지의 여부. 설정할경우 속도가 빠르다.
-- NOORDER / ORDER 시퀀스 요청이 들어온 순서대로 값을 생성해서 순서를 보장하지만 시스템 부하가 있음.

-- 1부터 100까지, 1씩 증가하고 반복없음, 캐쉬없음, 순서 없는 시퀀스.
CREATE SEQUENCE UPCOUNT INCREMENT BY 1 START WITH 1 MINVALUE 1 MAXVALUE 100 NOCYCLE NOCACHE NOORDER;

-- 아무런 속성을 주지 않아도 생성은 가능하다. 상세화면을 보면 기본설정은 1부터 시작, 1씩 증가, 쵀대 28자리의 9천자...까지...?
-- 반복, 순서 설정은 NO, 캐쉬는 기본크기 20으로 설정되어 있음.
-- 다른 속성들 생략 가능하고 그럴경우 설정하지 않은 속성은 전부 기본값으로 들어가네.
CREATE SEQUENCE UPCOUNT1;
CREATE SEQUENCE UPCOUNT2 START WITH 10;
CREATE SEQUENCE UPCOUNT3 MAXVALUE 200;

-- 일단 기능같은 느낌이고 테이블은 아니니까 이렇게 하면 아무것도 못함.
SELECT UPCOUNT FROM DUAL;
SELECT * FROM UPCOUNT;

-- 시퀀스를 시작하려면 일단 시퀀스이름.NEXTVAL 을 한번 실행해줘야 시작을 하는듯.
-- .NEXTVAL 다음값을 생성, .CURRVAL 현재 지정되어 있는 값.
-- 주의할점은 한번 .NEXTVAL 로 생성된 시퀀스 값을 다시 되돌릴수는 없다는것.
SELECT UPCOUNT.NEXTVAL FROM DUAL;
SELECT UPCOUNT.CURRVAL FROM DUAL;

-- 설정이 1씩 증가이기 때문에 실행할때마다 다음 숫자가 나옴.
SELECT UPCOUNT.NEXTVAL FROM DUAL;

-- 시퀀스는 테이블처럼 ALTER 문으로 설정을 변경해줄 수 있다.
ALTER SEQUENCE UPCOUNT INCREMENT BY 10;
ALTER SEQUENCE UPCOUNT CYCLE ORDER;
-- 캐쉬크기는 해당 사이클의 최댓값보다 클 수 없다. 아마 몇개까지를 먼저 생성할거냐 설정하는거 같은데
ALTER SEQUENCE UPCOUNT CACHE 5;
SELECT UPCOUNT.NEXTVAL FROM DUAL;

-- 이렇게 생성한 시퀀스로 테이블에 일정 간격으로 연속된 값을 넣을때 간편하게 넣을 수 있다.
-- 사원번호나... 숫자로 지정한 PK 값이나...
-- 숫자를 아스키코드로 설정해서 TO_CHAR() 함수로 문자로 바꾸는것도 가능할듯????
INSERT INTO ACADEMY_A VALUES (UPCOUNT.NEXTVAL, 'K');
INSERT INTO ACADEMY_A VALUES (UPCOUNT.NEXTVAL, 'K');
INSERT INTO ACADEMY_A VALUES (UPCOUNT.NEXTVAL, 'K');
INSERT INTO ACADEMY_A VALUES (UPCOUNT.NEXTVAL, 'K');

DROP SEQUENCE UPCOUNT;
DROP SEQUENCE UPCOUNT1;
DROP SEQUENCE UPCOUNT2;
DROP SEQUENCE UPCOUNT3;

