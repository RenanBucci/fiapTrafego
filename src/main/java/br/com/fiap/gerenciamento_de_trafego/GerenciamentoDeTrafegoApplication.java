package br.com.fiap.gerenciamento_de_trafego;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "br.com.fiap.gerenciamento_de_trafego.repository")
@EntityScan(basePackages = "br.com.fiap.gerenciamento_de_trafego.model")
public class GerenciamentoDeTrafegoApplication {


	public static void main(String[] args) {
		SpringApplication.run(GerenciamentoDeTrafegoApplication.class, args);
	}

}
