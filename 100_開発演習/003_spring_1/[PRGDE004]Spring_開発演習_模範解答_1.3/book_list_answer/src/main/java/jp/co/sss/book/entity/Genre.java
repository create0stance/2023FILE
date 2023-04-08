package jp.co.sss.book.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "genre")
public class Genre {


	 /** ジャンルID */
	@Id
    private int genreId;

    /** ジャンル名 */
	@Column
    private String genreName;

	/**
	 * ジャンルIDを取得
	 * @return ジャンルID
	 */
	public int getGenreId() {
		return genreId;
	}

	/**
	 * ジャンルIDを保存
	 * @param genreId ジャンルID
	 */
	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}

	/**
	 * ジャンル名を取得
	 * @return ジャンル名
	 */
	public String getGenreName() {
		return genreName;
	}

	/**
	 * ジャンル名を保存
	 * @param genreName ジャンル名
	 */
	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}



}