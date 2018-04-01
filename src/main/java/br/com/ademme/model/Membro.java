package br.com.ademme.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Membro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "igreja_id")
	private Igreja igreja;

	@Column(length = 100)
	private String nome;

	@Column(length = 100)
	private String endereco;

	@Column(length = 100)
	private String cidade;

	@Column(length = 16)
	private String telefone;

	@Column(length = 16)
	private String celular;

	@Column(length = 100)
	private String email;

	@Column(length = 100)
	private String profissao;

	@Column(length = 100)
	private String estado;

	@Column(length = 100)
	private String escolaridade;

	@Column(length = 20)
	private String rg;

	@Column(length = 16)
	private String cpf;

	@Temporal(TemporalType.DATE)
	private Date data_nascimento;

	@Column(length = 15)
	private String sexo;

	@Column(length = 3)
	private int idade;

	@Column(length = 100)
	private String nacionalidade;

	@Column(length = 70)
	private String estado_civil;

	@Temporal(TemporalType.DATE)
	private Date data_casamento;

	@Column(length = 100)
	private String pai;

	@Column(length = 100)
	private String mae;

	@Column(length = 100)
	private String conjugue;

	@Column(length = 100)
	private String cargo;

	@Temporal(TemporalType.DATE)
	private Date entrada_igreja;

	@Temporal(TemporalType.DATE)
	private Date data_batismo;

	@Column(length = 100)
	private String igreja_batismo;

	@Column
	private boolean ativo;

	@Column
	private String foto;

	@Column
	private String caminhoImg;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getEstado_civil() {
		return estado_civil;
	}

	public void setEstado_civil(String estado_civil) {
		this.estado_civil = estado_civil;
	}

	public Date getData_casamento() {
		return data_casamento;
	}

	public void setData_casamento(Date data_casamento) {
		this.data_casamento = data_casamento;
	}

	public String getPai() {
		return pai;
	}

	public void setPai(String pai) {
		this.pai = pai;
	}

	public String getMae() {
		return mae;
	}

	public void setMae(String mae) {
		this.mae = mae;
	}

	public String getConjugue() {
		return conjugue;
	}

	public void setConjugue(String conjugue) {
		this.conjugue = conjugue;
	}

	public Date getEntrada_igreja() {
		return entrada_igreja;
	}

	public void setEntrada_igreja(Date entrada_igreja) {
		this.entrada_igreja = entrada_igreja;
	}

	public Date getData_batismo() {
		return data_batismo;
	}

	public void setData_batismo(Date data_batismo) {
		this.data_batismo = data_batismo;
	}

	public String getIgreja_batismo() {
		return igreja_batismo;
	}

	public void setIgreja_batismo(String igreja_batismo) {
		this.igreja_batismo = igreja_batismo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Igreja getIgreja() {
		return igreja;
	}

	public void setIgreja(Igreja igreja) {
		this.igreja = igreja;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getCaminhoImg() {
		return caminhoImg;
	}

	public void setCaminhoImg(String caminhoImg) {
		this.caminhoImg = caminhoImg;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	/*
	 * Metodo pra saber quando a persistencia no banco esta sendo inserido ou se
	 * é uma edição. *
	 */
	public boolean isInclusao() {
		return getId() == null ? true : false;
	}

	public boolean isEdicao() {
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
		Membro other = (Membro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
