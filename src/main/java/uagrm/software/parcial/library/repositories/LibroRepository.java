package uagrm.software.parcial.library.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uagrm.software.parcial.library.models.Libro;

@Repository
public interface LibroRepository extends CrudRepository<Libro, Long> {
  List<Libro> findByAutorContainingIgnoreCase(String autor);
  List<Libro> findByEditorialContainingIgnoreCase(String titulo);
  List<Libro> findByTituloContainingIgnoreCase(String titulo);
  List<Libro> findByLenguajeContainingIgnoreCase(String idioma);
}
