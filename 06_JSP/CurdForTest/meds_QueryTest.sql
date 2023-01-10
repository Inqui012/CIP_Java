SELECT NAME, OUTPRICE FROM MED_PRODUCT;
INSERT INTO MED_SALE (SALENO, CODE, SALE_QUANTITY, SALE_DATE) VALUES (SALENO_SEQ.NEXTVAL, 3, 20, TO_DATE('20001201', 'YYYYMMDD'));
SELECT CODE FROM MED_PRODUCT WHERE NAME = '°¡½ºÆÄ¹ÎÁ¤';

select pr.code, pr.stored from med_product pr; 
select pr.code, sum(decode(sa.sale_status, 'R', 0, (sa.sale_quantity * -1))) as sale from med_product pr, med_sale sa where pr.code = sa.code GROUP by pr.code;
select pr.code, sum(decode(st.store_status, 'I', st.store_quantity, (st.store_quantity * -1))) as stock from med_product pr, med_store st where pr.code = st.code GROUP by pr.code;

select pr.code, pr.stored , sum(decode(sa.sale_status, 'R', 0, (sa.sale_quantity * -1))) as sale, sum(decode(st.store_status, 'I', st.store_quantity, (st.store_quantity * -1))) as stock from med_product pr, med_sale sa, med_store st where pr.code = sa.code and pr.code = st.code GROUP by pr.code, pr.stored; 
select pr.code, pr.name, pr.madeby, pr.stored, nvl(sale.sale, 0), nvl(stock.stock, 0), (nvl(sale.sale, 0)+nvl(stock.stock, 0)) as fianl from med_product pr LEFT JOIN (select pr.code, sum(decode(sa.sale_status, 'R', 0, (sa.sale_quantity * -1))) as sale from med_product pr, med_sale sa where pr.code = sa.code GROUP by pr.code) sale on pr.code = sale.code left join (select pr.code, sum(decode(st.store_status, 'I', st.store_quantity, (st.store_quantity * -1))) as stock from med_product pr, med_store st where pr.code = st.code GROUP by pr.code) stock on pr.code = stock.code order by pr.code;

SELECT STORED FROM MED_PRODUCT WHERE CODE = 24;
select NVL(sum(decode(sa.sale_status, 'R', 0, (sa.sale_quantity * -1))), 0) as sale from med_sale sa where sa.code = 24;
select NVL(sum(decode(st.store_status, 'I', st.store_quantity, (st.store_quantity * -1))), 0) as stock from med_store st where st.code = 24;


select pr.code, pr.stored, nvl(sale.sale, 0), nvl(stock.stock, 0) from med_product pr LEFT JOIN (select pr.code, sum(decode(sa.sale_status, 'R', 0, (sa.sale_quantity * -1))) as sale from med_product pr, med_sale sa where pr.code = sa.code GROUP by pr.code) sale on pr.code = sale.code left join (select pr.code, sum(decode(st.store_status, 'I', st.store_quantity, (st.store_quantity * -1))) as stock from med_product pr, med_store st where pr.code = st.code GROUP by pr.code) stock on pr.code = stock.code where pr.code = 25;
SELECT PR.CODE, PR.STORED, 
    (SELECT NVL(SUM(DECODE(SA.SALE_STATUS, 'R', 0, (SA.SALE_QUANTITY * -1))), 0) FROM MED_SALE SA WHERE SA.CODE = PR.CODE) SALED,
    (SELECT NVL(SUM(DECODE(ST.STORE_STATUS, 'I', ST.STORE_QUANTITY, (ST.STORE_QUANTITY * -1))), 0) FROM MED_STORE ST WHERE ST.CODE = PR.CODE) ORDERED
    FROM MED_PRODUCT PR WHERE PR.CODE = 5;
    
(SELECT  
    ((SELECT NVL(SUM(DECODE(SA.SALE_STATUS, 'R', 0, (SA.SALE_QUANTITY * -1))), 0) FROM MED_SALE SA WHERE SA.CODE = PR.CODE) + (SELECT NVL(SUM(DECODE(ST.STORE_STATUS, 'I', ST.STORE_QUANTITY, (ST.STORE_QUANTITY * -1))), 0) FROM MED_STORE ST WHERE ST.CODE = PR.CODE)) TOTAL
    FROM MED_PRODUCT PR);

SELECT  
    NVL(SUM(DECODE(SA.SALE_STATUS, 'R', 0, (SA.SALE_QUANTITY * -1))), 0) + NVL(SUM(DECODE(ST.STORE_STATUS, 'I', ST.STORE_QUANTITY, (ST.STORE_QUANTITY * -1))), 0) TOTAL
    FROM MED_PRODUCT PR, MED_SALE SA, MED_STORE ST;
    
UPDATE MED_PRODUCT SET STORED = 
    (SELECT  
    ((SELECT NVL(SUM(DECODE(SA.SALE_STATUS, 'R', 0, (SA.SALE_QUANTITY * -1))), 0) FROM MED_SALE SA WHERE SA.CODE = PR.CODE) + (SELECT NVL(SUM(DECODE(ST.STORE_STATUS, 'I', ST.STORE_QUANTITY, (ST.STORE_QUANTITY * -1))), 0) FROM MED_STORE ST WHERE ST.CODE = PR.CODE)) TOTAL
    FROM MED_PRODUCT PR);

SELECT PRODUCT_SEQ.CURRVAL FROM DUAL;

UPDATE MED_PRODUCT A SET STORED = 0;
UPDATE MED_PRODUCT A SET STORED = 
    (SELECT  
    ((SELECT NVL(SUM(DECODE(SA.SALE_STATUS, 'R', 0, (SA.SALE_QUANTITY * -1))), 0) FROM MED_SALE SA WHERE SA.CODE = PR.CODE) + (SELECT NVL(SUM(DECODE(ST.STORE_STATUS, 'I', ST.STORE_QUANTITY, (ST.STORE_QUANTITY * -1))), 0) FROM MED_STORE ST WHERE ST.CODE = PR.CODE)) TOTAL
    FROM MED_PRODUCT PR WHERE PR.CODE = 25) WHERE MED_PRODUCT.CODE = 25;

SELECT LAST_NUMBER FROM USER_SEQUENCES WHERE SEQUENCE_NAME='PRODUCT_SEQ';
ALTER SEQUENCE PRODUCT_SEQ INCREMENT BY 1;
ALTER SEQUENCE PRODUCT_SEQ NOCACHE;
SELECT PRODUCT_SEQ.NEXTVAL FROM DUAL;
SELECT PRODUCT_SEQ.CURRVAL FROM DUAL;

SELECT LAST_NUMBER FROM USER_SEQUENCES WHERE SEQUENCE_NAME='SALENO_SEQ';
ALTER SEQUENCE SALENO_SEQ INCREMENT BY 1;
ALTER SEQUENCE SALENO_SEQ NOCACHE;
SELECT SALENO_SEQ.NEXTVAL FROM DUAL;
SELECT SALENO_SEQ.CURRVAL FROM DUAL;

SELECT LAST_NUMBER FROM USER_SEQUENCES WHERE SEQUENCE_NAME='STORE_SEQ';
ALTER SEQUENCE STORE_SEQ INCREMENT BY 1;
ALTER SEQUENCE STORE_SEQ NOCACHE;
SELECT STORE_SEQ.NEXTVAL FROM DUAL;
SELECT STORE_SEQ.CURRVAL FROM DUAL;

commit;