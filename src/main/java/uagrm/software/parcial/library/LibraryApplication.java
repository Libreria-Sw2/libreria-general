package uagrm.software.parcial.library;

import javax.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import uagrm.software.parcial.library.services.ArchivoService;

@SpringBootApplication
public class LibraryApplication implements CommandLineRunner {

	@Resource
	ArchivoService archivoService;

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		archivoService.init();
	}

}
