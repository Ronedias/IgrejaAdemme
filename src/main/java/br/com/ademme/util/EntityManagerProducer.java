package br.com.ademme.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*FÁBRICA DE CONEXÃO produto de entitymanager*/

@ApplicationScoped
public class EntityManagerProducer {

	private EntityManagerFactory factory;// fabrica
	
	public EntityManagerProducer(){
		/*"crudPU" é o valor do meu persistence.xml*/
		this.factory = Persistence.createEntityManagerFactory("crudPU");
	}
	@Produces//produtor
	@RequestScoped// a cada requisição cria a conexão
	public EntityManager createEntityManager(){
		return this.factory.createEntityManager();
	}
	
	//fecha a conexão
	public void closeEntityManager(@Disposes EntityManager manager){
		manager.close();
	}
	
	
}
