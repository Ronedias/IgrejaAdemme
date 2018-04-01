package br.com.ademme.mb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.ademme.model.Igreja;
import br.com.ademme.service.IgrejaService;


@Named
@ViewScoped
@ManagedBean
public class CadastroIgrejaMB implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Igreja igreja = new Igreja();
	
	private Long idIgreja;
	
	private List<Igreja> listagemigrejas;
	@Inject
	private IgrejaService igrejaService;
	
	
	public void inicializar() {
		if (idIgreja != null) {
			igreja = igrejaService.porId(idIgreja);
		}
	}
	
	
	public String salvar() {
		igrejaService.salvar(igreja);
		return "lista-igreja.xhtml?faces-redirect=true";
	}
	
	public String excluir() {
		igrejaService.excluir(igreja);
		return "lista-igreja.xhtml?faces-redirect=true";
	}


	public Igreja getIgreja() {
		return igreja;
	}


	public void setIgreja(Igreja igreja) {
		this.igreja = igreja;
	}


	public Long getIdIgreja() {
		return idIgreja;
	}


	public void setIdIgreja(Long idIgreja) {
		this.idIgreja = idIgreja;
	}

	

	public List<Igreja> getListagemigrejas() {
		return listagemigrejas;
	}


	public void setListagemigrejas(List<Igreja> listagemigrejas) {
		this.listagemigrejas = listagemigrejas;
	}

	
}
