package cesur.tienda.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import cesur.tienda.dtos.AutorDTO;
import cesur.tienda.persistence.entities.AutorEntity;

@Mapper(componentModel = "spring", uses = {LibroMapper.class})
public interface AutorMapper {
	
	AutorDTO toDto(AutorEntity autor);
	AutorEntity toEntity(AutorDTO autorDTO);
    
    @Mapping(target = "libros")
    AutorDTO toDtoWithoutLibros(AutorEntity autor);
    
    public List<AutorDTO> mapEntityListToDToList(List<AutorEntity> autores);

}
