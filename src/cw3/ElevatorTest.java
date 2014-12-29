package cw3;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

/**
 * @author fgrami01 & jbukow01
 *
 */

public class ElevatorTest {

	@Test
	public void test() {
		Customer cust = new Customer(8, 2, 4);
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		customerList.add(cust);
		Elevator elevator = new Elevator(customerList, 8, 0);
		elevator.defaultStrategy();
		assertEquals("Number of floors", 8, 8);

	}
}