//6章 全件検索-1.コントローラの作成
package jp.co.sss.shop.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sss.shop.bean.ItemBean;
import jp.co.sss.shop.entity.Item;
import jp.co.sss.shop.repository.ItemRepository;

/**
 * 商品アイテムに関連するコントローラー
 *
 */
@Controller
public class ItemController {
	
	// DIコンテナからItemRepositoryを取得
	@Autowired
	ItemRepository repository;
	
	// レポジトリをAutowiredした時点で実行確認。
	// →起動できなければ、Entityまたはレポジトリの実装に間違いがある。
	@RequestMapping("/items/findAll")
	public String showItemList(Model model) {
		
		// 実装クラス「SimpleJpaRepository」のfindAll()メソッドを使用し、
		// 全件のデータをList<Entity>で取得
		List<Item> items = repository.findAll();
		
		// コンソールで内容を確認
		for (Item item : items) {
			System.out.println(item);
		}
		
		// modelにList<Items>を変数名「items」で保存
		model.addAttribute("items", repository.findAll());
		
		return "items/item_list";
	}
	
	@RequestMapping("/items/findAllByOrderByPriceDesc")
	public String showItemListByOrderByPriceDesc(Model model) {
		model.addAttribute("items", repository.findAllByOrderByPriceDesc());
		return "items/item_list";
	}

	@RequestMapping("/items/getOne/{id}")
	public String showItem(@PathVariable int id, Model model) {
		Item item = repository.getReferenceById(id);
		ItemBean itemBean = new ItemBean();
		BeanUtils.copyProperties(item, itemBean);
		model.addAttribute("item", itemBean);
		return "items/item";
	}

	@RequestMapping("/items/findByPrice/{price}")
	public String showItemListByPrice(@PathVariable Integer price, Model model) {
		model.addAttribute("items", repository.findByPrice(price));
		return "items/item_list";
	}

	@RequestMapping("/items/findByNameAndPrice/{name}/{price}")
	public String showItemListByNameAndPrice(
			@PathVariable String name, @PathVariable Integer price, Model model) {
		model.addAttribute("items", repository.findByNameAndPrice(name, price));
		return "items/item_list";
	}

	@RequestMapping("/items/findByNameLike/{name}")
	public String showItemListByNameLike(@PathVariable String name, Model model) {
		model.addAttribute("items", repository.findByNameContaining(name));
		return "items/item_list";
	}

	@RequestMapping("/items/findAllAndSetDropdown")
	public String itemListSetDropdown(Model model) {
		model.addAttribute("items", repository.findAll());
		return "items/item_list_dropdown";
	}
	
//	//6章 登録　2.コントローラの編集 追記
//    @RequestMapping("/items/create/input")
//    public String createInput() {
//        return "items/create_input";
//    }

//	//6章 登録　2.コントローラの編集 追記
//    @RequestMapping(path = "/items/create/complete", method = RequestMethod.POST)
//    public String createComplete(ItemForm form,Model model) {
//       Item item = new Item();
//       BeanUtils.copyProperties(form, item, "id");
//       item=repository.save(item);
//       ItemBean itemBean = new ItemBean();
//       BeanUtils.copyProperties(item,itemBean);
//       model.addAttribute("item", itemBean);
//       return "items/item";
//    }
//
//	//6章 更新　1.コントローラの編集 追記
//    @RequestMapping("/items/update/input/{id}")
//    public String updateInput(@PathVariable Integer id, Model model) {
//        Item item =repository.getReferenceById(id);
//        ItemBean itemBean = new ItemBean();
//        BeanUtils.copyProperties(item,itemBean);
//        model.addAttribute("item", itemBean);
//        return "items/update_input";
//    }
//
//	//6章 更新　1.コントローラの編集 追記
//    @RequestMapping(path = "/items/update/complete/{id}", method = RequestMethod.POST)
//    public String updateComplete(@PathVariable Integer id, ItemForm form,Model model) {
//       Item item = repository.getReferenceById(id);
//       BeanUtils.copyProperties(form, item, "id");
//       item=repository.save(item);
//       ItemBean itemBean = new ItemBean();
//       BeanUtils.copyProperties(item,itemBean);
//       model.addAttribute("item", itemBean);
//       return "items/item";
//    }
//
//	//6章 削除　1.コントローラの編集 追記
//    @RequestMapping("/items/delete/input")
//    public String deleteInput(Model model) {
//        model.addAttribute("items", repository.findAll());
//        return "items/delete_input";
//    }
//	//6章 削除　1.コントローラの編集 追記
//    @RequestMapping(path = "/items/delete/complete")
//    public String deleteComplete(ItemForm form) {
//        repository.deleteById(form.getId());
//        return "redirect:/items/findAll";
//    }
//
//    //12章 CSSとJavaScriptの利用 3.コントローラの編集 追記
//    @RequestMapping("/items/findAllJs")
//    public String showItemListJs(Model model) {
//    	model.addAttribute("items", repository.findAll());
//    	return "items/item_list_js";
//    }
//

}
