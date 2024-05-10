package tn.esprit.examen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
@EnableAspectJAutoProxy
@EnableFeignClients
public class StudentApplication {
	@Bean
	public RestTemplate restTemplateBean() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}

}
