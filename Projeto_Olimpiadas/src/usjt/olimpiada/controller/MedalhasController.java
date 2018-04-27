package usjt.olimpiada.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import usjt.olimpiada.model.Ano;
import usjt.olimpiada.model.Modalidade;
import usjt.olimpiada.model.Olimpiada;
import usjt.olimpiada.model.Pais;
import usjt.olimpiada.service.AnoService;
import usjt.olimpiada.service.ModalidadeService;
import usjt.olimpiada.service.OlimpiadaService;
import usjt.olimpiada.service.PaisService;

/**
 * Servlet implementation class PaisController
 */
@WebServlet("/quadro_medalhas")
public class MedalhasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MedalhasController() {
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
		OlimpiadaService os = new OlimpiadaService();
		PaisService ps = new PaisService();
		ModalidadeService ms = new ModalidadeService();
		AnoService as = new AnoService();
		
		RequestDispatcher view;
		
		tipoAcao = request.getParameter("acao");

		if(tipoAcao == null) {
			request.setAttribute("quadros", os.listaQuadro());
			pagina = "/WEB-INF/views/ListagemQuadroMedalhas.jsp";
			
		}else if(tipoAcao.equals("Novo")) {
			request.setAttribute("paises", ps.buscaPaises());
			request.setAttribute("anos", as.buscaAnos());
			request.setAttribute("modalidades", ms.buscaModalidades());
			
			pagina = "/WEB-INF/views/FormularioQuadro.jsp";
			
		}else if(tipoAcao.equals("Editar")) {
			
			int idPais = Integer.parseInt(request.getParameter("pais"));
			int idModalidade = Integer.parseInt(request.getParameter("modalidade"));
			int idAno = Integer.parseInt(request.getParameter("ano"));
			
			//Cria instancias com ID para fazer a exclusão;
			Pais pais = new Pais();
			pais.setId(idPais);
			
			Modalidade modalidade = new Modalidade();
			modalidade.setId(idModalidade);
			
			Ano ano = new Ano();
			ano.setAno(idAno);
			
			Olimpiada olimpiada = new Olimpiada();
			olimpiada.setPais(pais);
			olimpiada.setModalidade(modalidade);
			olimpiada.setAno(ano);
			
			request.setAttribute("paises", ps.buscaPaises());
			request.setAttribute("anos", as.buscaAnos());
			request.setAttribute("modalidades", ms.buscaModalidades());
			request.setAttribute("quadro", os.carregar(olimpiada));
			
			pagina = "/WEB-INF/views/FormularioQuadro.jsp";
			
		}else if(tipoAcao.equals("Excluir")) {
			int idPais = Integer.parseInt(request.getParameter("pais"));
			int idModalidade = Integer.parseInt(request.getParameter("modalidade"));
			int idAno = Integer.parseInt(request.getParameter("ano"));
			
			
			//Cria instancias com ID para fazer a exclusão;
			Pais pais = new Pais();
			pais.setId(idPais);
			
			Modalidade modalidade = new Modalidade();
			modalidade.setId(idModalidade);
			
			Ano ano = new Ano();
			ano.setAno(idAno);
			
			Olimpiada olimpiada = new Olimpiada();
			olimpiada.setPais(pais);
			olimpiada.setModalidade(modalidade);
			olimpiada.setAno(ano);
			
			boolean excluido = os.excluir(olimpiada);
			
			if (excluido) {
				pagina = "/WEB-INF/views/SucessoGravacao.jsp"; 
			}
			
		}else if(tipoAcao.equals("Gravar")) {
			//Monta objeto com parametros recebidos da request.
			int idQuadro = 0;
			
			if((request.getParameter("id") != null) && !(request.getParameter("id").isEmpty())) {	
				idQuadro = Integer.parseInt(request.getParameter("id"));
			}
			
			int ouro = Integer.parseInt(request.getParameter("ouro"));
			int prata = Integer.parseInt(request.getParameter("prata"));
			int bronze = Integer.parseInt(request.getParameter("bronze"));;
			
			int idPais = Integer.parseInt(request.getParameter("pais"));
			int idModalidade = Integer.parseInt(request.getParameter("modalidade"));
			int idAno = Integer.parseInt(request.getParameter("ano"));
			
			Ano ano = as.carregar(idAno);
			Modalidade modalidade = ms.carregar(idModalidade);
			Pais pais = ps.carregar(idPais);
			
			//Variavel auxiliar para verificar a gravacao
			boolean gravado = false;
			
			Olimpiada olimpiada = new Olimpiada();
			olimpiada.setOuro(ouro);
			olimpiada.setPrata(prata);
			olimpiada.setBronze(bronze);
			olimpiada.setAno(ano);
			olimpiada.setModalidade(modalidade);
			olimpiada.setPais(pais);
			
			if (idQuadro > 0) {
				olimpiada.setId(idQuadro);
				gravado = os.atualizar(olimpiada);
			}else {
				gravado = os.criar(olimpiada);
			}
			
			if(gravado) {
				pagina = "/WEB-INF/views/SucessoGravacao.jsp"; 
			}
		}
		
		view = request.getRequestDispatcher(pagina);
		view.forward(request, response);
	}

}
