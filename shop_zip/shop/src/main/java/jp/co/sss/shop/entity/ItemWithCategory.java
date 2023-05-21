package jp.co.sss.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "items_with_categories")
// ★NamedQuery：
// ①Entityに記載する
// ②name="任意のクエリ名"
// ③JPQL:
//		From
@NamedQuery(name="findByIdNamedQuery",query="SELECT i FROM ItemWithCategory i WHERE i.id = :id")
public class ItemWithCategory {
	
	
	/** 商品ID */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_items_with_categories_gen")
	@SequenceGenerator(name = "seq_items_with_categories_gen", sequenceName = "seq_items_with_categories", allocationSize = 1)
	private Integer id;

	/** 商品名 */
	@Column
	private String name;

	/** 商品価格 */
	@Column
	private Integer price;
	
	/** カテゴリEntity */
	// 多対一の関係性を示すアノテーション
	@ManyToOne
	// 結合条件
	// name="自テーブルの列名"
	// referencedColumnName="参照先Entityのフィールド名"
	@JoinColumn(name = "category_id",
				referencedColumnName = "id")
	private Category category;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
}

