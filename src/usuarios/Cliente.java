package usuarios;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conta.Contas;
import dao.ContaDao;

public class Cliente extends Pessoa {
	
	
	public Cliente(String cpf, String senha) {
		super(cpf, senha);
		
	}
	private ContaDao contasdao=new ContaDao();
	
	private ArrayList<Contas> contas;
	
	
	public ArrayList<Contas> getContas() throws SQLException {
		
			contas= contasdao.recuperarPorCliente(cpf);
		
		
		return contas;
	}
	public void setContas(ArrayList<Contas> contas) {
		this.contas = contas;
	}
	
	
	

}
