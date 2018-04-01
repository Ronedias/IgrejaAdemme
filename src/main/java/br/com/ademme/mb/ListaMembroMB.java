package br.com.ademme.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import br.com.ademme.model.Membro;
import br.com.ademme.service.MembroService;

@Named
@ViewScoped
public class ListaMembroMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private MembroService membroService;
	private List<Membro> membros = new ArrayList<>();
	private List<Membro> membroSelecionados = new ArrayList<>();
	private List<Membro> membrosIgreja = new ArrayList<>();
	private Membro selectedMembro;
	private Long totalCadastrado;
	private Long totalCadastradoSede;
	private Long totalCadastradoVila;
	private Long totalCadastradosSao;
	private Long totalCadastradoIlheus;
	private Long totalCadastradoSobradinho;
	private String radioPesquisaQ15;
	private String radioPesquisaSede;
	private String radioPesquisaSobradinho;
	private String radioPesquisaIheus;
	private String radioPesquisaSaoSebastiao;
	private String radioPesquisaRabelo;
	
	@PostConstruct
	public void inicializar() {
		membros = membroService.listAll();
		this.radioPesquisaQ15 = "todos";
		this.radioPesquisaSede = "todos";
		this.radioPesquisaSobradinho = "todos"; 
		this.radioPesquisaIheus = "todos";
		this.radioPesquisaSaoSebastiao = "todos" ;
		this.radioPesquisaRabelo = "todos" ;
		this.totalCadastrado = membroService.pesquisaTotalCadastradosQ15();
		this.totalCadastradoSede = membroService.pesquisaTotalCadastradoSede();
		this.totalCadastradoVila = membroService.pesquisaTotalCadastradoVila();
		this.totalCadastradosSao = membroService.pesquisaTotalCadastradoSao();
		this.totalCadastradoIlheus = membroService.pesquisaTotalCadastradoIlheus();
		this.totalCadastradoSobradinho = membroService.pesquisaTotalCadastradoSobradinho();
	}

	public void excluirSelecionados() {
		for (Membro membro : membroSelecionados) {
			membroService.excluir(membro);
			membros.remove(membro);
		}

		Messages.addGlobalInfo("Membro(s) excluída(s) com sucesso!");
	}

	public void pesquisarMembrosQuadra15() {
		this.membros.clear();
		try {
			List<Membro> membros = new ArrayList<>();
			if (this.radioPesquisaQ15.equals("inativos")) {
				membrosIgreja.clear();
				membros = membroService.buscarMembrosInativosQuadra15();

			} else {
				membrosIgreja.clear();
				membros = membroService.buscarMembrosIgrejaQuadra15();
			}
			this.membrosIgreja.addAll(membros);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void pesquisarMembrosSede() {
		this.membros.clear();
		try {
			List<Membro> membros = new ArrayList<>();
			if (this.radioPesquisaSede.equals("inativos")) {
				membrosIgreja.clear();
				membros = membroService.buscarMembrosInativosSede();
			} else {
				membrosIgreja.clear();
				membros = membroService.buscarMembrosIgrejaSede();
			}
			this.membrosIgreja.addAll(membros);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void pesquisarMembrosIgrejaVila() {
		this.membros.clear();
		try {
			List<Membro> membros = new ArrayList<>();
			if (this.radioPesquisaRabelo.equals("inativos")) {
				membrosIgreja.clear();
				membros = membroService.buscarMembrosInativosVila();

			} else {
				membrosIgreja.clear();
				membros = membroService.buscarMembroPorIgrejaVila();
				
			}
			this.membrosIgreja.addAll(membros);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void pesquisarMembrosIgrejaSao() {
		this.membros.clear();
		try {
			List<Membro> membros = new ArrayList<>();
			if (this.radioPesquisaSaoSebastiao.equals("inativos")) {
				membrosIgreja.clear();
				membros = membroService.buscarMembrosInativosSao();

			} else {
				membrosIgreja.clear();
				membros = membroService.buscarMembroPorIgrejaSao();
				
			}
			this.membrosIgreja.addAll(membros);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void pesquisarMembrosIgrejaIlheus() {
		this.membros.clear();
		try {
			List<Membro> membros = new ArrayList<>();
			if (this.radioPesquisaIheus.equals("inativos")) {
				membrosIgreja.clear();
				membros = membroService.buscarMembrosInativosIlheus();

			} else {
				membrosIgreja.clear();
				membros = membroService.buscarMembroPorIgrejaIlheus();
				
			}
			this.membrosIgreja.addAll(membros);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void pesquisarMembrosIgrejaSobradinho() {
		this.membros.clear();
		try {
			List<Membro> membros = new ArrayList<>();
			if (this.radioPesquisaSobradinho.equals("inativos")) {
				membrosIgreja.clear();
				membros = membroService.buscarMembrosInativosSobradinho();

			} else {
				membrosIgreja.clear();
				membros = membroService.buscarMembroPorIgrejaSobradinho();
				
			}
			this.membrosIgreja.addAll(membros);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Membro> getMembros() {
		return membros;
	}

	public void setMembros(List<Membro> membros) {
		this.membros = membros;
	}

	public List<Membro> getMembroSelecionados() {
		return membroSelecionados;

	}

	public void setMembroSelecionados(List<Membro> membroSelecionados) {
		this.membroSelecionados = membroSelecionados;
	}

	public Membro getSelectedMembro() {
		return selectedMembro;
	}

	public void setSelectedMembro(Membro selectedMembro) {
		this.selectedMembro = selectedMembro;
	}

	public Long getTotalCadastrado() {
		return totalCadastrado;
	}

	public void setTotalCadastrado(Long totalCadastrado) {
		this.totalCadastrado = totalCadastrado;
	}

	public List<Membro> getMembrosIgreja() {
		return membrosIgreja;
	}

	public void setMembrosIgreja(List<Membro> membrosIgreja) {
		this.membrosIgreja = membrosIgreja;
	}

	public Long getTotalCadastradoSede() {
		return totalCadastradoSede;
	}

	public void setTotalCadastradoSede(Long totalCadastradoSede) {
		this.totalCadastradoSede = totalCadastradoSede;
	}

	public Long getTotalCadastradoVila() {
		return totalCadastradoVila;
	}

	public void setTotalCadastradoVila(Long totalCadastradoVila) {
		this.totalCadastradoVila = totalCadastradoVila;
	}

	public Long getTotalCadastradosSao() {
		return totalCadastradosSao;
	}

	public void setTotalCadastradosSao(Long totalCadastradosSao) {
		this.totalCadastradosSao = totalCadastradosSao;
	}

	public Long getTotalCadastradoIlheus() {
		return totalCadastradoIlheus;
	}

	public void setTotalCadastradoIlheus(Long totalCadastradoIlheus) {
		this.totalCadastradoIlheus = totalCadastradoIlheus;
	}

	public Long getTotalCadastradoSobradinho() {
		return totalCadastradoSobradinho;
	}

	public void setTotalCadastradoSobradinho(Long totalCadastradoSobradinho) {
		this.totalCadastradoSobradinho = totalCadastradoSobradinho;
	}

	public String getRadioPesquisaQ15() {
		return radioPesquisaQ15;
	}

	public void setRadioPesquisaQ15(String radioPesquisaQ15) {
		this.radioPesquisaQ15 = radioPesquisaQ15;
	}

	public String getRadioPesquisaSede() {
		return radioPesquisaSede;
	}

	public void setRadioPesquisaSede(String radioPesquisaSede) {
		this.radioPesquisaSede = radioPesquisaSede;
	}

	public String getRadioPesquisaSobradinho() {
		return radioPesquisaSobradinho;
	}

	public void setRadioPesquisaSobradinho(String radioPesquisaSobradinho) {
		this.radioPesquisaSobradinho = radioPesquisaSobradinho;
	}

	public String getRadioPesquisaIheus() {
		return radioPesquisaIheus;
	}

	public void setRadioPesquisaIheus(String radioPesquisaIheus) {
		this.radioPesquisaIheus = radioPesquisaIheus;
	}

	public String getRadioPesquisaSaoSebastiao() {
		return radioPesquisaSaoSebastiao;
	}

	public void setRadioPesquisaSaoSebastiao(String radioPesquisaSaoSebastiao) {
		this.radioPesquisaSaoSebastiao = radioPesquisaSaoSebastiao;
	}

	public String getRadioPesquisaRabelo() {
		return radioPesquisaRabelo;
	}

	public void setRadioPesquisaRabelo(String radioPesquisaRabelo) {
		this.radioPesquisaRabelo = radioPesquisaRabelo;
	}
	
	
	

}