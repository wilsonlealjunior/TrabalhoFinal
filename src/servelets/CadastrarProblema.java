package servelets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conta.TipoReclamacao;
import dao.TipoDao;

/**
 * Servlet implementation class CadastrarProblema
 */
@WebServlet("/CadastrarProblema")
public class CadastrarProblema extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarProblema() {
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
		String msg="problema cadastrado com sucesso";
		String descricao=request.getParameter("descricao");
		int codigo=Integer.parseInt(request.getParameter("codigo"));
		
		TipoDao daotipo=new TipoDao();
		TipoReclamacao tipo=new TipoReclamacao();
		tipo.setDescricao(descricao);
		tipo.setId(codigo);
		try {
			daotipo.salvar(tipo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg="erro ao salvar o problema";
		}
		
		
request.setAttribute("msg", msg);
		
		RequestDispatcher dispatcher = null;
		
		dispatcher = request.getRequestDispatcher("cadastrarProblema.jsp");
		dispatcher.forward(request, response);
	}

}
