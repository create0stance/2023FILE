package jp.co.sss.shop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jp.co.sss.shop.entity.Category;
import jp.co.sss.shop.entity.Item;
import jp.co.sss.shop.util.JPQLConstant;

/**
 * itemsテーブル用リポジトリ
 *
 * @author System Shared
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

	// 商品情報を新着順で検索
	public Page<Item> findByDeleteFlagOrderByInsertDateDesc(int deleteFlag, Pageable pageable);

	// 商品情報を新着順で検索(カテゴリ別)
	public Page<Item> findByDeleteFlagAndCategoryOrderByInsertDateDesc(int deleteFlag, Category category, Pageable pageable);

	/**
	 * 注文商品情報を対象に商品情報を注文件数がおおい順に検索
	 * @param pageable
	 * @return 商品情報リスト
	 */
	@Query(value = JPQLConstant.FIND_ITEMS_INNER_ORDERITEMS_ORDERCNT,
			  countQuery = JPQLConstant.FIND_ITEMS_CNT_INNER_ORDERITEMS_ORDERCNT,
			  nativeQuery = true)
	public Page<Item> findItemsInnerOrderItemOrderCnt(Pageable pageable);

	/**
	 * 商品情報で注文件数がおおい順に検索
	 * @param pageable
	 * @return 商品情報リスト
	 */
	@Query(value = JPQLConstant.FIND_ITEMS_OUTER_ORDERITEMS_ORDERCNT,
			  countQuery = JPQLConstant.FIND_ITEMS_CNT_OUTER_ORDERITEMS_ORDERCNT,
			  nativeQuery = true)
	public Page<Item> findItemsOuterOrderItemOrderCnt(Pageable pageable);

	/**
	 * 注文商品情報を対象に商品情報を注文件数がおおい順に検索
	 * (カテゴリ別)
	 * @param pageable
	 * @return 商品情報リスト
	 */
	@Query(value = JPQLConstant.FIND_ITEMS_INNER_ORDERITEMS_ORDERCNT_WITH_CATEGORY,
			  countQuery = JPQLConstant.FIND_ITEMS_CNT_INNER_ORDERITEMS_ORDERCNT_WITH_CATEGORY,
			  nativeQuery = true)
	public Page<Item> findItemsInnerOrderItemOrderCntWithCategory(@Param("categoryId") String categoryId, Pageable pageable);

}
