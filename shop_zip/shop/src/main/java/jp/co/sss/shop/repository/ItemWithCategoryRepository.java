package jp.co.sss.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.sss.shop.entity.Category;
import jp.co.sss.shop.entity.ItemWithCategory;

public interface ItemWithCategoryRepository
		extends JpaRepository<ItemWithCategory, Integer> {

	List<ItemWithCategory> findByCategory(Category category);

}
