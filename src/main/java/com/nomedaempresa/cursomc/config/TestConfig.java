package com.nomedaempresa.cursomc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.expression.ParseException;

import com.nomedaempresa.cursomc.services.DBService;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private DBService dbService;
	
	//le parametros do arquivo application-test.properties
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	/* os beans abaixo somente vao ser ativados quando o profile test estiver ativo
	 * no arquivo application.properties linha
	 * spring.profiles.active=test
	 */
	
	@Bean
	public boolean instantiateDatabase() throws ParseException{
		
		if (!"create".equals(strategy)) {
			return false;
		}
		
		dbService.instantiateTestDatabase();
		return true;
	}
}
