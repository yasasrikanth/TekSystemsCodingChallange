package com.tek.interview.question;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class OrderTest {

	@Rule
    public ExpectedException thrown= ExpectedException.none();
	
	Order order1 = new Order();
	
	@After
	public void tearDown() throws Exception {
		order1.clear();
	}

	@Test
	public void testOneOrder() throws Exception {
		
		Item item1 = new Item("Pen", 2f);
		OrderLine orderline1 = new OrderLine(item1, 2);
		order1.add(orderline1);
		
		assertEquals(1, order1.size());
		
		assertEquals(orderline1, order1.get(0));
		
	}
	
	@Test
	public void testNullOrder() throws Exception {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Order is NULL");
		
		OrderLine orderline2 = null;
		order1.add(orderline2);
	}

}
