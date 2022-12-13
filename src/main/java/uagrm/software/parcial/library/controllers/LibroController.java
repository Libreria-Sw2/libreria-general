package uagrm.software.parcial.library.controllers;

import java.util.Optional;
import javax.print.attribute.standard.Media;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import uagrm.software.parcial.library.models.Libro;
import uagrm.software.parcial.library.services.ArchivoService;
import uagrm.software.parcial.library.services.LibroService;

@AllArgsConstructor
@RestController
@RequestMapping("api/libros")
@CrossOrigin("http://localhost:4200")
public class LibroController {

  private final LibroService libroService;
  private final ArchivoService archivoService;

  @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE })
  public ResponseEntity<Libro> crearLibro(@RequestPart("libro") String libro,
                                          @RequestPart("portada") MultipartFile portada,
                                          @RequestPart("archivo") MultipartFile archivo) {
    archivoService.save(portada);
    archivoService.save(archivo);

    String locale = "http://127.0.0.1:8080/api/libros/archivo/";

    String portadaURL = locale + portada.getOriginalFilename();
    String archivoURL = locale + archivo.getOriginalFilename();

    return ResponseEntity.ok(libroService.saveLibro(libro, portadaURL, archivoURL));
  }

  @GetMapping("/archivo/{archivoNombre:.+}")
  @ResponseBody
  public ResponseEntity<Resource> obtenerArchivo(@PathVariable String archivoNombre) {
    Resource archivo = archivoService.load(archivoNombre);
    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""
            + archivo.getFilename() + "\"").body(archivo);
  }

  @GetMapping(path = "/searchLibros")
  public ResponseEntity<Iterable<Libro>> bucarLibrosByCategoria(
      @RequestParam String categoria,
      @RequestParam String busqueda
  ) {
    if (busqueda.equals("")) {
      return ResponseEntity.ok(libroService.getLibros());
    } else {
      return ResponseEntity.ok(libroService.getLibrosByCategoria(categoria, busqueda));
    }
  }

  @GetMapping(path = "/search")
  public ResponseEntity<Optional<Libro>> encontrarLibroById(@RequestParam Long id) {
    return ResponseEntity.ok(libroService.getLibroById(id));
  }

  @GetMapping
  public ResponseEntity<Iterable<Libro>> obtenerLibros() {
    return ResponseEntity.ok(libroService.getLibros());
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<Libro> actualizarLibro(@PathVariable Long id,
                                               @RequestBody @Valid Libro libro) {
    return libroService.updateLibro(id, libro)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Libro> eliminarLibro(@PathVariable Long id) {
    return libroService.deleteLibroById(id)
        .map(ResponseEntity::ok)
        .orElseGet(()-> ResponseEntity.notFound().build());
  }
}
