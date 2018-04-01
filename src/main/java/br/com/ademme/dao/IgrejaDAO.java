package br.com.ademme.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.omnifaces.util.Messages;

import br.com.ademme.model.Igreja;

public class IgrejaDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject //com a injeção do entitymanager ele procura o producer  que cria a conexao 
	private EntityManager manager;
	
	
	
	//metodo salvar tarefa
	public Igreja salvar(Igreja igreja){
		return manager.merge(igreja);
	}
	
	//metodo excuir tarefa por id
	public void excluir(Igreja igreja ){
		try {
			igreja = porId(igreja.getId());
			manager.remove(igreja);
			manager.flush();
		} catch (Exception e) {
			Messages.addFlashGlobalError("Igreja não pode ser excluída");
		}
		
	}
	
	//metodo porId que é passado para o metodo excluir
	public Igreja porId(Long id) {
		return manager.find(Igreja.class, id);
	}
	
	
	//lista todas as tarefas
	public List<Igreja>listAll(){
		return manager.createNativeQuery("SELECT * FROM Igreja",Igreja.class).getResultList();
	}
	
	
}
