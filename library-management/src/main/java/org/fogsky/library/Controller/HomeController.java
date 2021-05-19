package org.fogsky.library.Controller;

import java.security.Principal;
import java.util.List;

import org.fogsky.library.model.Book;
import org.fogsky.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@Autowired
	BookService bookService;
	@GetMapping("/log")
	public String home(Principal pc, Model model){
		model.addAttribute("userName", pc.getName());
		return "home";
		
	}
	@GetMapping("/addbook")
	public String addBook(@RequestParam(required=false) Integer id,Model model) {
		if(id!=null) {
			Book bookParam=new Book();
			bookParam.setId(id);
			List<Book> book=bookService.getBook(bookParam);
			model.addAttribute("book", book.get(0));
		}
		return "addbook";
	}
	@PostMapping("/addbook")
	public String addBook(@RequestParam String name,@RequestParam String author,@RequestParam int quantity,
																@RequestParam int quantityCanBorrow){
		if	(name!=null && author!=null && quantity>0)	{
			Book book=new Book();
			book.setName(name);
			book.setAuthor(author);
			book.setQuantity(quantity);
			book.setQuantityCanBorrow(quantityCanBorrow);
			bookService.addBook(book);
		}
		
		return "redirect:/books";
	}
	@GetMapping("/books")
	public String getBooks(Model model) {
		List<Book> books=bookService.getBook(null);
		model.addAttribute("books",books);
		return "books";
	}
}
