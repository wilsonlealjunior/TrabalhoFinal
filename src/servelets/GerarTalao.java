package servelets;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conta.Taloes;
import dao.ClienteDao;
import dao.ContaDao;
import dao.TalaoDao;

/**
 * Servlet implementation class RegistrarTalao
 */
@WebServlet("/GerarTalao")
public class GerarTalao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GerarTalao() {
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
		
		int numero=Integer.parseInt(request.getParameter("numero"));
		String vencimento=request.getParameter("vencimento");
		int numerotalao=Integer.parseInt(request.getParameter("numerotalao"));
		double valor=Double.parseDouble(request.getParameter("valor"));
		String msg="";
		SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy"); 
		Date nasc = null;
		try {
			nasc = sdf1.parse(vencimento);
		} catch (ParseException e1) {
			msg = msg.concat("Data invalida. ");			
			e1.printStackTrace();
		}
        
		
		ClienteDao dao=new ClienteDao();
		Taloes talao=new Taloes();
		talao.setData(nasc);
		ContaDao daoconta=new ContaDao();
		try {
			talao.setConta(daoconta.recuperar(numero));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		talao.setNumero(numerotalao);
		talao.setPago(false);
		talao.setValor(valor);
		TalaoDao daot=new TalaoDao();
		try {
			daot.salvar(talao);
			System.out.println("salvou");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
request.setAttribute("msg", msg);
		
		RequestDispatcher dispatcher = null;
		
		dispatcher = request.getRequestDispatcher("gerarTalao.jsp");
		dispatcher.forward(request, response);
		
		
		
	}

}
