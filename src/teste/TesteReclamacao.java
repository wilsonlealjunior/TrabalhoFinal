package teste;

import java.sql.SQLException;
import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;

import usuarios.Cliente;
import conta.Contas;
import conta.Reclamacao;
import conta.TipoReclamacao;
import dao.ClienteDao;
import dao.ContaDao;
import dao.ReclamacaoDao;
import dao.TipoDao;

public class TesteReclamacao {

	
	@Test
	public void testarCriacaoDeReclamacao() throws SQLException{
//		Cliente cliente=new Cliente("2","123");
//		ClienteDao dao=new ClienteDao();
//		dao.salvar(cliente);
//		Contas conta=new Contas();
//		ContaDao dao1=new ContaDao();
//		conta.setCliente(cliente);
//		conta.setIdConta(3);
//		dao1.salvar(conta);
//		
//		
//		Cliente outro = dao.recuperar("2");
//		Assert.assertEquals(2,outro.getContas().size());
//		Assert.assertEquals("123", outro.getSenha());
//		ArrayList<Contas> conta1=  outro.getContas();
//		for(Contas c: conta1){
//			System.out.println(c.getIdConta());
//			System.out.println(c.getCliente().getSenha());
//		}
		
//		TipoReclamacao tipo=new TipoReclamacao();
//		tipo.setDescricao("falta de agua");
//		tipo.setId(2);
//		TipoDao dao11=new TipoDao();
//		dao11.salvar(tipo);
		
//		TipoReclamacao outro1 = dao11.recuperar(2);
//		Assert.assertEquals(2,outro1.getId());
//		Assert.assertEquals("falta de agua", outro1.getDescricao());
		TipoDao dao1=new TipoDao();
		Reclamacao recla=new Reclamacao();
		recla.setDescricao("indignados com a falta de cerveja");
		ContaDao daoconta=new ContaDao();
		recla.setConta(daoconta.recuperar(3));
		recla.setStatus(false);
		recla.setTipo(dao1.recuperar(1));
		ReclamacaoDao daoRecla=new ReclamacaoDao();
		daoRecla.salvar(recla);
        ClienteDao dao =new ClienteDao();
		Cliente novoCliente=dao.recuperar("1");
		ArrayList<Contas> conta2=  novoCliente.getContas();
		System.out.println("contas do cliente com cpf 1:");
		int x=1;
		for(Contas c: conta2){
			System.out.println("conta - "+ x);
			System.out.println("numero : " +c.getIdConta());
			//System.out.println(c.getCliente().getSenha());
			//if(c.getReclamacao().getDescricao().equals(""))
			if(c.getReclamacao()!=null)
			System.out.println("reclamacao da conta : " +c.getReclamacao().getDescricao());
			x++;
		}
	}
	
}
