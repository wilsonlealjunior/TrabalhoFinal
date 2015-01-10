package conta;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import dao.ReclamacaoDao;
import dao.TalaoDao;
import usuarios.Cliente;

public class Contas {
	private Cliente cliente;
	private ArrayList<Taloes> talao;
	private Reclamacao reclamacao;
	ReclamacaoDao daorecla=new ReclamacaoDao();

	public Reclamacao getReclamacao() throws SQLException {
		return reclamacao=daorecla.recuperarPorConta(idConta);
		
	}

	public void setReclamacao(Reclamacao reclamacao) {
		this.reclamacao = reclamacao;
	}

	public void setIdConta(int idConta) {
		this.idConta = idConta;
	}

	TalaoDao daotalao=new TalaoDao();
	
	public ArrayList<Taloes> getTalao() throws SQLException {
	    return talao=daotalao.recuperarPorConta(idConta);
	}
	
	public void setTalao(ArrayList<Taloes> talao) {
		this.talao=talao;
	}
	public int getIdConta() {
		return idConta;
	}

	private int idConta;
	
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	

}
