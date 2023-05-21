//6章 エンティティとリポジトリの利用-2.リポジトリの作成
package jp.co.sss.shop.repository;
import java.util.List; //6章　全件検索(並び替え指定) 追記

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.sss.shop.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
	
	
	// findAllで全件取得
	// OrderByPriceDesc = order by price desc
	// ↓複数件レコードを取得
	// List<Entity>
	// ↓1件取得
	// Entity 
	
	List<Item> findAllByOrderByPriceDesc();
	
	
	
	
	
	
	
	 List<Item> findByPrice(Integer price);
	 
	 List<Item> findByNameAndPrice(String name, Integer price);
	 
	 /**
	  * 商品名に検索文字列が含まれる商品一覧を取得
	  * @param name 検索文字列
	  * @return 商品エンティティリスト
	  */
	 // Where name like "%name%"
	 List<Item> findByNameLike(String name);
	 
	 List<Item> findByNameContainingOrNameContaining(String n,String n2);
}
