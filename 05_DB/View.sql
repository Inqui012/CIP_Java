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
-- CREATE VIEW ���̸� AS (SELECT ���̺�����);
-- �Ϲ� ���������� �����Ǵ� �ӽ� ���̺��� �̸��� �����ؼ� ������ �� �ִ�. ������ ���̺�� ����Ǵ°� �ƴϰ� �������̺���.
-- 
CREATE VIEW COMMON AS SELECT academy_a.student_name FROM academy_a, academy_b WHERE academy_a.student_no = academy_b.student_no;
