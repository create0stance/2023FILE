//7章 外部参照関係にあるテーブルの検索 3．リポジトリの作成
package jp.co.sss.shop.repository;

import java.util.List;//7章 外部キーによる条件検索 1．リポジトリの編集 追記

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;	//8章 @Queryを利用したJPQL  1.リポジトリの編集  追記
import org.springframework.data.repository.query.Param; //8章 @Queryを利用したJPQL  1.リポジトリの編集  追記

import jp.co.sss.shop.entity.Category; //7章 外部キーによる条件検索 1．リポジトリの編集 追記
import jp.co.sss.shop.entity.ItemWithCategory;

public interface ItemWithCategoryRepository
 extends JpaRepository<ItemWithCategory, Integer> {
	//7章 外部キーによる条件検索 1．リポジトリの編集 追記
	List<ItemWithCategory> findByCategory(Category category);
	
	//8章 @Queryを利用したJPQL  1.リポジトリの編集  追記
    @Query("SELECT i FROM ItemWithCategory i WHERE i.id = :id")
    public List<ItemWithCategory> findByIdQuery(@Param("id") Integer id);

	//8章 @Queryの活用  1.リポジトリの編集  追記
    @Query("SELECT i FROM ItemWithCategory i WHERE i.price >= "+ 
    		"(SELECT AVG(i2.price) FROM ItemWithCategory i2)") 
    		public List<ItemWithCategory> findByPriceGreaterThanEqualAVGPriceQuery();

}

