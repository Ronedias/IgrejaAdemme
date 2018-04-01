
package br.com.ademme.model;


// enum
public enum Status {
	// Declaração das constantes
	ANDAMENTO("Em Andamento"),
	FINALIZADO("Finalizado");
	// Definição das constante
	private String descricao;
	
	// métodos para acessar os valores
	Status(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}

	
} 