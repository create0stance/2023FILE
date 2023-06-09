package jp.co.sss.shop.bean;

import java.util.Date;

public class Test1 {
	private String name;
	private Integer id;
	private ItemBean item;
	private Date date;
	
	public Test1(String name,Integer id,ItemBean item){
		setId(id);
		setName(name);
		setItem(item);
		this.date = new Date(); 
	}
	
	@Override
	public String toString() {
		String str = "id：" + getId();
		str += "\nname：" + getName();
		str += "\nItemBean：" + getItem();
		str += "\nDate：" + this.date;
		return str;
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

	/**
	 * @return date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date セットする date
	 */
	public void setDate(Date date) {
		this.date = date;
	}
}
