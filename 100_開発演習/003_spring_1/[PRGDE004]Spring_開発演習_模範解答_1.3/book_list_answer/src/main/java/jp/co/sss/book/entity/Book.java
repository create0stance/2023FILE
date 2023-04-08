package jp.co.sss.book.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
　 * bookエンティティ
 *
 */
@Entity
@Table(name = "book")
public class Book {

	/** 書籍ID */
	@Id
	private int bookId;


	/** 書籍名 */
	@Column
	private String bookName;

	/** 著者 */
	@Column
	private String author;

    /** 発行日 */
	@Column
    private Date publicationDate;

    /** 在庫 */
	@Column
	private int stock;

    /** ジャンル情報 */
    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "genreId")
    private Genre genre;

	/**
	 * 書籍IDを取得
	 * @return 書籍ID
	 */
	public int getBookId() {
		return bookId;
	}


	/**
	 * 書籍IDを保存
	 * @param bookId 書籍ID
	 */
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	/**
	 * 書籍名を取得
	 * @return 書籍名
	 */
	public String getBookName() {
		return bookName;
	}


	/**
	 * 書籍名を保存
	 * @param bookName 書籍名
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	/**
	 * 著者を取得
	 * @return 著者
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * 著者を保存
	 * @param author 著者
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * 発行日を取得
	 * @return 発行日
	 */
	public String getPublicationDate() {

//		YYYY/MM/dd型へフォーマット
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		String date = dateFormat.format(publicationDate);
		return date;
	}

	/**
	 * 発行日を保存
	 * @param publicationDate 発行日
	 */
	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;

	}

	/**
	 * 在庫を取得
	 * @return 在庫
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * 在庫を保存
	 * @param stock 在庫
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	/**
	 * ジャンル情報を取得
	 * @return ジャンル情報
	 */
	public Genre getGenre() {
		return genre;
	}

	/**
	 * ジャンル情報を保存
	 * @param genre ジャンル情報
	 */
	public void setGenre(Genre genre) {
		this.genre = genre;
	}


}