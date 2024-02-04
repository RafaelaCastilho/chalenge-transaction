package me.tgi.transaction.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe que representa uma empresa.
 * Utiliza as anotações do projeto Lombok para gerar automaticamente construtores, getters, setters e outros métodos.
 * A anotação @Entity indica que a classe é uma entidade persistente e pode ser mapeada para uma tabela no banco de dados.
 * A anotação @JsonIgnoreProperties é usada para ignorar propriedades específicas durante a serialização/desserialização JSON.
 */
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handle"})

@Entity
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String cnpj;
	private Double amount;
	private Double tax;
}
