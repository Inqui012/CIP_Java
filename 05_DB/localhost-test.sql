-- CREATE TABLE 테이블 이름 (열);
-- 테이블을 생성하는 명령문. 데이터가 아니라 데이터를 넣을 틀을 생성하는 느낌임.
CREATE TABLE CUSTOMER (
-- 아래처럼 데이터에 여러 설정을 붙이는것을 제약조건이라고 한다. 테이블 상세화면에서 제약조건 탭으로 확인가능.
-- PRIMARY KEY = 데이터를 구분할때 사용한다. 중복해서 사용할 수 없고 NULL 을 허용하지 않음.
-- 해당 설정이 지정된 값에는 반드시 중복되지 않는 값, NULL 이 아닌 값이 들어가야 한다는 설정.
    ID NUMBER PRIMARY KEY,
-- NOT NULL = NULL 값을 허용하지 않는다. 중복은 가능.
    NAME VARCHAR2(20) NOT NULL,
    ADRESS VARCHAR2(100)
);