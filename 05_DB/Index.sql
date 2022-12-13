CREATE TABLE SAMPLE (
    NO   NUMBER PRIMARY KEY,
    NAME VARCHAR2(20),
    AGE  NUMBER
);

INSERT INTO SAMPLE VALUES(1, '양지은', 10);
INSERT INTO SAMPLE VALUES(2, '박우진', 10);
INSERT INTO SAMPLE VALUES(3, '김태은', 10);

COMMIT;
INSERT INTO SAMPLE VALUES(4, '정지우', 10);
ROLLBACK;

-- age 에 들어갈 수 있는 값을 10 과 11로 제한한다. 따라서 아래 12를 넣은 insert 는 오류남.
ALTER TABLE SAMPLE MODIFY AGE NUMBER CHECK(AGE IN (10, 11));
INSERT INTO SAMPLE VALUES(4, '정지우', 12);

-- CREATE INDEX 인덱스이름 ON 테이블이름(열이름);
-- 해당 이름으로 인덱스를 생성. 하나 이상의 열로 인덱스를 생성하는 것도 가능하다.
-- 생성된 인덱스는 따로 저장이 되어 검색을 할 때 유용하게 사용할 수 있다. 자동으로 NULL 을 무시하기 때문에 편한듯.
-- 인덱스는 지정한 열과 ROWID 를 가지고 있어서 이걸 기반으로 원래 테이블에서 데이터를 참조하는듯?
-- 인덱스는 지정한 열의 데이터를 기반으로 자동으로 내림차순 정렬이 되고, 오름차순을 원할경우 열이름 옆에 DESC 를 붙여주면 됨.
create index sample_01 on sample(name);
SELECT * FROM SAMPLE;
SELECT * FROM USER_INDEXES;
create index sample_02 on sample(no, name);
-- UNIQUE 를 추가할경우 지정된 열이 해당 테이블에서 중복이 없는 값이어야 한다. UNIQUE, PRIMARY KEY?
-- 테이블의 데이터가 변경될 때마다 중복을 체크해야 하기 때문에 일반 인덱스보다 느리다.
create UNIQUE index sample_02 on sample(no, name);

-- 인덱스를 삭제할때는 테이블명을 지정할 필요는 없나보네.
-- 대량의 데이터에서 검색을 할때는 편하지만 인덱스가 저장공간도 차지하고,
-- 테이블을 수정할 경우에 인덱스까지 체크해야 되서 BD 성능이 저하될 수도있다.
-- 사용하지 않는 인덱스는 삭제하는게 좋음.
DROP INDEX SAMPLE_01;

-- REBUILD 하기. 인덱스를 오래 사용할경우 트리구조인 인덱스가 무거워지는 현상이 발생한다.
-- 이럴경우 리빌딩으로 인덱스를 초기화? 하는 작업이 있는듯.
ALTER INDEX SAMPLE_02 REBUILD;
