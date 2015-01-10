package teste;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;

import usuarios.Cliente;
import conta.Contas;
import conta.Taloes;
import dao.ClienteDao;
import dao.ContaDao;
import dao.TalaoDao;

public class TesteTalao {
	
	@Test
	public void testarCriacaoDeTalao() throws SQLException{
		ClienteDao dao=new ClienteDao();
		Taloes talao=new Taloes();
		talao.setData(new Date());
		ContaDao daoconta=new ContaDao();
		talao.setConta(daoconta.recuperar(3));
		talao.setNumero(20);
		talao.setPago(true);
		talao.setValor(600);
		TalaoDao daot=new TalaoDao();
		daot.salvar(talao);
		Cliente outro1 = dao.recuperar("1");
		ArrayList<Contas> contas1=  outro1.getContas();
		for(Contas c: contas1){
			ArrayList<Taloes> taloes=  c.getTalao();
			
			System.out.println("cpf do cliente : " + c.getCliente().getCpf());
			System.out.println("conta com numero : " + c.getIdConta());
			if(c.getReclamacao()!=null)
			System.out.println("reclamacao da conta : " + c.getReclamacao().getDescricao());
			for(Taloes t: taloes){
				System.out.println("TALAO \nnumero do talao :" + t.getNumero());
				System.out.println("valor : " + t.getValor());
				System.out.println("Data do vencimento : "+ t.getData());
			}
			
		}
		dao.remover("3");
		
	}
	

}
