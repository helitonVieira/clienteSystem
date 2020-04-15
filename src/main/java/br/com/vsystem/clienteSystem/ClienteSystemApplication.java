package br.com.vsystem.clienteSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan(basePackages="br.com.vsystem.clienteSystem.doman")
@ComponentScan(basePackages = "br.com.vsystem.*")
@EnableJpaRepositories(basePackages = {"br.com.vsystem.clienteSystem.repositorios"})
@EnableTransactionManagement
public class ClienteSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClienteSystemApplication.class, args);
	}

}
