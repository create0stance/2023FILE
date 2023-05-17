//7章 外部参照関係にあるテーブルの検索 4．コントローラの作成
package jp.co.sss.shop.controller;

import java.util.List;	//7章 外部キーによる条件検索 2．コントローラの編集 追記

import javax.persistence.EntityManager;	//8章 @NamedQueryを利用したJPQL  2.コントローラの編集  追記
import javax.persistence.Query;	//8章 @NamedQueryを利用したJPQL  2.コントローラの編集  追記

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable; //7章 外部キーによる条件検索 2．コントローラの編集 追記
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sss.shop.entity.Category;//7章 外部キーによる条件検索 2．コントローラの編集 追記
import jp.co.sss.shop.entity.ItemWithCategory;//7章 外部キーによる条件検索 2．コントローラの編集 追記
import jp.co.sss.shop.repository.ItemWithCategoryRepository;

@Controller
public class ItemWithCategoryController {
	@Autowired
	ItemWithCategoryRepository repository;
	
    @Autowired
    EntityManager entityManager;	//8章 @NamedQueryを利用したJPQL  2.コントローラの編集  追記

	
	@RequestMapping("/items/findItemAndCategory")
	public String showItemAndCategoryList(Model model) {
		model.addAttribute("items", repository.findAll());
		return "items/item_category_list";
	}
	
	//7章 外部キーによる条件検索 2．コントローラの編集 追記
    @RequestMapping("/items/searchByCategoryId/{categoryId}")
    public String searchByCategoryId(@PathVariable Integer categoryId, Model model) {
        //外部参照先テーブルに対応付けられたエンティティCategoryのオブジェクトを生成
        Category category = new Category();
        //Categoryのオブジェクト内のidフィールドにパラメータの値を代入
        category.setId(categoryId);
       //Categoryのオブジェクト内のidフィールドを使用した条件検索を実行
        List<ItemWithCategory> items = repository.findByCategory(category);

        //検索結果をリクエストスコープに保存
        model.addAttribute("items", items);
        //商品一覧画面に遷移
        return "items/item_category_list";
    }
    
	//8章 @NamedQueryを利用したJPQL  2.コントローラの編集  追記    
    @RequestMapping("/items/searchWithNamedQuery/{id}")
    public String searchWithNamedQuery(@PathVariable Integer id, Model model) {
    	Query query = entityManager.createNamedQuery("findByIdNamedQuery");
    	query.setParameter("id", id);
    	model.addAttribute("items", query.getResultList());
    	return "items/item_category_list";
    }

	//8章 @Queryを利用したJPQL  2.コントローラの編集  追記    
    @RequestMapping("/items/searchWithQuery/{id}")
    public String searchWithQuery(@PathVariable Integer id,Model model) {
    	model.addAttribute("items", repository.findByIdQuery(id));
    	return"items/item_category_list";
    }
    
	//8章 @Queryの活用  2.コントローラの編集  追記    
    @RequestMapping("/items/searchWithQuery")
    public String searchWithQuery(Model model) {
        model.addAttribute("items", repository.findByPriceGreaterThanEqualAVGPriceQuery());
        return"items/item_category_list";
    }


}

