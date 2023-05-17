//6章 エンティティとリポジトリの利用-2.リポジトリの作成
package jp.co.sss.shop.repository;
import java.util.List; //6章　全件検索(並び替え指定) 追記

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.sss.shop.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
	
	//6章　全件検索(並び替え指定) 追記
	List<Item> findAllByOrderByPriceDesc();
	
	//6章　条件検索(その他の検索) 1.主キー以外の列による条件検索
	 List<Item> findByPrice(Integer price);
	 
	//6章　条件検索(その他の検索) 2.複数の列による条件検索
	 List<Item> findByNameAndPrice(String name, Integer price);
	 
	 
	//6章　条件検索(その他の検索) 3.曖昧検索
	 List<Item> findByNameContaining(String name);
}
