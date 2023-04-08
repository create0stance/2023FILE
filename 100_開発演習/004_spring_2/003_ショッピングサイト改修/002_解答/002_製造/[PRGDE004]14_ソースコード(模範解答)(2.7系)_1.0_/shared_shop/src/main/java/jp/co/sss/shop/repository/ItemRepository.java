package jp.co.sss.shop.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jp.co.sss.shop.entity.Item;
import jp.co.sss.shop.util.JPQLConstant;

/**
 * itemsテーブル用リポジトリ
 *
 * @author System Shared
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

	/**  商品情報をすべて取得
	 * @return 商品エンティティのリスト
	 */
	@Query(JPQLConstant.FIND_ORDER_BY_ORDER_COUNT)
	public List<Item> findAllOrderById();

	/**  商品情報を新着順で検索
	 * @param deleteFlag 削除フラグ
	 * @return 商品エンティティのリスト
	 */
	public List<Item> findByDeleteFlagOrderByInsertDateDescIdDesc(int deleteFlag);

	/**
	 * 商品情報を登録日付順に取得
	 * @param deleteFlag 削除フラグ
	 * @param pageable ページング情報
	 * @return 商品エンティティのページオブジェクト
	 */
	@Query(JPQLConstant.FIND_ALL_ITEMS_ORDER_BY_INSERT_DATE)
	Page<Item> findByDeleteFlagOrderByInsertDateDescPage(
	        @Param(value = "deleteFlag") int deleteFlag, Pageable pageable);

	/** 商品情報をカテゴリIDで条件検索(新着順
	 * @param categoryId カテゴリID
	 * @param deleteFlag 削除フラグ
	 * @return 商品エンティティのリスト
	 */
	public List<Item> findByCategoryIdAndDeleteFlagOrderByInsertDateDescIdDesc(int categoryId, int deleteFlag);

	/**  商品情報をカテゴリIDで条件検索(売れ筋順)
	 * @param categoryId カテゴリID
	 * @return 商品エンティティのリスト
	 */
	@Query(JPQLConstant.FIND_BY_CATEGORY_ID_ORDER_BY_ORDER_COUNT)
	public List<Item> findByCategoryIdOrderById(@Param("categoryId") int categoryId);

	/**  注文数より在庫数の少ない商品情報を検索
	 * @param id 商品ID
	 * @param orderNum 注文数
	 * @return 商品エンティティ
	 */
	public Item findByIdAndStockLessThan(int id, int orderNum);

	/**
	 * 商品IDと削除フラグを条件に検索
	 * @param id 商品ID
	 * @param deleteFlag 削除フラグ
	 * @return 商品エンティティ
	 */
	public Item findByIdAndDeleteFlag(Integer id, int deleteFlag);

	/**
	 * 商品名と削除フラグを条件に検索
	 * @param name 商品名
	 * @param notDeleted 削除フラグ
	 * @return 商品エンティティ
	 */
	public Item findByNameAndDeleteFlag(String name, int notDeleted);
}
