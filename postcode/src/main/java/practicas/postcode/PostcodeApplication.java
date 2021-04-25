package practicas.postcode;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import practicas.postcode.models.responses.UserRest;
import practicas.postcode.security.AppProperties;
import practicas.postcode.shared.dto.UserDto;

@SpringBootApplication
@EnableJpaAuditing /**Con esta anotacion se permite la generacion de las fechas automaticas */
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

		
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper mapper = new ModelMapper();

		mapper.typeMap(UserDto.class, UserRest.class).addMappings(m -> m.skip(UserRest::setPosts));

		return mapper;
	}
}
