package usjt.olimpiada.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import usjt.olimpiada.model.Pais;
import usjt.olimpiada.service.PaisService;

/**
 * Servlet implementation class PaisController
 */
@WebServlet("/paises")
public class PaisController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaisController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Retorna qual o nome da rota está acessando. Servirá para controle do active do menu.
		request.setAttribute("menu", request.getServletPath());
		String tipoAcao, pagina = "";
		PaisService ps = new PaisService();
		RequestDispatcher view;
		
		tipoAcao = request.getParameter("acao");

		if(tipoAcao == null) {
			request.setAttribute("paises", ps.buscaPaises());
			pagina = "/WEB-INF/views/Paises.jsp";
			
		}else if(tipoAcao.equals("Novo")) { 
			pagina = "/WEB-INF/views/FormularioPais.jsp";
			
		}else if(tipoAcao.equals("Editar")) {
			int idPais = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("pais", ps.carregar(idPais));
			pagina = "/WEB-INF/views/FormularioPais.jsp";
			
		}else if(tipoAcao.equals("Excluir")) {
			int idPais = Integer.parseInt(request.getParameter("id"));
			if (ps.excluir(idPais)) {
				pagina = "/WEB-INF/views/SucessoGravacao.jsp"; 
			}
			
		}else if(tipoAcao.equals("Gravar")) {
			//Monta objeto com parametros recebidos da request.
			int idPais = 0;

			if((request.getParameter("id") != null) && !(request.getParameter("id").isEmpty())) {	
				idPais = Integer.parseInt(request.getParameter("id"));
			}
			String nomePais = request.getParameter("nome");
			long populacaoPais = Long.parseLong(request.getParameter("populacao"));
			double areaPais = Double.parseDouble(request.getParameter("area"));
			
			//Variavel auxiliar para verificar a gravacao
			boolean gravado = false;
			
			Pais pais = new Pais();
			pais.setNome(nomePais);
			pais.setPopulacao(populacaoPais);
			pais.setArea(areaPais);
			
			if (idPais > 0) {
				pais.setId(idPais);
				gravado = ps.atualizar(pais);
			}else {
				gravado = ps.criar(pais);
			}
			
			if(gravado) {
				pagina = "/WEB-INF/views/SucessoGravacao.jsp"; 
			}
		}
		
		view = request.getRequestDispatcher(pagina);
		view.forward(request, response);
		
	}

}
