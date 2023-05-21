-- テーブルとシーケンス削除用
DROP TABLE items CASCADE CONSTRAINTS;
DROP SEQUENCE seq_items ;
DROP TABLE items_with_categories CASCADE CONSTRAINTS;
DROP TABLE categories CASCADE CONSTRAINTS;
DROP SEQUENCE seq_categories;
DROP SEQUENCE seq_items_with_categories;

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

------------------------------------------
-- p232
------------------------------------------
-- ユーザ名spring_userで接続後、items_with_categoriesテーブル、categoriesテーブルを作成する。 



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

------------------------------------------
-- p394
------------------------------------------

INSERT INTO items_with_categories VALUES (seq_items_with_categories.NEXTVAL, 'りんご', 250, 1); 
INSERT INTO items_with_categories VALUES (seq_items_with_categories.NEXTVAL, 'バナナ', 300, 1); 
INSERT INTO items_with_categories VALUES (seq_items_with_categories.NEXTVAL, 'いちご', 450, 1); 
INSERT INTO items_with_categories VALUES (seq_items_with_categories.NEXTVAL, 'ボールペン', 170, 2); 
INSERT INTO items_with_categories VALUES (seq_items_with_categories.NEXTVAL, '消しゴム', 120, 2); 
INSERT INTO items_with_categories VALUES (seq_items_with_categories.NEXTVAL, 'ノート ', 150, 2); 
INSERT INTO items_with_categories VALUES (seq_items_with_categories.NEXTVAL, 'ペンケース', 800, 2); 
INSERT INTO items_with_categories VALUES (seq_items_with_categories.NEXTVAL, '定規', 200, 2); 
INSERT INTO items_with_categories VALUES (seq_items_with_categories.NEXTVAL, 'Javaプログラミング問題集', 2500, 3); 
INSERT INTO items_with_categories VALUES (seq_items_with_categories.NEXTVAL, 'SQL入門', 1500, 3); 
INSERT INTO items_with_categories VALUES (seq_items_with_categories.NEXTVAL, '明解Spring Framework', 3500, 3); 
INSERT INTO items_with_categories VALUES (seq_items_with_categories.NEXTVAL, '長編歴史小説 第1巻', 1000, 3); 
INSERT INTO items_with_categories VALUES (seq_items_with_categories.NEXTVAL, '長編歴史小説 第2巻', 1000, 3); 
INSERT INTO items_with_categories VALUES (seq_items_with_categories.NEXTVAL, '長編歴史小説 第3巻', 1000, 3); 
INSERT INTO items_with_categories VALUES (seq_items_with_categories.NEXTVAL, '長編歴史小説 第4巻', 1000, 3); 
INSERT INTO items_with_categories VALUES (seq_items_with_categories.NEXTVAL, '長編歴史小説 第5巻', 1000, 3); 
INSERT INTO items_with_categories VALUES (seq_items_with_categories.NEXTVAL, '長編歴史小説 第6巻', 1000, 3); 
INSERT INTO items_with_categories VALUES (seq_items_with_categories.NEXTVAL, '長編歴史小説 第7巻', 1000, 3); 
INSERT INTO items_with_categories VALUES (seq_items_with_categories.NEXTVAL, '観光ガイドマップ東京編', 1300, 3); 
INSERT INTO items_with_categories VALUES (seq_items_with_categories.NEXTVAL, '観光ガイドマップ大阪編', 1300, 3); 
INSERT INTO items_with_categories VALUES (seq_items_with_categories.NEXTVAL, '観光ガイドマップ京都編', 1300, 3); 
 
--コミットする。 
COMMIT; 