INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '가네리버연질캡슐 175mg', '한국휴텍스제약', 30, 50, 0);
INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '가네리버연질캡슐 350mg', '한국휴텍스제약', 30, 50, 0);
INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '뮤코세린캡슐', '한국휴텍스제약', 30, 50, 0);
INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '레큐틴정', '한국휴텍스제약', 30, 50, 0);
INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '세트린정', '한국휴텍스제약', 30, 50, 0);
INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '구구정 10mg', '한미약품', 30, 50, 0);
INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '구구츄정 10mg', '한미약품', 30, 50, 0);
INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '라메졸캡슐 20mg', '한미약품', 30, 50, 0);
INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '라타로점안액 2.5ml', '한미약품', 30, 50, 0);
INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '무조날 외용액 1%', '한미약품', 30, 50, 0);

INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '디푸루칸 캡슐 50mg', '한국화이자제약', 30, 50, 0);
INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '알닥톤필름코딩정 25mg', '한국화이자제약', 30, 50, 0);
INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '탈제나캡슐 1mg', '한국화이자제약', 30, 50, 0);
INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '입랜스캡슐 125mg', '한국화이자제약', 30, 50, 0);
INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '시빈코정 50mg', '한국화이자제약', 30, 50, 0);
INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '타나센정', '유한양행', 30, 50, 0);
INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '트루비타정', '유한양행', 30, 50, 0);
INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '그랑페롤연질캡슐 1000iu', '유한양행', 30, 50, 0);
INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '뉴큅정 2mg', '유한양행', 30, 50, 0);
INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '코푸시럽 20ml', '유한양행', 30, 50, 0);

INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '카스몬정 10mg', '아주약품', 30, 50, 0);
INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '가스파민정', '아주약품', 30, 50, 0);
INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '아나리카캡슐 75mg', '아주약품', 30, 50, 0);
INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '비아맥스정 100mg', '아주약품', 30, 50, 0);
INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '세바코정 10/40mg', '아주약품', 30, 50, 0);
INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '제니칼캡슐 120mg', '종근당', 30, 50, 0);
INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '발사벨정 80mg', '종근당', 30, 50, 0);
INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '마이렙틱엔장용정 180mg', '종근당', 30, 50, 0);
INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '마이렙틱엔장용정 360mg', '종근당', 30, 50, 0);
INSERT INTO med_product VALUES (PRODUCT_SEQ.nextval, '치퀵정', '종근당', 30, 50, 0);

commit;
SELECT NAME, OUTPRICE FROM MED_PRODUCT;

INSERT INTO MED_SALE (SALENO, CODE, SALE_QUANTITY, SALE_DATE) VALUES (SALENO_SEQ.NEXTVAL, 3, 20, TO_DATE('20001201', 'YYYYMMDD'));

SELECT CODE FROM MED_PRODUCT WHERE NAME = '가스파민정';
