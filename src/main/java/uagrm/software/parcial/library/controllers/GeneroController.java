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
import uagrm.software.parcial.library.models.Genero;
import uagrm.software.parcial.library.services.GeneroService;

@AllArgsConstructor
@RestController
@RequestMapping("api/generos")
public class GeneroController {
  private final GeneroService generoService;

  @PostMapping
  public ResponseEntity<Genero> crearGenero(@RequestBody @Valid Genero genero) {
    return ResponseEntity.ok(generoService.saveGenero(genero));
  }

  @GetMapping(path = "/search")
  public ResponseEntity<Optional<Genero>> encontrarGeneroById(@RequestParam Long id) {
    return ResponseEntity.ok(generoService.getGeneroById(id));
  }

  @GetMapping
  public ResponseEntity<Iterable<Genero>> obtenerGeneros() {
    return ResponseEntity.ok(generoService.getGeneros());
  }
}
