package in.micheal.test;

import static org.junit.Assert.*;

import org.junit.Test;

import in.micheal.exception.DbException;
import in.micheal.service.CustomerService;

public class SummaTest {

	@Test
	public void test() throws DbException {
		long amount = CustomerService.calculateFine(454545L, "PYTHON EDITION-1");
		System.out.println(amount);
	}

}
