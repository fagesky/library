package org.fogsky.library.service;

import java.util.List;

import org.fogsky.library.mapper.LendRecordMapper;
import org.fogsky.library.mapper.UserMapper;
import org.fogsky.library.model.Book;
import org.fogsky.library.model.LendRecord;
import org.fogsky.library.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserMapper userMapper;
	@Autowired
	BookService bookService;
	@Autowired
	LendRecordMapper lendRecordMapper;
	
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.insertUser(user);
	}
	@Override
	public User getUser(String name) {
		// TODO Auto-generated method stub
		User userParam=new User();
		userParam.setName(name);
		User user=userMapper.selectUserByIdOrName(userParam);
		System.out.println("user 为:"+user);
		return user;
	}
	@Override
	@Transactional
	public void borrowBook(LendRecord record) throws BadParamException {
		// TODO Auto-generated method stub
		Book book=new Book();
		book.setId(record.getBookId());
		int oldQuantityCanBorrow=bookService.getBook(book).get(0).getQuantityCanBorrow();
		int lendQuantity=record.getQuantity();
		if(record.getQuantity()<1 ||lendQuantity>oldQuantityCanBorrow)
			throw new BadParamException("quantity:"+lendQuantity);
		else {
			book.setQuantityCanBorrow(oldQuantityCanBorrow-lendQuantity);
			bookService.updateBook(book);
			List<LendRecord> list=lendRecordMapper.selectLendRecordByUserNameOrAndByBookId(record.getUserName()
													,record.getBookId());
			if(list.isEmpty())
				lendRecordMapper.insertLendRecord(record);
			else {
				record.setQuantity(list.get(0).getQuantity()+lendQuantity);
				lendRecordMapper.updateLendRecord(record);
			}
		}
//		throw new RuntimeException();
	}
	
	


}
