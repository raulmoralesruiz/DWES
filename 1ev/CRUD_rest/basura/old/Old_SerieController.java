package z_com.jacaranda.old;
//package com.jacaranda;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
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
//import com.jacaranda.entity.Serie;
//import com.jacaranda.entity.SuscriptionEnum;
//
//
//@RestController
//@RequestMapping(path = "/netflix")
//public class Old_SerieController {
//	
////	@Autowired
////	private SerieService service;
////
////	
////	@SuppressWarnings("serial")
////	private List<Serie> series = new ArrayList<>() {
////		{
////			add(new Serie("Black Mirror", SuscriptionEnum.PREMIUM, Category.SCIFI));
////			add(new Serie("Dark", SuscriptionEnum.STANDARD, Category.SCIFI));
////			add(new Serie("Breaking Bad", SuscriptionEnum.STANDARD, Category.DRAMA));
////			add(new Serie("Stranger Things", SuscriptionEnum.STANDARD, Category.SCIFI));
////			add(new Serie("Friends", SuscriptionEnum.BASIC, Category.COMEDIA));
//////			add(new Serie());
////		}
////	};
////
////	
////	
////	/**
////	 * Método que inserta título por defecto a las series que no lo tienen.
////	 */
////	private void insertaTitulo() {
////		for (Serie s : series) {
////			if (!service.isValidTitle(s.getTitle())) {
////				s.setTitle("default_title");
////			}
////		}
////	}
////	
////	
////	
////	/**
////	 * Método que comprueba si la serie existe, introduciendo el título.	
////	 * @param newTitle (Título de la serie)
////	 * @return int (id de la serie)
////	 */
////	private int existeSerie(String newTitle) {
////		boolean serieEncontrada = false;
////		int id = -1;
////
////		for (int i = 0; i < series.size() && serieEncontrada == false; i++) {
////			String title = series.get(i).getTitle();
////			
////			if (newTitle.equalsIgnoreCase(title)) {
////				serieEncontrada = true;	
////				id = series.get(i).getIdSerie();
////			} 
////		}
////
////		return id;
////	}
////
////
////	
////	/**
////	 * GET. Método para revisar el listado de series existentes.
////	 * @return
////	 */
////	@GetMapping("/series")
////	public ResponseEntity<?> leeSeries() {
////		
////		ResponseEntity<?> response = null;
////
////		if (series.isEmpty()) {
////			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("La lista está de series vacía");
////		} else {
////			insertaTitulo();
////			response = ResponseEntity.status(HttpStatus.OK).body(series);
////		}
////
////		return response;
////	}
////	
////	
////	
////	/**
////	 * POST. Creación de serie, proporcionando JSON en body
////	 * @param nuevaSerie
////	 * @return
////	 */
////	@PostMapping("/series")
////	public ResponseEntity<?> creaSerie(@RequestBody Serie nuevaSerie) {
////
////		ResponseEntity<?> response = null;
////		
////		// guardamos el título de la nueva serie
////		String newTitle = nuevaSerie.getTitle();
////		
////		// Si la serie no existe en la lista de series...
////		if (existeSerie(newTitle) == -1) {
////			//obtenemos el idSerie de la última serie
////			int id = series.get(series.size() - 1).getIdSerie();
////			
////			//incrementamos el anterior id y lo aplicamos a la nuevaSerie
////			nuevaSerie.setIdSerie(id + 1);
////			
////			//insertamos la serie en la lista de series.
////			series.add(nuevaSerie);
////			response = ResponseEntity.status(HttpStatus.CREATED).body(nuevaSerie);
////			
////		// Si la serie existe en la lista de series.
////		} else {
////			response = ResponseEntity.status(HttpStatus.CONFLICT).body("ERROR. La serie " + newTitle + " ya existe. No se puede crear");
////		}
////		
////		return response;
////	}
////	
////	
////	
////	/**
////	 * PUT. Actualización del título de una serie.
////	 * @param oldTitle (Título existente en la lista)
////	 * @param newTitle (Nuevo título)
////	 * @return
////	 */
////	@PutMapping(path="/series")
////	public ResponseEntity<?> modSerie(@RequestParam String oldTitle, @RequestParam String newTitle)  {
////		
////		ResponseEntity<?> response = null;
////		
////		// guardamos el id de las series old y new (si no existe, será -1)
////		int idOldSerie = existeSerie(oldTitle);
////		int idNewSerie = existeSerie(newTitle);	
////		
////		// Si la serie old no existe en la lista de series...
////		if (idOldSerie == -1) {
////			
////			//mostramos el error
////			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR. La serie " + oldTitle + " no existe. No se puede actualizar");
////
////		// Si la serie old existe en la lista de series.
////		} else {
////			
////			// si la nueva serie no existe en la lista...
////			if (idNewSerie == -1) {
////				//modificamos el título y devolvemos la serie modificada.
////				series.get(idOldSerie).setTitle(newTitle);
////				response = ResponseEntity.status(HttpStatus.CREATED).body(series.get(idOldSerie));
////				
////			// si la nueva serie ya existe en la lista...
////			} else {
////				
////				//mostramos el error
////				response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR. La serie " + newTitle + " ya existe. No se puede actualizar");
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
////	 * DELETE. Eliminación de una serie.
////	 * @param title (Título de la serie a eliminar)
////	 * @return
////	 */
////	@DeleteMapping(path="/series")
////	public ResponseEntity<?> borraSerie(@RequestParam String title) {		
////		
////		ResponseEntity<?> response = null;
////
////		// guardamos el id de la serie (si no existe, será -1)
////		int idSerie = existeSerie(title);
////				
////		// Si la serie no existe en la lista de series...
////		if (idSerie == -1) {
////			
////			//mostramos el error
////			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR. La serie " + title + " no existe. No se puede borrar");
////
////		// Si la serie existe en la lista de series.
////		} else {
////			
////			//borramos la serie y devolvemos el listado de series.
////			series.remove(idSerie);
////			response = ResponseEntity.status(HttpStatus.OK).body(series);
////		}
////		
////		return response;
////	}
//
//
//}
