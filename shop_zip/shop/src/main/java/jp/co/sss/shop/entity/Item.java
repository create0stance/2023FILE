package jp.co.sss.shop.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="items")
public class Item {
	
	@Id
	// 値の作成方法の指定
	@GeneratedValue(
			// 戦略
			strategy = GenerationType.SEQUENCE,
			// 値の作成者
			generator = "seq_items_gen")
	// シーケンス作成者の設定
	@SequenceGenerator(
			// 作成者名
			name = "seq_items_gen", 
			// シーケンス名(oracleで設定した名称）
			sequenceName = "seq_items",
			//増減値
			// (データベースのシーケンス
			// 増減値に合わせる)
			allocationSize = 1
			)
	private Integer id;
	
	@Column
	private String name;
	
	@Column
	private Integer price;
	
	@Transient
	private Date date;
	
	public Item(){
		this.date = new Date();
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
