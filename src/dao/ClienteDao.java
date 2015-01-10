package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;



import usuarios.Cliente;
import conexao.Conexao;

public class ClienteDao {
	
	public void salvar(Cliente cliente) throws SQLException{
		   Connection c = Conexao.getConnection();
		   Statement st = c.createStatement();
		   String comando = null;
		   
		   if (recuperar(cliente.getCpf()) == null){
			   comando = "insert into cliente values ('" + cliente.getCpf() + 
			     "', '" + cliente.getSenha() + "')";
			    
			   } else { 
			   comando = "update cliente set senha = '" + cliente.getSenha() +
			     "' where cpf = " + cliente.getCpf(); 
			  
		   }
		   st.execute(comando);
		   st.close();
		}
		
		public void remover(String cpf) throws SQLException{
			   Connection c = Conexao.getConnection();
			   Statement st = c.createStatement();
			   String comando = "delete from cliente where cpf = " + cpf;
			   ContaDao daoc=new ContaDao();
			   daoc.removerPorCliente(cpf);
			   st.execute(comando);
			   st.close();
		}
		
		public Cliente recuperar(String cpf) throws SQLException{
	       Cliente cliente = null;
		   Connection c = Conexao.getConnection();
		   Statement st = c.createStatement();
		   ResultSet rs = st.executeQuery("select * from cliente where cpf = " 
				   + cpf);
		   if (rs.next()){
			   String senha = rs.getString("senha");
	           cliente = new Cliente(cpf,senha);
	          //cliente.setContas(cliente.getContas());
	          
	          // Curso objcurso = daoCurso.recuperar(curso);
	          // aluno.setCursos(objcurso);
		   }
		   st.close();
		   return cliente;
		}
		
		
		public ArrayList<Cliente> recuperarClientes() throws SQLException{
			   ArrayList<Cliente> clientes = new ArrayList<Cliente>();
			   Connection c = Conexao.getConnection();
			   Statement st = c.createStatement();
			   ResultSet rs = st.executeQuery("select * from cliente");
			   while (rs.next()){
				   String cpf=rs.getString("cpf");
				   String senha=rs.getString("senha");
				   Cliente cliente=new Cliente(cpf,senha);
				   clientes.add(cliente);
			   }
			   st.close();
			   return clientes;
			}
	

}
