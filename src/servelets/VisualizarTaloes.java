package servelets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conta.Contas;
import conta.Taloes;
import dao.ContaDao;

/**
 * Servlet implementation class VisualizarTaloes
 */
@WebServlet("/VisualizarTaloes")
public class VisualizarTaloes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizarTaloes() {
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
		int idConta=Integer.parseInt(request.getParameter("idConta"));
		ContaDao daoconta=new ContaDao();
		
		Contas contas=null;
		try {
			 contas=daoconta.recuperar(idConta);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			request.setAttribute("lista",contas.getTalao());
			request.setAttribute("pago","nao");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Taloes> talao=null;
		try {
			 talao=contas.getTalao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			request.setAttribute("cpf",contas.getCliente().getCpf());
			request.setAttribute("senha",contas.getCliente().getSenha());
		
		
		RequestDispatcher dispatcher = null;
		
		dispatcher = request.getRequestDispatcher("visualizarTaloes.jsp");
		dispatcher.forward(request, response);
	}

}
