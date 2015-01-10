package servelets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDao;
import usuarios.Cliente;

/**
 * Servlet implementation class CadastrarCliente
 */
@WebServlet("/CadastrarCliente")
public class CadastrarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarCliente() {
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
		String cpf=request.getParameter("cpf");
		String senha=request.getParameter("senha");
	    Cliente cliente=new Cliente(cpf,senha);
	    ClienteDao dao =new ClienteDao();
	    String msg="";
	    try {
			dao.salvar(cliente);
		} catch (SQLException e) {
			
			msg="erro ao salvar cliente";
		}
	    
	    request.setAttribute("msg", msg);
		
		RequestDispatcher dispatcher = null;
		
		dispatcher = request.getRequestDispatcher("CadastrarCliente.jsp");
		dispatcher.forward(request, response);
		
	}

}
