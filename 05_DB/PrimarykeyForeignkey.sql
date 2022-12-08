-- Primary key (PK) �⺻Ű. ���̺��� �� �����͸� �ĺ��ϴ¿뵵�� ���� ���� �����Ѵ�.
-- �ߺ��� �Ұ�(unique) �� not null ������ �⺻������ �ٴ´�.
-- ���̺��� ������ ������ �� ���� ���Ǵµ�.

-- foreigh key (FK) �ܷ�Ű. �� ���̺��� �ƴ϶� �ٸ� ���̺��� �⺻Ű�� �����ͼ� ����ϴ� ���� �����Ѵ�.
-- �θ����̺��� PK ������ ������ �ִ� ���� �ƴϿ��� UNIQUE ������ ������ ���̶�� ���� �����ϴ�.
-- ����� ���̺��� ����ϴ� Ű�� �ǹ��ΰ�. Ŭ������ ���ó�� �⺻Ű�� ������ �ִ� �θ����̺��� �����Ǿ� �־�� ��������.
-- ���̺��� �����Ұ�쿡�� ����Ű�� ������ �ִ� ���̺�(�ڽ�)�� ���� �����ϰ� �������� �⺻Ű ���̺�(�θ�)�� �����ؾ���. ���ϸ� ����.
-- Ű�� �̸��� �ߺ��� �Ұ����ϴ�. FK ������ �ߺ��� �ȵȴٴ°� ����. FK �� PK �� �̸��� �ߺ��Ǵ°� ����??
-- ���̺� �ܷ�Ű�� �����Ұ�� ���̺� ��ȭ���� MODEL ������ ���輺�� ���̾�׷����� ���ϰ� �� �� �ֳ�.

CREATE TABLE DEPT (
    DEPT_NO      NUMBER PRIMARY KEY,
    DEPT_NAME    VARCHAR2(20) NOT NULL,
    DEPT_UNIQUE  VARCHAR2(20) UNIQUE
);

CREATE TABLE EMP (
    EMP_NO      NUMBER PRIMARY KEY,
    EMP_NAME    VARCHAR2(20) NOT NULL,
    DEPT_NO     NUMBER NOT NULL,
    -- CONSTRAINT (�������� �̸�)�ܷ�Ű�̸� FOREIGH KEY ǥ���� ���̸� REFERENCE ���������̺��̸� (������ ���̸�) ����
    -- ���̺� ���������� �����Ѵٴ� �����ΰ�. ���̺� ��ȭ���� �������Ƕ��� �ܷ�Ű �̸��� ���´�.
    -- ���� ���̺� �����Ϳ� ���� �����ϴ°��� ���̸��� FOREIGN KEY ���� ������ ���̸���.
    -- ������ �� ������ ����. ON DELETE CASCADE / ON DELETE SET NULL
    -- �Ѵ� �����ϰ� �ִ� �θ����̺����� DELETE �� ��������� �θ����̺��� DELETE �� ���� �������� �ٸ�.
    -- CASCADE �� ��� ������ ���� Ű�� �����ϴ� ��� �ڽ����̺��� �����͸� ���ÿ� �����ϰ�
    -- SET NULL �� ��� ������ ���� Ű�� �����ϴ� ��� �ڽ����̺��� �����͸� NULL �� �����Ѵ�.
    -- ���̺� �����ÿ� �ܷ�Ű�� �ۼ����� ������ ��� ���Ŀ� ALTER �������ε� ��������.
    -- �� ���̺� �ܷ�Ű�� ������ ���������Ϸ���
    CONSTRAINT FK_DEPT_NO FOREIGN KEY(DEPT_NO) REFERENCES DEPT (DEPT_NO)
);

-- ������� �ؼ� �⺻Ű ���̺��� �����͸� �������°��� �˾Ҵ��� �ƴϳ�.
-- �ڽ����̺��� �ܷ�Ű������ ���� �����͸� �Է��ϴµ�, ��� �⺻Ű ���̺� �̹� �����ϴ� ���� �ƴϸ� �Է��� �� ���� �����ε�.
INSERT INTO DEPT VALUES (1, '�λ��');
INSERT INTO DEPT VALUES (2, '������');
INSERT INTO DEPT VALUES (3, 'ȫ����');
-- ����ũ ���������� �ߺ��� �ȵɻ����� NULL �� �����. ����Ŭ������ �ߺ����� NULL �� �����ϱ� ������ NULL �ߺ��� �����ٴµ�.
-- �ٸ� SQL ������ NULL �� �ߺ��� üũ�ؼ� �ϳ��� NULL �� ����ϴ� ��쵵 �ִµ�.
INSERT INTO DEPT VALUES (4, '�����', NULL);
INSERT INTO DEPT VALUES (5, 'E��', 'TEST');
INSERT INTO DEPT VALUES (6, '�����', NULL);

INSERT INTO EMP VALUES (1001, '����ȭ', 3);
INSERT INTO EMP VALUES (1002, '����', 1);
INSERT INTO EMP VALUES (1003, '���', 2);
-- DEPT �� �⺻Ű���� �ƴ� ����ũ ���� �����ϴ� �ܷ�Ű�� ����
-- ����ũ���� NULL �� ����ϱ� ������ NULL ���� ���� �� �ִ�.
INSERT INTO EMP VALUES (1005, '��', 5, 'FK');
INSERT INTO EMP VALUES (1006, '��', 4, 'TEST');
INSERT INTO EMP VALUES (1007, '��', 4, NULL);
-- DEPT �� NO ���� 999 �����Ͱ� ���� ���� ������ �Ʒ� �����ʹ� ���� �Ұ���.
INSERT INTO EMP VALUES (1004, '���', 999);


-- ���̺� �����Ŀ� ����ũ ������ ���� ���� �߰��� ���.
ALTER TABLE DEPT ADD DEPT_UNIQUE VARCHAR2(20);
ALTER TABLE DEPT ADD CONSTRAINT UNIQ_DEPT_UNIQUE UNIQUE(DEPT_UNIQUE);
ALTER TABLE EMP ADD DEPT_UNIQUE VARCHAR2(20);
ALTER TABLE EMP ADD CONSTRAINT FK_DEPT_UNIQUE FOREIGN KEY (DEPT_UNIQUE) REFERENCES DEPT (DEPT_UNIQUE);