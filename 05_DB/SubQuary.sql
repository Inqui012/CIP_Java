CREATE TABLE ACADEMY_A (
    STUDENT_NO NUMBER PRIMARY KEY,
    STUDENT_NAME VARCHAR2(20) NOT NULL
);
INSERT INTO ACADEMY_A VALUES (1001, '정소화');
INSERT INTO ACADEMY_A VALUES (1002, '김용욱');
INSERT INTO ACADEMY_A VALUES (1003, '고명석');
INSERT INTO ACADEMY_A VALUES (1004, '김연아');

CREATE TABLE ACADEMY_B (
    STUDENT_NO NUMBER PRIMARY KEY,
    STUDENT_NAME VARCHAR2(20) NOT NULL
);
INSERT INTO ACADEMY_B VALUES (1003, '고명석');
INSERT INTO ACADEMY_B VALUES (1004, '김연아');
INSERT INTO ACADEMY_B VALUES (1005, '김태환');
INSERT INTO ACADEMY_B VALUES (1006, '이윤아');

-- 서브쿼리. 하나의 쿼리문(SELECT) 안에 다른 쿼리가 들어가 있는 형태. JOIN 을 대체할 수 있다.
-- 들어가는 위치에 따라 부르는 명칭이 다르다.

-- 스칼라 서브쿼리 = SELECT 절에서 다른 SELECT 문으로 열을 불러온다. 
-- 메인이 되는 SELECT문이 불러오는 컬럼을 서브쿼리로 지정하는 것이기 때문에 반환하는 값은 반드시 하나여야만 함.
SELECT ACADEMY_A.STUDENT_NO, (SELECT STUDENT_NAME FROM ACADEMY_B WHERE ACADEMY_A.STUDENT_NO = ACADEMY_B.STUDENT_NO) FROM ACADEMY_A;

-- 인라인 뷰 = FROM 절에서 다른 SELECT 문을 사용한다. 테이블 대신 불러오기 때문에 하나의 컬럼 이상을 불러올 수 있음.
-- FROM 안에서 인라인뷰로 새로운 테이블을 가져오는 느낌이기 때문에 별칭을 정해서 사용해야 제대로 사용할 수 있다.
SELECT ACADEMY_A.STUDENT_NO, B.STUDENT_NAME FROM ACADEMY_A, (SELECT STUDENT_NO, STUDENT_NAME FROM ACADEMY_B) B WHERE ACADEMY_A.STUDENT_NO = B.STUDENT_NO;

-- 중첩 서브쿼리 = WHERE, HAVING 절에서 서브쿼리를 사용할경우. 이 경우는 다시 연관/ 비연관 으로 나뉜다.
-- 이건 메인쿼리와 서브쿼리가 의존적인지, 독립적인지로 판단하는듯.
-- 비연관. 사용하는 서브쿼리의 내용이 메인이 되는 쿼리와는 전혀 상관이 없다. 참조하는 테이블이 다를경우.
SELECT * FROM ACADEMY_A WHERE STUDENT_NAME = (SELECT STUDENT_NAME FROM ACADEMY_B WHERE STUDENT_NO = 1003);
-- 연관. 메인쿼리에서 사용하는 테이블을 서브쿼리에서, 서브쿼리에서 사용하는 테이블을 메인쿼리에서 사용하는 경우?
SELECT * FROM ACADEMY_A A WHERE STUDENT_NAME = (SELECT ACADEMY_B.STUDENT_NAME FROM ACADEMY_B WHERE ACADEMY_B.STUDENT_NO = A.STUDENT_NO);

-- 중첩 서브쿼리의 경우 반환하는 값의 형태에 따라 다시 세가지로 나눔. 단일행 / 다중행 / 다중컬럼
-- 단일행 서브쿼리 = 받아오는 데이터가 하나 이하일경우. 
-- 서브쿼리로 가져오는 결과값은 하나이거나 NULL 이고 이걸 WHERE 절에서 비교하게 되니 단일행 비교 연산자 (=, <, >, <=, >=, !=) 등과 같이 사용.
SELECT * FROM ACADEMY_A WHERE STUDENT_NAME = (SELECT STUDENT_NAME FROM ACADEMY_B WHERE STUDENT_NO = 1003);

-- 다중행 서브쿼리 = 여러건의 데이터를 반환할경우.
-- 중첩 서브쿼리는 WHERE 적에서 사용하기 때문에 다중행 서브쿼리의 경우 비교하는 값으로 가져오는 테이블을 의미한다.
-- 여러개의 데이터와 비교를 하기 위해서는 단순 JOIN 인 = 은 사용할 수 없으니 다중으로 비교하는 IN 을 사용해야 함.
SELECT * FROM ACADEMY_A WHERE STUDENT_NAME IN (SELECT STUDENT_NAME FROM ACADEMY_B WHERE STUDENT_NO = 1003 OR STUDENT_NO = 1004);

-- 다중컬럼 서브쿼리 = 서브쿼리의 반환 데이터의 컬럼이 여러개 = 테이블 형식으로 반환.
-- 비교하는 값이 두개 이상일것 같은데. 비교 대상이 하나라면 받아오는 서브쿼리가... 아니구나.
-- 받아오는 서브쿼리에 따라서 종류가 나뉘는 거니, 테이블 형태로 받아온 서브쿼리의 결과값을 WHERE 절에서 비교하기 때문에 여기서도 비교에는 IN 을 사용함.
SELECT * FROM ACADEMY_A WHERE (STUDENT_NAME, STUDENT_NO) IN (SELECT STUDENT_NAME, STUDENT_NO FROM ACADEMY_B WHERE STUDENT_NO = 1003 OR STUDENT_NO = 1004);