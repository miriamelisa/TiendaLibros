package cesur.tienda.dtos;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutorDTO {
	private Long id;
	private String nombre;
	private String nacionalidad;
 
	//Relación: Un autor puede tener varios libros.
    private List<LibroDTO> libros;

}
