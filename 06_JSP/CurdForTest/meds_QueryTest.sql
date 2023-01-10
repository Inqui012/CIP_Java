SELECT NAME, OUTPRICE FROM MED_PRODUCT;
INSERT INTO MED_SALE (SALENO, CODE, SALE_QUANTITY, SALE_DATE) VALUES (SALENO_SEQ.NEXTVAL, 3, 20, TO_DATE('20001201', 'YYYYMMDD'));
SELECT CODE FROM MED_PRODUCT WHERE NAME = '°¡½ºÆÄ¹ÎÁ¤';

select pr.code, pr.stored from med_product pr; 
select pr.code, sum(decode(sa.sale_status, 'R', 0, (sa.sale_quantity * -1))) as sale from med_product pr, med_sale sa where pr.code = sa.code GROUP by pr.code;
select pr.code, sum(decode(st.store_status, 'I', st.store_quantity, (st.store_quantity * -1))) as stock from med_product pr, med_store st where pr.code = st.code GROUP by pr.code;

select pr.code, pr.stored , sum(decode(sa.sale_status, 'R', 0, (sa.sale_quantity * -1))) as sale, sum(decode(st.store_status, 'I', st.store_quantity, (st.store_quantity * -1))) as stock from med_product pr, med_sale sa, med_store st where pr.code = sa.code and pr.code = st.code GROUP by pr.code, pr.stored; 
select pr.code, pr.name, pr.madeby, pr.stored, nvl(sale.sale, 0), nvl(stock.stock, 0), (pr.stored+nvl(sale.sale, 0)+nvl(stock.stock, 0)) as fianl from med_product pr LEFT JOIN (select pr.code, sum(decode(sa.sale_status, 'R', 0, (sa.sale_quantity * -1))) as sale from med_product pr, med_sale sa where pr.code = sa.code GROUP by pr.code) sale on pr.code = sale.code left join (select pr.code, sum(decode(st.store_status, 'I', st.store_quantity, (st.store_quantity * -1))) as stock from med_product pr, med_store st where pr.code = st.code GROUP by pr.code) stock on pr.code = stock.code order by pr.code;

SELECT STORED FROM MED_PRODUCT WHERE CODE = 3;
select sum(decode(sa.sale_status, 'R', 0, (sa.sale_quantity * -1))) as sale from med_sale sa where sa.code = 3;
select NVL(sum(decode(st.store_status, 'I', st.store_quantity, (st.store_quantity * -1))), 0) as stock from med_store st where st.code = 3;


select pr.code, pr.stored, nvl(sale.sale, 0), nvl(stock.stock, 0) from med_product pr LEFT JOIN (select pr.code, sum(decode(sa.sale_status, 'R', 0, (sa.sale_quantity * -1))) as sale from med_product pr, med_sale sa where pr.code = sa.code GROUP by pr.code) sale on pr.code = sale.code left join (select pr.code, sum(decode(st.store_status, 'I', st.store_quantity, (st.store_quantity * -1))) as stock from med_product pr, med_store st where pr.code = st.code GROUP by pr.code) stock on pr.code = stock.code where pr.code = 25;
SELECT PR.CODE, PR.STORED, 
    (SELECT NVL(SUM(DECODE(SA.SALE_STATUS, 'R', 0, (SA.SALE_QUANTITY * -1))), 0) FROM MED_SALE SA WHERE SA.CODE = PR.CODE) SALED,
    (SELECT NVL(SUM(DECODE(ST.STORE_STATUS, 'I', ST.STORE_QUANTITY, (ST.STORE_QUANTITY * -1))), 0) FROM MED_STORE ST WHERE ST.CODE = PR.CODE) ORDERED,
    (PR.STORED + (SELECT NVL(SUM(DECODE(SA.SALE_STATUS, 'R', 0, (SA.SALE_QUANTITY * -1))), 0) FROM MED_SALE SA WHERE SA.CODE = PR.CODE) + (SELECT NVL(SUM(DECODE(ST.STORE_STATUS, 'I', ST.STORE_QUANTITY, (ST.STORE_QUANTITY * -1))), 0) FROM MED_STORE ST WHERE ST.CODE = PR.CODE)) TOTAL
    FROM MED_PRODUCT PR WHERE PR.CODE = 5;
    
SELECT PR.CODE, 
    (PR.STORED + (SELECT NVL(SUM(DECODE(SA.SALE_STATUS, 'R', 0, (SA.SALE_QUANTITY * -1))), 0) FROM MED_SALE SA WHERE SA.CODE = PR.CODE) + (SELECT NVL(SUM(DECODE(ST.STORE_STATUS, 'I', ST.STORE_QUANTITY, (ST.STORE_QUANTITY * -1))), 0) FROM MED_STORE ST WHERE ST.CODE = PR.CODE)) TOTAL
    FROM MED_PRODUCT PR WHERE PR.CODE = 25;