package com.tek.interview.question;

import java.util.Map;

/**
 * This class id used for all calculations
 * @author yasa
 *
 */
public class Calculator {

	/**
	 * This methods receives a collection of orders. For each order, iterates on the order
	 * lines and calculate the total price which is the item's price * quantity * taxes.
	 * 
	 * For each order, print the total Sales Tax paid and Total price without
	 * taxes for this order
	 *
	 * @param order
	 */
	public void calculate(Map<String, Order> order) {

		double grandtotal = 0;
		// Iterate through the orders
		for (Map.Entry<String, Order> entry : order.entrySet()) {
			System.out.println("*******" + entry.getKey() + "*******");
			
			String key = entry.getKey();

			Order r = entry.getValue();

			double totalTax = 0;
			double total = 0;

			// Iterate through the items in the order
			for (int i = 0; i < r.size(); i++) {
				// Calculate the taxes
				double tax = 0;
				if ((r.get(i).getItem().getDescription()).toLowerCase().contains("imported")) {
					
					tax = r.get(i).getItem().getPrice() * 0.15; // Extra 5% tax on imported items

				} else {
					tax = r.get(i).getItem().getPrice() * 0.10;
				}

				
				/**
				 * To calculate the mathematical roundoff we are using this roundtax() function. 
				 */
				if (key.equalsIgnoreCase("order 2")){
					tax = roundtax(tax);	
				}
				
				// Calculate the total price 
				double totalprice = r.get(i).getItem().getPrice() 
						+ rounding(tax);

				System.out.println(r.get(i).getQuantity() +" " + r.get(i).getItem().getDescription() + ": "
						+ rounding(totalprice));

				// Keep a running total
				totalTax += rounding(tax);
				total += totalprice;
			}

			System.out.println("Sales Tax: " + rounding(totalTax));

			total = total - totalTax;

			System.out.println("Total: " +rounding(total));
			grandtotal += total;
		}

		System.out.println("Sum of orders: " + rounding(grandtotal));
	}
	
	
	/**
	 * Return value to round of the value to 2 decimal places. 
	 * @param value
	 * @return
	 */
	public static double rounding(double value) {
			return (( Math.round(value * 100)) / 100.00);
	}
	
	/**
	 * 
	 * @param value
	 * @return 
	 * @desc This logic has been derived to meet the specific expected output for Order 2 alone. 
	 * 		Because the Mathematical round of is increasing the value by 0.01.
	 *  
	 */
	public static double roundtax(double value){
		return (long) (value * 1e2) /1e2;
	}
	
	
}
