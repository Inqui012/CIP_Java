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

CREATE TABLE ACADEMY_C (
    STUDENT_NO NUMBER PRIMARY KEY,
    STUDENT_NAME VARCHAR2(20) NOT NULL
);
INSERT INTO ACADEMY_C VALUES (1004, '�迬��');
INSERT INTO ACADEMY_C VALUES (1006, '������');
INSERT INTO ACADEMY_C VALUES (1001, '����ȭ');
INSERT INTO ACADEMY_C VALUES (1007, '����ȭ');

CREATE TABLE ACADEMY_D (
    STUDENT_NO NUMBER PRIMARY KEY
);
INSERT INTO ACADEMY_D VALUES (1004);
INSERT INTO ACADEMY_D VALUES (1006);
INSERT INTO ACADEMY_D VALUES (1001);
INSERT INTO ACADEMY_D VALUES (1007);

-- UNION ��. ���̺� ������ ��ġ�Ұ��, �ϳ��� ���̺�� �����ؼ� ����Ѵ�.
-- �� ���̺��� ����(�÷� ����)�� �ٸ���� ����. ������ ���Ƶ� ��ġ�ϴ� ���̸��� ���� ��� ����.
-- ���̺��� ������ FROM���� �����ϴ� ���̺��� ��ü����� �ƴ϶� SELECT �� �ҷ����� ���̺��� ����� ����.
-- �⺻����� �޶� ���� ���̸��� ���� �÷��� ���� �����Ͽ� UNION ���� ����ϸ� ���డ���ϴ�.

-- SELECT * FROM ���̺�A UNION ALL SELECT * FROM ���̺�B;
-- �� ���̺��� �����Ͽ� �ϳ��� ���̺�� ǥ���ϴµ� ���� �ܼ��ϰ� �� ���̺��� ������ �ִ� �����͸� �ϳ��� �����ؼ� ������ ����.
-- SELECT * FROM ���̺�A UNION SELECT * FROM ���̺�B;
-- ���� ������ �� ���̺� ���̿� ��ġ�ϴ� ���� �ִٸ� �̸� �ߺ���Ű�� �ʰ� ���ʸ� ǥ���Ѵ�. �ߺ��� ǥ������ �ʴ� ����Ʈ?
SELECT * FROM ACADEMY_A UNION ALL SELECT * FROM ACADEMY_B;
SELECT STUDENT_NO FROM ACADEMY_A UNION ALL SELECT * FROM ACADEMY_D;
SELECT STUDENT_NO FROM ACADEMY_A UNION SELECT * FROM ACADEMY_D;

-- SELECT * FROM ���̺�A INTERSECT SELECT * FROM ���̺�B;
-- �� ���̺� ���̿� ��ġ�ϴ� �κ��� ���� �� �����ؼ� ǥ���Ѵ�. 
SELECT STUDENT_NO FROM ACADEMY_A INTERSECT SELECT * FROM ACADEMY_D;

-- SELECT * FROM ���̺�A MUNUS SELECT * FROM ���̺�B;
-- ���� �ݴ�. ��ġ�ϴ� ���� ������, A �� B �� ���� ������ �ִ� ������ ���鸸 ǥ���Ѵ�.
SELECT STUDENT_NO FROM ACADEMY_A MINUS SELECT * FROM ACADEMY_D;

-- �̰͵� �������� ����ǳ�. �Ʊ� ���κ��ٴ� �Ѱ� �Ӹ��ӿ��� ����ϱ� ���ѵ�.
SELECT STUDENT_NO FROM ACADEMY_A MINUS SELECT * FROM ACADEMY_D INTERSECT SELECT STUDENT_NO FROM ACADEMY_B;
SELECT STUDENT_NO FROM ACADEMY_A UNION ALL SELECT * FROM ACADEMY_D INTERSECT SELECT STUDENT_NO FROM ACADEMY_B;

