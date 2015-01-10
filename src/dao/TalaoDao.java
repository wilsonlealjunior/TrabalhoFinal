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
import conta.Taloes;

public class TalaoDao {
	
	public void salvar(Taloes talao) throws SQLException{
		   Connection c = Conexao.getConnection();
		   Statement st = c.createStatement();
		   String comando = null;
		   
		   if (recuperar(talao.getNumero()) == null){
			   comando = "insert into talao  values (" + talao.getPago() + 
			     ", " + talao.getValor() + ","+ talao.getData().getTime() + "," + 
					   talao.getConta().getIdConta() + ","+talao.getNumero()+")";
			   
		   }
			    else { 
			   comando = "update talao set valor = " + talao.getValor() +
			     ",pago = "+talao.getPago()+" where numero = " + talao.getNumero(); 
		   }
		   st.execute(comando);
		   st.close();

	}
	
	public Taloes recuperar(int numero) throws SQLException{
		   Taloes  talao = null;
		   Connection c = Conexao.getConnection();
		   Statement st = c.createStatement();
		   ResultSet rs = st.executeQuery("select * from talao where numero = " 
				   + numero);
		   if (rs.next()){
			   double valor = rs.getDouble("valor");
			   boolean pago=rs.getBoolean("pago");
			   int idConta=rs.getInt("idConta");
			   long data=rs.getLong("data");
	           talao=new Taloes();
	           Date data1 = new Date();
	           data1.setTime(data);
	           
	           talao.setData(data1);
	           ContaDao daoconta=new ContaDao();
	           talao.setConta(daoconta.recuperar(idConta));
	           talao.setNumero(numero);
	           talao.setPago(pago);
	           talao.setValor(valor);
	           
	           
		   }
		   st.close();
		   return talao;
		}
	
	public ArrayList<Taloes> recuperarPorConta(int idC ) throws SQLException{
		   ArrayList<Taloes> taloes = new ArrayList<Taloes>();
		   
		   Connection c = Conexao.getConnection();
		   Statement st = c.createStatement();
		   ContaDao daoconta=new ContaDao();
		   Contas objconta=daoconta.recuperar(idC);
		   ResultSet rs = st.executeQuery("select * from talao where idConta = " 
				   + idC);
		   while (rs.next()){
			   double valor = rs.getDouble("valor");
			   boolean pago=rs.getBoolean("pago");
			   int numero=rs.getInt("numero");
			   long data=rs.getLong("data");
	           Taloes talao=new Taloes();
	           Date data1 = new Date();
	           data1.setTime(data);
	           
	           talao.setData(data1);
	          talao.setConta(objconta);
	           talao.setNumero(numero);
	           talao.setPago(pago);
	           talao.setValor(valor);
	           taloes.add(talao);
			  
			   
		   }
		   st.close();
		   return taloes;
		}
	
	public void remover(int num) throws SQLException{
		   Connection c = Conexao.getConnection();
		   Statement st = c.createStatement();
		   String comando = "delete from talao where numero = " + num;
		   st.execute(comando);
		   st.close();
	}
	
	public void removerPorConta(int idConta) throws SQLException{
		   Connection c = Conexao.getConnection();
		   Statement st = c.createStatement();
		   String comando = "delete from talao where idConta = " + idConta;
		   st.execute(comando);
		   st.close();
	}


}
