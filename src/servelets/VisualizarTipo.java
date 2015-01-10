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
import conta.TipoReclamacao;
import dao.ReclamacaoDao;
import dao.TipoDao;

/**
 * Servlet implementation class VisualizarTipo
 */
@WebServlet("/VisualizarTipo")
public class VisualizarTipo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizarTipo() {
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
		
		int id=Integer.parseInt(request.getParameter("id"));
		int idConta=Integer.parseInt(request.getParameter("idConta"));
		ReclamacaoDao daorecla=new ReclamacaoDao();
		Reclamacao recla=null;
		try {
			 recla=daorecla.recuperar(idConta);
			if(recla.isStatus()==false)
				request.setAttribute("status","nao resolvido");
		 request.setAttribute("recla",recla);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		TipoDao daotipo=new TipoDao();
		TipoReclamacao tipo=null;
		try {
			tipo=daotipo.recuperar(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("tipo",tipo);
		
RequestDispatcher dispatcher = null;
		
		dispatcher = request.getRequestDispatcher("visualizarTipo.jsp");
		dispatcher.forward(request, response);
		
	}

}
