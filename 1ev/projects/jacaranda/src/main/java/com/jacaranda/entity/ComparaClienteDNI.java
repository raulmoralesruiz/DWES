package com.jacaranda.entity;

import java.util.Comparator;

public class ComparaClienteDNI implements Comparator<Customer> {

	@Override
	public int compare(Customer c1, Customer c2) {
		return c1.getDni().compareTo(c2.getDni());
	}
	
	

}
