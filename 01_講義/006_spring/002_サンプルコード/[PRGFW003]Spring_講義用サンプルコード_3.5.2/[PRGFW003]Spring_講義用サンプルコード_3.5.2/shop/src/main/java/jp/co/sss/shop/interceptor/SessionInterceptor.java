//15章 SpringAOPの実装
package jp.co.sss.shop.interceptor;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SessionInterceptor {
	@Autowired
	private HttpSession session;

	@Before("execution(* jp.co.sss.shop.controller.*.*(..)) &&" +
			"@annotation(org.springframework.web.bind.annotation.RequestMapping)")
	public void printMessage(JoinPoint joinPoint) {
		//セッションからスコープ変数「userId」の値を取得
		Integer userId = (Integer) session.getAttribute("userId");

		System.out.println(userId);
	}

}
