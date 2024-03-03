package me.tgi.transaction.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import me.tgi.transaction.model.Company;
import me.tgi.transaction.model.Transaction;
import me.tgi.transaction.service.TransactionService;
import me.tgi.transaction.utils.ValidatorHelper;

/**
 * Controlador Rest que lida com as operações relacionadas a transações.
 * Utiliza a anotação @RestController para indicar que é um controlador Spring que responde a solicitações REST.
 * Utiliza a anotação @RequestMapping para mapear os endpoints relacionados a transações para "/transaction".
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/transaction")
public class TransactionResource {
	private final TransactionService transactionService;
	private final ValidatorHelper validatorHelper;

    /**
     * Endpoint POST para executar uma transação com base nos dados fornecidos.
     *
     * @return Um objeto resultante da execução da transação.
     */
	@PostMapping
	public Object executeTransaction(@RequestBody Transaction transaction) {
		if (!validatorHelper.CPForCNPJ(transaction.getCpf())) {
			return "CPF inválido.";
		}

		if (!validatorHelper.CPForCNPJ(transaction.getCnpj())) {
			return "CNPJ inválido.";
		}
		
		return transactionService.executeTransaction(transaction);
	}

    /**
     * Endpoint GET para obter informações de uma empresa com base no CNPJ fornecido.
     *
     * @param cnpj O CNPJ da empresa a ser consultada.
     * @return Uma instância de Company representando os dados da empresa com o CNPJ fornecido.
     */
	@GetMapping("/{cnpj}")
	public Company getCompany(@PathVariable("cnpj") String cnpj) {
		return transactionService.getCompany(cnpj);
	}

}
