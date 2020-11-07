package z_com.jacaranda.old;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jacaranda.entity.Visual;


@RestController
@RequestMapping(path = "/netflix")
public class Old_VisualController {
	
//	@SuppressWarnings("serial")
//	private List<Visual> visuals = new ArrayList<>() {
//		{
//			//								inicio												fin							id_producto
//			add(new Visual(LocalDateTime.of(2017, Month.AUGUST, 20, 8, 30), LocalDateTime.of(2017, Month.AUGUST, 20, 9, 30), 1));
//			add(new Visual(LocalDateTime.of(2018, Month.SEPTEMBER, 10, 10, 30), LocalDateTime.of(2018, Month.SEPTEMBER, 10, 11, 30), 3));	
//			add(new Visual(LocalDateTime.of(2020, Month.MAY, 1, 2, 0), LocalDateTime.of(2020, Month.MAY, 1, 2, 15), 2));	
//			add(new Visual(LocalDateTime.of(2020, Month.JUNE, 22, 0, 30), LocalDateTime.of(2020, Month.JUNE, 22, 0, 45), 4));	
//			//Formato:	Año, mes, dia, hora, minuto
//		}
//	};
//
//	
//	
//	/**
//	 * GET. Método para revisar el listado de visualizaciones.
//	 * @return
//	 */
//	@GetMapping("/vis")
//	public ResponseEntity<?> leeVisual() {
//		
//		ResponseEntity<?> response = null;
//
//		if (visuals.isEmpty()) {
//			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("La lista de visualizaciones está vacía");
//		} else {
//			response = ResponseEntity.status(HttpStatus.OK).body(visuals);
//		}
//
//		return response;
//	}

}

