package me.tgi.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import me.tgi.transaction.model.Company;

/**
 * Interface de repositório para operações relacionadas à entidade {@link Company}.
 * Extende a interface JpaRepository fornecendo métodos CRUD padrão.
 * Utiliza a anotação @Repository para indicar que é um componente de repositório do Spring.
 */
@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>{
	Company findByCnpj(@Param("cnpj") String cnpj);
}
