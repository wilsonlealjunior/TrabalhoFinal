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
import conta.Taloes;
import dao.ContaDao;
import dao.TalaoDao;

/**
 * Servlet implementation class RegistrarPagamento
 */
@WebServlet("/RegistrarPagamento")
public class RegistrarPagamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarPagamento() {
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
		int numero=Integer.parseInt(request.getParameter("numero"));
		double valor=Double.parseDouble(request.getParameter("valor"));
		TalaoDao daotalao=new TalaoDao();
		String msg="";
		Taloes talao = null;
		try {
		 talao=daotalao.recuperar(numero);
		
		if(talao.getValor()!=valor){
			msg="valor nao e igual ao da conta";
		}
		else{
			talao.setValor(valor);
			talao.setPago(true);
			daotalao.salvar(talao);
		}
		} catch (SQLException e) {
			msg="erro ao recuperar o talao";
		
	}
		if(msg.equals("")){
			msg="talao pago";
		}
		 request.setAttribute("msg", msg);
			
			RequestDispatcher dispatcher = null;
			
			dispatcher = request.getRequestDispatcher("RegistrarPagamento.jsp");
			dispatcher.forward(request, response);

}
}
