package jp.co.sss.shop.form;

import javax.validation.constraints.NotBlank;

public class PaymentForm {

	/**
	 * 支払い方法(値)
	 */
	@NotBlank
	private Integer	payMethod;

	/**
	 * 支払い方法(名称)
	 */
	private String	payMethodText;

	public Integer getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(Integer payMethod) {
		this.payMethod = payMethod;
	}

	/**
	 * @return payMethodText
	 */
	public String getPayMethodText() {
		return payMethodText;
	}

	/**
	 * @param payMethodText セットする payMethodText
	 */
	public void setPayMethodText(String payMethodText) {
		this.payMethodText = payMethodText;
	}


}
