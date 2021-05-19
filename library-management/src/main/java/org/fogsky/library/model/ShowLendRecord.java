package org.fogsky.library.model;

import java.time.LocalDate;

public class ShowLendRecord {
	private String bookName;
	private String bookAuthor;
	private int quantity;
	private LocalDate borrowTime;
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
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
