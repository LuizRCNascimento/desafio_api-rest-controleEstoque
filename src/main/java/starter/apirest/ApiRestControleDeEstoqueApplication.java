package starter.apirest;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class ApiRestControleDeEstoqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestControleDeEstoqueApplication.class, args);
		
		Locale defaultLocale = Locale.getDefault();
		System.out.println("Default Locale: "+defaultLocale);
	}

}
