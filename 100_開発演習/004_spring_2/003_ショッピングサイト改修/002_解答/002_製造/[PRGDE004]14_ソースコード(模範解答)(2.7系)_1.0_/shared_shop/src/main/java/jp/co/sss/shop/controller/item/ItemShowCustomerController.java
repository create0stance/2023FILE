package jp.co.sss.shop.controller.item;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.shop.entity.Item;
import jp.co.sss.shop.service.items.ItemsService;
import jp.co.sss.shop.util.BeanCopy;
import jp.co.sss.shop.util.Constant;

/**
 * 商品管理 一覧表示機能(一般会員用)のコントローラクラス
 *
 * @author SystemShared
 */
@Controller
public class ItemShowCustomerController {

	/**
	 * 商品情報取得サービス
	 */
	@Autowired
	ItemsService	itemsService;

	@Autowired
	HttpSession session;

	/**
	 * 新着一覧画面 表示処理
	 * (ナビゲーションバー遷移 sortType=1)
	 * (表示順　並び替えリンク遷移
	 * 新着順　sortType=1
	 * 売れ筋順 sortType=2)
	 *
	 * @param model    Viewとの値受渡し
	 * @param pageable ページング情報
	 * @return "/" トップ画面へ
	 */
	@RequestMapping(path = "/item/list/{sortType}" , method=RequestMethod.GET)
	public String itemsShowSortType(@PathVariable int sortType, Model model,  Pageable pageable) {
		Page<Item> itemPageList = null;
		if(Constant.DEFAULT_SORT_TYPE == sortType) {
			itemPageList = itemsService.fingItemsOrderByInsertDate(pageable);
			model.addAttribute("sortType", Constant.DEFAULT_SORT_TYPE);
		}else {
			itemPageList = itemsService.findItemsInnerOrderItemOrderCnt(pageable);
			model.addAttribute("sortType", Constant.SALE_CNT_SORT_TYPE);
		}
		// 商品情報をViewへ渡す
		model.addAttribute("pages", itemPageList);
		model.addAttribute("items", BeanCopy.copyEntityToItemBean(itemPageList.getContent()));
		model.addAttribute("url", "/item/list/" + sortType);

		return "/item/list/item_list";
	}

	/**
	 * 新着一覧画面 表示処理
	 * (サイドバー　カテゴリ検索)
	 * 並び順は直前の並び順を参照
	 *
	 * @param sortType    並べ替え
	 * @param categoryId    カテゴリID
	 * @param model    Viewとの値受渡し
	 * @param pageable ページング情報
	 * @return "/" トップ画面へ
	 */
	@RequestMapping(path = "/item/list/category/{sortType}" , method=RequestMethod.GET)
	public String itemsShowCategoryAndSortType(@PathVariable int sortType, String categoryId,
												Model model,  Pageable pageable ) {

		Page<Item> itemPageList = null;
		if(Constant.DEFAULT_SORT_TYPE == sortType) {
			itemPageList = itemsService.findByDeleteFlagAndCategoryOrderByInsertDateDesc(categoryId, pageable);
			model.addAttribute("sortType", Constant.DEFAULT_SORT_TYPE);
		}else {
			itemPageList = itemsService.findItemsInnerOrderItemOrderCntWithCategory(categoryId, pageable);
			model.addAttribute("sortType", Constant.SALE_CNT_SORT_TYPE);
		}
		// 商品情報をViewへ渡す
		model.addAttribute("pages", itemPageList);
		model.addAttribute("items", BeanCopy.copyEntityToItemBean(itemPageList.getContent()));
		model.addAttribute("url", "/item/list/" + sortType);

		return "/item/list/item_list";
	}

	/**
	 * 商品情報検索(単品)
	 * @param id 商品ID
	 * @param model
	 * @return 商品情報
	 */
	@RequestMapping(path = "/item/detail/{id}" , method=RequestMethod.GET)
	public String itemDetailShow(@PathVariable int id, Model model) {
		Item item = itemsService.findByItemDetail(id);
		model.addAttribute("item", item);
		return "/item/detail/item_detail";
	}
}
