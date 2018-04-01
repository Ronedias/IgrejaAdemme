package br.com.ademme.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import br.com.ademme.model.Usuario;
import br.com.ademme.service.UsuarioService;

@Named
@ViewScoped
public class ListaUsuarioMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioService usuarioService;

	private List<Usuario> usuarios = new ArrayList<>();

	private List<Usuario> usuarioSelecionados = new ArrayList<>();
	
	private Usuario Usuarioselecionado;

	@PostConstruct
	public void inicializar() {
		usuarios = usuarioService.listAll();
	}

	public void excluirSelecionados() {
		for (Usuario usuario : usuarioSelecionados) {
			usuarioService.excluir(usuario);
			usuarios.remove(usuario);
		}

		//Messages.addGlobalInfo("Usuario(s)  teste excluída(s) com sucesso!");
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Usuario> getUsuarioSelecionados() {
		return usuarioSelecionados;

	}
	
	public void setUsuarioSelecionados(List<Usuario> usuarioSelecionados) {
		this.usuarioSelecionados = usuarioSelecionados;
	}

	public Usuario getUsuarioselecionado() {
		return Usuarioselecionado;
	}

	public void setUsuarioselecionado(Usuario usuarioselecionado) {
		Usuarioselecionado = usuarioselecionado;
	}	
}
