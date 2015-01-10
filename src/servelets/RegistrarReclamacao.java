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
import dao.ContaDao;
import dao.ReclamacaoDao;
import dao.TipoDao;

/**
 * Servlet implementation class RegistrarReclamacao
 */
@WebServlet("/RegistrarReclamacao")
public class RegistrarReclamacao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarReclamacao() {
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
		int tipo=Integer.parseInt(request.getParameter("tipo"));
		String descricao=request.getParameter("descricao");
		String msg="";
		TipoDao daotipo=new TipoDao();
		TipoReclamacao tiporecla=null;
		try {
			 tiporecla=daotipo.recuperar(tipo);
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			msg="erro ao recuperar tipo";
			e.printStackTrace();
		}
		Reclamacao recla=new Reclamacao();
		recla.setDescricao(descricao);
		ContaDao daoconta=new ContaDao();
        try {
			recla.setConta(daoconta.recuperar(numero));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        recla.setStatus(false);
        if(tiporecla!=null){
        recla.setTipo(tiporecla);
        
        }
        ReclamacaoDao daorecla=new ReclamacaoDao();
        try {
			daorecla.salvar(recla);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			msg="erro ao salvar reclamacao";
			e.printStackTrace();
		}
        
     request.setAttribute("msg", msg);
		
		RequestDispatcher dispatcher = null;
		
		dispatcher = request.getRequestDispatcher("registrarReclamacao.jsp");
		dispatcher.forward(request, response);
		
	}

}
