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
 * Servlet implementation class VisualizarContas
 */
@WebServlet("/VisualizarContas")
public class VisualizarContas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizarContas() {
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
		ClienteDao daocliente=new ClienteDao();
		Cliente cliente=null;
		try {
		 cliente=daocliente.recuperar(cpf);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		if(cliente!=null){
			try {
				request.setAttribute("lista",cliente.getContas());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		// request.setAttribute("lista",);
			
			RequestDispatcher dispatcher = null;
			
			dispatcher = request.getRequestDispatcher("VisualizarContasPorCliente.jsp");
			dispatcher.forward(request, response);
	}

}
