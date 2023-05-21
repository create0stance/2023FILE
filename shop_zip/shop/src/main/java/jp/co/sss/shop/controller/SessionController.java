package jp.co.sss.shop.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.shop.form.LoginForm;
import jp.co.sss.shop.service.SessionService;

@Controller
public class SessionController {
	
	public SessionController(){
		System.out.println("SessionControllerが作成されました。");
	}

	/**
	 * ログインページの表示
	 * @return ログインページビュー
	 */
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String login() {
		return "session/login";
	}

	/**
	 * ログインフォームで入力された
	 * ユーザーIDを取得しコンソールに出力
	 * @param userId ユーザーID
	 * @return ログインページ
	 */
	@RequestMapping(path = "/doLogin", method = RequestMethod.GET)
	// パラメータ名と同名の変数を引数に置いとくと
	// パラメータ値が代入(バインド)される
	public String doLoginGet(Integer userId, String password) {
		System.out.println(password);
		System.out.println(userId);
		return "session/login";
	}

	/**
	 * POSTされたuserIdの値をコンソール出力
	 * @param userId
	 * @return ログインページビュー
	 */
	@RequestMapping(path = "/doLogin", method = RequestMethod.POST)
	public String doLoginPost(Integer userId) {

		System.out.println(userId);

		// ビューのパス指定
		//		return "session/login";
		return "redirect:/login";
	}

	/**
	 * ログインフォーム表示
	 * @return ログインフォームビューパス
	 */
	@GetMapping("loginUsingForm")
	public String loginUsingForm() {
		return "session/loginUsingForm";
	}

	/**
	 * コントローラーの引数にフォームクラスを使う
	 * @param form 
	 * Loginフォームから送信されたデータを保持するクラス
	 * @return ログインフォームビュー
	 */
	@PostMapping("doLoginUsingForm")
	public String doLoginUsingForm(LoginForm form) {
		System.out.println(form.getUserId());
		System.out.println(form.getPassword());

		return "session/loginUsingForm";
	}

	/**
	 * リクエストスコープに保存されたデータを使う
	 * @return
	 */
	@RequestMapping(path = "/loginOnRequest", method = RequestMethod.GET)
	public String loginOnRequest() {
		return "session/loginOnRequest";
	}

	/**
	 * ログインフォームから送信されたデータをビューに渡す
	 * @param model BindingAwareModelMap リクエストされたデータを管理するHashMap
	 * @param form ログインフォームから送信されたデータ
	 * @return ログインフォームビュー
	 */
	@RequestMapping(path = "/doLoginOnRequest", method = RequestMethod.POST)
	public String doLoginOnRequest(Model model, LoginForm form) {

		// 【この場合のModel実装クラス】BindingAwareModelMap
		// バインドされているオブジェクトをHashMapに保管し管理する
		// クラス名をキーとして値が保存される。

		// リクエストスコープにuserIdを保存
		model.addAttribute("userId", form.getUserId());

		// ビューへ処理を移行
		return "session/loginOnRequest";
	}

	/**
	 * sessionにフォームデータを保存する
	 * @return ログインフォームビューパス
	 */
	@RequestMapping(path = "loginOnSession", method = RequestMethod.GET)
	public String loginOnSession() {
		return "session/loginOnSession";
	}

	/**
	 * ログインフォームの送信データを受け取り
	 * ログイン可能ならSessionにuserIdを保存し
	 * TOPページへリダイレクト。
	 * ログイン不可なら、再度ログインページを表示
	 * @param form LoginFormクラス
	 * @param session HttpSession
	 * @return ビューパス
	 */
	@Autowired
	SessionService service;
	
	@RequestMapping(path = "doLoginOnSession", method = RequestMethod.POST)
	public String doLoginOnSession
	(LoginForm form, HttpSession session) {
		
		// ログインOKならsessionにuserIdを保存し、
		// TOPページへリダイレクト
		if(service.checkLogin(form.getUserId())) {
			// sessionに変数名(キー)userIdで入力されたIDを保存
			session.setAttribute("userId", form.getUserId());

			return "redirect:/";
		}
		
		return "session/loginOnSession";
		
	}

	/**
	 * sessionを破棄
	 * @param session
	 * @return
	 */
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		// sessionを破棄
		session.invalidate();
		return "session/logout";
	}

	/**
	 * リクエストスコープ（Model）に保存されているオブジェクトを一覧表示
	 * @param model Model
	 * @return LinkedHashMap
	 */
	public Map<String, Object> showModelInfoAndReturnMap(Model model) {

		if (model == null) {
			return null;
		}
		System.out.println("----------------------------------");
		// リクエストスコープに保存されているMap(LinkedHashMap)の取得
		Map<String, Object> modelMap = model.asMap();
		//Modelの実装クラス名を取得
		System.out.println(model.getClass().getName());

		// Mapをループ処理しキーと値をコンソール出力
		for (Entry<String, Object> entry : modelMap.entrySet()) {
			System.out.println("key:" + entry.getKey());
			System.out.println(entry.getValue());
		}
		System.out.println("----------------------------------");
		return modelMap;
	}

	

	/**
	 * ログインフォームをシリアライズ、デシリアライズする
	 * ※試す場合は、LoginFormクラスでimplements Serializableしてください。 
	 * @param form LoginForm
	 * @param isDeserialize デシリアライズする場合、true
	 * @return 
	 */
	public LoginForm serializer(LoginForm form, boolean isDeserialize) {
		String fileName = "loginForm.txt";
		
		if(isDeserialize) {
			try {
				LoginForm formDe = deSerialize(fileName);
				System.out.println("デシリアライズ後");
				System.out.println(formDe);
				System.out.println(formDe.getPassword());
				System.out.println(formDe.getUserId());
				System.out.println("----------------------------");
				return formDe;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			serialize(form, fileName);
			System.out.println(form + "をシリアライズしました。");
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		System.out.println(form.getUserId());
		return form;
	}

	/**
	 * LoginFormをシリアライズ（バイトコードで直列化）する
	 * @param form LoginForm
	 * @param fileName ファイルパス
	 * @throws IOException 
	 */
	private void serialize(LoginForm form, String fileName) throws IOException {
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

	/**
	 * シリアライズされたLoginFormをデシリアライズする。
	 * @param fileName シリアライズされたバイトコードが記載されているファイルパス
	 * @return デシリアライズされたLoginForm
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private LoginForm deSerialize(String fileName) throws IOException, ClassNotFoundException {
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
}
