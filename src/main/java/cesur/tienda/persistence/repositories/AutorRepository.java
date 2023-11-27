package cesur.tienda.persistence.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cesur.tienda.persistence.entities.AutorEntity;

@Repository
public interface AutorRepository extends JpaRepository<AutorEntity, Long> {

}
