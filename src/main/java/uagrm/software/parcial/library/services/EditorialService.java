package uagrm.software.parcial.library.services;

import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uagrm.software.parcial.library.models.Editorial;
import uagrm.software.parcial.library.repositories.EditorialRepository;

@Service
@AllArgsConstructor
public class EditorialService {

  private final EditorialRepository editorialRepository;

  public Iterable<Editorial> getEditoriales() {
    return editorialRepository.findAll();
  }

  public Optional<Editorial> getEditorialById(Long id) {
    return editorialRepository.findById(id);
  }

  public Editorial saveEditorial(Editorial editorial) {
    if (editorial.getId() != null) {
      editorial.setId(null);
    }
    return editorialRepository.save(editorial);
  }
}
