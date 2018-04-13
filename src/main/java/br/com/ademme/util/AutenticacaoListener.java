/*package br.com.ademme.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.omnifaces.util.Faces;

import br.com.ademme.mb.LoginMB;
import br.com.ademme.model.Usuario;


@SuppressWarnings("serial")
public class AutenticacaoListener implements PhaseListener {

	@Override
	public void afterPhase(PhaseEvent event) {

		
		String paginaAtual = Faces.getViewId();
		boolean ehPaginaDeAutenticacao = paginaAtual.contains("Login.xhtml");
		LoginMB loginBean = Faces.getSessionAttribute("loginMB");
		
		
		if (!ehPaginaDeAutenticacao) {
			 Faces.getSessionAttribute("loginMB");
		}
		
			if (loginBean == null) {
				Faces.navigate("/Login.xhtml");
				return;
			}	
				
		Usuario usuario = loginBean.getUsuario();		
				if (usuario == null) {
					Faces.navigate("/Login.xhtml");
					return;
				}

			}

		
	

	@Override
	public void beforePhase(PhaseEvent event) {
	}

	
	  //phserlistener vai agir  
	
	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}
}*/