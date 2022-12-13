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
import uagrm.software.parcial.library.models.Lenguaje;
import uagrm.software.parcial.library.services.LenguajeService;

@AllArgsConstructor
@RestController
@RequestMapping("api/lenguajes")
public class LenguajeController {
  private final LenguajeService lenguajeService;

  @PostMapping
  public ResponseEntity<Lenguaje> crearLenguaje(@RequestBody @Valid Lenguaje lenguaje) {
    return ResponseEntity.ok(lenguajeService.saveLenguaje(lenguaje));
  }

  @GetMapping(path = "/search")
  public ResponseEntity<Optional<Lenguaje>> encontrarLenguajeById(@RequestParam Long id) {
    return ResponseEntity.ok(lenguajeService.getLenguajeById(id));
  }

  @GetMapping
  public ResponseEntity<Iterable<Lenguaje>> obtenerLenguajes() {
    return ResponseEntity.ok(lenguajeService.getLenguajes());
  }
}
