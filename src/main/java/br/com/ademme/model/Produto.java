package br.com.ademme.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_produto")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "prod_id")
	private int id;
	@Column(name = "prod_nome")
	private String nome;
	@Column(name = "prod_preco")
	private double preco;
	@Column(name = "prod_foto")
	private String foto;
	
	@Column(name = "prod_caminho") 
	private String caminhoImg;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
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

	

}