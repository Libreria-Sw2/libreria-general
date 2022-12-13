package uagrm.software.parcial.library.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uagrm.software.parcial.library.models.Libro;
import uagrm.software.parcial.library.repositories.LibroRepository;

@Service
@AllArgsConstructor
public class LibroService {

  private final LibroRepository libroRepository;

  public Iterable<Libro> getLibros() {
    return libroRepository.findAll();
  }

  public Optional<Libro> getLibroById(Long id) {
    return libroRepository.findById(id);
  }

  public Iterable<Libro> getLibrosByCategoria(String categoria, String busqueda) {
    switch (categoria) {
      case "autor": return libroRepository.findByAutorContainingIgnoreCase(busqueda);
      case "editorial": return libroRepository.findByEditorialContainingIgnoreCase(busqueda);
      case "lenguaje": return libroRepository.findByLenguajeContainingIgnoreCase(busqueda);
      case "titulo": return libroRepository.findByTituloContainingIgnoreCase(busqueda);
    }
    return libroRepository.findByTituloContainingIgnoreCase(busqueda);
  }


  public Libro saveLibro(String libro, String portadaURL, String archivoURL) {
    Libro libroJSON = new Libro();

    try {
      ObjectMapper objectMapper = new ObjectMapper();
      libroJSON = objectMapper.readValue(libro, Libro.class);
    } catch (IOException err) {
      System.out.printf("Error", err.toString());
    }

    libroJSON.setPortadaURL(portadaURL);
    libroJSON.setArchivoURL(archivoURL);

    return libroRepository.save(libroJSON);
  }

  public Optional<Libro> updateLibro(Long id, Libro libroUpdated) {
    return getLibroById(id).map(libro -> {
      libro.setTitulo(libroUpdated.getTitulo());
      libro.setFechaDePublicacion(libroUpdated.getFechaDePublicacion());
      libro.setPuntuacion(libroUpdated.getPuntuacion());
      libro.setPaginas(libroUpdated.getPaginas());
      libro.setDescripcion(libroUpdated.getDescripcion());
      libro.setCodigoISBN(libroUpdated.getCodigoISBN());
      libro.setAutor(libroUpdated.getAutor());
      libro.setEditorial(libroUpdated.getEditorial());
      libro.setGenero(libroUpdated.getGenero());
      libro.setLenguaje(libroUpdated.getLenguaje());
      return libroRepository.save(libro);
    });
  }

  public Optional<Libro> deleteLibroById(Long id) {
    Optional<Libro> libro = libroRepository.findById(id);
    if (libro.isPresent()) {
      libroRepository.deleteById(id);
    }
    return libro;
  }

}
