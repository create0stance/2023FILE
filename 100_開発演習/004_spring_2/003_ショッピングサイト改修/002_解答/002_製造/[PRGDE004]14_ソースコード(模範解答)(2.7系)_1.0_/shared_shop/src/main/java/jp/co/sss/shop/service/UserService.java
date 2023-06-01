package jp.co.sss.shop.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.sss.shop.bean.UserBean;
import jp.co.sss.shop.entity.User;
import jp.co.sss.shop.form.UserForm;
import jp.co.sss.shop.repository.UserRepository;
import jp.co.sss.shop.util.BeanCopy;
import jp.co.sss.shop.util.Constant;

/**
 * 会員情報サービス
 *
 * @author TEAM_AKIBA
 *
 */
@Service
public class UserService extends SuperService{

	/** ユーザーRepository */
	@Autowired
	UserRepository repository;

	/** セッション */
	@Autowired
	HttpSession session;

	/**
	 * セッションに保存されているユーザー
	 * @return
	 */
	public UserBean getUserBeanFromSessionUserById() {
		return this.getUserBeanById(this.getSessionSaveUserBean().getId());
	}
	/**
	 * ユーザーidからDBデータを取得しユーザーbeanに格納し取得する
	 *
	 * @param id ユーザーid
	 * @return ユーザーbean
	 */
	public UserBean getUserBeanById(Integer id) {

		return BeanCopy.copyUserEntityToUserBean(repository.getOne(id));
	}

	/**
	 * UserFormにidがセットされていない場合、Sessionに保存されているuser.idから
	 * DBデータを取得し、UserFormに格納し返す
	 * @return 	UserForm 会員情報フォームデータ
	 */
	public UserForm getInicialUserForm(UserForm form,String backFlg) {
		if (form.getId() == null && backFlg != "true") {
			return BeanCopy.copyUserToUserForm(repository.getOne(this.getSessionSaveUserBean().getId()));
		}
		return form;
	}

	/**
	 * セッションに保存されているユーザー情報の取得
	 * @return セッションに保存されているUserBean
	 */
	public UserBean getSessionSaveUserBean() {
		return (UserBean) session.getAttribute(Constant.USER_SAVE_KEY);
	}

	/**
	 * セッションに保存されている会員情報とフォームクラスの比較
	 *
	 * @param form フォーム入力値
	 * @return idが一致しているかの判定結果
	 */
	public boolean comparisonFormIdAndBeanId(UserForm form) {
		UserForm sessionForm = BeanCopy.copyUserBeanToUserForm(this.getSessionSaveUserBean());
		return sessionForm.getId() == form.getId();
	}

	/**
	 * 会員情報更新フォームデータをDBに保存
	 * @param form 会員情報フォームデータ
	 * @return 保存した会員情報Entity
	 */
	public User update(UserForm form) {
		User dbUser = repository.getOne(form.getId());
		User saveUser = BeanCopy.copyUserFormToUser(form);
		saveUser.setAuthority(dbUser.getAuthority());
		saveUser.setInsertDate(dbUser.getInsertDate());
		saveUser.setDeleteFlag(dbUser.getDeleteFlag());

		return repository.save(saveUser);

	}

	/**
	 * 会員情報更新フォームデータをDBに保存
	 * @param form 会員情報フォームデータ
	 * @return 保存した会員情報Entity
	 */
	public User insert(UserForm form) {

		form.setAuthority(Constant.SHOP_MEMBER_AUTHORITY);
		form.setDeleteFlag(Constant.DELETED);

		User user = BeanCopy.copyUserFormToUser(form);

		return repository.save(user);
	}

	/**
	 * 一般会員の削除処理(deleteFlgを1にする)
	 * @return 一般会員
	 */
	public User delete() {
		User user = repository.getOne(getSessionSaveUserBean().getId());
		user.setDeleteFlag(Constant.DELETED);

		return repository.save(user);
	}
	/**
	 * セッションに会員情報を保存
	 *
	 * @param user UserEntity
	 */
	public void saveSession(User user) {
		session.setAttribute(Constant.USER_SAVE_KEY, BeanCopy.copyUserEntityToUserBean(user));
	}


}
