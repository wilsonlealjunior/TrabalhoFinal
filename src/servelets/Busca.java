package servelets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import usuarios.Cliente;
import dao.ClienteDao;

/**
 * Servlet implementation class Busca
 */
@WebServlet("/Busca")
public class Busca extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Busca() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("get");
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int escolha=Integer.parseInt(request.getParameter("escolha"));
		String cpf=request.getParameter("cpf");
		String senha=request.getParameter("senha");
		String msg="";
		Cliente cliente=null;
		if(escolha==0){
		ClienteDao daocliente=new ClienteDao();
		try {
		  cliente= daocliente.recuperar(cpf);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			msg="senha ou cpf incorreto";
			e.printStackTrace();
		}
		if(cliente!=null)
			try {
				if(cliente.getContas()!=null)
				request.setAttribute("lista", cliente.getContas());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		RequestDispatcher dispatcher = null;
		if(senha.equals(cliente.getSenha())){
		dispatcher = request.getRequestDispatcher("VisualizarContasPorCliente.jsp");
		dispatcher.forward(request, response);
		}
		else{
			msg="senha ou cpf incorreto";
			request.setAttribute("msg",msg);
			dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
			
		}
	}
		RequestDispatcher dispatcher = null;
		dispatcher = request.getRequestDispatcher("principal.jsp");
		dispatcher.forward(request, response);
		
	}

}
