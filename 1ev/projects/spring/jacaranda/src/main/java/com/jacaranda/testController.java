package com.jacaranda;

import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
//@RequestMapping(path = "/public-api")
@RequestMapping(path = "${test.controller.root}")
public class testController {
	
	private Logger logger = org.slf4j.LoggerFactory.getLogger(testController.class);
	
	
	//2 formas de utilizar peticiones de tipo GET ---------------------------------------
	
	// ----> 1. @RequestMapping -> GET
	@RequestMapping(path="/prueba", method = RequestMethod.GET)
	public String prueba() {
		logger.warn("Método prueba funcionando --> Ejemplo Warning");
		logger.info("Método prueba funcionando --> Ejemplo Info");
		return "Test OK";
	}
	
	// ----> 2. GetMapping
	@GetMapping(path="/test")
	public String test() {
		logger.error("Método test funcionando --> Ejemplo Error");
		logger.info("Método test funcionando --> Ejemplo Info");
		return "Todo OK";
	}
	//2 formas de utilizar peticiones de tipo GET ---------------------------------------

	
	
	
	//2 formas de utilizar peticiones de tipo POST --------------------------------------
	
	// ----> 1. @RequestMapping -> POST
	@RequestMapping(path="/post1", method = RequestMethod.POST)
	public String post1() {
		return "Post 1 OK";
	}
	
	// ----> 2. PostMapping
	@PostMapping(path="/post2")
	public String post2() {
		return "Post 2 OK";
	}

	//2 formas de utilizar peticiones de tipo POST --------------------------------------

	
	// Post. mostrar nombre
	@PostMapping(path="/hola")
	public ResponseEntity<?> saluda(@RequestParam String nombre) {
		return ResponseEntity.ok("Hola " + nombre);
	}
	
	// Post. mostrar id
	@PostMapping(path="/ident/{id}")
	public String otroSaludo(@PathVariable String id) {
		return ("El id es " + id);
	}

	
	// PUT ---------------------------------
	@PutMapping(path="/mod")
	public ResponseEntity<?> modificar(@RequestParam String param) {
		return ResponseEntity.ok("Parámetro: " + param);
	}
	// PUT ---------------------------------

	
	
	// DELETE ------------------------------
	@DeleteMapping(path="/del")
	public ResponseEntity<?> borrar(@RequestParam String param) {
		return ResponseEntity.ok("Borrado: " + param);
	}
	// DELETE ------------------------------


}
