package org.fogsky.library.model;

import java.io.Serializable;

public class Book implements Serializable{
	private int id;
	private String name;
	private String author;
	private int quantity;
	private int quantityCanBorrow;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getQuantityCanBorrow() {
		return quantityCanBorrow;
	}
	public void setQuantityCanBorrow(int quantityCanBorrow) {
		this.quantityCanBorrow = quantityCanBorrow;
	}
}
