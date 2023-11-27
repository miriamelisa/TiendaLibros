package cesur.tienda.services;

import java.util.List;

import cesur.tienda.dtos.AutorDTO;

public interface AutorService {
	
	AutorDTO createAutor(AutorDTO autorDTO);
	AutorDTO getAutor(Long autorId);
	//Consultar la lista de autores con sus libros
	List<AutorDTO> getAllLibros();

}
