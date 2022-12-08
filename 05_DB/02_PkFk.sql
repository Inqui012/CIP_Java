-- Primary key (PK) 기본키. 테이블에서 각 데이터를 식별하는용도로 쓰는 열에 지정한다.
-- 중복이 불가(unique) 와 not null 조건이 기본적으로 붙는다.
-- 테이블끼리 연결을 설정할 때 자주 사용되는듯.

-- foreigh key (FK) 외래키. 현 테이블이 아니라 다른 테이블의 기본키를 가져와서 사용하는 열에 지정한다.
-- 부모테이블의 PK 설정을 가지고 있는 열이 아니여도 UNIQUE 제약을 지정한 열이라면 참조 가능하다.
-- 연결된 테이블에서 사용하는 키의 의미인가. 클래스의 상속처럼 기본키를 가지고 있는 부모테이블이 생성되어 있어야 생성가능.
-- 테이블을 삭제할경우에는 참조키를 가지고 있는 테이블(자식)을 먼저 삭제하고 마지막에 기본키 테이블(부모)를 삭제해야함. 안하면 에러.
-- 키의 이름은 중복이 불가능하다. FK 끼리의 중복이 안된다는것 같음. FK 와 PK 의 이름이 중복되는건 가능??
-- 테이블에 외래키가 존재할경우 테이블 상세화면의 MODEL 란에서 관계성을 다이어그램으로 편하게 볼 수 있네.

CREATE TABLE DEPT (
    DEPT_NO      NUMBER PRIMARY KEY,
    DEPT_NAME    VARCHAR2(20) NOT NULL,
    DEPT_UNIQUE  VARCHAR2(20) UNIQUE
);

CREATE TABLE EMP (
    EMP_NO      NUMBER PRIMARY KEY,
    EMP_NAME    VARCHAR2(20) NOT NULL,
    DEPT_NO     NUMBER NOT NULL,
    -- CONSTRAINT (제약조건 이름)외래키이름 FOREIGH KEY 표시할 열이름 REFERENCE 참조할테이블이름 (참조할 열이름) 조건
    -- 테이블에 제약조건을 설정한다는 느낌인가. 테이블 상세화면의 제약조건란에 외래키 이름이 나온다.
    -- 실제 테이블 데이터에 값을 참조하는곳의 열이름은 FOREIGN KEY 에서 설정한 열이름임.
    -- 조건은 두 가지가 존재. ON DELETE CASCADE / ON DELETE SET NULL
    -- 둘다 참조하고 있는 부모테이블에서의 DELETE 를 허용하지만 부모테이블에서 DELETE 한 후의 변경점이 다름.
    -- CASCADE 의 경우 삭제된 행의 키를 참조하는 모든 자식테이블의 데이터를 동시에 삭제하고
    -- SET NULL 의 경우 삭제된 행의 키를 참조하는 모든 자식테이블의 데이터를 NULL 로 변경한다.
    -- 테이블 생성시에 외래키를 작성하지 못했을 경우 추후에 ALTER 구문으로도 생성가능.
    -- 한 테이블에 외래키를 여러개 설정가능하려나
    CONSTRAINT FK_DEPT_NO FOREIGN KEY(DEPT_NO) REFERENCES DEPT (DEPT_NO)
);

-- 참조라고 해서 기본키 테이블에서 데이터를 가져오는건줄 알았더니 아니네.
-- 자식테이블의 외래키열에도 직접 데이터를 입력하는데, 대신 기본키 테이블에 이미 존재하는 값이 아니면 입력할 수 없는 제약인듯.
INSERT INTO DEPT VALUES (1, '인사부');
INSERT INTO DEPT VALUES (2, '연구부');
INSERT INTO DEPT VALUES (3, '홍보부');
-- 유니크 제약조건은 중복만 안될뿐이지 NULL 은 허용함. 오라클에서는 중복에서 NULL 을 제외하기 때문에 NULL 중복은 괜찮다는데.
-- 다른 SQL 에서는 NULL 도 중복을 체크해서 하나의 NULL 만 허용하는 경우도 있는듯.
INSERT INTO DEPT VALUES (4, '자재부', NULL);
INSERT INTO DEPT VALUES (5, 'E부', 'TEST');
INSERT INTO DEPT VALUES (6, '자재부', NULL);

INSERT INTO EMP VALUES (1001, '정소화', 3);
INSERT INTO EMP VALUES (1002, '김용욱', 1);
INSERT INTO EMP VALUES (1003, '고명석', 2);
-- DEPT 의 기본키열이 아닌 유니크 열을 참조하는 외래키를 생성
-- 유니크열은 NULL 을 허용하기 때문에 NULL 값도 넣을 수 있다.
INSERT INTO EMP VALUES (1005, '고석', 5, 'FK');
INSERT INTO EMP VALUES (1006, '고석', 4, 'TEST');
INSERT INTO EMP VALUES (1007, '고석', 4, NULL);
-- DEPT 의 NO 열에 999 데이터가 아직 없기 때문에 아래 데이터는 삽입 불가능.
INSERT INTO EMP VALUES (1004, '고명석', 999);


-- 테이블 생성후에 유니크 설정을 가진 열을 추가할 경우.
ALTER TABLE DEPT ADD DEPT_UNIQUE VARCHAR2(20);
ALTER TABLE DEPT ADD CONSTRAINT UNIQ_DEPT_UNIQUE UNIQUE(DEPT_UNIQUE);
ALTER TABLE EMP ADD DEPT_UNIQUE VARCHAR2(20);
ALTER TABLE EMP ADD CONSTRAINT FK_DEPT_UNIQUE FOREIGN KEY (DEPT_UNIQUE) REFERENCES DEPT (DEPT_UNIQUE);