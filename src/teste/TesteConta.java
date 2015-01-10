package teste;

import java.sql.SQLException;
import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;

import conta.Contas;
import usuarios.Cliente;
import dao.ClienteDao;
import dao.ContaDao;

public class TesteConta {

	@Test
	public void testarCriacaoDeConta() throws SQLException{
	   //Cliente cliente=new Cliente("2","123");
		ClienteDao dao=new ClienteDao();
		//dao.salvar(cliente);
		Contas conta=new Contas();
		ContaDao dao1=new ContaDao();
		conta.setCliente(dao.recuperar("1"));
		conta.setIdConta(3);
		dao1.salvar(conta);
		
		
		Cliente outro = dao.recuperar("1");
		Assert.assertEquals(2,outro.getContas().size());
		Assert.assertEquals("123", outro.getSenha());
		ArrayList<Contas> conta1=  outro.getContas();
		int x=1;
		System.out.println("Contas do cliente com cpf 1");
		for(Contas c: conta1){
			System.out.println("Conta "+x);
			System.out.println("numero :" + c.getIdConta());
			System.out.println("senha :" +c.getCliente().getSenha());
			x++;
		}
	}
	
}
