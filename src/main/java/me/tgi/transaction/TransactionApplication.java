package me.tgi.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principal responsável por iniciar a aplicação de transações.
 * Utiliza a anotação @SpringBootApplication para configurar automaticamente a aplicação Spring Boot.
 */
@SpringBootApplication
public class TransactionApplication {
    /**
     * Método principal que inicia a execução da aplicação Spring Boot.
     * @param args Argumentos da linha de comando que podem ser passados durante a inicialização da aplicação.
     */
	public static void main(String[] args) {
		SpringApplication.run(TransactionApplication.class, args);
	}

}
