package me.tgi.transaction.resource.dto;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.tgi.transaction.enumeration.TypeTransaction;

/**
 * Classe de transferência de dados (DTO) que representa os dados de uma transação.
 * Utiliza as anotações do projeto Lombok para gerar automaticamente construtores, getters, setters e outros métodos.
 * A anotação @Embeddable é utilizada para indicar que a classe pode ser incorporada em outra entidade.
 */
@AllArgsConstructor
@Builder
@Data
@Embeddable
@NoArgsConstructor

public class TransactionDto {
	private String cpf;
	private String cnpj;
	private Double value;
	private Double tax;
	private TypeTransaction type;
	
}
