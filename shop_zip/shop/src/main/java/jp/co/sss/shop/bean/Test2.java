package jp.co.sss.shop.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test2 implements Serializable {
	private String name;
	private Integer id;
	private ItemBean item;
	private Date date;
	private String strDate;
	
	public Test2(String name,Integer id,ItemBean item){
		setId(id);
		setName(name);
		setItem(item);
		
	}
	@Override
	public String toString() {
		String str = "id：" + getId();
		str += "\nname：" + getName();
		str += "\nItemBean：" + getItem();
		str += "\nDate：" + getDate();
		str += "\nstrDate：" + getStrDate();
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
	public String getDate() {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-mm-dd");
		return f.format(date);
	}
	
	
	/**
	 * @param date セットする date
	 */
	public void setDate(Date date) {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-mm-dd");
		this.setStrDate(f.format(date));
		this.date = date;
	}
	/**
	 * @return strDate
	 */
	public String getStrDate() {
		return strDate;
	}
	/**
	 * @param strDate セットする strDate
	 */
	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}
}
