package jp.co.sss.shop.util;

/**
 * 独自JPQLを定義するためのクラス
 *
 * @author System Shared
 */
public class JPQLConstant {

	// 注文情報を全件検索(新着順)
	public static final String	FIND_ALL_ORDERS_ORDER_BY_INSERT_DATE
		= "SELECT o FROM Order o ORDER BY o.insertDate DESC";

	// カテゴリ情報を全件検索(新着順)
	public static final String	FIND_ALL_CATEGORIES_ORDER_BY_INSERT_DATE
	 = "SELECT c FROM Category c WHERE c.deleteFlag =:deleteFlag ORDER BY c.insertDate DESC,c.id ASC";

	// 注文商品情報対象に売れ筋検索
	public static final String	FIND_ITEMS_INNER_ORDERITEMS_ORDERCNT
	 = "select i.* from items i "
 		+ "inner join (select item_id , count(item_id) as cnt from order_items group by item_id ) oi "
 		+ "on i.id = oi.item_id order by cnt, i.id";

	// 注文商品情報対象に売れ筋検索(カウント番)
	public static final String	FIND_ITEMS_CNT_INNER_ORDERITEMS_ORDERCNT
	 = "select Count(*) from items i "
 		+ "inner join (select item_id , count(item_id) as cnt from order_items group by item_id ) oi "
 		+ "on i.id = oi.item_id order by cnt, i.id";

	// 商品情報対象に売れ筋検索
	public static final String	FIND_ITEMS_OUTER_ORDERITEMS_ORDERCNT
	 = "select i.* from items i "
 		+ "left outer join (select item_id , count(item_id) as cnt from order_items group by item_id ) oi "
 		+ "on i.id = oi.item_id order by cnt, i.id";

	// 商品情報対象に売れ筋検索
	public static final String	FIND_ITEMS_CNT_OUTER_ORDERITEMS_ORDERCNT
	 = "select i.* from items i "
 		+ "left outer join (select item_id , count(item_id) as cnt from order_items group by item_id ) oi "
 		+ "on i.id = oi.item_id order by cnt, i.id";

	// 注文商品情報対象に売れ筋検索
	//(カテゴリ別)
	public static final String	FIND_ITEMS_INNER_ORDERITEMS_ORDERCNT_WITH_CATEGORY
	 = "select i.* from items i "
 		+ "inner join (select item_id , count(item_id) as cnt from order_items group by item_id ) oi "
 		+ "on i.id = oi.item_id where i.category_id = :categoryId order by cnt, i.id";

	// 注文商品情報対象に売れ筋検索(カウント番)
	//(カテゴリ別)
	public static final String	FIND_ITEMS_CNT_INNER_ORDERITEMS_ORDERCNT_WITH_CATEGORY
	 = "select Count(*) from items i "
 		+ "inner join (select item_id , count(item_id) as cnt from order_items group by item_id ) oi "
 		+ "on i.id = oi.item_id where i.category_id = :categoryId order by cnt, i.id";

}
