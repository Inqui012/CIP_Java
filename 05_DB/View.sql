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

-- VIEW.
-- CREATE OR REPLACE VIEW 뷰이름 AS (SELECT 테이블쿼리);
-- 영어 그대로, 이름으로 생성한 뷰가 없으면 새로 만들고, 있으면 덮어씌우는듯.
-- 일반 쿼리문으로 생성되는 임시 테이블을 이름을 지정해서 저장할 수 있다. 실제로 테이블로 저장되는건 아니고 가상테이블임.
-- 근데 데이터베이스에 뷰로 저장은 되니까... 흐음?
CREATE VIEW COMMON AS SELECT academy_a.student_name FROM academy_a, academy_b WHERE academy_a.student_no = academy_b.student_no;

-- 당연하지만 REPLACE 안쓰면 같은 이름의 뷰는 생성할 수 없음.
CREATE VIEW COMMON AS SELECT * FROM ACADEMY_A;

-- 이미 생성한 COMMON 뷰를 지정한 새로운 테이블로 덮어씌움. 구조랑 데이터 전부 바뀜.
CREATE OR REPLACE VIEW COMMON AS SELECT * FROM ACADEMY_A;
CREATE OR REPLACE VIEW COMMON AS SELECT * FROM ACADEMY_B;


-- 장점1. 논리적 독립성 = 참조하는 테이블의 구조가 변경되더라도 뷰를 수정할 필요가 없음.
-- 뷰에서 참조하고 있는 두 테이블의 열의 속성을 병경했더니 뷰에서도 자동으로 변경이 되네.
ALTER TABLE ACADEMY_A MODIFY STUDENT_NAME VARCHAR2(30);
ALTER TABLE ACADEMY_B MODIFY STUDENT_NAME VARCHAR2(30);

-- 장점2. 데이터관리 용이 = 여러 테이블에 흩어져있는 다양한 데이터를 참조할때 훨씬 단순한 쿼리문으로 처리할 수 있음.
-- 뷰를 하나의 테이블처럼 표시할 수 있음. 이게 되는거면 조인이나 서브쿼리도 다 쓸 수 있다는거니까... 쿼리문 복잡하에 안써도 되겠다.
SELECT * FROM COMMON;

-- 장점3. 보안. 접근을 못하게 만들어놓는 테이블이 있는데 그 데이터를 뷰에서만 참조하도록 할 수 있대.

-- 단점1. 이미 생성한 뷰에서 데이터 삽입, 변경, 삭제가 안됨. 하긴 참조해온거니까 하고싶으면 참조를 했던 테이블에서 해야겠지?
-- 단짐2. 뷰 구조 변경불가. 테이블처럼 데이터타입을 바꾸거나 데이터를 바꾸거나 안됨. 단점1에 연관되는거네.
-- 새로운 구조로 뷰를 만들고 싶다면 삭제하고 다시 생성하는 방법밖에는 없다.
-- 단점3. 인덱스 사용 불가. DB에는 데이터를 관리하기 위해 인덱스라는게 있는데 각 데이터의 주소를 가지고 있다.
-- ROWID = 행의 주소? 이걸 뷰에서는 사용할 수 없다는듯.
DROP VIEW COMMON;



