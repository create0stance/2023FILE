package jp.co.sss.shop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jp.co.sss.shop.util.UtilErrorsList;

/**
 * サービス親クラス
 *
 * @author TEAM_AKIBA
 */
@Service
public class SuperService {

	/**
	 * エラー文をエラーリストにセットし返す
	 * @param error エラー文
	 * @return エラーリスト
	 */
	public List<String> resetErrorsAndSetError(String error) {
		UtilErrorsList errorList = new UtilErrorsList();
		return errorList.setError(error);
	}
}
