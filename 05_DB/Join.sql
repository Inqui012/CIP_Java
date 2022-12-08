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

-- JOIN 명령. 두개의 테이블에서 데이터를 조합해서 출력한다. 크게 INNER 와 OUTER JOIN 이 있다.
-- INNER 조인의 경우는 두 테이블에서 공통된 부분만을 출력하고 
-- OUTER 조인은 크게 세가지로 나뉨.
-- OUTER JOIN = 두 테이블이 가지고 있는 모든 데이터를 조합
-- LEFT JOIN = 왼쪽의 테이블만이 가지고 있는 데이터를 조합
-- RIGHT JOIN = 오른쪽의 테이블만이 가지고 있는 데이터를 조합
DROP TABLE ACADEMY_C;
CREATE TABLE ACADEMY_C (
    STUDENT_NO NUMBER PRIMARY KEY,
    STUDENT_NAME VARCHAR2(20) NOT NULL
);
INSERT INTO ACADEMY_C VALUES (1004, '김연아');
INSERT INTO ACADEMY_C VALUES (1006, '이윤아');
INSERT INTO ACADEMY_C VALUES (1001, '정소화');
INSERT INTO ACADEMY_C VALUES (1007, '정소화');

-- FROM 으로 여러개의 테이블을 불러올때, 해당 테이블들의 열갯수가 일치할경우 임의로 별칭을 지정할 수 있다.
-- 아닌데 열 갯수가 다른 C 테이블과도 별칭지정이 되네. 데이터타입이 달라도 되고. 열이름이 달라도 되고, 속성이 달라도 되고.
-- 별칭 짓는건 무조건으로 다 되는거 같은데?

-- 일치하는 값을 찾아내는 INNER JOIN 은 WHERE 문의 조건으로 간단하게 사용할 수 있다.
-- 이때 비교할 두 값의 자료형이 일치해야 함.
-- 일치하는 값만 표시하기 때문에 일치하지 않는 데이터들은 표시하지 않음.
SELECT * FROM ACADEMY_A A, ACADEMY_B B WHERE A.STUDENT_NO = B.STUDENT_NO;

-- 등호(=) 이외의 연산자 (>, <, >=, <=, !=, BETWEEN...)를 사용하는 JOIN 을 NON-EQUI JOIN 이라고도 한다.
-- 이경우에도 기준이 되는 A테이블의 모든 데이터에 조건에 맞는 B의 데이터를 모두 붙인 긴~ 데이터가 나오네?
SELECT * FROM ACADEMY_A A, ACADEMY_B B WHERE A.STUDENT_NO != B.STUDENT_NO;

-- LEFT JOIN. FROM 테이블A LEFT JOIN 테이블B ON 조건; 으로 실행한다.
-- JOIN 문의 오른쪽 왼쪽으로 구분하는것 같네. 왼쪽인 테이블A의 데이터는 전부 표시하고, 이것과 일치하는 테이블B 의 데이터만 표시.
-- B에 A와 일치하는 데이터가 없을경우 NULL 로 표시한다.
-- RIGHT JOIN 은 기준이 되는 테이블이 반대임.
SELECT * FROM ACADEMY_A A LEFT JOIN ACADEMY_C C ON A.STUDENT_NO = C.STUDENT_NO;
SELECT * FROM ACADEMY_A A RIGHT JOIN ACADEMY_C C ON A.STUDENT_NO = C.STUDENT_NO;

-- FULL OUTER JOIN. 기본적인 형태는 다른 JOIN과 동일하나 표시하는 방법이 다름.
-- 일단 양쪽 테이블의 모든 데이터를 표시하고 일치하는 데이터가 있을경우 같은 행으로, 없을경우 NULL 로 표시.
SELECT * FROM ACADEMY_A A FULL OUTER JOIN ACADEMY_C C ON A.STUDENT_NO = C.STUDENT_NO;

-- JOIN 구문 여러개 쓰려면 테이블A JOIN 테이블B ON 조건 JOIN 테이블C ON 조건... 으로 이어짐.
-- 오라클의 경우에는 FROM 테이블A, 테이블B, 테이블C WHERE 조건1 AND 조건2... 로도 사용가능.
-- 이럴경우 기준은...가장 마지막에 있는 테이블의 JOIN 문부터 실행하는건가?
-- 조인 조건이 RIGHT / LEFT / OUTER 다르면 가장 마지막 조인부터, 같을경우 LEFT 면 맨 외쪽, RIGHT면 맨 오른쪽 부터???
-- FULL OUTER JOIN 은 우선순위가 가장 높은가? 으으음......?? 상상이 안되네
SELECT * FROM ACADEMY_A A LEFT JOIN ACADEMY_B B ON A.STUDENT_NO = B.STUDENT_NO RIGHT JOIN ACADEMY_C C ON A.STUDENT_NO = C.STUDENT_NO;
SELECT * FROM ACADEMY_A A LEFT JOIN ACADEMY_B B ON A.STUDENT_NO = B.STUDENT_NO LEFT JOIN ACADEMY_C C ON A.STUDENT_NO = C.STUDENT_NO;
SELECT * FROM ACADEMY_A A LEFT JOIN ACADEMY_B B ON A.STUDENT_NO = B.STUDENT_NO FULL OUTER JOIN ACADEMY_C C ON B.STUDENT_NO = C.STUDENT_NO;

-- 테이블A NATURAL JOIN 테이블B;
-- 두 테이블의 같은 열이름을 가진 데이터를 비교하고, 둘 모두가 같은 값을 가지고 있을 경우에만 출력.
-- '정소화' 는 NO 1001, 1007 의 두개가 있지만 1007의 데이터는 A에 존재하지 않기 때문에 1001 하나만 나옴.
SELECT * FROM ACADEMY_A NATURAL JOIN ACADEMY_C;

DROP TABLE ACADEMY_D;
CREATE TABLE ACADEMY_D (
    STUDENT NUMBER PRIMARY KEY
);
INSERT INTO ACADEMY_D VALUES (1004);
INSERT INTO ACADEMY_D VALUES (1006);
INSERT INTO ACADEMY_D VALUES (1001);
INSERT INTO ACADEMY_D VALUES (1007);

-- 열의 갯수가 달라도 괜찮네. 기준은 FROM 바로 뒤에오는 테이블A 인듯?
-- 만약 비교하는 두 테이블에 일치하는 컬럼(열이름)이 없을경우에는 기준이 되는 테이블A의 하나의 값에 대하여 비교한 테이블B 의 모든 데이터를 붙여오는거 같은데...
SELECT * FROM ACADEMY_A NATURAL JOIN ACADEMY_D;

-- 단순한 INNER JOIN 과 다른점은 INNER JOIN 의 경우 조건만 맞다면 다른 열의 값이 달라도 표시한다는 차이인듯.
-- 표시하고 싶은 컬럼을 지정하고싶다면 테이블명.컬럼명 으로 지정할 수 있네
SELECT A.STUDENT_NO, c.student_name FROM ACADEMY_A A, ACADEMY_C C WHERE a.student_no = c.student_no;