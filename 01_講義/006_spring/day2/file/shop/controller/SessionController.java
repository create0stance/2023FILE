package jp.co.sss.shop.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.shop.form.LoginForm;

@Controller
public class SessionController {
	
	@ModelAttribute(name = "query")
	public String test () {
		return "12345";
	}
	@RequestMapping(path="/login",method=RequestMethod.GET)
	public String login() {
		return "session/login";
	}
	
	@RequestMapping(path="/doLogin",method=RequestMethod.GET)
	public String doLoginGet(Integer userId) {
		System.out.println(userId);
		return "session/login";
	}
	
	@RequestMapping(path="/doLogin",method=RequestMethod.POST)
	public String doLoginPost(Integer userId,Model model) {
			
		System.out.println(userId);
		return "session/login";
	}
	
	@GetMapping("loginUsingForm")
	public String loginUsingForm(LoginForm form) {
		 String fileName = "loginForm.txt";
		 form.setPassword("12345");
		 form.setUserId(100);

	        // Languageクラスをインスタンス化
	        try {
	            serialize(form, fileName);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	        try {
	        	LoginForm formDe = deSerialize(fileName);
	        	System.out.println("デシリアライズ後");
	        	System.out.println(formDe);
	        	System.out.println(formDe.getPassword());
	        	System.out.println(formDe.getUserId());
	        	System.out.println("----------------------------");
			} catch (Exception e) {
				e.printStackTrace();
			}
		System.out.println(form.getUserId());
		return "session/loginUsingForm";
	}
	void serialize(LoginForm form, String fileName) throws IOException {
        // わかりやすくするために冗長に書いている
        // ファイルを指定して、FileOutputStreamを生成
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        System.out.println(fileName);
        System.out.println(fileOutputStream);
        // OutputStreamに基本データ型とオブジェクトのグラフをOutputStreamに書き込む
        // 今回は、FileOutputStreamに書き込む
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        // 特定のクラスのオブジェクトの状態をストリームに書き込む
        objectOutputStream.writeObject(form);
        objectOutputStream.flush();

        objectOutputStream.close();
    }
	
	LoginForm deSerialize(String fileName) throws IOException, ClassNotFoundException {
        // わかりやすくするために冗長に書いている
        // ファイルを指定して、FileInputStreamを生成
        FileInputStream fileInputStream = new FileInputStream(fileName);
        // 事前にObjectOutputStreamを使って作成されたプリミティブ・データとプリミティブ・オブジェクトを直列化復元する
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        // 対応するwriteObjectメソッドによってストリームに書き込まれたデータを使用する特定のクラスのオブジェクトの状態を読み込み、復元する
        LoginForm form = (LoginForm) objectInputStream.readObject();

        objectInputStream.close();

        return form;
    }
	/**
	 * コントローラーの引数にフォームクラスを使う
	 * @param form Loginフォームから送信されたデータを保持するクラス
	 * @return ログインフォームビュー
	 */
	@PostMapping("doLoginUsingForm")
	public String doLoginUsingForm(@ModelAttribute(name = "query") String query,LoginForm form,Model model) {
		
		showModelInfoAndReturnMap(model);
		System.out.println(query);
		System.out.println(form.getUserId());
		System.out.println(form.getPassword());
		return "session/loginUsingForm";
	}
	
	@RequestMapping(path="/loginOnRequest" ,method = RequestMethod.GET)
	public String loginOnRequest() {
		return "session/loginOnRequest";
	}
	/**
	 * ログインフォームから送信されたデータをビューに渡す
	 * @param model BindingAwareModelMap リクエストされたデータを管理するHashMap
	 * @param form ログインフォームから送信されたデータ
	 * @return ログインフォームビュー
	 */
	@RequestMapping(path="/doLoginOnRequest" ,method = RequestMethod.POST)
	public String doLoginOnRequest(BindingAwareModelMap model,LoginForm form) {
		
		// BindingAwareModelMap・・・バインドされているオブジェクトをMapに保管し管理する
		// クラス名をキーとして値が保存される。
	
		// リクエストスコープにuserIdを保存
		model.addAttribute("userId",form.getUserId());
		
		showModelInfoAndReturnMap(model);
		
		System.out.println(((LoginForm)model.getAttribute("loginForm")).getUserId());
		

		
		
		// ビューへ処理を移行
		return "session/loginOnRequest";
	}
	
	@RequestMapping(path="loginOnSession",method = RequestMethod.GET)
	public String loginOnSession() {
		return "session/loginOnSession";
	}
	
	@RequestMapping(path = "doLoginOnSession",method = RequestMethod.POST)
	public String doLoginOnSession(LoginForm form ,Model model,HttpSession session) {
		model.addAttribute("userId",form.getUserId());
		if(!Objects.isNull(form.getUserId()) &&  form.getUserId().equals(123)) {
			session.setAttribute("userId", form.getUserId());
			return "index";
		}else {
			return "session/loginOnSession";
		}
	}
	
	public String logout(HttpSession session) {
		// sessionを破棄
		session.invalidate();
		return "logout";
	}
	public Map<String,Object> showModelInfoAndReturnMap (Model model) {
		
		if(model == null) {
			return null;
		}
		System.out.println("----------------------------------");
		Map<String, Object> modelMap = model.asMap();
		System.out.println(model.getClass().getName());
		for (Entry<String, Object> entry : modelMap.entrySet()) {
			System.out.println("key:" + entry.getKey());
			System.out.println(entry.getValue());
		}
		System.out.println("----------------------------------");
		return modelMap;
	}
}
