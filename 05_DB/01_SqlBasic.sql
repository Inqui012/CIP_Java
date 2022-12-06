-- CREATE TABLE ���̺� �̸� (�� ������Ÿ��);
-- ���̺��� �����ϴ� ��ɹ�. �����Ͱ� �ƴ϶� �����͸� ���� Ʋ�� �����ϴ� ������.
-- ���̺� ��ȭ���� MODEL ���� �ش� ���̺��� ���̾�׷� ������ �� �� ����.
CREATE TABLE CUSTOMER (
-- �Ʒ�ó�� �����Ϳ� ���� ������ ���̴°��� ���������̶�� �Ѵ�. ���̺� ��ȭ�鿡�� �������� ������ Ȯ�ΰ���.
-- PRIMARY KEY = �����͸� �����Ҷ� ����Ѵ�. �ߺ��ؼ� ����� �� ���� NULL �� ������� ����.
-- �ش� ������ ������ ������ �ݵ�� �ߺ����� �ʴ� ��, NULL �� �ƴ� ���� ���� �Ѵٴ� ����.
    ID NUMBER PRIMARY KEY,
-- NOT NULL = NULL ���� ������� �ʴ´�. �ߺ��� ����. ���鵵 NULL �� ����Ѵ�.
    NAME VARCHAR2(20) NOT NULL,
    ADRESS VARCHAR2(100)
);

-- PRIMARY KEY �� ������ ID �� �ߺ��� ���� ����� ������ ���鼭 �Է��� �ȵ�.
INSERT INTO CUSTOMER(ID, NAME) VALUES (0001, 'KIM');

-- INSERT INTO ���̺��̸�(���̸�) VALUES(������); 
-- ������ ���̺��� ������ ���� �Է��� �����͸� �����Ѵ�. ���̺��� �Ϻ� ������ �����͸� �Է��ϰ� ���� �� ���.
-- ���̺� ���ǵ� ��� ���� �����͸� ���� ��쿡�� ���� �����ϴ� ��ȣ�� ���� ����.
INSERT INTO CUSTOMER(ID, NAME) VALUES (0001, 'KIM');
INSERT INTO CUSTOMER VALUES (0002, 'PARK', 'HOME');
-- ��� ���� �Է��� �� ��� ���� ������ �Էµ� �������� ������ ���� ������� ������.
INSERT INTO CUSTOMER VALUES (0002, 'PARK');

-- ALTER TABLE ���̺��. ������ ���̺��� �����ϴ� �⺻ ��ɹ�, ���� �߰�/����, �������� ������ ����.
-- ADD ���̸� �� ������Ÿ��; = ������ ���̺� �ش� ������Ÿ���� ������ ���� �߰�.
ALTER TABLE CUSTOMER ADD PHON NUMBER;
-- RENAME COLUMN ���̸� TO ���ο��̸�; = ������ ���� �̸��� ���ο� ������ ����.
ALTER TABLE CUSTOMER RENAME COLUMN PHON TO PNUM;
-- MODIFY ���̸�; = �ش� ���� �Ӽ��� �����Ѵ�. ������Ÿ���� ����/ũ�⸦ �ٲٰų�, ���������� �����ϰų�.
-- ���������� �����Ұ�� �̹� �� �ִ� �����Ͱ� �������ǿ� �������� ������� ����.
ALTER TABLE CUSTOMER MODIFY PNUM VARCHAR2(20);
ALTER TABLE CUSTOMER MODIFY PNUM NOT NULL;
-- DROP COLUMN ���̸�; = ������ ���� ���̺��� �����Ѵ�. ��� ������ ����.
ALTER TABLE CUSTOMER DROP COLUMN PHUM;

-- COMMENT ON COLUMN ���̺��.���̸� IS '����'; = ������ ���̺��� �ش翭�� ���� ������ �߰��Ѵ�.
COMMENT ON COLUMN customer.pnum IS '��ȭ��ȣ';

-- DROP TABLE ���̺��̸�; = �����Ǿ� �ִ� ���̺��� �����ϴ� ��ɾ�.
-- ������ ���̺��� �������� ������ ������.
DROP TABLE TESING;

CREATE TABLE ORDERS (
    ORDER_ID NUMBER PRIMARY KEY,
    SALESMAN_ID NUMBER,
    ORDER_DATE DATE NOT NULL
);

CREATE TABLE CATEGORIES (
    GATEGORY_ID NUMBER PRIMARY KEY,
    CATEGORY_NAME VARCHAR2(100) NOT NULL
);

CREATE TABLE LOCATION (
    LOCATION_ID NUMBER PRIMARY KEY,
    ADRESS      VARCHAR2(255) NOT NULL,
    POSTAL_CODE VARCHAR2(20),
    CITY        VARCHAR2(50)
);

