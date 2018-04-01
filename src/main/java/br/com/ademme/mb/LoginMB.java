package br.com.ademme.mb;
import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.omnifaces.util.Messages;

import br.com.ademme.CPFUtils.CPFUtils;
import br.com.ademme.dao.UsuarioDAO;
import br.com.ademme.model.Usuario;


@ManagedBean
@SessionScoped
public class LoginMB {

	
	
	
	private Usuario usuario;
	private String login;
	private String senha;

	
	@PostConstruct
	public void iniciar() {
		usuario = new Usuario();

	}

	/*@GetMapping("/Autenticacao")*/
	public String autenticar() {

		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			this.login = CPFUtils.limparCpf(this.login);
			this.usuario = usuarioDAO.autenticar(this.login, this.senha);
			if (this.usuario!= null) {
				// Parte que realiza
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user",
						getUsuario().getCpf());
				FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");

			} else {
				Messages.addGlobalError("Usuário e/ou senha incorretos.");
				return null;
			}

		} catch (IOException erro) {
			erro.printStackTrace();

		}
		return "Login";

	}
	
	
	public void sair(){
		try {
		FacesContext fc = FacesContext.getCurrentInstance();   
		HttpSession session = (HttpSession)fc.getExternalContext().getSession(false);   
		session.invalidate();
		FacesContext.getCurrentInstance().getExternalContext().redirect("Login.xhtml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean temPermissoes(List<String> permissoes) {
		for (String permissao : permissoes) {
			if (usuario.getTipo() == permissao.charAt(0)) {
				return true;
			}

		}
		return false;
	}
	
	
	public boolean isLoggedIn () {
        return "Login" != null ; 
    }
	
	

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
	


