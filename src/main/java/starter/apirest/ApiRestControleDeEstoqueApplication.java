package starter.apirest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class ApiRestControleDeEstoqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestControleDeEstoqueApplication.class, args);
		System.out.println("### Welcome ###");
	}

}
