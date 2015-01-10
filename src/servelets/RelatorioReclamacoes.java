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

import conta.Reclamacao;
import dao.ReclamacaoDao;

/**
 * Servlet implementation class RelatorioReclamacoes
 */
@WebServlet("/RelatorioReclamacoes")
public class RelatorioReclamacoes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RelatorioReclamacoes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get");
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReclamacaoDao daorecla=new ReclamacaoDao();
		String msg="";
		ArrayList<Reclamacao> lista = null;
		try {
			 lista=daorecla.recuperarReclamacoes();
		} catch (SQLException e) {
		}
		if(lista.size()<=0){
			msg="nao possui reclamacoes";
		}
request.setAttribute("lista", lista);
request.setAttribute("msg", msg);
		
		RequestDispatcher dispatcher = null;
		
		dispatcher = request.getRequestDispatcher("relatorioReclamacoes.jsp");
		dispatcher.forward(request, response);
		
	}

}
