package cesur.tienda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cesur.tienda.dtos.AutorDTO;
import cesur.tienda.mappers.AutorMapper;
import cesur.tienda.persistence.entities.AutorEntity;
import cesur.tienda.persistence.repositories.AutorRepository;

@Service
public class AutorServiceImpl implements AutorService {
	
	@Autowired
	public AutorRepository autorRepository;
	@Autowired
	public AutorMapper autorMapper;
	
	@Override
	public AutorDTO createAutor(AutorDTO autorDTO) {
		return autorMapper.toDto(autorRepository.save(autorMapper.toEntity(autorDTO)));
	}

	@Override
	public AutorDTO getAutor(Long autorId) {
		AutorEntity autorE = autorRepository.findById(autorId)
				.orElseThrow(() -> new RuntimeException("Autor no encontrado"));
		
		return autorMapper.toDto(autorE);
	}

	@Override
	public List<AutorDTO> getAllLibros() {
		List<AutorEntity> Autores = autorRepository.findAll();
		return autorMapper.mapEntityListToDToList(Autores);
	}

}
