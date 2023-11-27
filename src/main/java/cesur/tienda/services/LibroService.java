package cesur.tienda.services;

import cesur.tienda.dtos.LibroDTO;

public interface LibroService {
	
	//LibroDTO createLibro(LibroDTO libroDTO); Crear libro solo no se utiliza porque
	//cada libro que de crea tiene que estar asociado a un autor
	LibroDTO getLibro(Long libroId);
	
	LibroDTO createLibroPorEsteAutor(LibroDTO libroDTO);
	
	
	


}
