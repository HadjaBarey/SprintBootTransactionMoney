package com.kadous.gestiondealer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import static com.kadous.gestiondealer.model.Role.ADMIN;
import static com.kadous.gestiondealer.model.Role.MANAGER;
import com.kadous.gestiondealer.auth.AuthenticationService;
import com.kadous.gestiondealer.auth.RegisterRequest;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class ApiGestionDealerApplication {

  public static void main(String[] args) {
    SpringApplication.run(ApiGestionDealerApplication.class, args);

  }

  	@Bean
	public CommandLineRunner commandLineRunner(
			AuthenticationService service
	) {
		return args -> {
			// var admin = RegisterRequest.builder()
			// 		.identiteag("Admin1")
			// 		// .matricule("Admin")
			// 		// .email("admin@mail.com")
			// 		.password("password2")
			// 		.sexe("Masculin")
			// 		.telephone("70808882")
			// 		.refcnib("B446626262")
			// 		.email("oued.kader5@ahoo.fr")
			// 		.matricule("ADM5")
			// 		.cloturer(0)
			// 		.role(ADMIN)
			// 		.build();
			// System.out.println("Admin token: " + service.register(admin).getAccessToken());

			// var manager = RegisterRequest.builder()
			// 		.identiteag("Admin6")
			// 		// .matricule("Admin")
			// 		// .email("manager@mail.com")
			// 		.password("password6")
			// 		.sexe("Feminin")
			// 		.telephone("76675866")
			// 		.refcnib("B8888556")
			// 		.email("oued.kader6@ahoo.fr")
			// 		.matricule("MNG6")
			// 		.cloturer(0)
			// 		.role(MANAGER)
			// 		.build();
			// System.out.println("Manager token: " + service.register(manager).getAccessToken());

		};
	}

}