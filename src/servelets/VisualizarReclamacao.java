package servelets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conta.Reclamacao;
import dao.ReclamacaoDao;

/**
 * Servlet implementation class VisualizarReclamacao
 */
@WebServlet("/VisualizarReclamacao")
public class VisualizarReclamacao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizarReclamacao() {
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
		ReclamacaoDao daorecla=new ReclamacaoDao();
		String msg="";
		Reclamacao recla = null;
		try {
			 recla=daorecla.recuperar(idConta);
			 if(recla.isStatus()==false)
					request.setAttribute("status","nao resolvido");
			 request.setAttribute("recla",recla);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			msg="erro ao recuperar reclamacao";
			e.printStackTrace();
		}
		
		
		RequestDispatcher dispatcher = null;
		
		dispatcher = request.getRequestDispatcher("visualizarReclamacao.jsp");
		dispatcher.forward(request, response);
		
	}

}
