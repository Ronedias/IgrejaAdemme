package br.com.ademme.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Tarefa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//faz o auto incremento
	private Long id;
	
	@NotEmpty //não faz a persistencia da entidade caso nao tenha um titulo preenchido
	private String titulo;
	
	@NotEmpty
	private String descricao;

	@NotNull
	@Enumerated(EnumType.STRING) // Essa coluna la na tabela vai ser armazenado um campo String da enum
	private Status status;
	

	private Date criacao;
	
	private Date edicao;

	
	public Date getCriacao() {
		return criacao;
	}
	public void setCriacao(Date criacao) {
		this.criacao = criacao;
	}
	public Date getEdicao() {
		return edicao;
	}
	public void setEdicao(Date edicao) {
		this.edicao = edicao;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	
	/* Metodo pra saber quando a persistencia no banco 
	 * esta sendo inserido ou se é uma edição. * */
	public boolean isInclusao(){
		return getId() == null ? true : false;
	}
	public boolean isEdicao(){
		return !isInclusao();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarefa other = (Tarefa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
