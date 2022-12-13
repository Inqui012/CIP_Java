CREATE TABLE SAMPLE (
    NO   NUMBER PRIMARY KEY,
    NAME VARCHAR2(20),
    AGE  NUMBER
);

INSERT INTO SAMPLE VALUES(1, '������', 10);
INSERT INTO SAMPLE VALUES(2, '�ڿ���', 10);
INSERT INTO SAMPLE VALUES(3, '������', 10);

COMMIT;
INSERT INTO SAMPLE VALUES(4, '������', 10);
ROLLBACK;

-- age �� �� �� �ִ� ���� 10 �� 11�� �����Ѵ�. ���� �Ʒ� 12�� ���� insert �� ������.
ALTER TABLE SAMPLE MODIFY AGE NUMBER CHECK(AGE IN (10, 11));
INSERT INTO SAMPLE VALUES(4, '������', 12);

-- CREATE INDEX �ε����̸� ON ���̺��̸�(���̸�);
-- �ش� �̸����� �ε����� ����. �ϳ� �̻��� ���� �ε����� �����ϴ� �͵� �����ϴ�.
-- ������ �ε����� ���� ������ �Ǿ� �˻��� �� �� �����ϰ� ����� �� �ִ�. �ڵ����� NULL �� �����ϱ� ������ ���ѵ�.
-- �ε����� ������ ���� ROWID �� ������ �־ �̰� ������� ���� ���̺��� �����͸� �����ϴµ�?
-- �ε����� ������ ���� �����͸� ������� �ڵ����� �������� ������ �ǰ�, ���������� ���Ұ�� ���̸� ���� DESC �� �ٿ��ָ� ��.
create index sample_01 on sample(name);
SELECT * FROM SAMPLE;
SELECT * FROM USER_INDEXES;
create index sample_02 on sample(no, name);
-- UNIQUE �� �߰��Ұ�� ������ ���� �ش� ���̺��� �ߺ��� ���� ���̾�� �Ѵ�. UNIQUE, PRIMARY KEY?
-- ���̺��� �����Ͱ� ����� ������ �ߺ��� üũ�ؾ� �ϱ� ������ �Ϲ� �ε������� ������.
create UNIQUE index sample_02 on sample(no, name);

-- �ε����� �����Ҷ��� ���̺���� ������ �ʿ�� ��������.
-- �뷮�� �����Ϳ��� �˻��� �Ҷ��� �������� �ε����� ��������� �����ϰ�,
-- ���̺��� ������ ��쿡 �ε������� üũ�ؾ� �Ǽ� BD ������ ���ϵ� �����ִ�.
-- ������� �ʴ� �ε����� �����ϴ°� ����.
DROP INDEX SAMPLE_01;

-- REBUILD �ϱ�. �ε����� ���� ����Ұ�� Ʈ�������� �ε����� ���ſ����� ������ �߻��Ѵ�.
-- �̷���� ���������� �ε����� �ʱ�ȭ? �ϴ� �۾��� �ִµ�.
ALTER INDEX SAMPLE_02 REBUILD;
