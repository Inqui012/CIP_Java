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

-- JOIN ���. �ΰ��� ���̺��� �����͸� �����ؼ� ����Ѵ�. ũ�� INNER �� OUTER JOIN �� �ִ�.
-- INNER ������ ���� �� ���̺��� ����� �κи��� ����ϰ� 
-- OUTER ������ ũ�� �������� ����.
-- OUTER JOIN = �� ���̺��� ������ �ִ� ��� �����͸� ����
-- LEFT JOIN = ������ ���̺��� ������ �ִ� �����͸� ����
-- RIGHT JOIN = �������� ���̺��� ������ �ִ� �����͸� ����
DROP TABLE ACADEMY_C;
CREATE TABLE ACADEMY_C (
    STUDENT_NO NUMBER PRIMARY KEY,
    STUDENT_NAME VARCHAR2(20) NOT NULL
);
INSERT INTO ACADEMY_C VALUES (1004, '�迬��');
INSERT INTO ACADEMY_C VALUES (1006, '������');
INSERT INTO ACADEMY_C VALUES (1001, '����ȭ');
INSERT INTO ACADEMY_C VALUES (1007, '����ȭ');

-- FROM ���� �������� ���̺��� �ҷ��ö�, �ش� ���̺���� �������� ��ġ�Ұ�� ���Ƿ� ��Ī�� ������ �� �ִ�.
-- �ƴѵ� �� ������ �ٸ� C ���̺���� ��Ī������ �ǳ�. ������Ÿ���� �޶� �ǰ�. ���̸��� �޶� �ǰ�, �Ӽ��� �޶� �ǰ�.
-- ��Ī ���°� ���������� �� �Ǵ°� ������?

-- ��ġ�ϴ� ���� ã�Ƴ��� INNER JOIN �� WHERE ���� �������� �����ϰ� ����� �� �ִ�.
-- �̶� ���� �� ���� �ڷ����� ��ġ�ؾ� ��.
-- ��ġ�ϴ� ���� ǥ���ϱ� ������ ��ġ���� �ʴ� �����͵��� ǥ������ ����.
SELECT * FROM ACADEMY_A A, ACADEMY_B B WHERE A.STUDENT_NO = B.STUDENT_NO;

-- ��ȣ(=) �̿��� ������ (>, <, >=, <=, !=, BETWEEN...)�� ����ϴ� JOIN �� NON-EQUI JOIN �̶�� �Ѵ�.
-- �̰�쿡�� ������ �Ǵ� A���̺��� ��� �����Ϳ� ���ǿ� �´� B�� �����͸� ��� ���� ��~ �����Ͱ� ������?
SELECT * FROM ACADEMY_A A, ACADEMY_B B WHERE A.STUDENT_NO != B.STUDENT_NO;

-- LEFT JOIN. FROM ���̺�A LEFT JOIN ���̺�B ON ����; ���� �����Ѵ�.
-- JOIN ���� ������ �������� �����ϴ°� ����. ������ ���̺�A�� �����ʹ� ���� ǥ���ϰ�, �̰Ͱ� ��ġ�ϴ� ���̺�B �� �����͸� ǥ��.
-- B�� A�� ��ġ�ϴ� �����Ͱ� ������� NULL �� ǥ���Ѵ�.
-- RIGHT JOIN �� ������ �Ǵ� ���̺��� �ݴ���.
SELECT * FROM ACADEMY_A A LEFT JOIN ACADEMY_C C ON A.STUDENT_NO = C.STUDENT_NO;
SELECT * FROM ACADEMY_A A RIGHT JOIN ACADEMY_C C ON A.STUDENT_NO = C.STUDENT_NO;

-- FULL OUTER JOIN. �⺻���� ���´� �ٸ� JOIN�� �����ϳ� ǥ���ϴ� ����� �ٸ�.
-- �ϴ� ���� ���̺��� ��� �����͸� ǥ���ϰ� ��ġ�ϴ� �����Ͱ� ������� ���� ������, ������� NULL �� ǥ��.
SELECT * FROM ACADEMY_A A FULL OUTER JOIN ACADEMY_C C ON A.STUDENT_NO = C.STUDENT_NO;

-- JOIN ���� ������ ������ ���̺�A JOIN ���̺�B ON ���� JOIN ���̺�C ON ����... ���� �̾���.
-- ����Ŭ�� ��쿡�� FROM ���̺�A, ���̺�B, ���̺�C WHERE ����1 AND ����2... �ε� ��밡��.
-- �̷���� ������...���� �������� �ִ� ���̺��� JOIN ������ �����ϴ°ǰ�?
-- ���� ������ RIGHT / LEFT / OUTER �ٸ��� ���� ������ ���κ���, ������� LEFT �� �� ����, RIGHT�� �� ������ ����???
-- FULL OUTER JOIN �� �켱������ ���� ������? ������......?? ����� �ȵǳ�
SELECT * FROM ACADEMY_A A LEFT JOIN ACADEMY_B B ON A.STUDENT_NO = B.STUDENT_NO RIGHT JOIN ACADEMY_C C ON A.STUDENT_NO = C.STUDENT_NO;
SELECT * FROM ACADEMY_A A LEFT JOIN ACADEMY_B B ON A.STUDENT_NO = B.STUDENT_NO LEFT JOIN ACADEMY_C C ON A.STUDENT_NO = C.STUDENT_NO;
SELECT * FROM ACADEMY_A A LEFT JOIN ACADEMY_B B ON A.STUDENT_NO = B.STUDENT_NO FULL OUTER JOIN ACADEMY_C C ON B.STUDENT_NO = C.STUDENT_NO;

-- ���̺�A NATURAL JOIN ���̺�B;
-- �� ���̺��� ���� ���̸��� ���� �����͸� ���ϰ�, �� ��ΰ� ���� ���� ������ ���� ��쿡�� ���.
-- '����ȭ' �� NO 1001, 1007 �� �ΰ��� ������ 1007�� �����ʹ� A�� �������� �ʱ� ������ 1001 �ϳ��� ����.
SELECT * FROM ACADEMY_A NATURAL JOIN ACADEMY_C;

DROP TABLE ACADEMY_D;
CREATE TABLE ACADEMY_D (
    STUDENT NUMBER PRIMARY KEY
);
INSERT INTO ACADEMY_D VALUES (1004);
INSERT INTO ACADEMY_D VALUES (1006);
INSERT INTO ACADEMY_D VALUES (1001);
INSERT INTO ACADEMY_D VALUES (1007);

-- ���� ������ �޶� ������. ������ FROM �ٷ� �ڿ����� ���̺�A �ε�?
-- ���� ���ϴ� �� ���̺� ��ġ�ϴ� �÷�(���̸�)�� ������쿡�� ������ �Ǵ� ���̺�A�� �ϳ��� ���� ���Ͽ� ���� ���̺�B �� ��� �����͸� �ٿ����°� ������...
SELECT * FROM ACADEMY_A NATURAL JOIN ACADEMY_D;

-- �ܼ��� INNER JOIN �� �ٸ����� INNER JOIN �� ��� ���Ǹ� �´ٸ� �ٸ� ���� ���� �޶� ǥ���Ѵٴ� �����ε�.
-- ǥ���ϰ� ���� �÷��� �����ϰ�ʹٸ� ���̺��.�÷��� ���� ������ �� �ֳ�
SELECT A.STUDENT_NO, c.student_name FROM ACADEMY_A A, ACADEMY_C C WHERE a.student_no = c.student_no;