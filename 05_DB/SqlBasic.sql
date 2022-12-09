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
ALTER TABLE CUSTOMER MODIFY ADRESS DEFAULT 'NONE';
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

INSERT INTO ORDERS VALUES(1006, 1002, TO_DATE('2022-12-24 12:10:45', 'YYYY-MM-DD HH:MI:SS'), 'SIN');
SELECT * FROM ORDERS;

-- ���� ��ġ�� ����ŬDB�� ĳ���ͼ��� Ȯ���ϴ� ��ɾ�. �⺻ AL32UTF8�ΰ�?
select * from nls_database_parameters where parameter = 'NLS_CHARACTERSET';

-- ������ ũ�� �̻��� ���ڸ� �������� �� ��� ������ ���鼭 ��BYTE �������� �˷��ֳ�.
-- AL������ ���� �ѱ��� 3BYTE ����̴� ������ 20�̸� �ִ� 6����. �� �� ���� ����.
INSERT INTO CUSTOMER(ID, NAME) VALUES(005, '�����ٶ󸶹ٻ�');
INSERT INTO CUSTOMER(ID, NAME) VALUES(005, '�����ٶ󸶹�');

-- DELETE FROM ���̺��̸� WHRER ���ǽ�; = ������ ���̺��� �����͸� �����ϴ� ��ɹ�.
-- WHERE ���ĸ� �ۼ����� ������� �ش� ���̺��� ������ ��� �����͸� �����Ѵ�.
-- ���ǽĿ� ��ġ�ϴ� �����Ͱ� ��� ������ �ȳ��� �׳� 0�� ������ �����.
-- �����Ұ�� ��Ȯ�� ���� �ٷ� ����Ǵϱ� �Ǽ��ϸ� ū�ϳ�?
DELETE FROM CUSTOMER WHERE ID=5;

-- SELECT ���̸� FROM ���̺��̸�; = ������ ���̺��� ������ ���� �����͸� ��� �������µ�?
-- ���̸��� * �� ������ ���̺� �ִ� ��� ���� ������ �ִ� ��� �����͸� ������.
-- �ڿ� WHERE ������ ���ǽ��� �ٿ����� �� ����. �ٿ��ִ´ٸ� ���ǿ� �´� �����͸��� ǥ��.
-- ������, ����, ����, NULLüũ ���� ��� ����.
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
ALTER TABLE NUMBERTEST ADD NUM05 NUMBER(10, -9);
INSERT INTO NUMBERTEST (NUM05) VALUES (12345678901234567890.9876543219);
INSERT INTO NUMBERTEST (NUM04) VALUES (0.9876543219);
-- order by asc/desc �� ��������, ������������ ���İ���.
SELECT * FROM NUMBERTEST order by num05 desc;
SELECT FLOOR(NUM04) FROM NUMBERTEST; 

-- UPDATE ���̺��̸� SET �����ҵ������� ���̸� = '�����Ұ�' WHERE ���ǹ�;
-- ���̺� �̹� �����Ǿ� �ִ� �����͸� �����ϴ� ���. ���ǹ��� ������� ������ ���� ��� �����͸� �ϰ������Ѵ�.
UPDATE CUSTOMER SET NAME = 'HO' WHERE ID = 2;
UPDATE CUSTOMER SET NAME = 'JUNG';

-- �Ʒ��� DUAL �̶�� ����Ŭ�� �⺻ ���̺��� TO_CHAR ��� �Լ��� �ҷ����� ����.
-- TO_CHAR(��, 'ǥ��������') ���� �Էµ� ���� ���Ŀ� ���缭 ������ش�.
-- AS �� ǥ���ϴ� �������� ���̸��� ���Ƿ� ������ �� ����. FROM ���� �տ� �Է��Ұ�.
-- SYSDATE �� �ý��������� �ð��� �ҷ����� ����ε�????
SELECT TO_CHAR(SYSDATE, 'YY-MM-DD HH24 : MI : SS DY') AS ���� FROM DUAL;
-- ������ ǥ������. �����ϰ�� ���� ���̺��� ������ ���� ���� ����� ����Ѵ�. �������� ### �� ǥ��.
-- �Ҽ��� ���̸� �����Ұ�� ���Ŀ� �µ��� �ݿø��ؼ� ���� ǥ���Ѵ�.
-- FM �� ���ڿ��� ������ �����϶�� ��� 
-- 9�� �ش� �ڸ��� ���� ������� ǥ�ø� ����, 0�� ���� ������� 0���� ǥ����.
SELECT TO_CHAR(123456789, 'FM9999,9,99,999') AS ���� FROM DUAL;
SELECT TO_CHAR(1.23456789, 'FM990.99999') AS ���� FROM DUAL;

create table grouping (
    type varchar2(20),
    name varchar2(50),
    price NUMBER
);
insert into grouping (DATETEST) VALUES (SYSDATE + 5);
-- SUM(���̸�) �� ����Ŭ �⺻ �Լ��ε�. ������ ���̸��� �������ִ� �����͸� �ջ���.
-- COUNT(���̸�) �� ������ ���̸��� �����Ͱ� � �ִ����� ����. NULL ���� ����.
-- SELECT ���̸� GROUP BY ���̸�1; = ���̸��� �������� �׷�ȭ�� ����� ������. �� ���̸��� �����ؾ���.
-- GROUP BY ���̸� HAVING ����; ���� �׷�ȭ�� �� �� ������ ������ �� �ִ�. ���� ��� �׷�ȭ�� ���̸����� Ư�� ���� ���� Ÿ�Ը��� ����ʹٰų� �� ���.
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

-- ������ ���� �������߿��� ���� ó������ NULL �� �ƴѰ��� ��ȯ.
SELECT COALESCE(NUM01, NUM02, NUM03, NUM04, NUM05) FROM NUMBERTEST;