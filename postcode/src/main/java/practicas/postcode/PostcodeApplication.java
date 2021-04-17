package practicas.postcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import practicas.postcode.security.AppProperties;

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


	@Bean
		public SpringApplicationContext springApplicationContext(){

			return new SpringApplicationContext();
		}


		@Bean(name = "AppProperties")
		public AppProperties getAppProperties(){

			return new AppProperties();
		}
}
