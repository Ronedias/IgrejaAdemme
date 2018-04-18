package br.com.ademme.mb;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import br.com.ademme.CPFUtils.CPFUtils;
import br.com.ademme.model.Igreja;
import br.com.ademme.model.Membro;
import br.com.ademme.service.MembroService;

@Named
@ViewScoped
@ManagedBean
public class CadastroMembroMB implements Serializable {

	private static final long serialVersionUID = 1L;
	private Membro membro = new Membro();
	private String nome;
	private Long idMembro;
	private String UrlArquivo;
	private Boolean exibePainelDados;
	@Inject
	private MembroService membroService;

	public void inicializar() {
		if (idMembro != null) {
			membro = membroService.porId(idMembro);
			nome = membro.getIgreja().getNome();
			membro.setCaminhoImg("/opt/Ademme/Uploads/" + membro.getRg() + ".png");
		}

	}

	public String salvar() {

		try {
			// valida o campo auto de apreenssao da imagem
			if (membro.getCaminhoImg() == null) {
				Messages.addGlobalError("O campo foto é obrigatório");
				return "";
			}
			membroService.salvar(membro);
			Messages.addGlobalInfo("Membro salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o Membro");
			erro.printStackTrace();
		}
		return "lista-membro.xhtml?faces-redirect=true";
	}

	public void selecionar(Igreja igreja) {
		membro.setIgreja(igreja);
		this.nome = igreja.getNome();
		RequestContext.getCurrentInstance().update("painelmembro");
	}

	public String excluir() {
		membroService.excluir(membro);
		return "lista-usuario.xhtml?faces-redirect=true";
	}

	public void carregarFoto(FileUploadEvent evento) {
		try {
			UploadedFile arquivoUpload = evento.getFile();
			Path arquivoTemp = Files.createTempFile(null, null);
			Files.copy(arquivoUpload.getInputstream(), arquivoTemp, StandardCopyOption.REPLACE_EXISTING);
			membro.setCaminhoImg(arquivoTemp.toString());
			Messages.addGlobalInfo("Imagem carregada com  sucesso");
			System.out.println(membro.getCaminhoImg());

		} catch (IOException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar carregar foto");
			erro.printStackTrace();
		}

	}
	//buscar registro contribuinte
			@SuppressWarnings("unused")
			public void buscarMembroPorCpf() {
				
				try {
					CadastroMembroMB MembroMB = new CadastroMembroMB();
					Membro resultado = membroService.buscar(CPFUtils.limparCpf(membro.getCpf()));
					
					if (resultado == null) {
						setExibePainelDados(false);
						Messages.addGlobalWarn("Não existe membro cadastrado para o cpf informado");
					} else {
						setExibePainelDados(true);
						membro = resultado;
						this.setUrlArquivo("http://localhost:8080/uploads/"+this.membro.getRg() +".png");
						
					}
					
				} catch (RuntimeException erro) {
					Messages.addGlobalError("Ocorreu um erro ao tentar buscar o membro");
					erro.printStackTrace();
				}
				
			}

	public Membro getMembro() {
		return membro;
	}

	public void setMembro(Membro membro) {
		this.membro = membro;
	}

	public Long getIdMembro() {
		return idMembro;
	}

	public void setIdMembro(Long idMembro) {
		this.idMembro = idMembro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUrlArquivo() {
		return UrlArquivo;
	}

	public void setUrlArquivo(String urlArquivo) {
		UrlArquivo = urlArquivo;
	}

	public Boolean getExibePainelDados() {
		return exibePainelDados;
	}

	public void setExibePainelDados(Boolean exibePainelDados) {
		this.exibePainelDados = exibePainelDados;
	}

}
