package br.com.ademme.service;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import br.com.ademme.dao.TarefaDAO;
import br.com.ademme.model.Tarefa;
import br.com.ademme.util.Transacional;

/*
classe que faz o meio de campo entre o dao e o 
controler entao se eu precisar
 colocar alguma regra pesada seria aqui */

public class TarefaService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private TarefaDAO tarefaDAO;
	
	@Transacional
	public void salvar(Tarefa tarefa){
		if(tarefa.isInclusao()){
			tarefa.setCriacao(new Date());
		}
		if (tarefa.isEdicao()){
			tarefa.setEdicao(new Date());
		}
		tarefaDAO.salvar(tarefa);
	}
	@Transacional
	public void excluir (Tarefa tarefa){
		tarefaDAO.excluir(tarefa);
	}
	public List<Tarefa> listAll(){
		return tarefaDAO.listAll();
	}
	public Tarefa porId(Long id){
		return tarefaDAO.porId(id);
	}
}
