package jp.co.sss.shop.service;

import org.springframework.stereotype.Service;

@Service
public class SessionService {
	public SessionService() {
		System.out.println("SessionServiceが作成されました。");
	}
	/**
	 * ログイン可能なuserIdかチェックする
	 * @param userId 
	 * @return ログイン可能ならtrue
	 */
	public Boolean checkLogin(Integer userId) {
		return userId != null && userId.equals(123);
	}
}
