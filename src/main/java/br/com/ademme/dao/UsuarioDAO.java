package br.com.ademme.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.omnifaces.util.Messages;

import com.mysql.fabric.FabricConnection;
import com.sun.faces.util.Cache.Factory;

import br.com.ademme.model.Usuario;

public class UsuarioDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject //com a injeção do entitymanager ele procura o producer  que cria a conexao 
	private EntityManager manager;

	
	
	
	
	
	//metodo salvar tarefa
	public Usuario salvar(Usuario usuario){
		return manager.merge(usuario);
	}
	
	//metodo excuir tarefa por id
	public void excluir(Usuario usuario ){
		try {
			usuario = porId(usuario.getId());
			manager.remove(usuario);
			manager.flush();
		} catch (Exception e) {
			Messages.addGlobalError("Usuario não pode ser excluída");
		}
		
	}
	
	//metodo porId que é passado para o metodo excluir
	public Usuario porId(Long id) {
		return manager.find(Usuario.class, id);
	}
	
	
	//lista todas as tarefas
	public List<Usuario>listAll(){
		return manager.createNativeQuery("SELECT * FROM Usuario",Usuario.class).getResultList();
	}
	
	
	public Usuario   autenticar(String cpf, String senha) {
			
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudPU");
		EntityManager manager = factory.createEntityManager();
		
		try {
			SimpleHash hash = new SimpleHash("md5", senha);
			Usuario usuario = (Usuario) manager
                    .createQuery(
                    		"select usu from Usuario usu where usu.cpf = :cpf and usu.senha = :senha")
                    .setParameter("cpf", cpf)
                    .setParameter("senha", hash.toHex()).getSingleResult();
			
			return usuario;
			
		} catch (RuntimeException erro) {
			return null;
		}
		

		}

	
	
	
	
	
	/*public Usuario autenticar(String cpf, String senha) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		try {
			
			SimpleHash hash = new SimpleHash("md5", senha);

			Query q = sessao
					.createQuery("select usu from Usuario usu where usu.cpf = :cpf and usu.senha = :senha")
					.setParameter("cpf", cpf).setParameter("senha", hash.toHex());

			Usuario usuario = (Usuario) q.uniqueResult();
			return usuario;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();

		}*/
	
}

