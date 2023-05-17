package jp.co.sss.shop.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sss.shop.bean.ItemBean;
import jp.co.sss.shop.bean.Test1;
import jp.co.sss.shop.bean.Test2;

@Controller
public class TestController {

	@RequestMapping(value = {"/test"})
//	@ResponseBody
	public String index() {
		ItemBean item = new ItemBean(1,"mikan");
		Test1 test1 = new Test1("tanaka",1,item);
		Test2 test2 = new Test2(null, null, null);
	
		// ★BeanUtils.copyProperties
		// オブジェクトをディープコピーする。
		// 別のクラスの同じ名称のフィールドへ値をコピー。
		// 型の変換も行ってくれるが、基本的に違う型への変換はデフォルトでは行ってくれないため過信は禁物。
		// 異なる型のフィールドへ変換するにはConverterインターフェイスを継承し、独自のコンバーターを作成し、利用する必要がある。
//		Convert
		BeanUtils.copyProperties(test1, test2,"id","name");
		System.out.println(test1);
		System.out.println("---------------------------");
		System.out.println(test2);
		return "index";
	}
	
}
