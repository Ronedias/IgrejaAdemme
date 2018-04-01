package br.com.ademme.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.omnifaces.util.Messages;

import br.com.ademme.CPFUtils.CPFUtils;
import br.com.ademme.dao.UsuarioDAO;
import br.com.ademme.model.Usuario;
import br.com.ademme.util.Transacional;

public class UsuarioService implements Serializable{

	private static final long serialVersionUID = 1L;

	
	@Inject
	private UsuarioDAO usuarioDAO;
	


	

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

	
	
	
	
}
