package jp.co.sss.shop.service.items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jp.co.sss.shop.entity.Category;
import jp.co.sss.shop.entity.Item;
import jp.co.sss.shop.repository.ItemRepository;

@Service
public class ItemsService {

	/**
	 * 商品情報
	 */
	@Autowired
	ItemRepository itemRepository;

	/**
	 * 商品情報を注文商品情報の件数が多い順に取得
	 * @param pageable
	 * @return 商品情報リスト
	 */
	public Page<Item> findItemsOuterOrderItemOrderCnt(Pageable pageable) {
		// すべての注文情報を取得
		Page<Item> itemList = itemRepository.findItemsOuterOrderItemOrderCnt(pageable);

		return itemList;
	}

	/**
	 * 注文商品情報を対象に商品情報を件数が多い順に取得
	 * @param pageable
	 * @return 商品情報リスト
	 */
	public Page<Item> findItemsInnerOrderItemOrderCnt(Pageable pageable) {
		// すべての注文情報を取得
		Page<Item> itemList = itemRepository.findItemsInnerOrderItemOrderCnt(pageable);

		return itemList;
	}

	/**
	 * 商品情報を登録順で取得
	 * @param pageable
	 * @return 商品情報リスト
	 */
	public Page<Item> fingItemsOrderByInsertDate(Pageable pageable){

		Page<Item> itemList = itemRepository.findByDeleteFlagOrderByInsertDateDesc(0, pageable);
		return itemList;
	}

	/**
	 * 商品情報を登録順で取得
	 * (カテゴリ別)
	 * @param pageable
	 * @return 商品情報リスト
	 */
	public Page<Item> findByDeleteFlagAndCategoryOrderByInsertDateDesc(String categoryId ,Pageable pageable){
		Category category = new Category();
		category.setId(Integer.parseInt(categoryId));
		Page<Item> itemList = itemRepository.findByDeleteFlagAndCategoryOrderByInsertDateDesc(0, category, pageable);

		return itemList;
	}

	/**
	 * 注文商品情報を対象に商品情報を件数が多い順に取得
	 * (カテゴリ別)
	 * @param pageable
	 * @return 商品情報リスト
	 */
	public Page<Item> findItemsInnerOrderItemOrderCntWithCategory(String categoryId ,Pageable pageable) {
		// すべての注文情報を取得
		Page<Item> itemList = itemRepository.findItemsInnerOrderItemOrderCntWithCategory(categoryId ,pageable);

		return itemList;
	}

	public Item findByItemDetail(int id) {
		Item item = itemRepository.getOne(id);
		 return item;
	}
}
