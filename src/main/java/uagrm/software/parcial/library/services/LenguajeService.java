package uagrm.software.parcial.library.services;

import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uagrm.software.parcial.library.models.Lenguaje;
import uagrm.software.parcial.library.repositories.LenguajeRepository;

@Service
@AllArgsConstructor
public class LenguajeService {

  private final LenguajeRepository lenguajeRepository;

  public Iterable<Lenguaje> getLenguajes() {
    return lenguajeRepository.findAll();
  }

  public Optional<Lenguaje> getLenguajeById(Long id) {
    return lenguajeRepository.findById(id);
  }

  public Lenguaje saveLenguaje(Lenguaje lenguaje) {
    if (lenguaje.getId() != null) {
      lenguaje.setId(null);
    }
    return lenguajeRepository.save(lenguaje);
  }
}
