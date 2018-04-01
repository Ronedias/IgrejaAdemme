package br.com.ademme.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.omnifaces.util.Messages;

import br.com.ademme.model.Membro;

public class MembroDAO implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	@Inject // com a injeção do entitymanager ele procura o producer que cria a
			// conexao
	private EntityManager manager;

	// metodo salvar tarefa
	public Membro salvar(Membro membro) {
		return manager.merge(membro);
	}

	// metodo excuir tarefa por id
	public void excluir(Membro membro) {
		try {
			membro = porId(membro.getId());
			manager.remove(membro);
			manager.flush();
		} catch (Exception e) {
			Messages.addFlashGlobalError("Membro não pode ser excluída");
		}

	}

	// metodo porId que é passado para o metodo excluir
	public Membro porId(Long id) {
		return manager.find(Membro.class, id);
	}

	// lista todas as tarefas
	public List<Membro> listAll() {
		return manager.createNativeQuery("SELECT * FROM Membro", Membro.class).getResultList();
	}

}