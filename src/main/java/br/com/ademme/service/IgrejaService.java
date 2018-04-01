package br.com.ademme.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.omnifaces.util.Messages;

import br.com.ademme.dao.IgrejaDAO;
import br.com.ademme.model.Igreja;
import br.com.ademme.util.Transacional;

public class IgrejaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IgrejaDAO igrejaDAO;

	@Transacional
	public void salvar(Igreja igreja) {
		try {

			igrejaDAO.salvar(igreja);

			Messages.addGlobalInfo("Igreja salva com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar a Igreja");
			erro.printStackTrace();
		}

	}

	@Transacional
	public void excluir(Igreja igreja) {
		igrejaDAO.excluir(igreja);
	}

	public List<Igreja> listAll() {
		return igrejaDAO.listAll();
	}

	public Igreja porId(Long id) {
		return igrejaDAO.porId(id);
	}

}
