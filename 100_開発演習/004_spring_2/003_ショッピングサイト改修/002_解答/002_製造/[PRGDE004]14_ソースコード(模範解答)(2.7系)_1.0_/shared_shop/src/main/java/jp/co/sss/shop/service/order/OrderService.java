package jp.co.sss.shop.service.order;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jp.co.sss.shop.bean.BasketBean;
import jp.co.sss.shop.bean.OrderBean;
import jp.co.sss.shop.bean.OrderItemBean;
import jp.co.sss.shop.bean.UserBean;
import jp.co.sss.shop.entity.Item;
import jp.co.sss.shop.entity.Order;
import jp.co.sss.shop.entity.OrderItem;
import jp.co.sss.shop.entity.User;
import jp.co.sss.shop.form.AddressForm;
import jp.co.sss.shop.form.OrderForm;
import jp.co.sss.shop.form.PaymentForm;
import jp.co.sss.shop.repository.ItemRepository;
import jp.co.sss.shop.repository.OrderItemRepository;
import jp.co.sss.shop.repository.OrderRepository;
import jp.co.sss.shop.repository.UserRepository;

@Service
public class OrderService {

	/** 注文情報取得用リポジトリ **/
	@Autowired
	OrderRepository orderRepository;

	/**
	 * ユーザ情報取得用リポジトリ
	 */
	@Autowired
	UserRepository userRepository;

	/**
	 * 商品情報取得用リポジトリ
	 */
	@Autowired
	ItemRepository itemRepository;

	/**
	 *注文商品情報取得用リポジトリ
	 */
	@Autowired
	OrderItemRepository orderItemRepository;

	/**
	 * 注文情報取得
	 * ユーザ毎、登録日順で取得
	 */
	public Page<Order> findOrdersByUserId(int userId, Pageable pageable) {
		return orderRepository.findByUserIdOrderByInsertDateDesc(userId, pageable);
	}

	/**
	 * 注文情報を画面表示用に編集
	 * @param orders
	 * @return
	 */
	public List<OrderBean> editOrders(Page<Order> orders){
		// 注文情報リストを生成
		List<OrderBean> orderBeanList = new ArrayList<OrderBean>();
		for (Order order : orders) {
			OrderBean orderBean = new OrderBean();
			orderBean.setId(order.getId());
			orderBean.setUserName(order.getUser().getName());
			orderBean.setInsertDate(order.getInsertDate().toString());
			orderBean.setPayMethod(order.getPayMethod());

			//注文時点の単価を合計するための一時変数
			int total = 0;

			//orderレコードから紐づくOrderItemのListを取り出す
			List<OrderItem> orderItemList = order.getOrderItemsList();

			for(OrderItem orderItem :  orderItemList) {

				//購入時単価 * 買った個数をもとめて、合計に加算
				total += ( orderItem.getPrice() * orderItem.getQuantity() );
			}
			//Orderに改めて注文時点の単価をセット
			orderBean.setTotal(total);

			orderBeanList.add(orderBean);
		}

		return orderBeanList;
	}

	/**
	 * 注文詳細情報取得
	 */
	public Order findOrderDetail(int id) {
		return orderRepository.getOne(id);
	}

	/**
	 * 注文情報画面用編集
	 */
	public OrderBean editOrderDetail(Order order) {
		OrderBean orderBean = new OrderBean();
		orderBean.setPostalCode(order.getPostalCode());
		orderBean.setAddress(order.getAddress());
		orderBean.setName(order.getName());
		orderBean.setPhoneNumber(order.getPhoneNumber());
		orderBean.setPayMethod(order.getPayMethod());
		orderBean.setInsertDate(order.getInsertDate().toString());

		return orderBean;
	}

	/**
	 * 注文商品情報画面用編集
	 */
	public List<OrderItemBean> editOrderItemList(List<OrderItem> orderItemList, OrderBean orderBean){
		List<OrderItemBean> editOrderItemList = new ArrayList<OrderItemBean>();

		int itemTotalPrice = 0;
		for(OrderItem orderItem : orderItemList) {
			OrderItemBean orderItemBean = new OrderItemBean();
			orderItemBean.setId(orderItem.getId());
			orderItemBean.setName(orderItem.getItem().getName());
			orderItemBean.setPrice(orderItem.getPrice());
			orderItemBean.setOrderNum(orderItem.getQuantity());
			orderItemBean.setSubtotal(orderItem.getPrice() * orderItem.getQuantity());
			itemTotalPrice += orderItemBean.getSubtotal();
			editOrderItemList.add(orderItemBean);
		}
		orderBean.setTotal(itemTotalPrice);
		return editOrderItemList;
	}

	/**
	 * 注文商品情報画面用編集
	 */
	public List<OrderItemBean> editOrderItemListForBasketList(List<BasketBean> basketList, OrderForm orderForm, PaymentForm form){
		List<OrderItemBean> editOrderItemList = new ArrayList<OrderItemBean>();

		orderForm.setPayMethod(form.getPayMethod());

		List<OrderItemBean> orderItemList = new ArrayList<OrderItemBean>();
		int itemTotalPrice = 0;
		for(BasketBean basketBean : basketList) {
			OrderItemBean orderItemBean = new OrderItemBean();
			Item item = itemRepository.getOne(basketBean.getId());
			orderItemBean.setId(item.getId());
			orderItemBean.setName(item.getName());
			orderItemBean.setImage(item.getImage());
			orderItemBean.setPrice(item.getPrice());
			orderItemBean.setOrderNum(basketBean.getOrderNum());
			orderItemBean.setSubtotal(item.getPrice() * basketBean.getOrderNum());
			itemTotalPrice += orderItemBean.getSubtotal();
			orderItemList.add(orderItemBean);
		}
		orderForm.setPrice(itemTotalPrice);
		return orderItemList;
	}

	/**
	 * 届け先情報取得
	 */
	public void editAddressForm(AddressForm form, int userId) {
		User userEntiry = userRepository.getOne(userId);
		form.setPostalCode(userEntiry.getPostalCode());
		form.setAddress(userEntiry.getAddress());
		form.setName(userEntiry.getName());
		form.setPhoneNumber(userEntiry.getPhoneNumber());

	}

	/**
	 * 注文情報設定(届け先内容)
	 */
	public OrderForm editOrderFormForAddress(AddressForm form) {
		OrderForm orderForm = new OrderForm();
		orderForm.setPostalCode(form.getPostalCode());
		orderForm.setAddress(form.getAddress());
		orderForm.setName(form.getName());
		orderForm.setPhoneNumber(form.getPhoneNumber());
		return orderForm;
	}

	/**
	 * 支払い先情報設定
	 */
	public void editPaymentForm(PaymentForm form) {
		String payMethodText;
		switch (form.getPayMethod()) {
		case 1:
			payMethodText = "クレジットカ-ド";
			break;
		case 2:
			payMethodText = "銀行振り込み";
			break;
		case 3:
			payMethodText = "着払い";
			break;
		case 4:
			payMethodText = "電子マネー";
			break;
		case 5:
			payMethodText = "コンビニ決済";
			break;
		default :
			payMethodText = "";
		}
		form.setPayMethodText(payMethodText);
	}

	/**
	 *
	 * @param userBean
	 * @param orderForm
	 * @param orderItemList
	 */
	public void orderRegist(UserBean userBean, OrderForm orderForm, List<OrderItemBean> orderItemList) {
		Order orderEntity = new Order();
		User userEntity = new User();
		userEntity.setId(userBean.getId());

		orderEntity.setPostalCode(orderForm.getPostalCode());
		orderEntity.setAddress(orderForm.getAddress());
		orderEntity.setPhoneNumber(orderForm.getPhoneNumber());
		orderEntity.setPayMethod(orderForm.getPayMethod());
		orderEntity.setName(orderForm.getName());
		orderEntity.setUser(userEntity);
		orderEntity = orderRepository.save(orderEntity);

		for(OrderItemBean orderItemBean : orderItemList) {
			OrderItem orderItemEntity = new OrderItem();
			Item itemEntity = itemRepository.getOne(orderItemBean.getId());
			orderItemEntity.setItem(itemEntity);
			orderItemEntity.setOrder(orderEntity);
			orderItemEntity.setPrice(orderItemBean.getPrice());
			orderItemEntity.setQuantity(orderItemBean.getOrderNum());
			orderItemRepository.save(orderItemEntity);

			itemEntity.setStock(itemEntity.getStock() - orderItemBean.getOrderNum());
			itemRepository.save(itemEntity);
		}


	}
}
