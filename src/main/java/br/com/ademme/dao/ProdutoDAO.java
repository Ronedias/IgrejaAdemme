package br.com.ademme.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.Session;

import br.com.ademme.model.Produto;
import br.com.ademme.model.Usuario;

public class ProdutoDAO {

	@Inject
	private EntityManager manager;

	public void salvar(Produto produto) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudPU");
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();
		((Session) manager).saveOrUpdate(produto);
		manager.getTransaction().commit();
		manager.close();
		System.out.println("Salvo com sucesso");

		
	}

	
	
	@SuppressWarnings("unchecked")
	public List<Produto>listAll(){
		
		
        String sql = "SELECT * FROM Produto";

        return (List<Produto>) manager.createQuery(sql).getResultList();
	}

}