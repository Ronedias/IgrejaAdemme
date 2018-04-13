package br.com.ademme.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@NamedQueries({
	@NamedQuery(name = "usuario.pesquisarPorCpf", query = "select u from Usuario u where u.cpf=:cpf"),
	@NamedQuery(name = "usuario.pesquisarPorNome" ,  query = "select u from Usuario u where upper(u.nome) like :nome"),
})
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 32)
	private String senha;
	
	@Transient
	private String confirmasenha;
	
	@Column
	private char tipo;

	@Column
	private boolean ativo;


	@Column
	private String nome;
	
	@CPF
	@Column(length = 16)
	private String cpf;

	@Column(length = 10)
	private String data;

	@Column(length = 15)
	private String sexo;

	@Column(length = 255)
	private String endereco;

	@Column(length = 16)
	private String telefone;
	
	@Email
	@Column(length = 255)
	private String email;

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	

	public String getConfirmasenha() {
		return confirmasenha;
	}

	public void setConfirmasenha(String confirmasenha) {
		this.confirmasenha = confirmasenha;
	}


	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Transient
	public String getTipoFormatado() {
		String tipoFormatado = null;

		if (tipo == 'D') {
			tipoFormatado = "Diretor";
		} else if (tipo == 'G') {
			tipoFormatado = "Gerente";
		} else if (tipo == 'A') {
			tipoFormatado = "Administrador";
		}
		return tipoFormatado;
	}

	public void setTipo(Character tipo) {
		this.tipo = tipo;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	@Transient
	public String getAtivoFormatado() {
		String ativoFormatado = "Não";

		if (ativo) {
			ativoFormatado = "Sim";
		}

		return ativoFormatado;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
}
