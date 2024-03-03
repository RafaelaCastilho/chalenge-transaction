package me.tgi.transaction.service.impl;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import me.tgi.transaction.enumeration.TypeTransaction;
import me.tgi.transaction.model.Company;
import me.tgi.transaction.model.Transaction;
import me.tgi.transaction.repository.CompanyRepository;
import me.tgi.transaction.repository.TransactionRepository;
import me.tgi.transaction.service.TransactionService;


/**
 * Implementação do serviço relacionado a transações.
 * Utiliza a anotação @Service para indicar que é um componente de serviço Spring.
 * Utiliza a anotação @RequiredArgsConstructor para gerar automaticamente um construtor com as dependências necessárias.
 */
@RequiredArgsConstructor
@Service
public class TransactionServiceImpl implements TransactionService {
	public final CompanyRepository companyRepository;
	public final TransactionRepository transactionRepository;

    /**
     * Executa uma transação com base nos dados fornecidos no objeto {@link TransactionDto}.
     *
     * @param transactionDto Objeto que representa os dados da transação a ser executada.
     * @return Um objeto resultante da execução da transação.
     */
	@Override
	public Object executeTransaction(Transaction transaction) {
		// Obter a empresa com base no CNPJ fornecido
		Company company = getCompany(transaction.getCnpj().replaceAll("[^0-9]", ""));
		
		// Obter o saldo atual da empresa	
		Double amountUpdate = company.getAmount();
		
        // Calcular o desconto com base na taxa associada à empresa
		Double discount = transaction.getValueTransaction() * (company.getTax() / 100);

        // Verificar o tipo de transação e atualizar o saldo da empresa
		if (transaction.getType() == TypeTransaction.DEPOSIT) {

			amountUpdate += transaction.getValueTransaction() - discount;

		} else if (transaction.getType() == TypeTransaction.WITHDRAWAL) {
            // Verificar se há saldo suficiente para o saque
			if (amountUpdate > transaction.getValueTransaction() - discount) {
				amountUpdate -= transaction.getValueTransaction() - discount;
			} else {
				return "Saldo insuficiente.";
			}
		}
		
        // Atualizar o saldo da empresa e salvar no repositório
		company.setAmount(amountUpdate);
		companyRepository.save(company);
		transactionRepository.save(transaction);
		return transaction;
	}

    /**
     * Obtém informações de uma empresa com base no CNPJ fornecido.
     *
     * @param cnpj O CNPJ da empresa a ser consultada.
     * @return Uma instância de {@link Company} representando os dados da empresa com o CNPJ fornecido.
     * @throws RuntimeException Se a empresa não existir.
     */
	@Override
	public Company getCompany(String cnpj) {
		Company company = companyRepository.findByCnpj(cnpj);
		if (company == null) {
			throw new RuntimeException("Essa empresa não existe!");
		}
		return company;
	}

}
