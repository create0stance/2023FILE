package jp.co.sss.shop.controller.order;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.shop.bean.OrderBean;
import jp.co.sss.shop.bean.OrderItemBean;
import jp.co.sss.shop.bean.UserBean;
import jp.co.sss.shop.entity.Order;
import jp.co.sss.shop.service.order.OrderService;
import jp.co.sss.shop.util.UrlConstant;

@Controller
public class OrderShowCustomerController {

	/** セッション情報**/
	@Autowired
	HttpSession session;

	/** 注文情報サービス**/
	@Autowired
	OrderService orderService;

	/**
	 * 注文一覧表示
	 * @param model
	 * @param pageable
	 * @return
	 */
	@RequestMapping(path = UrlConstant.ORDER_LIST , method=RequestMethod.GET)
	public String orderListShow(Model model,Pageable pageable) {
		UserBean userBean = (UserBean)session.getAttribute("user");
		Page<Order> orders = orderService.findOrdersByUserId(userBean.getId(), pageable);

		model.addAttribute("pages", orders);
		model.addAttribute("orders", orderService.editOrders(orders));
		model.addAttribute("url", UrlConstant.ORDER_LIST);
		return UrlConstant.ORDER_HTML_LIST;
	}

	/**
	 * 注文詳細情報表示
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(path = UrlConstant.ORDER_DETAIL + "/{id}" , method=RequestMethod.GET)
	public String orderDetailshow(@PathVariable int id, Model model) {
		Order order = orderService.findOrderDetail(id);
		OrderBean orderBean = orderService.editOrderDetail(order);

		List<OrderItemBean> orderItemList = orderService.editOrderItemList(order.getOrderItemsList(), orderBean);
		model.addAttribute("orderItemList", orderItemList);
		model.addAttribute("order", orderBean);


		return UrlConstant.ORDER_HTML_DETAIL;
	}
}
