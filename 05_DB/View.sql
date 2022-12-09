CREATE TABLE ACADEMY_A (
    STUDENT_NO NUMBER PRIMARY KEY,
    STUDENT_NAME VARCHAR2(20) NOT NULL
);
INSERT INTO ACADEMY_A VALUES (1001, '����ȭ');
INSERT INTO ACADEMY_A VALUES (1002, '����');
INSERT INTO ACADEMY_A VALUES (1003, '���');
INSERT INTO ACADEMY_A VALUES (1004, '�迬��');

CREATE TABLE ACADEMY_B (
    STUDENT_NO NUMBER PRIMARY KEY,
    STUDENT_NAME VARCHAR2(20) NOT NULL
);
INSERT INTO ACADEMY_B VALUES (1003, '���');
INSERT INTO ACADEMY_B VALUES (1004, '�迬��');
INSERT INTO ACADEMY_B VALUES (1005, '����ȯ');
INSERT INTO ACADEMY_B VALUES (1006, '������');

-- VIEW.
-- CREATE OR REPLACE VIEW ���̸� AS (SELECT ���̺�����);
-- ���� �״��, �̸����� ������ �䰡 ������ ���� �����, ������ �����µ�.
-- �Ϲ� ���������� �����Ǵ� �ӽ� ���̺��� �̸��� �����ؼ� ������ �� �ִ�. ������ ���̺�� ����Ǵ°� �ƴϰ� �������̺���.
-- �ٵ� �����ͺ��̽��� ��� ������ �Ǵϱ�... ����?
CREATE VIEW COMMON AS SELECT academy_a.student_name FROM academy_a, academy_b WHERE academy_a.student_no = academy_b.student_no;

-- �翬������ REPLACE �Ⱦ��� ���� �̸��� ��� ������ �� ����.
CREATE VIEW COMMON AS SELECT * FROM ACADEMY_A;

-- �̹� ������ COMMON �並 ������ ���ο� ���̺�� �����. ������ ������ ���� �ٲ�.
CREATE OR REPLACE VIEW COMMON AS SELECT * FROM ACADEMY_A;
CREATE OR REPLACE VIEW COMMON AS SELECT * FROM ACADEMY_B;


-- ����1. ���� ������ = �����ϴ� ���̺��� ������ ����Ǵ��� �並 ������ �ʿ䰡 ����.
-- �信�� �����ϰ� �ִ� �� ���̺��� ���� �Ӽ��� �����ߴ��� �信���� �ڵ����� ������ �ǳ�.
ALTER TABLE ACADEMY_A MODIFY STUDENT_NAME VARCHAR2(30);
ALTER TABLE ACADEMY_B MODIFY STUDENT_NAME VARCHAR2(30);

-- ����2. �����Ͱ��� ���� = ���� ���̺� ������ִ� �پ��� �����͸� �����Ҷ� �ξ� �ܼ��� ���������� ó���� �� ����.
-- �並 �ϳ��� ���̺�ó�� ǥ���� �� ����. �̰� �Ǵ°Ÿ� �����̳� ���������� �� �� �� �ִٴ°Ŵϱ�... ������ �����Ͽ� �Ƚᵵ �ǰڴ�.
SELECT * FROM COMMON;

-- ����3. ����. ������ ���ϰ� �������� ���̺��� �ִµ� �� �����͸� �信���� �����ϵ��� �� �� �ִ�.

-- ����1. �̹� ������ �信�� ������ ����, ����, ������ �ȵ�. �ϱ� �����ؿ°Ŵϱ� �ϰ������ ������ �ߴ� ���̺��� �ؾ߰���?
-- ����2. �� ���� ����Ұ�. ���̺�ó�� ������Ÿ���� �ٲٰų� �����͸� �ٲٰų� �ȵ�. ����1�� �����Ǵ°ų�.
-- ���ο� ������ �並 ����� �ʹٸ� �����ϰ� �ٽ� �����ϴ� ����ۿ��� ����.
-- ����3. �ε��� ��� �Ұ�. DB���� �����͸� �����ϱ� ���� �ε�����°� �ִµ� �� �������� �ּҸ� ������ �ִ�.
-- ROWID = ���� �ּ�? �̰� �信���� ����� �� ���ٴµ�.
DROP VIEW COMMON;



