package com.jacaranda.customer;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import com.jacaranda.entity.ComparaClienteDNI;
import com.jacaranda.entity.ComparaClienteNombre;
import com.jacaranda.entity.Customer;

class TestCustomer {

	private List<Customer> customers = new ArrayList<>() {
		{
			add(new Customer("Ruben", "Dxc", "Sev", "823"));
			add(new Customer("Alvaro", "Geerw", "Sev", "932"));
			add(new Customer("Yi", "Bwerd", "Sev", "178"));
			add(new Customer("Raul", "Sdfe", "Sev", "323"));
		}
	};
	
//	@Test
//	void test() {
//		fail("Not yet implemented");
//		assert(true);
//	}

	
	@Test
	void testFailOnNull() {
		List<Customer> customers = null;
		try {
			customers.stream().sorted();
		} catch (Exception e) {
			assert(false);
		}
	}
	
	
	@Test
	void testFailOnEmpty() {
		List<Customer> cust = new ArrayList<>();
		try {
			cust.stream().sorted();
		} catch (Exception e) {
			assert(false);
		}
		
	}


	
	public List<Customer> getCustomers() {
		return customers;
	}

	@Test
	void testOrderedCollection() {
//		customers.stream().sorted();
		Collections.sort(customers, new ComparaClienteDNI());
		
		System.out.println(getCustomers());
	}

	
	
}
