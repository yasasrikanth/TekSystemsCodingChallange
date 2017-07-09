package com.tek.interview.question;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class OrderLineTest {

	@Rule
    public ExpectedException thrown= ExpectedException.none();
	
	@Test
	public void testNullOrderLine() throws Exception {
		thrown.expect(Exception.class);
		thrown.expectMessage("Item is NULL");
		
		Item item1 = null;
		OrderLine orderLine = new OrderLine(item1, 0);
	}
	
	@Test
	public void testOrderLine() throws Exception {
		
		Item item1 = new Item("Book", 5f);
		OrderLine orderLine = new OrderLine(item1, 1);
		
		junit.framework.Assert.assertNotNull(orderLine);
	}

}
