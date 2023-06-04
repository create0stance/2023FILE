package jp.co.sss.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.sss.book.entity.Book;
import jp.co.sss.book.repository.BookRepository;

@RestController
public class BookRestController {
	
	@Autowired
	BookRepository repository;
	
	@RequestMapping("/api/book_find_all")
	public List<Book> bookFindAll(){
		return repository.findAll();
	}
}
