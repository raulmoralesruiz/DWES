package z_com.jacaranda.old;
//package com.jacaranda;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.jacaranda.entity.Category;
//import com.jacaranda.entity.Movie;
//import com.jacaranda.entity.SuscriptionEnum;
//
//@RestController
//@RequestMapping(path = "/netflix")
//public class Old_MovieController {
//	
////	@SuppressWarnings("serial")
////	private List<Movie> movies = new ArrayList<>() {
////		{
////			add(new Movie("Senderos de gloria", SuscriptionEnum.PREMIUM, Category.DRAMA));
////			add(new Movie("La naranja mecánica", SuscriptionEnum.STANDARD, Category.DRAMA));
////			add(new Movie("12 hombres sin piedad", SuscriptionEnum.STANDARD, Category.DRAMA));
////			add(new Movie("Origen", SuscriptionEnum.STANDARD, Category.SCIFI));
////			add(new Movie("El show de Truman", SuscriptionEnum.BASIC, Category.SCIFI));
////		}
////	};
////
////	
////	
////	/**
////	 * Método que comprueba si la película existe, introduciendo el título.	
////	 * @param newTitle (Título de la película)
////	 * @return int (id de la película)
////	 */
////	private int existePeli(String newTitle) {
////		boolean peliEncontrada = false;
////		int id = -1;
////
////		for (int i = 0; i < movies.size() && peliEncontrada == false; i++) {
////			String title = movies.get(i).getTitle();
////			
////			if (newTitle.equalsIgnoreCase(title)) {
////				peliEncontrada = true;	
////				id = movies.get(i).getIdMovie();
////			} 
////		}
////
////		return id;
////	}
////
////
////	
////	/**
////	 * GET. Método para revisar el listado de películas existentes.
////	 * @return
////	 */
////	@GetMapping("/movies")
////	public ResponseEntity<?> leePelis() {
////		
////		ResponseEntity<?> response = null;
////
////		if (movies.isEmpty()) {
////			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("La lista de películas está vacía");
////		} else {
////			response = ResponseEntity.status(HttpStatus.OK).body(movies);
////		}
////
////		return response;
////	}
////	
////	
////	
////	/**
////	 * POST. Creación de película, proporcionando JSON en body
////	 * @param nuevaPeli
////	 * @return
////	 */
////	@PostMapping("/movies")
////	public ResponseEntity<?> creaPeli(@RequestBody Movie nuevaPeli) {
////
////		ResponseEntity<?> response = null;
////		
////		// guardamos el título de la nueva película
////		String newTitle = nuevaPeli.getTitle();
////		
////		// Si la película no existe en la lista de películas...
////		if (existePeli(newTitle) == -1) {
////			//obtenemos el idMovie de la última película
////			int id = movies.get(movies.size() - 1).getIdMovie();
////			
////			//incrementamos el anterior id y lo aplicamos a la nuevaPeli
////			nuevaPeli.setIdMovie(id + 1);
////			
////			//insertamos la película en la lista de películas.
////			movies.add(nuevaPeli);
////			response = ResponseEntity.status(HttpStatus.CREATED).body(nuevaPeli);
////			
////		// Si la película existe en la lista de películas.
////		} else {
////			response = ResponseEntity.status(HttpStatus.CONFLICT).body("ERROR. La película " + newTitle + " ya existe. No se puede crear");
////		}
////		
////		return response;
////	}
////	
////	
////	
////	/**
////	 * PUT. Actualización del título de una película.
////	 * @param oldTitle (Título existente en la lista)
////	 * @param newTitle (Nuevo título)
////	 * @return
////	 */
////	@PutMapping(path="/movies")
////	public ResponseEntity<?> modPeli(@RequestParam String oldTitle, @RequestParam String newTitle)  {
////		
////		ResponseEntity<?> response = null;
////
////		// guardamos el id de las películas old y new (si no existe, será -1)
////		int idOldMovie = existePeli(oldTitle);
////		int idNewMovie = existePeli(newTitle);
////		
////		// Si la película old no existe en la lista de películas...
////		if (idOldMovie == -1) {
////			
////			//mostramos el error
////			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR. La película " + oldTitle + " no existe. No se puede actualizar");
////
////		// Si la old película existe en la lista de películas.
////		} else {
////			
////			// si la nueva película no existe en la lista...
////			if (idNewMovie == -1) {
////				//modificamos el título y devolvemos la película modificada.
////				movies.get(idOldMovie).setTitle(newTitle);
////				response = ResponseEntity.status(HttpStatus.CREATED).body(movies.get(idOldMovie));
////				
////			// si la nueva película ya existe en la lista...
////			} else {
////				
////				//mostramos el error
////				response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR. La película " + newTitle + " ya existe. No se puede actualizar");
////			}
////			
////		}
////		
////		return response;
////	}
////	
////	
////	
////	/**
////	 * DELETE. Eliminación de una película.
////	 * @param title (Título de la película a eliminar)
////	 * @return
////	 */
////	@DeleteMapping(path="/movies")
////	public ResponseEntity<?> borraPeli(@RequestParam String title) {		
////		
////		ResponseEntity<?> response = null;
////
////		// guardamos el id de la película (si no existe, será -1)
////		int idPeli = existePeli(title);
////				
////		// Si la película no existe en la lista de películas...
////		if (idPeli == -1) {
////			
////			//mostramos el error
////			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR. La película " + title + " no existe. No se puede borrar");
////
////		// Si la película existe en la lista de películas.
////		} else {
////			
////			//borramos la película y devolvemos el listado de películas.
////			movies.remove(idPeli);
////			response = ResponseEntity.status(HttpStatus.OK).body(movies);
////		}
////		
////		return response;
////	}
//
//
//}
