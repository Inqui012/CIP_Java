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

-- ��������. �ϳ��� ������(SELECT) �ȿ� �ٸ� ������ �� �ִ� ����. JOIN �� ��ü�� �� �ִ�.
-- ���� ��ġ�� ���� �θ��� ��Ī�� �ٸ���.

-- ��Į�� �������� = SELECT ������ �ٸ� SELECT ������ ���� �ҷ��´�. 
-- ������ �Ǵ� SELECT���� �ҷ����� �÷��� ���������� �����ϴ� ���̱� ������ ��ȯ�ϴ� ���� �ݵ�� �ϳ����߸� ��.
SELECT ACADEMY_A.STUDENT_NO, (SELECT STUDENT_NAME FROM ACADEMY_B WHERE ACADEMY_A.STUDENT_NO = ACADEMY_B.STUDENT_NO) FROM ACADEMY_A;

-- �ζ��� �� = FROM ������ �ٸ� SELECT ���� ����Ѵ�. ���̺� ��� �ҷ����� ������ �ϳ��� �÷� �̻��� �ҷ��� �� ����.
-- FROM �ȿ��� �ζ��κ�� ���ο� ���̺��� �������� �����̱� ������ ��Ī�� ���ؼ� ����ؾ� ����� ����� �� �ִ�.
SELECT ACADEMY_A.STUDENT_NO, B.STUDENT_NAME FROM ACADEMY_A, (SELECT STUDENT_NO, STUDENT_NAME FROM ACADEMY_B) B WHERE ACADEMY_A.STUDENT_NO = B.STUDENT_NO;

-- ��ø �������� = WHERE, HAVING ������ ���������� ����Ұ��. �� ���� �ٽ� ����/ �񿬰� ���� ������.
-- �̰� ���������� ���������� ����������, ������������ �Ǵ��ϴµ�.
-- �񿬰�. ����ϴ� ���������� ������ ������ �Ǵ� �����ʹ� ���� ����� ����. �����ϴ� ���̺��� �ٸ����.
SELECT * FROM ACADEMY_A WHERE STUDENT_NAME = (SELECT STUDENT_NAME FROM ACADEMY_B WHERE STUDENT_NO = 1003);
-- ����. ������������ ����ϴ� ���̺��� ������������, ������������ ����ϴ� ���̺��� ������������ ����ϴ� ���?
SELECT * FROM ACADEMY_A A WHERE STUDENT_NAME = (SELECT ACADEMY_B.STUDENT_NAME FROM ACADEMY_B WHERE ACADEMY_B.STUDENT_NO = A.STUDENT_NO);

-- ��ø ���������� ��� ��ȯ�ϴ� ���� ���¿� ���� �ٽ� �������� ����. ������ / ������ / �����÷�
-- ������ �������� = �޾ƿ��� �����Ͱ� �ϳ� �����ϰ��. 
-- ���������� �������� ������� �ϳ��̰ų� NULL �̰� �̰� WHERE ������ ���ϰ� �Ǵ� ������ �� ������ (=, <, >, <=, >=, !=) ��� ���� ���.
SELECT * FROM ACADEMY_A WHERE STUDENT_NAME = (SELECT STUDENT_NAME FROM ACADEMY_B WHERE STUDENT_NO = 1003);

-- ������ �������� = �������� �����͸� ��ȯ�Ұ��.
-- ��ø ���������� WHERE ������ ����ϱ� ������ ������ ���������� ��� ���ϴ� ������ �������� ���̺��� �ǹ��Ѵ�.
-- �������� �����Ϳ� �񱳸� �ϱ� ���ؼ��� �ܼ� JOIN �� = �� ����� �� ������ �������� ���ϴ� IN �� ����ؾ� ��.
SELECT * FROM ACADEMY_A WHERE STUDENT_NAME IN (SELECT STUDENT_NAME FROM ACADEMY_B WHERE STUDENT_NO = 1003 OR STUDENT_NO = 1004);

-- �����÷� �������� = ���������� ��ȯ �������� �÷��� ������ = ���̺� �������� ��ȯ.
-- ���ϴ� ���� �ΰ� �̻��ϰ� ������. �� ����� �ϳ���� �޾ƿ��� ����������... �ƴϱ���.
-- �޾ƿ��� ���������� ���� ������ ������ �Ŵ�, ���̺� ���·� �޾ƿ� ���������� ������� WHERE ������ ���ϱ� ������ ���⼭�� �񱳿��� IN �� �����.
SELECT * FROM ACADEMY_A WHERE (STUDENT_NAME, STUDENT_NO) IN (SELECT STUDENT_NAME, STUDENT_NO FROM ACADEMY_B WHERE STUDENT_NO = 1003 OR STUDENT_NO = 1004);