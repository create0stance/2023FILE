package jp.co.sss.shop.controller.order;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.shop.bean.BasketBean;
import jp.co.sss.shop.bean.OrderItemBean;
import jp.co.sss.shop.bean.UserBean;
import jp.co.sss.shop.form.AddressForm;
import jp.co.sss.shop.form.OrderForm;
import jp.co.sss.shop.form.PaymentForm;
import jp.co.sss.shop.service.order.OrderService;
import jp.co.sss.shop.util.UrlConstant;

@Controller
public class OrderRegistCustomerController {

	/**
	 * セッション情報
	 */
	@Autowired
	HttpSession session;

	/** 注文情報サービス**/
	@Autowired
	OrderService orderService;


	/**
	  * 注文手続き(届先入力)
	  * GET
	  * @return
	  */
	@RequestMapping(path = UrlConstant.ADDRESS_INPUT , method=RequestMethod.GET)
	public String inputAdressRedirect() {
		return UrlConstant.ADDRESS_REGIST_INPUT;
	}

	/**
	  * 注文手続き(届先入力)
	  * POST
	  * @return
	  */
	@RequestMapping(path = UrlConstant.ADDRESS_INPUT , method=RequestMethod.POST)
	public String inputAdress(boolean backflg, AddressForm form, Model model) {
		if(backflg) {
			form = (AddressForm)session.getAttribute("address");
			model.addAttribute("addressForm", form);
		}else {
			UserBean userBean = (UserBean)session.getAttribute("user");
			orderService.editAddressForm(form, userBean.getId());
		}
		return UrlConstant.ADDRESS_REGIST_INPUT;
	}

	/**
	  * 注文手続き(支払い選択)
	  * @return
	  */
	@RequestMapping(path = UrlConstant.PAYMENT_INPUT , method=RequestMethod.POST)
	public String inputPayment(boolean backflg, AddressForm form, BindingResult result, PaymentForm paymentForm,  Model model) {
		String transitionURL = UrlConstant.PAYMENT_REGIST_INPUT;
		if(result.hasErrors()) {
			transitionURL = "redirect:" + UrlConstant.ADDRESS_INPUT;
		}
		if(backflg) {
			paymentForm = (PaymentForm)session.getAttribute("payment");
			model.addAttribute("paymentForm", paymentForm);

		}else {
			session.setAttribute("address", form);
			session.setAttribute("orderForm", orderService.editOrderFormForAddress(form));
		}
		return transitionURL;
	}

	/**
	  * 注文手続き(確認)
	  * @return
	  */
	@RequestMapping(path = UrlConstant.ORDER_CHECK , method=RequestMethod.POST)
	public String checkOrder(PaymentForm form,BindingResult result, Model model) {
		String transitionURL = UrlConstant.ORDER_REGIST_CHECK;
		if(result.hasErrors()) {
			transitionURL = "redirect:" + UrlConstant.PAYMENT_INPUT;
		}
		orderService.editPaymentForm(form);
		session.setAttribute("payment", form);
		OrderForm orderForm = (OrderForm)session.getAttribute("orderForm");

		List<BasketBean> basketList = (List<BasketBean>)session.getAttribute("basketList");
		List<OrderItemBean> orderItemList = orderService.editOrderItemListForBasketList(basketList, orderForm, form);
		session.setAttribute("orderItemList", orderItemList);
		session.setAttribute("orderForm", orderForm);

		return transitionURL;
	}

	/**
	  * 注文手続き(完了)
	  * @return
	  */
	@RequestMapping(path = UrlConstant.ORDER_COMPLETE , method=RequestMethod.POST)
	public String completeOrder() {

		OrderForm orderForm = (OrderForm)session.getAttribute("orderForm");
		UserBean userBean = (UserBean)session.getAttribute("user");
		List<OrderItemBean> orderItemList = (List<OrderItemBean>)session.getAttribute("orderItemList");
		orderService.orderRegist(userBean, orderForm, orderItemList);
		return UrlConstant.ORDER_REGIST_COMPLETE;
	}


}
