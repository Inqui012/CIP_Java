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
INSERT INTO CUSTOMER(ID, NAME, PNUM) VALUES(4, 'AA', '11223');
-- DROP COLUMN ���̸�; = ������ ���� ���̺��� �����Ѵ�. �ش� ���� ��� ������ ����. �ٸ� ���� ����Ǿ� �ִ� �����ʹ� ����
ALTER TABLE CUSTOMER DROP COLUMN PNUM;

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

-- ���� ��ġ�� ����ŬDB�� ĳ���ͼ��� Ȯ���ϴ� ��ɾ�. �⺻ AL32UTF8�ΰ�?
select * from nls_database_parameters where parameter = 'NLS_CHARACTERSET';

-- ������ ũ�� �̻��� ���ڸ� �������� �� ��� ������ ���鼭 ��BYTE �������� �˷��ֳ�.
-- AL������ ���� �ѱ��� 3BYTE ����̴� ������ 20�̸� �ִ� 6����. �� �� ���� ����.
INSERT INTO CUSTOMER(ID, NAME) VALUES(005, '�����ٶ󸶹ٻ�');
INSERT INTO CUSTOMER(ID, NAME) VALUES(005, '�����ٶ󸶹�');

-- DELETE FROM ���̺��̸� WHRER ���ǽ�; = ������ ���̺��� �����͸� �����ϴ� ��ɹ�.
-- ���ǽĿ� ��ġ�ϴ� �����Ͱ� ��� ������ �ȳ��� �׳� 0�� ������ �����.
-- �����Ұ�� ��Ȯ�� ���� �ٷ� ����Ǵϱ� �Ǽ��ϸ� ū�ϳ�?
DELETE FROM CUSTOMER WHERE ID=5;

-- SELECT ���̸� FROM ���̺��̸�; = ������ ���̺��� ������ ���� �����͸� ��� �������µ�?
-- ���̸��� * �� ������ ���̺� �ִ� ��� ���� ������ �ִ� ��� �����͸� ������.
SELECT * FROM CUSTOMER;
SELECT NAME FROM CUSTOMER;

CREATE TABLE NUMBERTEST (
    NUM01 NUMBER(3),
    NUM02 NUMBER(3, 2),
    NUM03 NUMBER(3, -2)
);

-- �ݿø��� ���� ���ڰ� �ڸ����� ������ �Է� �����ϴ�.
-- �ڸ����� 3���� �����ϰ� 10�� �ڸ����� �ݿø��ε� 15000 �� ���������� �Է��� �ǳ�????
-- �ݿø��ϴ� ��ġ �Ʒ��� ���ڵ��� �ڸ����� �ν����� �ʳ�?
-- �ƴѵ� �ȵ��µ� �ݿø� ���ڸ� ������ �����Ұ�� ��ü ���ڴ� �����Ѽ��� + �ݿø� �����ΰ�
INSERT INTO NUMBERTEST VALUES (123, 1.446, 15008.2);
SELECT * FROM NUMBERTEST;
