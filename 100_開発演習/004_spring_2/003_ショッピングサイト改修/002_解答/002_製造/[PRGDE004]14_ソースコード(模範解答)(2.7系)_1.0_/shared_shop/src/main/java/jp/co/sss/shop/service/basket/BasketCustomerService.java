package jp.co.sss.shop.service.basket;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.sss.shop.bean.BasketBean;
import jp.co.sss.shop.entity.Item;
import jp.co.sss.shop.repository.ItemRepository;

@Service
public class BasketCustomerService {

	@Autowired
	ItemRepository itemRepository;

	public List<BasketBean> editBasketList(Integer id, List<BasketBean> basketList) {
		//List<BasketBean> BasketList = (List<BasketBean>)session.getAttribute("basketList");
		if(basketList == null || basketList.size() == 0) {
			basketList = new ArrayList<BasketBean>();
		}
		Item item = itemRepository.getOne(id);

		boolean containsId = false;
		for(BasketBean basketBean : basketList) {
			if(id == basketBean.getId()) {
				containsId = true;
				if(item.getStock() - (basketBean.getOrderNum() + 1) >= 0) {
					basketBean.setOrderNum(basketBean.getOrderNum() + 1);
				}
				break;
			}
		}
		if(!containsId) {
			BasketBean newBasketBean = new BasketBean();
			newBasketBean.setId(item.getId());
			newBasketBean.setName(item.getName());
			newBasketBean.setStock(item.getStock());
			basketList.add(0, newBasketBean);
		}
		return basketList;
	}

	public List<BasketBean> basketDelete(List<BasketBean> basketList, int id){
		return basketList.stream().filter(bean -> {
			if (bean.getId() == id) {
				if (bean.getOrderNum() > 1) {
					bean.setOrderNum(bean.getOrderNum() - 1);
					return true;
				} else {
					return false;
				}
			} else {
				return true;
			}
		}).collect(Collectors.toList());
	}
}
