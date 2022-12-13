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
import uagrm.software.parcial.library.models.Editorial;
import uagrm.software.parcial.library.services.EditorialService;

@AllArgsConstructor
@RestController
@RequestMapping("api/editoriales")
public class EditorialController {
  private final EditorialService editorialService;

  @PostMapping
  public ResponseEntity<Editorial> crearEditorial(@RequestBody @Valid Editorial editorial) {
    return ResponseEntity.ok(editorialService.saveEditorial(editorial));
  }

  @GetMapping(path = "/search")
  public ResponseEntity<Optional<Editorial>> encontrarEditorialById(@RequestParam Long id) {
    return ResponseEntity.ok(editorialService.getEditorialById(id));
  }

  @GetMapping
  public ResponseEntity<Iterable<Editorial>> obtenerEditoriales() {
    return ResponseEntity.ok(editorialService.getEditoriales());
  }
}
