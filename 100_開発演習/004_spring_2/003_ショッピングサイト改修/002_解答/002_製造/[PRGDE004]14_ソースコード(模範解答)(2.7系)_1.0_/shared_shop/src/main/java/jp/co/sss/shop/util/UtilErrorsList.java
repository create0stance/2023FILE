package jp.co.sss.shop.util;

import java.util.ArrayList;
import java.util.List;

/**
 * エラー文保持クラス
 * @author TEAM_AKIBA
 *
 */
public class UtilErrorsList {

	/** エラーリスト */
	private List<String> errorList = new ArrayList<String>();

	/**
	 * エラー文をセットし、errorListを返す
	 * @param error エラー文
	 * @return errorList
	 */
	public List<String> setError(String error) {
		this.errorList.add(error);
		return this.errorList;
	}

	/**
	 * エラー文リストを返す
	 * @return エラー文リスト
	 */
	public List<String> getErrorList() {
		return errorList;
	}


}
