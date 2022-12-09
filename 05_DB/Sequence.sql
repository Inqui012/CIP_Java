CREATE TABLE ACADEMY_A (
    STUDENT_NO NUMBER PRIMARY KEY,
    STUDENT_NAME VARCHAR2(20) NOT NULL
);

-- CREATE SEQUENCE �������̸� INCREMENT BY ��1 START WITH ��2 MINVALUE ��3 MAXVALUE ��4 (OPTION);
-- ������. �÷����� ���� ������ �ڵ����� �����ϴ� ���� ���ϰ� �����ϱ� ���ؼ� �����ϴ� �ϳ���... ���?
-- �ɼ��� ���� �ǹ� �״���̰�. �⺻���´� ���������� ������ �ָ� ���ҵ� ����.
-- NOCYCLE / CYCLE ������ ���� �ִ񰪿� �������� ����� �ɼ�. �ݺ������� �ָ� 1���� �ٽ� �����ϰ� ���ָ�...?
-- NOCACHE / CACHE ĳ�ø� ����Ͽ� �̸� ���������� �Ҵ������� ����. �����Ұ�� �ӵ��� ������.
-- NOORDER / ORDER ������ ��û�� ���� ������� ���� �����ؼ� ������ ���������� �ý��� ���ϰ� ����.

-- 1���� 100����, 1�� �����ϰ� �ݺ�����, ĳ������, ���� ���� ������.
CREATE SEQUENCE UPCOUNT INCREMENT BY 1 START WITH 1 MINVALUE 1 MAXVALUE 100 NOCYCLE NOCACHE NOORDER;

-- �ƹ��� �Ӽ��� ���� �ʾƵ� ������ �����ϴ�. ��ȭ���� ���� �⺻������ 1���� ����, 1�� ����, ���� 28�ڸ��� 9õ��...����...?
-- �ݺ�, ���� ������ NO, ĳ���� �⺻ũ�� 20���� �����Ǿ� ����.
-- �ٸ� �Ӽ��� ���� �����ϰ� �׷���� �������� ���� �Ӽ��� ���� �⺻������ ����.
CREATE SEQUENCE UPCOUNT1;
CREATE SEQUENCE UPCOUNT2 START WITH 10;
CREATE SEQUENCE UPCOUNT3 MAXVALUE 200;

-- �ϴ� ��ɰ��� �����̰� ���̺��� �ƴϴϱ� �̷��� �ϸ� �ƹ��͵� ����.
SELECT UPCOUNT FROM DUAL;
SELECT * FROM UPCOUNT;

-- �������� �����Ϸ��� �ϴ� �������̸�.NEXTVAL �� �ѹ� ��������� ������ �ϴµ�.
-- .NEXTVAL �������� ����, .CURRVAL ���� �����Ǿ� �ִ� ��.
-- ���������� �ѹ� .NEXTVAL �� ������ ������ ���� �ٽ� �ǵ������� ���ٴ°�.
SELECT UPCOUNT.NEXTVAL FROM DUAL;
SELECT UPCOUNT.CURRVAL FROM DUAL;

-- ������ 1�� �����̱� ������ �����Ҷ����� ���� ���ڰ� ����.
SELECT UPCOUNT.NEXTVAL FROM DUAL;

-- �������� ���̺�ó�� ALTER ������ ������ �������� �� �ִ�.
ALTER SEQUENCE UPCOUNT INCREMENT BY 10;
ALTER SEQUENCE UPCOUNT CYCLE ORDER;
-- ĳ��ũ��� �ش� ����Ŭ�� �ִ񰪺��� Ŭ �� ����. �Ƹ� ������� ���� �����Ұų� �����ϴ°� ������
ALTER SEQUENCE UPCOUNT CACHE 5;
SELECT UPCOUNT.NEXTVAL FROM DUAL;

-- �̷��� ������ �������� ���̺� ���� �������� ���ӵ� ���� ������ �����ϰ� ���� �� �ִ�.
-- �����ȣ��... ���ڷ� ������ PK ���̳�...
-- ���ڸ� �ƽ�Ű�ڵ�� �����ؼ� TO_CHAR() �Լ��� ���ڷ� �ٲٴ°͵� �����ҵ�????
INSERT INTO ACADEMY_A VALUES (UPCOUNT.NEXTVAL, 'K');
INSERT INTO ACADEMY_A VALUES (UPCOUNT.NEXTVAL, 'K');
INSERT INTO ACADEMY_A VALUES (UPCOUNT.NEXTVAL, 'K');
INSERT INTO ACADEMY_A VALUES (UPCOUNT.NEXTVAL, 'K');

DROP SEQUENCE UPCOUNT;
DROP SEQUENCE UPCOUNT1;
DROP SEQUENCE UPCOUNT2;
DROP SEQUENCE UPCOUNT3;

