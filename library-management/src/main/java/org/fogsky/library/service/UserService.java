package org.fogsky.library.service;

import org.fogsky.library.model.LendRecord;
import org.fogsky.library.model.User;

public interface UserService {
	
	int addUser(User user);
	User getUser(String name); 
	void borrowBook(LendRecord record) throws BadParamException;
}
