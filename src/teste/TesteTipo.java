package teste;

import java.sql.SQLException;

import junit.framework.Assert;

import org.junit.Test;

import conta.TipoReclamacao;
import dao.TipoDao;

public class TesteTipo {
	@SuppressWarnings("deprecation")
	@Test
	public void testarCriacaoDeTipo() throws SQLException{
		TipoReclamacao tipo=new TipoReclamacao();
		tipo.setDescricao("falta de energia");
		tipo.setId(1);
		TipoDao dao=new TipoDao();
		dao.salvar(tipo);
		
		TipoReclamacao outro = dao.recuperar(1);
		Assert.assertEquals(1,outro.getId());
		Assert.assertEquals("falta de energia", outro.getDescricao());
		//dao.remover(1);
	}
		
	
	
}
