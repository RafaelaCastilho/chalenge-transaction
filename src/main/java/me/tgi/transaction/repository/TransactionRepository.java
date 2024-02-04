package me.tgi.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.tgi.transaction.model.Transaction;

/**
 * Interface de repositório para operações relacionadas à entidade {@link Transaction}.
 * Extende a interface JpaRepository fornecendo métodos CRUD padrão.
 * Utiliza a anotação @Repository para indicar que é um componente de repositório do Spring.
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}
