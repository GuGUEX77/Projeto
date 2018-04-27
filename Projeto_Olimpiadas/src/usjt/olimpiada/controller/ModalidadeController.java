package usjt.olimpiada.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import usjt.olimpiada.model.Modalidade;
import usjt.olimpiada.service.ModalidadeService;

/**
 * Servlet implementation class PaisController
 */
@WebServlet("/modalidades")
public class ModalidadeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModalidadeController() {
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
		ModalidadeService ms = new ModalidadeService();
		RequestDispatcher view;
		
		tipoAcao = request.getParameter("acao");

		if(tipoAcao == null) {
			request.setAttribute("modalidades", ms.buscaModalidades());
			pagina = "/WEB-INF/views/Modalidades.jsp";
			
		}else if(tipoAcao.equals("Novo")) { 
			pagina = "/WEB-INF/views/FormularioModalidade.jsp";
			
		}else if(tipoAcao.equals("Editar")) {
			int idModalidade = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("modalidade", ms.carregar(idModalidade));
			pagina = "/WEB-INF/views/FormularioModalidade.jsp";
			
		}else if(tipoAcao.equals("Excluir")) {
			int idModalidade = Integer.parseInt(request.getParameter("id"));
			if (ms.excluir(idModalidade)) {
				pagina = "/WEB-INF/views/SucessoGravacao.jsp"; 
			}
			
		}else if(tipoAcao.equals("Gravar")) {
			//Monta objeto com parametros recebidos da request.
			int idModalidade = 0;
			
			if((request.getParameter("id") != null) && !(request.getParameter("id").isEmpty())) {	
				idModalidade = Integer.parseInt(request.getParameter("id"));
			}
			String nomeModalidade = request.getParameter("nome");
			char tipo = request.getParameter("tipo").charAt(0);
			
			//Variavel auxiliar para verificar a gravacao
			boolean gravado = false;
			
			Modalidade modalidade = new Modalidade();
			modalidade.setNome(nomeModalidade);
			modalidade.setTipo(tipo);
			
			if (idModalidade > 0) {
				modalidade.setId(idModalidade);
				gravado = ms.atualizar(modalidade);
			}else {
				gravado = ms.criar(modalidade);
			}
			
			if(gravado) {
				pagina = "/WEB-INF/views/SucessoGravacao.jsp"; 
			}
		}
		
		view = request.getRequestDispatcher(pagina);
		view.forward(request, response);
	}

}
