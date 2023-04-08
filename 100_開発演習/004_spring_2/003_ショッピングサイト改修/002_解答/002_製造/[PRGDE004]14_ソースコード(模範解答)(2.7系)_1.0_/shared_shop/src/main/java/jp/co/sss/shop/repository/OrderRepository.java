package jp.co.sss.shop.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jp.co.sss.shop.entity.Order;
import jp.co.sss.shop.util.JPQLConstant;

/**
 * ordersテーブル用リポジトリ
 *
 * @author System Shared
 */
@Repository

public interface OrderRepository extends JpaRepository<Order, Integer> {

	/**
	 * 直近に登録された注文情報の取得
	 * @return 注文情報エンティティ
	 */
	Order findTop1ByOrderByIdDesc();

	/**
	 * 会員IDに該当する注文情報を注文日付降順で検索
	 * @param userId 会員ID
	 * @return 注文エンティティのリスト
	 */
	List<Order> findByUserIdOrderByInsertDateDescIdDesc(int userId);

	/**
	 * 注文日付降順で注文情報すべてを検索
	 * @param pageable ページング情報
	 * @return 注文エンティティのページオブジェクト
	 */
	@Query(JPQLConstant.FIND_ALL_ORDERS_ORDER_BY_INSERT_DATE)
	Page<Order> findAllOrderByInsertdateDescIdDesc(Pageable pageable);

}
