INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '���׸�������ĸ�� 175mg', '�ѱ����ؽ�����', 30, 50, 0);
INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '���׸�������ĸ�� 350mg', '�ѱ����ؽ�����', 30, 50, 0);
INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '���ڼ���ĸ��', '�ѱ����ؽ�����', 30, 50, 0);
INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '��ťƾ��', '�ѱ����ؽ�����', 30, 50, 0);
INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '��Ʈ����', '�ѱ����ؽ�����', 30, 50, 0);
INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '������ 10mg', '�ѹ̾�ǰ', 30, 50, 0);
INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '�������� 10mg', '�ѹ̾�ǰ', 30, 50, 0);
INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '�����ĸ�� 20mg', '�ѹ̾�ǰ', 30, 50, 0);
INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '��Ÿ�����Ⱦ� 2.5ml', '�ѹ̾�ǰ', 30, 50, 0);
INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '������ �ܿ�� 1%', '�ѹ̾�ǰ', 30, 50, 0);

INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '��Ǫ��ĭ ĸ�� 50mg', '�ѱ�ȭ��������', 30, 50, 0);
INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '�˴����ʸ��ڵ��� 25mg', '�ѱ�ȭ��������', 30, 50, 0);
INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, 'Ż����ĸ�� 1mg', '�ѱ�ȭ��������', 30, 50, 0);
INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '�Է���ĸ�� 125mg', '�ѱ�ȭ��������', 30, 50, 0);
INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '�ú����� 50mg', '�ѱ�ȭ��������', 30, 50, 0);
INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, 'Ÿ������', '���Ѿ���', 30, 50, 0);
INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, 'Ʈ���Ÿ��', '���Ѿ���', 30, 50, 0);
INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '�׶���ѿ���ĸ�� 1000iu', '���Ѿ���', 30, 50, 0);
INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '��Ţ�� 2mg', '���Ѿ���', 30, 50, 0);
INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '��Ǫ�÷� 20ml', '���Ѿ���', 30, 50, 0);

INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, 'ī������ 10mg', '���־�ǰ', 30, 50, 0);
INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '�����Ĺ���', '���־�ǰ', 30, 50, 0);
INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '�Ƴ���īĸ�� 75mg', '���־�ǰ', 30, 50, 0);
INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '��Ƹƽ��� 100mg', '���־�ǰ', 30, 50, 0);
INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '�������� 10/40mg', '���־�ǰ', 30, 50, 0);
INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '����Įĸ�� 120mg', '���ٴ�', 30, 50, 0);
INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '�߻级�� 80mg', '���ٴ�', 30, 50, 0);
INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '���̷�ƽ������� 180mg', '���ٴ�', 30, 50, 0);
INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '���̷�ƽ������� 360mg', '���ٴ�', 30, 50, 0);
INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, 'ġ����', '���ٴ�', 30, 50, 0);

commit;
SELECT NAME, OUTPRICE FROM MED_PRODUCT;

INSERT INTO MED_SALE (SALENO, CODE, SALE_QUANTITY, SALE_DATE) VALUES (SALENO_SEQ.NEXTVAL, 3, 20, TO_DATE('20001201', 'YYYYMMDD'));

SELECT CODE FROM MED_PRODUCT WHERE NAME = '�����Ĺ���';
