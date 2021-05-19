package org.fogsky.library.Controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.fogsky.library.mapper.LendRecordMapper;
import org.fogsky.library.model.Book;
import org.fogsky.library.model.LendRecord;
import org.fogsky.library.model.ShowLendRecord;
import org.fogsky.library.model.User;
import org.fogsky.library.service.BadParamException;
import org.fogsky.library.service.BookService;
import org.fogsky.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	
	@Autowired
	LendRecordMapper lendRecordMapper;
	@Autowired
	BookService bookService;
	@Autowired
	@Qualifier("userServiceImpl")
	UserService userService;
	@Autowired
	PasswordEncoder passwordEncoder;
	@GetMapping("/adduser")
	public String addUser() {
		return "adduser";
	}
	@PostMapping("/adduser")
	@ResponseBody
	public Object addUser(@Valid User user,BindingResult result) {
		String errors=null;
		if(result.hasErrors()) {
			errors=result.getAllErrors().stream().map(ObjectError::getDefaultMessage)
																	.reduce((m1,m2) -> m1+";"+m2).orElse("参数有误");
		System.out.println(errors);
		return errors;
		}
		else {
			String password=user.getPassword();
			user.setPassword(passwordEncoder.encode(password));
			userService.addUser(user);
		}
		return user;
	}
	@GetMapping("/borrowbook/{id}")
	public String bookBorrowed(@PathVariable("id") int bookId,Principal user) throws BadParamException {
		LendRecord record=new LendRecord();
		record.setBookId(bookId);
		record.setQuantity(1);
		record.setUserName(user.getName());
		userService.borrowBook(record);
		return "redirect:/borrowbook";
	}
	@GetMapping("/borrowbook")
	public String borrowBook(Principal user,Model model) throws BadParamException {
		
		List<LendRecord> list=lendRecordMapper.selectLendRecordByUserNameOrAndByBookId(user.getName(),0);
		List<Book> books=new ArrayList<>();
		for(LendRecord lendRecord:list) {
			books.add(bookService.getBook(lendRecord.getBookId()));
		}
		List<ShowLendRecord> records=new ArrayList<>();
		for(int i=0;i<books.size();i++) {
			ShowLendRecord showLendRecord=new ShowLendRecord();
			showLendRecord.setBookName(books.get(i).getName());
			showLendRecord.setBookAuthor(books.get(i).getAuthor());
			showLendRecord.setQuantity(list.get(i).getQuantity());
			showLendRecord.setBorrowTime(list.get(i).getBorrowTime());
			records.add(showLendRecord);
		}
		model.addAttribute("record", records);
		return "borrowedbooks";
	}
}
