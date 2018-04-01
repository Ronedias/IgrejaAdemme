package br.com.ademme.service;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.omnifaces.util.Messages;

import br.com.ademme.CPFUtils.CPFUtils;
import br.com.ademme.dao.MembroDAO;
import br.com.ademme.model.Membro;
import br.com.ademme.util.ConectionFactory;
import br.com.ademme.util.Transacional;

public class MembroService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private MembroDAO membroDAO;

	@Inject
	private EntityManager manager;

	@Transacional
	public void salvar(Membro membro) {
		try {

			// valida o campo auto de apreenssao da imagem
			if (membro.getCaminhoImg() == null) {
				Messages.addGlobalInfo("O campo foto é obrigatório");
				return;
			}

			Path origem = Paths.get(membro.getCaminhoImg());
			Path destino = Paths.get("/opt/Ademme/Uploads/" + membro.getRg() + ".png");
			Files.copy(origem, destino, StandardCopyOption.REPLACE_EXISTING);
			membro.setCpf(CPFUtils.limparCpf(membro.getCpf()));
			membroDAO.salvar(membro);

			Messages.addGlobalInfo("Membro salvo com sucesso");
		} catch (RuntimeException | IOException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o Membro");
			erro.printStackTrace();
		}

	}

	@Transacional
	public void excluir(Membro membro) {

		try {
			Path arquivo = Paths.get("/opt/Ademme/Uploads/" + membro.getRg() + ".png");
			Files.deleteIfExists(arquivo);
			membroDAO.excluir(membro);
		} catch (RuntimeException | IOException erro) {
			Messages.addGlobalError("Erro ao tentar excluir Membro");
			erro.printStackTrace();
		}
	}

	public Membro buscar(String cpf) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudPU");
		EntityManager manager = factory.createEntityManager();

		try {

			Membro membro = (Membro) manager.createQuery("select m from Membro m where m.cpf = :cpf ")
					.setParameter("cpf", cpf).getSingleResult();

			return membro;

		} catch (RuntimeException erro) {
			erro.printStackTrace();
			return null;
		}
	}

	public Long pesquisaTotalCadastradosQ15() {
		Long numero = new Long(0);
		BigInteger num = new BigInteger("0");

		try {
			String sql = "SELECT COUNT(id) FROM Membro where igreja_id = 3";

			num = (BigInteger) manager.createNativeQuery(sql).getSingleResult();
			numero = num.longValue();

		} catch (Exception e) {
			e.printStackTrace();

		}

		return numero;
	}

	public Long pesquisaTotalCadastradoSede() {
		Long numero = new Long(0);
		BigInteger num = new BigInteger("0");

		try {
			String sql = "SELECT COUNT(id) FROM Membro where igreja_id = 1";

			num = (BigInteger) manager.createNativeQuery(sql).getSingleResult();
			numero = num.longValue();

		} catch (Exception e) {
			e.printStackTrace();

		}

		return numero;
	}

	public Long pesquisaTotalCadastradoVila() {
		Long numero = new Long(0);
		BigInteger num = new BigInteger("0");

		try {
			String sql = "SELECT COUNT(id) FROM Membro where igreja_id = 2";

			num = (BigInteger) manager.createNativeQuery(sql).getSingleResult();
			numero = num.longValue();

		} catch (Exception e) {
			e.printStackTrace();

		}

		return numero;
	}

	public Long pesquisaTotalCadastradoSao() {
		Long numero = new Long(0);
		BigInteger num = new BigInteger("0");

		try {
			String sql = "SELECT COUNT(id) FROM Membro where igreja_id = 4";

			num = (BigInteger) manager.createNativeQuery(sql).getSingleResult();
			numero = num.longValue();

		} catch (Exception e) {
			e.printStackTrace();

		}

		return numero;
	}

	public Long pesquisaTotalCadastradoIlheus() {
		Long numero = new Long(0);
		BigInteger num = new BigInteger("0");

		try {
			String sql = "SELECT COUNT(id) FROM Membro where igreja_id = 11";

			num = (BigInteger) manager.createNativeQuery(sql).getSingleResult();
			numero = num.longValue();

		} catch (Exception e) {
			e.printStackTrace();

		}

		return numero;
	}

	public Long pesquisaTotalCadastradoSobradinho() {
		Long numero = new Long(0);
		BigInteger num = new BigInteger("0");

		try {
			String sql = "SELECT COUNT(id) FROM Membro where igreja_id = 6";

			num = (BigInteger) manager.createNativeQuery(sql).getSingleResult();
			numero = num.longValue();

		} catch (Exception e) {
			e.printStackTrace();

		}

		return numero;
	}

	public List<Membro> buscarMembrosIgrejaSede() {

		ArrayList<Membro> listaMembroIgreja = new ArrayList<Membro>();

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = null;

		try {
			conn = ConectionFactory.getConnection();
			sql = "SELECT id,nome,data_nascimento,cargo,celular,cidade FROM Membro where igreja_id = 1";

			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Membro membro = new Membro();
				membro.setId(rs.getLong("id"));
				membro.setNome(rs.getString("nome"));
				membro.setData_nascimento(rs.getDate("data_nascimento"));
				membro.setCargo(rs.getString("cargo"));
				membro.setCelular(rs.getString("celular"));
				membro.setCidade(rs.getString("cidade"));
				listaMembroIgreja.add(membro);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaMembroIgreja;
	}

	public List<Membro> buscarMembrosInativosSede() {
		ArrayList<Membro> listaMembroIgreja = new ArrayList<Membro>();

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = null;

		try {
			conn = ConectionFactory.getConnection();
			sql = "SELECT id,nome,data_nascimento,cargo,celular,cidade FROM Membro where igreja_id = 1 and ativo = '0' ";

			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Membro membro = new Membro();
				membro.setId(rs.getLong("id"));
				membro.setNome(rs.getString("nome"));
				membro.setData_nascimento(rs.getDate("data_nascimento"));
				membro.setCargo(rs.getString("cargo"));
				membro.setCelular(rs.getString("celular"));
				membro.setCidade(rs.getString("cidade"));
				listaMembroIgreja.add(membro);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaMembroIgreja;
	}

	public List<Membro> buscarMembrosIgrejaQuadra15() {

		ArrayList<Membro> listaMembroIgreja = new ArrayList<Membro>();

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = null;

		try {
			conn = ConectionFactory.getConnection();
			sql = "SELECT * FROM Membro where igreja_id = 3";

			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Membro membro = new Membro();
				membro.setId(rs.getLong("id"));
				membro.setNome(rs.getString("nome"));
				membro.setData_nascimento(rs.getDate("data_nascimento"));
				membro.setCargo(rs.getString("cargo"));
				membro.setCelular(rs.getString("celular"));
				membro.setCidade(rs.getString("cidade"));
				listaMembroIgreja.add(membro);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaMembroIgreja;
	}

	public List<Membro> buscarMembrosInativosQuadra15() {
		ArrayList<Membro> listaMembroIgreja = new ArrayList<Membro>();

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = null;

		try {
			conn = ConectionFactory.getConnection();
			sql = "SELECT * FROM Membro where igreja_id = 3 and ativo = 0";

			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Membro membro = new Membro();
				membro.setId(rs.getLong("id"));
				membro.setNome(rs.getString("nome"));
				membro.setData_nascimento(rs.getDate("data_nascimento"));
				membro.setCargo(rs.getString("cargo"));
				membro.setCelular(rs.getString("celular"));
				membro.setCidade(rs.getString("cidade"));
				listaMembroIgreja.add(membro);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaMembroIgreja;
	}

	public List<Membro> buscarMembroPorIgrejaVila() {

		ArrayList<Membro> listaMembroIgreja = new ArrayList<Membro>();

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = null;

		try {
			conn = ConectionFactory.getConnection();
			sql = "SELECT id,nome,data_nascimento,cargo,celular,cidade FROM Membro where igreja_id = 2";

			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Membro membro = new Membro();
				membro.setId(rs.getLong("id"));
				membro.setNome(rs.getString("nome"));
				membro.setData_nascimento(rs.getDate("data_nascimento"));
				membro.setCargo(rs.getString("cargo"));
				membro.setCelular(rs.getString("celular"));
				membro.setCidade(rs.getString("cidade"));
				listaMembroIgreja.add(membro);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaMembroIgreja;
	}

	public List<Membro> buscarMembrosInativosVila() {
		ArrayList<Membro> listaMembroIgreja = new ArrayList<Membro>();

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = null;

		try {
			conn = ConectionFactory.getConnection();
			sql = "SELECT id,nome,data_nascimento,cargo,celular,cidade FROM Membro where igreja_id = 2 and ativo = 0";

			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Membro membro = new Membro();
				membro.setId(rs.getLong("id"));
				membro.setNome(rs.getString("nome"));
				membro.setData_nascimento(rs.getDate("data_nascimento"));
				membro.setCargo(rs.getString("cargo"));
				membro.setCelular(rs.getString("celular"));
				membro.setCidade(rs.getString("cidade"));
				listaMembroIgreja.add(membro);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaMembroIgreja;
	}

	public List<Membro> buscarMembroPorIgrejaSao() {

		ArrayList<Membro> listaMembroIgreja = new ArrayList<Membro>();

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = null;

		try {
			conn = ConectionFactory.getConnection();
			sql = "SELECT id,nome,cargo,celular,data_nascimento,cidade FROM Membro where igreja_id = 4";

			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Membro membro = new Membro();
				membro.setId(rs.getLong("id"));
				membro.setNome(rs.getString("nome"));
				membro.setData_nascimento(rs.getDate("data_nascimento"));
				membro.setCargo(rs.getString("cargo"));
				membro.setCelular(rs.getString("celular"));
				membro.setCidade(rs.getString("cidade"));
				listaMembroIgreja.add(membro);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaMembroIgreja;
	}

	public List<Membro> buscarMembrosInativosSao() {
		ArrayList<Membro> listaMembroIgreja = new ArrayList<Membro>();

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = null;

		try {
			conn = ConectionFactory.getConnection();
			sql = "SELECT id,nome,cargo,data_nascimento,celular,cidade FROM Membro where igreja_id = 4 and ativo = 0";

			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Membro membro = new Membro();
				membro.setId(rs.getLong("id"));
				membro.setNome(rs.getString("nome"));
				membro.setData_nascimento(rs.getDate("data_nascimento"));
				membro.setCargo(rs.getString("cargo"));
				membro.setCelular(rs.getString("celular"));
				membro.setCidade(rs.getString("cidade"));
				listaMembroIgreja.add(membro);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaMembroIgreja;
	}

	public List<Membro> buscarMembroPorIgrejaIlheus() {

		ArrayList<Membro> listaMembroIgreja = new ArrayList<Membro>();

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = null;

		try {
			conn = ConectionFactory.getConnection();
			sql = "SELECT id,nome,data_nascimento,cargo,celular,cidade FROM Membro where igreja_id = 11";

			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Membro membro = new Membro();
				membro.setId(rs.getLong("id"));
				membro.setNome(rs.getString("nome"));
				membro.setData_nascimento(rs.getDate("data_nascimento"));
				membro.setCargo(rs.getString("cargo"));
				membro.setCelular(rs.getString("celular"));
				membro.setCidade(rs.getString("cidade"));
				listaMembroIgreja.add(membro);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaMembroIgreja;
	}

	public List<Membro> buscarMembrosInativosIlheus() {
		ArrayList<Membro> listaMembroIgreja = new ArrayList<Membro>();

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = null;

		try {
			conn = ConectionFactory.getConnection();
			sql = "SELECT id,nome,data_nascimento,cargo,celular,cidade FROM Membro where igreja_id = 11 and ativo = 0";

			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Membro membro = new Membro();
				membro.setId(rs.getLong("id"));
				membro.setNome(rs.getString("nome"));
				membro.setData_nascimento(rs.getDate("data_nascimento"));
				membro.setCargo(rs.getString("cargo"));
				membro.setCelular(rs.getString("celular"));
				membro.setCidade(rs.getString("cidade"));
				listaMembroIgreja.add(membro);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaMembroIgreja;
	}

	public List<Membro> buscarMembroPorIgrejaSobradinho() {

		ArrayList<Membro> listaMembroIgreja = new ArrayList<Membro>();

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = null;

		try {
			conn = ConectionFactory.getConnection();
			sql = "SELECT id,nome,cargo,celular,cidade,data_nascimento FROM Membro where igreja_id = 6";

			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Membro membro = new Membro();
				membro.setId(rs.getLong("id"));
				membro.setNome(rs.getString("nome"));
				membro.setData_nascimento(rs.getDate("data_nascimento"));
				membro.setCargo(rs.getString("cargo"));
				membro.setCelular(rs.getString("celular"));
				membro.setCidade(rs.getString("cidade"));
				listaMembroIgreja.add(membro);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaMembroIgreja;
	}

	public List<Membro> buscarMembrosInativosSobradinho() {
		ArrayList<Membro> listaMembroIgreja = new ArrayList<Membro>();

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = null;

		try {
			conn = ConectionFactory.getConnection();
			sql = "SELECT id,nome,cargo,celular,cidade,data_nascimento FROM Membro where igreja_id = 5 and ativo = 0";

			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Membro membro = new Membro();
				membro.setId(rs.getLong("id"));
				membro.setNome(rs.getString("nome"));
				membro.setData_nascimento(rs.getDate("data_nascimento"));
				membro.setCargo(rs.getString("cargo"));
				membro.setCelular(rs.getString("celular"));
				membro.setCidade(rs.getString("cidade"));
				listaMembroIgreja.add(membro);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaMembroIgreja;
	}

	public List<Membro> listAll() {
		return membroDAO.listAll();
	}

	public Membro porId(Long id) {
		return membroDAO.porId(id);
	}

}
