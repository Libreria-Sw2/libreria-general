package uagrm.software.parcial.library.services;

import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uagrm.software.parcial.library.models.Genero;
import uagrm.software.parcial.library.models.Lenguaje;
import uagrm.software.parcial.library.repositories.GeneroRepository;
import uagrm.software.parcial.library.repositories.LenguajeRepository;

@Service
@AllArgsConstructor
public class GeneroService {

  private final GeneroRepository generoRepository;

  public Iterable<Genero> getGeneros() {
    return generoRepository.findAll();
  }

  public Optional<Genero> getGeneroById(Long id) {
    return generoRepository.findById(id);
  }

  public Genero saveGenero(Genero genero) {
    if (genero.getId() != null) {
      genero.setId(null);
    }
    return generoRepository.save(genero);
  }
}
