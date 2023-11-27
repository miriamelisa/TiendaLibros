package cesur.tienda.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import cesur.tienda.dtos.LibroDTO;
import cesur.tienda.persistence.entities.AutorEntity;
import cesur.tienda.persistence.entities.LibroEntity;

@Mapper(componentModel = "spring")
public interface LibroMapper {
	
	@Mapping(source = "curso", target = "cursoId", qualifiedByName = "mapCursoId")
	LibroDTO toDto(LibroEntity libro);

	LibroEntity toEntity(LibroDTO libroDTO);

    @Named("mapAutorId")
    default Long mapCursoId(AutorEntity autor) {
        if (autor == null) {
            return null;
        }
        return autor.getId();
    }

}
