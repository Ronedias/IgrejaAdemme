package br.com.ademme.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.ademme.CPFUtils.CPFUtils;
import br.com.ademme.model.Usuario;
import br.com.ademme.service.UsuarioService;

@Named
@ViewScoped
public class ListaUsuarioMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioService usuarioService;

	private List<Usuario> usuarios = new ArrayList<>();
	private List<Usuario> returnusuarios;
	private List<Usuario> usuarioSelecionados = new ArrayList<>();

	private String cpfAUX;
	private String cpf;
	private String nomeUsuario;
	private Usuario usuario;

	private Usuario Usuarioselecionado;

	@PostConstruct
	public void inicializar() {
		usuarios = usuarioService.listAll();
		this.returnusuarios = new ArrayList<Usuario>();
	}

	public void excluirSelecionados() {
		for (Usuario usuario : usuarioSelecionados) {
			usuarioService.excluir(usuario);
			usuarios.remove(usuario);
		}

		// Messages.addGlobalInfo("Usuario(s) teste excluída(s) com sucesso!");
	}

	public void buscarUsuarioPorCpf() {
		this.usuarios = new ArrayList<Usuario>();

		try {
			if (!nomeUsuario.equals("")) {
				// this.returnusuarios = usuarioService.(nomeUsuario);
			} else {
				if (cpf != null && !cpf.isEmpty()) {
					this.cpfAUX = CPFUtils.limparCpf(cpf);
				}
				this.usuarios = usuarioService.pesquisarPorListaCpf(cpfAUX);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public List<Usuario> getReturnusuarios() {
		return returnusuarios;
	}

	public void setReturnusuarios(List<Usuario> returnusuarios) {
		this.returnusuarios = returnusuarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
