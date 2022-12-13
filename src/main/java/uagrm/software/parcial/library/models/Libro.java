package uagrm.software.parcial.library.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.ISBN.Type;
import org.hibernate.validator.constraints.Range;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Libro {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotBlank(message = "Prohibido campos blancos")
  @Size(min = 2, max = 128, message = "Longitud del titulo no aceptado")
  @Column(length = 128)
  private String titulo;

  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date fechaDePublicacion;

  @NotBlank(message = "Prohibido campos blancos")
  @Size(min = 16, message = "Longitud del titulo no aceptado")
  private String descripcion;

  @NotBlank(message = "Prohibido campos blancos")
  @ISBN(message = "Codigo ISBN no valido", type = Type.ANY)
  private String codigoISBN;

  @NotNull(message = "Prohibido campos nulos")
  private int paginas;

  @NotNull(message = "Prohibido campos nulos")
  @Range(min = 0, max = 5)
  private int puntuacion;

  @NotBlank(message = "Prohibido campos blancos")
  @Size(min = 4, message = "Longitud del titulo no aceptado")
  private String lenguaje;

  @NotBlank(message = "Prohibido campos blancos")
  @Size(min = 4, message = "Longitud del titulo no aceptado")
  private String genero;

  @NotBlank(message = "Prohibido campos blancos")
  @Size(min = 4, message = "Longitud del titulo no aceptado")
  private String autor;

  @NotBlank(message = "Prohibido campos blancos")
  @Size(min = 4, message = "Longitud del titulo no aceptado")
  private String editorial;

  private String portadaURL;

  private String archivoURL;
}
