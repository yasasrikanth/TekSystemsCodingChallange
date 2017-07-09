package com.tek.interview.question;

/**
 * Item POJO with price and description of an item
 * 
 * @author yasa
 *
 */
public class Item {

	private String description;
	private float price;

	public Item(String description, float price) {
		super();
		this.description = description;
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public float getPrice() {
		return price;
	}
}
