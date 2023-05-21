package jp.co.sss.shop.form;

/**
 * 商品情報入力フォームクラス
 *
 */
public class ItemForm {
	
	/** 商品ID */ 
	private Integer id;
	
	/** 商品名 */
	private String name;
	
	/** 商品価格 */
	private Integer price;
	
	/**
	 * @return id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id セットする id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return price
	 */
	public Integer getPrice() {
		return price;
	}
	/**
	 * @param price セットする price
	 */
	public void setPrice(Integer price) {
		this.price = price;
	}
}
