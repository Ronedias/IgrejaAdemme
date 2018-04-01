package br.com.ademme.CPFUtils;

public class CPFUtils {

	// Limpar cpf
	public static String limparCpf(String cpf) {

		if (cpf != null) {
			String cpfLimpo = cpf.replaceAll("\\.", "").replaceAll("\\-", "");
			return cpfLimpo;
		} else {
			return null;
		}
	}

	public static String formatarCpf(String cpf) {

		if (cpf != null) {
			String cpfFormatado = cpf.substring(0, 3).concat(".").concat(cpf.substring(3, 6)).concat(".")
					.concat(cpf.substring(6, 9)).concat("-").concat(cpf.substring(9, 11));
			return cpfFormatado;
		} else {
			return null;
		}

	}
}
