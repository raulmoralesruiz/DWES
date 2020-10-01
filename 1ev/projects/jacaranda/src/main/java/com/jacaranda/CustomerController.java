package com.jacaranda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jacaranda.entity.ComparaClienteDNI;
import com.jacaranda.entity.ComparaClienteNombre;
import com.jacaranda.entity.Customer;

/**
 * Controller to manage customer related requests
 * 
 * @author raul
 *
 */

@RestController
@RequestMapping(path = "/api")
public class CustomerController {
	private List<Customer> customers = new ArrayList<>() {
		{
			add(new Customer("Ruben", "Dxc", "Sev", "823"));
			add(new Customer("Alvaro", "Geerw", "Sev", "932"));
			add(new Customer("Yi", "Bwerd", "Sev", "178"));
			add(new Customer("Raul", "Sdfe", "Sev", "323"));
		}
	};

	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		// Se ordena la lista de clientes
		Collections.sort(customers, new ComparaClienteDNI());

		// Se devuelve la lista de clientes ordenada
		return customers;
	}
	
	
	@GetMapping("/ordenado")
	public ResponseEntity<?> ordena(@RequestParam String parametro) {
		
		if (parametro.equalsIgnoreCase("dni")) {
			Collections.sort(customers, new ComparaClienteDNI());
		}
		
		if (parametro.equalsIgnoreCase("nombre")) {
			Collections.sort(customers, new ComparaClienteNombre());
		}
				
		return ResponseEntity.ok(customers);
	}

	
	@GetMapping("/sorted")
	public ResponseEntity<?> sorted(@RequestParam String parametro) {
				
		ResponseEntity<?> response = null;
		customers = null; //new ArrayList<>();

		
		if (customers.isEmpty()) {
			response = ResponseEntity.
					status(HttpStatus.NOT_FOUND).body("La lista está vacía");
		} else {
			response = ResponseEntity.status(HttpStatus.OK).body(customers);
		}
		
		return response;
	}
	

	// ---------------- CREAR CRUD, con los correspondientes mensajes HTTP ----------------

	// LEER
	@GetMapping("/leer")
	public ResponseEntity<?> leeClientes() {
		
		ResponseEntity<?> response = null;

		if (customers.isEmpty()) {
			response = ResponseEntity.
					status(HttpStatus.NOT_FOUND).body("La lista está vacía");
		} else {
			// Se ordena la lista de clientes
			Collections.sort(customers, new ComparaClienteNombre());
			
			response = ResponseEntity.status(HttpStatus.OK).body(customers);
		}
		
		// Se devuelve la lista de clientes ordenada
		return response;
	}

	
	
	// CREAR
	
	// Creación de usuario, proporcionando JSON en body
	@PostMapping("/crear")
	public ResponseEntity<?> creaCliente(@RequestBody Customer nuevo) {
		customers.add(nuevo);
		return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
	}

	
	// Creación de usuario, sólo campo nombre
	@PostMapping(path = "/crea")
	public ResponseEntity<?> creaCli(@RequestParam String name) {
		
		Customer newCust = new Customer();
		newCust.setName(name);
		
		customers.add(newCust);
				
		return ResponseEntity.status(HttpStatus.CREATED).body(newCust);
	}
	
	
	
	// ACTUALIZAR	
	@PutMapping(path="/mod")
	public ResponseEntity<?> modCli(@RequestParam String oldName, @RequestParam String newName)  {
		
		ResponseEntity<?> response = null;
		boolean custEncontrado = false;
		
		for (int i = 0; i < customers.size() && custEncontrado == false; i++) {
			String nombre = customers.get(i).getName();
			
			if (nombre.equalsIgnoreCase(oldName)) {
				custEncontrado = true;
				
				customers.get(i).setName(newName);
				
				response = ResponseEntity.status(HttpStatus.OK).body(customers);
			} else {
				response = ResponseEntity.
						status(HttpStatus.NOT_FOUND).body("ERROR. Cliente no encontrado.");
			}
		}
		
		return response;
	}

	
	
//	@PutMapping(path="/modificar")
//	public Customer updateCustomer(@RequestBody Customer actualizado) {
//		Customer customerToUpdate = null;
//		
//		for (Customer c : customers) {
//			if (actualizado.getName().equalsIgnoreCase(c.getName())) {
//				actualizado = c;
//			}
//		}
//		
//		actualizado = customers.stream().filter(c -> c.getName().equalsIgnoreCase(c.getName()))
//				.findFirst().orElse(new Customer());
//		
//		return null;
//	}
	
	
	// BORRAR
	@DeleteMapping(path="/borra")
	public ResponseEntity<?> borraCli(@RequestParam String name) {
		
		ResponseEntity<?> response = null;
		boolean custEncontrado = false;
		
		for (int i = 0; i < customers.size() && custEncontrado == false; i++) {
			String nombre = customers.get(i).getName();
			
			if (nombre.equalsIgnoreCase(name)) {
				custEncontrado = true;
				customers.remove(customers.get(i));
				
				response = ResponseEntity.status(HttpStatus.OK).body(customers);
			} else {
				response = ResponseEntity.
						status(HttpStatus.NOT_FOUND).body("ERROR. Cliente no encontrado.");
			}
		}
		
		return response;
	}

	
	
}
