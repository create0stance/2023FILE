package jp.co.sss.shop.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * カテゴリEntity
 *
 */
@Entity
@Table(name = "categories")
public class Category {
	
	/** カテゴリID */
    @Id
    private Integer id;

    /** カテゴリ名 */
    @Column
    private String name;
   
    /** カテゴリに属する商品一覧  */
	@OneToMany(mappedBy="category")
	// 一対多の場合、OneToManyを使用
	// mappedBy="関連Entityの対象フィールド名"
    private List<ItemWithCategory> items;
    
	
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
    
    /**
	 * @return categories
	 */
	public List<ItemWithCategory> getItems() {
		return items;
	}
	
	/**
	 * @param categories セットする categories
	 */
	public void setItems(List<ItemWithCategory> categories) {
		this.items = categories;
	}
}

