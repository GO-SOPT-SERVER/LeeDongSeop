package sopt.org.jwtSeminar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class JwtSeminarApplication {
	public static void main(String[] args) {
		SpringApplication.run(JwtSeminarApplication.class, args);
	}
}
