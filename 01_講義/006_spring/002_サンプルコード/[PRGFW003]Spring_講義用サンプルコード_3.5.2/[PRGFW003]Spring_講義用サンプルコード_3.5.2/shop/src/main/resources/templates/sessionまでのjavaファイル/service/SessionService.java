package jp.co.sss.shop.service;

import org.springframework.stereotype.Service;

@Service
public class SessionService {
	public Boolean checkLogin(Integer userId) {
		return userId != null && userId.equals(123);
	}
}
