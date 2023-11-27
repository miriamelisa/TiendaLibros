package cesur.tienda.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cesur.tienda.dtos.LibroDTO;
import cesur.tienda.mappers.LibroMapper;
import cesur.tienda.persistence.entities.AutorEntity;
import cesur.tienda.persistence.entities.LibroEntity;
import cesur.tienda.persistence.repositories.AutorRepository;
import cesur.tienda.persistence.repositories.LibroRepository;
import jakarta.transaction.Transactional;

@Service
public class LibroServiceImpl implements LibroService{
	
	@Autowired
	public LibroRepository libroRepository;
	@Autowired
	public LibroMapper libroMapper;
	@Autowired
	AutorRepository autorRepository;

	@Override
	public LibroDTO getLibro(Long libroId) {
		LibroEntity libroE = libroRepository.findById(libroId)
		.orElseThrow(() -> new RuntimeException("Libro no encontrado"));
		
		return libroMapper.toDto(libroE);
		
	}

	@Override
	@Transactional
	public LibroDTO createLibroPorEsteAutor(LibroDTO libroDTO) {
		
		
		LibroEntity libro = libroMapper.toEntity(libroDTO);
	    
		if (libroDTO.getAutorId() != null) {
	        AutorEntity autor = autorRepository.findById(libroDTO.getAutorId())
	                            .orElseThrow(() -> new RuntimeException("Autor no encontrado"));
	        
	        libro.setAutor(autor);
	    }
		
	    libro = libroRepository.save(libro);
	    return libroMapper.toDto(libro);
		
	}

}
