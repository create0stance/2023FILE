-- �e�[�u���ƃV�[�P���X�폜�p
DROP TABLE items CASCADE CONSTRAINTS;
DROP SEQUENCE seq_items ;
DROP TABLE items_with_categories CASCADE CONSTRAINTS;
DROP TABLE categories CASCADE CONSTRAINTS;
DROP SEQUENCE seq_categories;
DROP SEQUENCE seq_items_with_categories;

-- ��U�f�[�^�x�[�X�Ƃ̐ڑ���ؒf���A����쐬�������[�U��spring_user�ōĐڑ�����B 
-- �ڑ���Aitems�e�[�u�����쐬����B 
CREATE TABLE items ( 
  id NUMBER(3) PRIMARY KEY, 
  name VARCHAR2(100), 
  price NUMBER(5) 
); 
 
-- seq_items�V�[�P���X���쐬����B 
CREATE SEQUENCE seq_items NOCACHE; 
 
-- items�e�[�u���Ƀ��R�[�h��ǉ�����B 
INSERT INTO items VALUES (seq_items.NEXTVAL,'�݂���',100); 
INSERT INTO items VALUES (seq_items.NEXTVAL,'���',200); 
INSERT INTO items VALUES (seq_items.NEXTVAL,'�o�i�i',300); 
 
-- �R�~�b�g����B 
COMMIT;

------------------------------------------
-- p232
------------------------------------------
-- ���[�U��spring_user�Őڑ���Aitems_with_categories�e�[�u���Acategories�e�[�u�����쐬����B 



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

------------------------------------------
-- p394
------------------------------------------

INSERT INTO items_with_categories VALUES (seq_items_with_categories.NEXTVAL, '���', 250, 1); 
INSERT INTO items_with_categories VALUES (seq_items_with_categories.NEXTVAL, '�o�i�i', 300, 1); 
INSERT INTO items_with_categories VALUES (seq_items_with_categories.NEXTVAL, '������', 450, 1); 
INSERT INTO items_with_categories VALUES (seq_items_with_categories.NEXTVAL, '�{�[���y��', 170, 2); 
INSERT INTO items_with_categories VALUES (seq_items_with_categories.NEXTVAL, '�����S��', 120, 2); 
INSERT INTO items_with_categories VALUES (seq_items_with_categories.NEXTVAL, '�m�[�g ', 150, 2); 
INSERT INTO items_with_categories VALUES (seq_items_with_categories.NEXTVAL, '�y���P�[�X', 800, 2); 
INSERT INTO items_with_categories VALUES (seq_items_with_categories.NEXTVAL, '��K', 200, 2); 
INSERT INTO items_with_categories VALUES (seq_items_with_categories.NEXTVAL, 'Java�v���O���~���O���W', 2500, 3); 
INSERT INTO items_with_categories VALUES (seq_items_with_categories.NEXTVAL, 'SQL����', 1500, 3); 
INSERT INTO items_with_categories VALUES (seq_items_with_categories.NEXTVAL, '����Spring Framework', 3500, 3); 
INSERT INTO items_with_categories VALUES (seq_items_with_categories.NEXTVAL, '���җ��j���� ��1��', 1000, 3); 
INSERT INTO items_with_categories VALUES (seq_items_with_categories.NEXTVAL, '���җ��j���� ��2��', 1000, 3); 
INSERT INTO items_with_categories VALUES (seq_items_with_categories.NEXTVAL, '���җ��j���� ��3��', 1000, 3); 
INSERT INTO items_with_categories VALUES (seq_items_with_categories.NEXTVAL, '���җ��j���� ��4��', 1000, 3); 
INSERT INTO items_with_categories VALUES (seq_items_with_categories.NEXTVAL, '���җ��j���� ��5��', 1000, 3); 
INSERT INTO items_with_categories VALUES (seq_items_with_categories.NEXTVAL, '���җ��j���� ��6��', 1000, 3); 
INSERT INTO items_with_categories VALUES (seq_items_with_categories.NEXTVAL, '���җ��j���� ��7��', 1000, 3); 
INSERT INTO items_with_categories VALUES (seq_items_with_categories.NEXTVAL, '�ό��K�C�h�}�b�v������', 1300, 3); 
INSERT INTO items_with_categories VALUES (seq_items_with_categories.NEXTVAL, '�ό��K�C�h�}�b�v����', 1300, 3); 
INSERT INTO items_with_categories VALUES (seq_items_with_categories.NEXTVAL, '�ό��K�C�h�}�b�v���s��', 1300, 3); 
 
--�R�~�b�g����B 
COMMIT; 