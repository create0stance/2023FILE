-- ジャンル情報テーブルへのレコード登録
INSERT INTO genre VALUES(nextval('seq_genre'), '文学');
INSERT INTO genre VALUES(nextval('seq_genre'), '経済');
INSERT INTO genre VALUES(nextval('seq_genre'), '技術');

-- 書籍情報テーブルへのレコード登録
INSERT INTO book VALUES(nextval('seq_book'), 'よくわかる経済', '山田健介', '2010-11-3', 10, 2);
INSERT INTO book VALUES(nextval('seq_book'), '日本文学傑作選', '大原洋子', '1998-03-05',  3, 1);
INSERT INTO book VALUES(nextval('seq_book'), '日本経済史2016', '宮本良太', '2016-07-20', 23, 2);

-- ユーザ情報テーブルへのレコード登録
INSERT INTO book_user VALUES(nextval('seq_book_user'), '鈴木太郎', 1111);
INSERT INTO book_user VALUES(nextval('seq_book_user'), '渡辺花子', 2222);

COMMIT;