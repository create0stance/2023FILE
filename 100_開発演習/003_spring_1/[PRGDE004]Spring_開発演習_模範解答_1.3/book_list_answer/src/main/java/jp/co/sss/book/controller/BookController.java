package jp.co.sss.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sss.book.entity.Genre;
import jp.co.sss.book.repository.BookRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository bookRepository;


	@RequestMapping("/all")
	public String BookListAll(Model model) {
        model.addAttribute("books", bookRepository.findAll());
		return "list";
	}

	@RequestMapping("/book_name")
	public String searchByBookName(String bookName,Model model) {
        model.addAttribute("books", bookRepository.findByBookNameLike("%"+bookName+"%"));
		return "list";
	}

	@RequestMapping("/genre_id")
	public String searchByGenre(int genreId,Model model) {
		Genre genre = new Genre();
		genre.setGenreId(genreId);
        model.addAttribute("books", bookRepository.findByGenre(genre));
		return "list";
	}


}
