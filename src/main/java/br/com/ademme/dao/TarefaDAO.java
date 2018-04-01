package br.com.ademme.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.omnifaces.util.Messages;

import br.com.ademme.model.Tarefa;

public class TarefaDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject //com a injeção do entitymanager ele procura o producer  que cria a conexao 
	private EntityManager manager;
	
	
	
	//metodo salvar tarefa
	public Tarefa salvar(Tarefa tarefa){
		return manager.merge(tarefa);
	}
	
	//metodo excuir tarefa por id
	public void excluir(Tarefa tarefa ){
		try {
			tarefa = porId(tarefa.getId());
			manager.remove(tarefa);
			manager.flush();
		} catch (Exception e) {
			Messages.addFlashGlobalError("Tarefa não pode ser excluída");
		}
		
	}
	
	//metodo porId que é passado para o metodo excluir
	public Tarefa porId(Long id) {
		return manager.find(Tarefa.class, id);
	}
	
	
	//lista todas as tarefas
	public List<Tarefa>listAll(){
		return manager.createNativeQuery("SELECT * FROM Tarefa",Tarefa.class).getResultList();
	}
}
