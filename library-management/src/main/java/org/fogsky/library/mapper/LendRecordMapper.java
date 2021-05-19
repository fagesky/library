package org.fogsky.library.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.fogsky.library.model.LendRecord;

@Mapper
public interface LendRecordMapper {
	boolean insertLendRecord(LendRecord record);
	List<LendRecord> selectLendRecordByUserNameOrAndByBookId(String userName,int bookId);
	int  updateLendRecord(LendRecord record);
}
