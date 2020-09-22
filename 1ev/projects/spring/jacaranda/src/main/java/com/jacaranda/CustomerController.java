package com.jacaranda;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jacaranda.entity.Customer;

/**
 * Controller to manage customer related requests
 * @author raul
 *
 */

@RestController
@RequestMapping(path="/api")
public class CustomerController {
	private List<Customer> customers = new ArrayList<>() {
		{
			add(new Customer("Ruben", "Dxc", "Sev", "123"));
			add(new Customer("Alvaro", "Geerw", "Sev", "432"));
			add(new Customer("Yi", "Bwerd", "Sev", "678"));
			add(new Customer("Raul", "Sdfe", "Sev", "923"));
		}
	};
	
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		return customers;
	}
	
}
