package org.fogsky.library.model;

import java.io.Serializable;
import java.time.LocalDate;

public class LendRecord implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3244325L;
	private String userName;
	private int bookId;
	private int quantity;
	private LocalDate borrowTime;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String string) {
		this.userName = string;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public LocalDate getBorrowTime() {
		return borrowTime;
	}
	public void setBorrowTime(LocalDate borrowTime) {
		this.borrowTime = borrowTime;
	}
	
}
