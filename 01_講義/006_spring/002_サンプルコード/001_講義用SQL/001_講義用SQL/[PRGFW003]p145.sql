-- ���[�U��system��xepdb1�ɐڑ��؂�ւ���A�V�K�ɃX�L�[�}���쐬����B 
ALTER SESSION SET CONTAINER = XEPDB1; 
CREATE USER spring_user IDENTIFIED BY systemsss; 
GRANT ALL PRIVILEGES TO spring_user; 
 
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