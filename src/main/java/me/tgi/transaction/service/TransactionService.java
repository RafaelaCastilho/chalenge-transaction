package me.tgi.transaction.service;

import me.tgi.transaction.model.Company;
import me.tgi.transaction.model.Transaction;
import me.tgi.transaction.repository.TransactionRepository;

/**
 * Interface que define os serviços relacionados a transações.
 */
public interface TransactionService {
	/**
     * Realiza uma transação com base nos dados fornecidos no objeto {@link TransactionRepository}.
     *
     * @param transactionRepository Objeto que representa os dados da transação a ser executada.
     * @return Um objeto resultante da execução da transação.
     */
	Object executeTransaction(Transaction transaction);
	
	/**
     * Obtém informações de uma empresa com base no CNPJ fornecido.
     *
     * @param cnpj O CNPJ da empresa a ser consultada.
     * @return Uma instância de {@link Company} representando os dados da empresa com o CNPJ fornecido.
     */
	Company getCompany(String cnpj);
}	
