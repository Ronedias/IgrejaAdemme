package br.com.ademme.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.omnifaces.util.Messages;

import br.com.ademme.CPFUtils.CPFUtils;
import br.com.ademme.model.Usuario;
import br.com.ademme.service.UsuarioService;

@Named
@ViewScoped
@ManagedBean
public class CadastroUsuarioMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario = new Usuario();
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	
	private String confirmaSenha;
	
	private Long idUsuario;

	@Inject
	private UsuarioService usuarioService;

	

	public void inicializar() {
		if (idUsuario != null) {
			usuario = usuarioService.porId(idUsuario);
		}
		
		
	}

	public String salvar() {
		try {

			SimpleHash md5Senha = new SimpleHash("md5", this.usuario.getSenha());
			SimpleHash md5Confirmasenha = new SimpleHash("md5", this.usuario.getConfirmasenha());
			this.usuario.setSenha(md5Senha.toString());
			this.usuario.setConfirmasenha(md5Confirmasenha.toString());

			if (usuario.getSenha().equals(usuario.getConfirmasenha())) {
				usuarioService.salvar(usuario);

			} else {
				Messages.addGlobalInfo("As senha não são iguais");
				return "cadastro-usuario.xhtml?faces-redirect=true";
			}

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o usuário");
			erro.printStackTrace();
		}
		return "lista-usuario.xhtml?faces-redirect=true";
	}

	

	

	public String excluir() {
		usuarioService.excluir(usuario);
		return "lista-usuario.xhtml?faces-redirect=true";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getConfirmaSenha() {
		return confirmaSenha;
	}

	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	

	

}
