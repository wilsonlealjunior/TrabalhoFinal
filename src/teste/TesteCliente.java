package teste;

import java.sql.SQLException;

import org.junit.Test;

import usuarios.Cliente;
import junit.framework.Assert;
import conta.TipoReclamacao;
import dao.ClienteDao;
import dao.TipoDao;

public class TesteCliente {
	@Test
	public void testarCriacaoDeCliente() throws SQLException{
		Cliente cliente=new Cliente("1","123");
		ClienteDao dao=new ClienteDao();
		dao.salvar(cliente);
		
		
		Cliente outro = dao.recuperar("1");
		Assert.assertEquals("1",outro.getCpf());
		Assert.assertEquals("123", outro.getSenha());
		//dao.remover(1);
	}
}
