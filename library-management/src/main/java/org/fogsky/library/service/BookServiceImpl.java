package org.fogsky.library.service;

import java.util.List;

import org.fogsky.library.mapper.BookMapper;
import org.fogsky.library.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
@Component
public class BookServiceImpl implements BookService{
	@Autowired
	private BookMapper bookMapper;
	@Override
	public int addBook(Book book) {
		// TODO Auto-generated method stub
		if(book.getName()!=null&&book.getAuthor()!=null&&book.getQuantity()>0&&book.getQuantityCanBorrow()>=0)
			return bookMapper.insertBook(book);
		return 0;
	}

	@Override
	public List<Book> getBook(Book book) {
		// TODO Auto-generated method stub
		return bookMapper.selectAllOrBy(book);
	}

	@Override
	@Transactional
	public boolean updateBook(Book book) {
		// TODO Auto-generated method stub
		boolean b= bookMapper.updateBook(book);
//			if(b) throw new RuntimeException();
		return b;
	}

	@Override
	public Book getBook(int id) {
		// TODO Auto-generated method stub
		return bookMapper.selectById(id);
	}

}
