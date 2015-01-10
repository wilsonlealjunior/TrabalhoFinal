package servelets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conta.Contas;
import dao.ClienteDao;
import dao.ContaDao;

/**
 * Servlet implementation class CadastrarConta
 */
@WebServlet("/CadastrarConta")
public class CadastrarConta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarConta() {
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
		String msg="conta cadastrada com sucesso";
		String cpf=request.getParameter("cpf");
		int idConta=Integer.parseInt(request.getParameter("numero"));
		ContaDao daoconta=new ContaDao();
		Contas conta=new Contas();
		conta.setIdConta(idConta);
		ClienteDao daocliente=new ClienteDao();
		try {
			conta.setCliente(daocliente.recuperar(cpf));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			msg="erro ao adcionar conta ao cliente";
			e.printStackTrace();
		}
		try {
			daoconta.salvar(conta);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			msg="erro ao salvar conta";
			e.printStackTrace();
		}
		
request.setAttribute("msg", msg);
		
		RequestDispatcher dispatcher = null;
		
		dispatcher = request.getRequestDispatcher("cadastrarConta.jsp");
		dispatcher.forward(request, response);
	}

}
