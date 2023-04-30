package java_sample.lesson15;

public class Phone {
	
	/** 
	 * 使用料金
	 * マイナスの値は不可
	 *  */
	int fee ;
	
	/** 
	 * 通信量
	 * 0～99.99まで対応可能
	 *  */
	double data;
	
	int price ;
	
	// オーバーロード
	public void setInfomation() {
		fee = 4800;
	}
	
	public void setInfomation(int fee) {
		this.fee = fee;
	}
	
	public void setInfomation(double data) {
		this.data = data;
	}
	
	public void setInfomation(int fee,double data) {
		this.fee = fee;
		this.data = data;
	}

	
}
