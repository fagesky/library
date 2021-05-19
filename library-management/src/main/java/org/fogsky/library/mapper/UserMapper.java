package org.fogsky.library.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.fogsky.library.model.User;

@Mapper
public interface UserMapper {
	int insertUser(User user);
	User selectUserByIdOrName(User user);
	List<User> selectAll();
	int updateUserById(User user);
}
