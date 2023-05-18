-- ���[�U��spring_user�Őڑ���Aitems_with_categories�e�[�u���Acategories�e�[�u�����쐬
����B 
 
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

-- seq_categories�V�[�P���X�Aseq_items_with_categories�V�[�P���X���쐬����B 
CREATE SEQUENCE seq_categories NOCACHE; 
CREATE SEQUENCE seq_items_with_categories NOCACHE; 
 
-- categories�e�[�u���Ƀ��R�[�h��ǉ�����B 
INSERT INTO categories VALUES (seq_categories.NEXTVAL, '�H���i'); 
INSERT INTO categories VALUES (seq_categories.NEXTVAL, '���[��'); 
INSERT INTO categories VALUES (seq_categories.NEXTVAL, '����'); 
 
-- items_with_categories�e�[�u���Ƀ��R�[�h��ǉ�����B 
INSERT INTO items_with_categories VALUES (seq_items_with_categories.NEXTVAL, '�݂���', 100, 1); 
INSERT INTO items_with_categories VALUES (seq_items_with_categories.NEXTVAL, '���M', 200, 2); 
INSERT INTO items_with_categories VALUES (seq_items_with_categories.NEXTVAL, 'Java�Q�l��', 300, 3); 
 
--�R�~�b�g����B 
COMMIT; 