-- CREATE TABLE 테이블 이름 (열 데이터타입);
-- 테이블을 생성하는 명령문. 데이터가 아니라 데이터를 넣을 틀을 생성하는 느낌임.
-- 테이블 상세화면의 MODEL 에서 해당 테이블의 다이어그램 형식을 볼 수 있음.
CREATE TABLE CUSTOMER (
-- 아래처럼 데이터에 여러 설정을 붙이는것을 제약조건이라고 한다. 테이블 상세화면에서 제약조건 탭으로 확인가능.
-- PRIMARY KEY = 데이터를 구분할때 사용한다. 중복해서 사용할 수 없고 NULL 을 허용하지 않음.
-- 해당 설정이 지정된 값에는 반드시 중복되지 않는 값, NULL 이 아닌 값이 들어가야 한다는 설정.
    ID NUMBER PRIMARY KEY,
-- NOT NULL = NULL 값을 허용하지 않는다. 중복은 가능. 공백도 NULL 로 취급한다.
    NAME VARCHAR2(20) NOT NULL,
    ADRESS VARCHAR2(100)
);

-- PRIMARY KEY 로 설정한 ID 에 중복된 값이 들어갈경우 오류가 나면서 입력이 안됨.
INSERT INTO CUSTOMER(ID, NAME) VALUES (0001, 'KIM');

-- INSERT INTO 테이블이름(열이름) VALUES(데이터); 
-- 지정한 테이블의 지정한 열에 입력한 데이터를 삽입한다. 테이블의 일부 열에만 데이터를 입력하고 싶을 때 사용.
-- 테이블에 정의된 모든 열에 데이터를 넣을 경우에는 열을 지정하는 괄호는 생략 가능.
INSERT INTO CUSTOMER(ID, NAME) VALUES (0001, 'KIM');
INSERT INTO CUSTOMER VALUES (0002, 'PARK', 'HOME');
-- 모든 열에 입력을 할 경우 열의 갯수와 입력된 데이터의 갯수가 맞지 않을경우 오류남.
INSERT INTO CUSTOMER VALUES (0002, 'PARK');

-- ALTER TABLE 테이블명. 지정한 테이블을 변경하는 기본 명령문, 열의 추가/삭제, 제약조건 변경이 가능.
-- ADD 열이름 열 데이터타입; = 지정한 테이블에 해당 데이터타입을 가지는 열을 추가.
ALTER TABLE CUSTOMER ADD PHON NUMBER;
-- RENAME COLUMN 열이름 TO 새로운이름; = 지정한 열의 이름을 새로운 것으로 변경.
ALTER TABLE CUSTOMER RENAME COLUMN PHON TO PNUM;
-- MODIFY 열이름; = 해당 열의 속성을 변경한다. 데이터타입의 종류/크기를 바꾸거나, 제약조건을 변경하거나.
-- 제약조건을 변경할경우 이미 들어가 있는 데이터가 제약조건에 부합하지 않을경우 오류.
ALTER TABLE CUSTOMER MODIFY PNUM VARCHAR2(20);
ALTER TABLE CUSTOMER MODIFY PNUM NOT NULL;
ALTER TABLE CUSTOMER MODIFY ADRESS DEFAULT 'NONE';
INSERT INTO CUSTOMER(ID, NAME, PNUM) VALUES(4, 'AA', '11223');
-- DROP COLUMN 열이름; = 지정한 열을 테이블에서 삭제한다. 해당 열의 모든 데이터 삭제. 다른 열에 저장되어 있는 데이터는 유지
ALTER TABLE CUSTOMER DROP COLUMN PNUM;

-- COMMENT ON COLUMN 테이블명.열이름 IS '설명'; = 지정한 테이블의 해당열에 대한 설명을 추가한다.
COMMENT ON COLUMN customer.pnum IS '전화번호';

-- DROP TABLE 테이블이름; = 생성되어 있는 테이블을 삭제하는 명령어.
-- 지정한 테이블이 존재하지 않으면 오류남.
DROP TABLE TESING;

CREATE TABLE ORDERS (
    ORDER_ID NUMBER PRIMARY KEY,
    SALESMAN_ID NUMBER,
    ORDER_DATE DATE NOT NULL
);

INSERT INTO ORDERS VALUES(1006, 1002, TO_DATE('2022-12-24 12:10:45', 'YYYY-MM-DD HH:MI:SS'), 'SIN');
SELECT * FROM ORDERS;

-- 현재 설치된 오라클DB의 캐릭터셋을 확인하는 명령어. 기본 AL32UTF8인가?
select * from nls_database_parameters where parameter = 'NLS_CHARACTERSET';

-- 지정된 크기 이상의 글자를 넣으려고 할 경우 오류가 나면서 몇BYTE 오버인지 알려주네.
-- AL상태인 현재 한글은 3BYTE 계산이니 지정된 20이면 최대 6글자. 사 는 들어가지 않음.
INSERT INTO CUSTOMER(ID, NAME) VALUES(005, '가나다라마바사');
INSERT INTO CUSTOMER(ID, NAME) VALUES(005, '가나다라마바');

-- DELETE FROM 테이블이름 WHRER 조건식; = 지정한 테이블에서 데이터를 삭제하는 명령문.
-- WHERE 이후를 작성하지 않을경우 해당 테이블이 가지는 모든 데이터를 삭제한다.
-- 조건식에 일치하는 데이터가 없어도 오류는 안나고 그냥 0개 삭제로 진행됨.
-- 실행할경우 재확인 없이 바로 실행되니까 실수하면 큰일남?
DELETE FROM CUSTOMER WHERE ID=5;

-- SELECT 열이름 FROM 테이블이름; = 지정한 테이블에서 지정한 열의 데이터를 모두 가져오는듯?
-- 열이름에 * 를 넣으면 테이블에 있는 모든 열이 가지고 있는 모든 데이터를 가져옴.
-- 뒤에 WHERE 문으로 조건식을 붙여넣을 수 있음. 붙여넣는다면 조건에 맞는 데이터만을 표시.
-- 연산자, 범위, 패턴, NULL체크 등을 사용 가능.
SELECT * FROM CUSTOMER;
SELECT NAME FROM CUSTOMER;

CREATE TABLE NUMBERTEST (
    NUM01 NUMBER(3),
    NUM02 NUMBER(3, 2),
    NUM03 NUMBER(3, -2)
);

-- 반올림된 후의 숫자가 자릿수에 맞으면 입력 가능하다.
-- 자릿수를 3으로 설정하고 10의 자리에서 반올림인데 15000 이 정상적으로 입력이 되네????
-- 반올림하는 위치 아래의 숫자들은 자릿수로 인식하지 않나?
-- 아닌데 안들어가는데 반올림 숫자를 음수로 지정할경우 전체 숫자는 지정한숫자 + 반올림 숫자인가
INSERT INTO NUMBERTEST VALUES (123, 1.446, 15008.2);
ALTER TABLE NUMBERTEST ADD NUM05 NUMBER(10, -9);
INSERT INTO NUMBERTEST (NUM05) VALUES (12345678901234567890.9876543219);
INSERT INTO NUMBERTEST (NUM04) VALUES (0.9876543219);
-- order by asc/desc 로 내림차순, 오름차순으로 정렬가능.
SELECT * FROM NUMBERTEST order by num05 desc;
SELECT FLOOR(NUM04) FROM NUMBERTEST; 

-- UPDATE 테이블이름 SET 변경할데이터의 열이름 = '변경할값' WHERE 조건문;
-- 테이블에 이미 생성되어 있는 데이터를 변경하는 명령. 조건문이 없을경우 지정한 열의 모든 데이터를 일괄변경한다.
UPDATE CUSTOMER SET NAME = 'HO' WHERE ID = 2;
UPDATE CUSTOMER SET NAME = 'JUNG';

-- 아래는 DUAL 이라는 오라클의 기본 테이블에서 TO_CHAR 라는 함수를 불러오는 구문.
-- TO_CHAR(값, '표시할형식') 으로 입력된 값을 형식에 맞춰서 출력해준다.
-- AS 는 표시하는 데이터의 열이름을 임의로 설정할 수 있음. FROM 보다 앞에 입력할것.
-- SYSDATE 는 시스템의현재 시간을 불러오는 기능인듯????
SELECT TO_CHAR(SYSDATE, 'YY-MM-DD HH24 : MI : SS DY') AS 날자 FROM DUAL;
-- 숫자의 표시형식. 정수일경우 값의 길이보다 형식의 길이 길어야 제대로 출력한다. 오류나면 ### 로 표시.
-- 소수의 길이를 지정할경우 형식에 맞도록 반올림해서 값을 표시한다.
-- FM 은 문자열에 공백을 제거하라는 명령 
-- 9는 해당 자리에 값이 없을경우 표시를 안함, 0은 값이 없을경우 0으로 표시함.
SELECT TO_CHAR(123456789, 'FM9999,9,99,999') AS 숫자 FROM DUAL;
SELECT TO_CHAR(1.23456789, 'FM990.99999') AS 날자 FROM DUAL;

create table grouping (
    type varchar2(20),
    name varchar2(50),
    price NUMBER
);
insert into grouping (DATETEST) VALUES (SYSDATE + 5);
-- SUM(열이름) 은 오라클 기본 함수인듯. 지정한 열이름이 가지고있는 데이터를 합산함.
-- COUNT(열이름) 은 지정한 열이름에 데이터가 몇개 있는지의 갯수. NULL 포함 안함.
-- SELECT 열이름 GROUP BY 열이름1; = 열이름을 기준으로 그룹화한 목록을 보여줌. 두 열이름을 동일해야함.
-- GROUP BY 열이름 HAVING 조건; 으로 그룹화를 할 때 기준을 지정할 수 있다. 예를 들면 그룹화할 열이름에서 특정 값을 가진 타입만을 보고싶다거나 할 경우.
select NAME from grouping GROUP by NAME;
select SUM(DATETEST) from grouping ;
select type,sum(price) as total from grouping GROUP by type;
select type,count(name) as count from grouping GROUP by TYPE;

SELECT LENGTH('') FROM DUAL;
SELECT ROUND(10.487, 2) FROM DUAL;
SELECT TRUNC(10.487, 2) FROM DUAL;
SELECT CEIL(10.0) FROM DUAL;
SELECT FLOOR(10.9) FROM DUAL;
SELECT 10 / 3 FROM DUAL;

-- 지정한 열의 데이터중에서 가장 처음으로 NULL 이 아닌값을 반환.
SELECT COALESCE(NUM01, NUM02, NUM03, NUM04, NUM05) FROM NUMBERTEST;