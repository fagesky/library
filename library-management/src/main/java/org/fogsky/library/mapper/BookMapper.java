package org.fogsky.library.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.fogsky.library.model.Book;

@Mapper
public interface BookMapper {
	List<Book> selectAllOrBy(Book book);
	int insertBook(Book book);
	boolean updateBook(Book book);
	Book selectById(int id);
}
