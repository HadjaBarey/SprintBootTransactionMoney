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
			
		};
	}

}