package uagrm.software.parcial.library.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uagrm.software.parcial.library.models.Editorial;

@Repository
public interface EditorialRepository extends CrudRepository<Editorial, Long> {

}
