package practicas.postcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class PostcodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostcodeApplication.class, args);
		System.out.print("Working Great Sahira");

		
	}

	 @Bean
		public BCryptPasswordEncoder bCryptPasswordEncoder(){

			return new BCryptPasswordEncoder();
		}

}
