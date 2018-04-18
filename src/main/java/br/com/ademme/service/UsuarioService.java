package br.com.ademme.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
<<<<<<< HEAD
import javax.persistence.NoResultException;

import org.apache.shiro.crypto.hash.SimpleHash;
=======
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

>>>>>>> 75079215d8f20673465477fea2dffd55f6e73f9b
import org.omnifaces.util.Messages;

import br.com.ademme.CPFUtils.CPFUtils;
import br.com.ademme.dao.UsuarioDAO;
import br.com.ademme.model.Usuario;
import br.com.ademme.util.Transacional;

public class UsuarioService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioDAO usuarioDAO;
<<<<<<< HEAD
	
	@Inject
	private EntityManager manager;

=======
>>>>>>> 75079215d8f20673465477fea2dffd55f6e73f9b

//	private Usuario usuarios;

	@Transacional
	public void salvar(Usuario usuario) {
		try {
			usuario.setCpf(CPFUtils.limparCpf(usuario.getCpf()));
			usuarioDAO.salvar(usuario);
			Messages.addFlashGlobalInfo("Usuário cadastrado com sucesso!");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar a Usuario");
			erro.printStackTrace();
		}

	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> pesquisarPorNome(String nome){
		
		List<Usuario> usuarios = (List<Usuario>) manager.createNamedQuery("usuario.pesquisarPorNome")
				.setParameter("nome", "%"+nome.toUpperCase()+"%").getResultList();
		return usuarios;
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> pesquisarPorListaCpf(String cpf){
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try{
			 usuarios = (List<Usuario>) manager.createNamedQuery("usuario.pesquisarPorCpf")
				.setParameter("cpf", cpf).getResultList();
		}catch(NoResultException ex){
			return null;
		}
		return usuarios;
	}
	

	/*public List<Usuario> buscarUsuarioPorCpf(String cpfAUX) {

		ArrayList<Usuario> resultado = new ArrayList<Usuario>();

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = null;

		try {
			conn = ConectionFactory.getConnection();
			sql = "SELECT * from Usuario  where cpf=?";

			pst = conn.prepareStatement(sql);
			pst.setString(1, cpfAUX);
			rs = pst.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setCpf(rs.getString("cpfAUX"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}*/

	
	
	@SuppressWarnings("unchecked")
	public List<Usuario> pesquisarPorListaCpf(String cpfAux){
		System.out.println("##>> Carregando usuario...");
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudPU");
		EntityManager manager = factory.createEntityManager();
		
		
		try{
			 usuarios = (List<Usuario>) manager
					 .createQuery("SELECT nome from Usuario  where cpf= :cpf")
				.setParameter("cpf", cpfAux).getResultList();
		}catch(NoResultException ex){
			System.out.printf("##>> Nao foi localizado nenhum usuario com CPF {0}.", cpfAux, ex);
			return null;
		}
		return usuarios;
	}
	
	@Transacional
	public void excluir(Usuario usuario) {
		usuarioDAO.excluir(usuario);
	}

	public List<Usuario> listAll() {
		return usuarioDAO.listAll();
	}

	public Usuario porId(Long id) {
		return usuarioDAO.porId(id);
	}
<<<<<<< HEAD
	
=======

>>>>>>> 75079215d8f20673465477fea2dffd55f6e73f9b
}
