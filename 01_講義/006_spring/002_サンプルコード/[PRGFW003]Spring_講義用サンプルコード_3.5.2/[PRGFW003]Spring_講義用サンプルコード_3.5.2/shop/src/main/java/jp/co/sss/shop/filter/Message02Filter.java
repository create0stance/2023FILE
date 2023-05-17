//11章 複数種類のフィルタを利用する方法　1.フィルタ(1つ目)の作成
package jp.co.sss.shop.filter;
import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Message02Filter extends HttpFilter {
    @Override
    public void doFilter(
     HttpServletRequest request, HttpServletResponse response, FilterChain chain)
     throws IOException, ServletException {
        System.out.println("Done Message02Filter");
        chain.doFilter(request, response);
    }
}

