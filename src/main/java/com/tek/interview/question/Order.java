package com.tek.interview.question;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents an order which contains an orderline list. Which is
 * used to add OrderLines to List
 *
 * @author yasa
 *
 */
public class Order {

	private List<OrderLine> orderLines;

	public Order() {
		orderLines = new ArrayList<OrderLine>();
	}

	public void add(OrderLine orderline) throws Exception {

		if (orderline == null) {
			throw new IllegalArgumentException("Order is NULL");
		}
		orderLines.add(orderline);
	}

	public int size() {
		return orderLines.size();
	}

	public OrderLine get(int i) {
		return orderLines.get(i);
	}

	public void clear() {
		this.orderLines.clear();
	}
}
