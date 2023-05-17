-- ユーザ名spring_userで接続後、items_with_categoriesテーブル、categoriesテーブルを作成
する。 
 
CREATE TABLE categories ( 
  id NUMBER(3) PRIMARY KEY, 
  name VARCHAR2(100) 
); 
 
CREATE TABLE items_with_categories ( 
  id NUMBER(3) PRIMARY KEY, 
  name VARCHAR2(100), 
  price NUMBER(5), 
  category_id NUMBER(3) NOT NULL REFERENCES categories(id) 
); 

-- seq_categoriesシーケンス、seq_items_with_categoriesシーケンスを作成する。 
CREATE SEQUENCE seq_categories NOCACHE; 
CREATE SEQUENCE seq_items_with_categories NOCACHE; 
 
-- categoriesテーブルにレコードを追加する。 
INSERT INTO categories VALUES (seq_categories.NEXTVAL, '食料品'); 
INSERT INTO categories VALUES (seq_categories.NEXTVAL, '文房具'); 
INSERT INTO categories VALUES (seq_categories.NEXTVAL, '書籍'); 
 
-- items_with_categoriesテーブルにレコードを追加する。 
INSERT INTO items_with_categories VALUES (seq_items_with_categories.NEXTVAL, 'みかん', 100, 1); 
INSERT INTO items_with_categories VALUES (seq_items_with_categories.NEXTVAL, '鉛筆', 200, 2); 
INSERT INTO items_with_categories VALUES (seq_items_with_categories.NEXTVAL, 'Java参考書', 300, 3); 
 
--コミットする。 
COMMIT; 