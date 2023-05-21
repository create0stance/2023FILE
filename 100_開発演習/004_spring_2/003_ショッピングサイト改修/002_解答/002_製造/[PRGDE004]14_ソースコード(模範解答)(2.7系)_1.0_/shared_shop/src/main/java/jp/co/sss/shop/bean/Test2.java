package jp.co.sss.shop.bean;

public class Test2 {
	private String name;
	private Integer id;
	private ItemBean item;
	
	Test2(String name,Integer id,ItemBean item){
		setId(id);
		setName(name);
		setItem(item);
	}
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @return item
	 */
	public ItemBean getItem() {
		return item;
	}
	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param id セットする id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @param item セットする item
	 */
	public void setItem(ItemBean item) {
		this.item = item;
	}
}
