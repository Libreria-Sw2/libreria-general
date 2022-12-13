package uagrm.software.parcial.library.services;

import java.nio.file.Path;
import java.util.stream.Stream;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface ArchivoService {
  public void init();

  public void save(MultipartFile file);

  public Resource load(String filename);

  public void deleteAll();

  public Stream<Path> loadAll();
}
