package me.tgi.transaction.service;

import me.tgi.transaction.model.Company;
import me.tgi.transaction.resource.dto.TransactionDto;

/**
 * Interface que define os serviços relacionados a transações.
 */
public interface TransactionService {
	/**
     * Realiza uma transação com base nos dados fornecidos no objeto {@link TransactionDto}.
     *
     * @param transactionDto Objeto que representa os dados da transação a ser executada.
     * @return Um objeto resultante da execução da transação.
     */
	Object executeTransaction(TransactionDto transacaoDto);
	
	/**
     * Obtém informações de uma empresa com base no CNPJ fornecido.
     *
     * @param cnpj O CNPJ da empresa a ser consultada.
     * @return Uma instância de {@link Company} representando os dados da empresa com o CNPJ fornecido.
     */
	Company getCompany(String cnpj);
}	
