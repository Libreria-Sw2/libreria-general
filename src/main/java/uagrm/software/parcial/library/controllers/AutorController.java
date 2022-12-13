package uagrm.software.parcial.library.controllers;

import java.util.Optional;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uagrm.software.parcial.library.models.Autor;
import uagrm.software.parcial.library.services.AutorService;

@AllArgsConstructor
@RestController
@RequestMapping("api/autores")
public class AutorController {
  private final AutorService autorService;

  @PostMapping
  public ResponseEntity<Autor> crearAutor(@RequestBody @Valid Autor autor) {
    return ResponseEntity.ok(autorService.saveAutor(autor));
  }

  @GetMapping(path = "/search")
  public ResponseEntity<Optional<Autor>> encontrarAutorById(@RequestParam Long id) {
    return ResponseEntity.ok(autorService.getAutorById(id));
  }

  @GetMapping
  public ResponseEntity<Iterable<Autor>> obtenerAutores() {
    return ResponseEntity.ok(autorService.getAutores());
  }
}
