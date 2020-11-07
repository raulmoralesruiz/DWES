package z_com.jacaranda.entity.old;

import java.util.Comparator;

import com.jacaranda.entity.Customer;

public class ComparaClienteDNI implements Comparator<Customer> {

	@Override
	public int compare(Customer c1, Customer c2) {
		return c1.getDni().compareTo(c2.getDni());
	}
	
	

}
