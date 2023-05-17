-- ユーザ名systemでxepdb1に接続切り替え後、新規にスキーマを作成する。 
ALTER SESSION SET CONTAINER = XEPDB1; 
CREATE USER spring_user IDENTIFIED BY systemsss; 
GRANT ALL PRIVILEGES TO spring_user; 
 
-- 一旦データベースとの接続を切断し、先程作成したユーザ名spring_userで再接続する。 
-- 接続後、itemsテーブルを作成する。 
CREATE TABLE items ( 
  id NUMBER(3) PRIMARY KEY, 
  name VARCHAR2(100), 
  price NUMBER(5) 
); 
 
-- seq_itemsシーケンスを作成する。 
CREATE SEQUENCE seq_items NOCACHE; 
 
-- itemsテーブルにレコードを追加する。 
INSERT INTO items VALUES (seq_items.NEXTVAL,'みかん',100); 
INSERT INTO items VALUES (seq_items.NEXTVAL,'りんご',200); 
INSERT INTO items VALUES (seq_items.NEXTVAL,'バナナ',300); 
 
-- コミットする。 
COMMIT; 