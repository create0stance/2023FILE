package jp.co.sss.shop.controller.basket;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.shop.bean.BasketBean;
import jp.co.sss.shop.service.basket.BasketCustomerService;
import jp.co.sss.shop.util.UrlConstant;

@Controller
public class BasketCustomerController {

	/**
	 * セッション情報
	 */
	@Autowired
	HttpSession session;

	@Autowired
	BasketCustomerService service;

	/**
	  * 買い物かご情報表示
	  * @return
	  */
	@RequestMapping(path = UrlConstant.BASKET_LIST, method = RequestMethod.GET)
	public String basketListGet() {
		return UrlConstant.BASKET_HTML_LIST;
	}

	/**
	  * 買い物かご情報表示
	  * @return
	  */
	@RequestMapping(path = UrlConstant.BASKET_LIST, method = RequestMethod.POST)
	public String basketList() {
		return UrlConstant.BASKET_HTML_LIST;
	}

	/**
	  * 買い物かご情報表示
	  * @return
	  */
	@RequestMapping(path = UrlConstant.BASKET_ADD, method = RequestMethod.POST)
	public String addItem(Integer id) {

		List<BasketBean> basketList = (List<BasketBean>) session.getAttribute("basketList");
		basketList = service.editBasketList(id, basketList);
		session.setAttribute("basketList", basketList);
		return "forward:" + UrlConstant.BASKET_LIST;
	}

	/**
		  * 買い物かご情報1件削除
		  * @return
		  */
	@RequestMapping(path = UrlConstant.BASKET_DELETE, method = RequestMethod.POST)
	public String deleteItem(int id) {
		List<BasketBean> basketList = (List<BasketBean>) session.getAttribute("basketList");
		//		basketList = basketList.forEach(basketBean -> {});
		basketList = service.basketDelete(basketList, id);

		if (basketList.size() == 0) {
			session.removeAttribute("basketList");
		} else {
			session.setAttribute("basketList", basketList);
		}
		return "forward:" + UrlConstant.BASKET_LIST;
	}

	/**
	  * 買い物かご情報全件削除
	  * @return
	  */
	@RequestMapping(path = UrlConstant.BASKET_ALL_DELETE, method = RequestMethod.POST)
	public String deleteAll() {
		session.removeAttribute("basketList");
		return "forward:" + UrlConstant.BASKET_LIST;
	}

}
