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

public class ContaDao {

	public void salvar(Contas conta) throws SQLException{
		   Connection c = Conexao.getConnection();
		   Statement st = c.createStatement();
		   String comando = null;
		   
		   if (recuperar(conta.getIdConta()) == null){
			   comando = "insert into contas values (" + conta.getIdConta() + 
			     ", '" + conta.getCliente().getCpf() + "')";
			   st.execute(comando);
			    
			   } 
		   st.close();
		}
		
		public void remover(int id) throws SQLException{
			   Connection c = Conexao.getConnection();
			   Statement st = c.createStatement();
			   String comando = "delete from contas where id = " + id;
			   st.execute(comando);
			   st.close();
		}
		
		public void removerPorCliente(String cpf) throws SQLException{
			   Connection c = Conexao.getConnection();
			   Statement st = c.createStatement();
			   String comando = "delete from contas where cpf = " + cpf;
			   TalaoDao daot=new TalaoDao();
			   ReclamacaoDao daor=new ReclamacaoDao();
			   ArrayList<Contas> contas=recuperarPorCliente(cpf);
			   for(Contas c1: contas){
				   daot.removerPorConta(c1.getIdConta());
				   daor.removerPorConta(c1.getIdConta());
			   }
			   st.execute(comando);
			   st.close();
		}
		
		public Contas recuperar(int id) throws SQLException{
	       Contas conta = null;
	       TalaoDao daotalao=new TalaoDao();
	       ReclamacaoDao daorecla=new ReclamacaoDao();
	       ClienteDao cliente=new ClienteDao();
		   Connection c = Conexao.getConnection();
		   Statement st = c.createStatement();
		   ResultSet rs = st.executeQuery("select * from contas where id = " 
				   + id );
		   if (rs.next()){
			   String cpf = rs.getString("cpf");
	           conta=new Contas();
	           conta.setCliente(cliente.recuperar(cpf));
	           conta.setIdConta(id);
		   }
		   st.close();
		   return conta;
		}
		
		public ArrayList<Contas> recuperarPorCliente(String cpf ) throws SQLException{
			   ArrayList<Contas> contas = new ArrayList<Contas>();
			   ClienteDao clientedao=new ClienteDao();
			  Cliente cliente=clientedao.recuperar(cpf);
			  ReclamacaoDao dao=new ReclamacaoDao();
			   
			   Connection c = Conexao.getConnection();
			   Statement st = c.createStatement();
			   ResultSet rs = st.executeQuery("select * from contas where cpf = " 
					   + cpf);
			   while (rs.next()){
				   int id = rs.getInt("id");
				   Contas conta=new Contas();
				  conta.setCliente(cliente);
				   conta.setIdConta(id);
				   conta.setReclamacao(dao.recuperar(id));
				   contas.add(conta);
				   
			   }
			   st.close();
			   return contas;
			}
	

	
	
}
