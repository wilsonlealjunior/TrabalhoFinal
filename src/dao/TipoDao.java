package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import conexao.Conexao;
import conta.TipoReclamacao;

public class TipoDao {
	public void salvar(TipoReclamacao tipo) throws SQLException{
		   Connection c = Conexao.getConnection();
		   Statement st = c.createStatement();
		   String comando = null;
		   
		   if (recuperar(tipo.getId()) == null){
			   comando = "insert into tiporeclamacao  values (" + tipo.getId() + 
			     ", '" + tipo.getDescricao() + "')";
			    
			   } else { 
			   comando = "update tiporeclamacao set descricao = '" + tipo.getDescricao() +
			     "' where id = " + tipo.getId(); 
		   }
		   st.execute(comando);
		   st.close();
		}
		
		public void remover(int id) throws SQLException{
			   Connection c = Conexao.getConnection();
			   Statement st = c.createStatement();
			   String comando = "delete from tiporeclamacao where id = " + id;
			   st.execute(comando);
			   
			   st.close();
		}
		
		
		public TipoReclamacao recuperar(int cod) throws SQLException{
			TipoReclamacao  tipo = null;
		   Connection c = Conexao.getConnection();
		   Statement st = c.createStatement();
		   ResultSet rs = st.executeQuery("select * from tiporeclamacao where id = " 
				   + cod);
		   if (rs.next()){
			   String descricao = rs.getString("descricao");
	           tipo = new TipoReclamacao();
	           tipo.setDescricao(descricao);
	           tipo.setId(cod);
		   }
		   st.close();
		   return tipo;
		}

}
