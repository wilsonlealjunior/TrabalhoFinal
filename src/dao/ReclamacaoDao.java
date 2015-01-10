package dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import usuarios.Cliente;
import conexao.Conexao;
import conta.Contas;
import conta.Reclamacao;
import conta.TipoReclamacao;



	public class ReclamacaoDao {
		public void salvar(Reclamacao recla) throws SQLException{
			   Connection c = Conexao.getConnection();
			   Statement st = c.createStatement();
			   String comando = null;
			   
			   if (recuperar(recla.getConta().getIdConta()) == null){
				   comando = "insert into reclamacoes  values (" + recla.isStatus() + 
				     ", '" + recla.getDescricao() + "',"+ recla.getTipo().getId() + "," + 
						   recla.getConta().getIdConta()+ ")";
			   }
				    else { 
				   comando = "update reclamacoes set descricao = '" + recla.getDescricao() +
				     "',tipo="+recla.getTipo().getId()+" where idConta = " + recla.getConta().getIdConta(); 
			   }
			   st.execute(comando);
			   st.close();

		}
			public void removerPorConta(int idConta) throws SQLException{
				   Connection c = Conexao.getConnection();
				   Statement st = c.createStatement();
				   String comando = "delete from reclamacoes where idConta = " + idConta;
				   st.execute(comando); 
				   st.close();
			}
			
			
			public Reclamacao recuperar(int id) throws SQLException{
			   Reclamacao  recla = null;
			   Connection c = Conexao.getConnection();
			   Statement st = c.createStatement();
			   TipoDao daotipo=new TipoDao();
			   ContaDao daoconta=new ContaDao();
			   ResultSet rs = st.executeQuery("select * from reclamacoes where idConta = " 
					   + id);
			   if (rs.next()){
				   String descricao = rs.getString("descricao");
				   boolean status=rs.getBoolean("status");
				   int tipo=rs.getInt("tipo");
		           recla = new Reclamacao();
		           recla.setStatus(status);
		           recla.setDescricao(descricao);
		           recla.setConta(daoconta.recuperar(id));
		           recla.setTipo(daotipo.recuperar(tipo));
		           
			   }
			   st.close();
			   return recla;
			}
			   
			  public Reclamacao recuperarPorConta(int idConta) throws SQLException{
				   Reclamacao recla = null;
				   ContaDao daoconta = new ContaDao();
		           Contas objconta = daoconta.recuperar(idConta);
				   Connection c = Conexao.getConnection();
				   Statement st = c.createStatement();
				   ResultSet rs = st.executeQuery("select * from reclamacoes where idConta = " 
						   + idConta);
				   while (rs.next()){
					   String descricao = rs.getString("descricao");
					   boolean status = rs.getBoolean("status");
			           recla = new Reclamacao();
			           int tipo=rs.getInt("tipo");
			           TipoDao daotipo=new TipoDao();
			           TipoReclamacao tipo1=daotipo.recuperar(tipo);
			           recla.setConta(objconta);
			           recla.setDescricao(descricao);
			           recla.setStatus(status);
			           recla.setTipo(tipo1);			           
				   }
				   st.close();
				   return recla;
				}
			

	public ArrayList<Reclamacao> recuperarReclamacoes() throws SQLException{
		   ArrayList<Reclamacao> reclamacoes = new ArrayList<Reclamacao>();
		   Connection c = Conexao.getConnection();
		   Statement st = c.createStatement();
		   
		   ResultSet rs = st.executeQuery("select * from reclamacoes ");
		   while (rs.next()){
			   String descricao=rs.getString("descricao");
			   boolean status=rs.getBoolean("status");
			   int idConta=rs.getInt("idConta");
			   Reclamacao recla=new Reclamacao();
			   int tipo=rs.getInt("tipo");
			   ContaDao daoconta = new ContaDao();
	           Contas objconta = daoconta.recuperar(idConta);
	           TipoDao daotipo=new TipoDao();
	           TipoReclamacao tipo1=daotipo.recuperar(tipo);
	           recla.setConta(objconta);
	           recla.setDescricao(descricao);
	           recla.setStatus(status);
	           recla.setTipo(tipo1);
	           reclamacoes.add(recla);
		   }
		   st.close();
		   return reclamacoes;
		}


}