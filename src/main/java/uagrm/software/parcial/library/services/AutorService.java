package uagrm.software.parcial.library.services;

import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uagrm.software.parcial.library.models.Autor;
import uagrm.software.parcial.library.repositories.AutorRepository;

@Service
@AllArgsConstructor
public class AutorService {

  private final AutorRepository autorRepository;

  public Iterable<Autor> getAutores() {
    return autorRepository.findAll();
  }

  public Optional<Autor> getAutorById(Long id) {
    return autorRepository.findById(id);
  }

  public Autor saveAutor(Autor autor) {
    if (autor.getId() != null) {
      autor.setId(null);
    }
    return autorRepository.save(autor);
  }
}
