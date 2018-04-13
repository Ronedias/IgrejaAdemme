package br.com.ademme.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import br.com.ademme.model.Igreja;
import br.com.ademme.model.Usuario;
import br.com.ademme.service.IgrejaService;


@Named
@ViewScoped
public class ListaIgrejaMB implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IgrejaService igrejaService;
	
	private List<Igreja> igrejas = new ArrayList<>();
	
	private List<Igreja> igrejaSelecionadas = new ArrayList<>();
	private Usuario usuarioLogado;
	
	
	private Igreja Igrejaselecionada;
	private Boolean btnExcluir;
	
	@PostConstruct
	public void inicializar() {
		igrejas = igrejaService.listAll();
		this.btnExcluir = false;
	}
	
	public void excluirSelecionados() {
		for (Igreja igreja : igrejaSelecionadas) {
			igrejaService.excluir(igreja);
			igrejas.remove(igreja);
		}
		
		Messages.addGlobalInfo("Igreja(s) excluída(s) com sucesso!");
	}

	public List<Igreja> getIgrejas() {
		return igrejas;
	}

	public void setIgrejas(List<Igreja> igrejas) {
		this.igrejas = igrejas;
	}

	public List<Igreja> getIgrejaSelecionadas() {
		return igrejaSelecionadas;
	}

	public void setIgrejaSelecionadas(List<Igreja> igrejaSelecionadas) {
		this.igrejaSelecionadas = igrejaSelecionadas;
	}

	public Igreja getIgrejaselecionada() {
		return Igrejaselecionada;
	}

	public void setIgrejaselecionada(Igreja igrejaselecionada) {
		Igrejaselecionada = igrejaselecionada;
	}

	public Boolean getBtnExcluir() {
		return btnExcluir;
	}

	public void setBtnExcluir(Boolean btnExcluir) {
		this.btnExcluir = btnExcluir;
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	
}
