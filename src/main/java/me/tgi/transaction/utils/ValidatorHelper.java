package me.tgi.transaction.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;


/**
 * Classe utilitária para realizar validações.
 * Utiliza a anotação @Component para indicar que é um componente Spring.
 */
@Component
public class ValidatorHelper {
	
    /**
     * Verifica se a string fornecida é um CPF ou CNPJ válido.
     *
     * @param cpfCnpj A string contendo o CPF ou CNPJ a ser validado.
     * @return true se a string é um CPF ou CNPJ válido, false caso contrário.
     */
	public boolean CPForCNPJ(String cpf_cnpj) {
		if (cpf_cnpj == null || cpf_cnpj.isEmpty()) {
            return false;
        }

        // Expressão regular para CPF ou CNPJ
        String regex = "^(\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2})|(\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}\\-\\d{2})$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cpf_cnpj);

        return matcher.matches();
    }
}
