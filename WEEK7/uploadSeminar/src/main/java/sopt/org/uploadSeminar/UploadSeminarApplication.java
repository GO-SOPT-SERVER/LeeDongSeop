package sopt.org.uploadSeminar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class UploadSeminarApplication {
	public static void main(String[] args) {
		SpringApplication.run(UploadSeminarApplication.class, args);
	}
}
