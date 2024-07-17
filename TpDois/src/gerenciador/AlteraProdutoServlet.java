package gerenciador;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;  

@WebServlet("/alteraProduto")
public class AlteraProdutoServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		System.out.println("Alterando Produto...");
		
		String nomeProduto = request.getParameter("nome");
		String descricaoProduto = request.getParameter("descricao");
		String paramUnidadeCompraProduto = request.getParameter("unidadeCompra");
		Integer unidadeCompraProduto = Integer.valueOf(paramUnidadeCompraProduto);
		String paramQtdePrevistoMesProduto = request.getParameter("qtdePrevistoMes");
		Double qtdePrevistoMesProduto = Double.valueOf(paramQtdePrevistoMesProduto);
		String paramPrecoMaxCompradoProduto = request.getParameter("precoMaxComprado");
		Double precoMaxCompradoProduto = Double.valueOf(paramPrecoMaxCompradoProduto);
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		System.out.println(id);
		Banco banco = new Banco();
		Produto produto = banco.buscaProdutoPeloId(id);
		produto.setNome(nomeProduto);
		produto.setDescricao(descricaoProduto);
		produto.setUnidadeCompra(unidadeCompraProduto);
		produto.setQtdePrevistoMes(qtdePrevistoMesProduto);
		produto.setPrecoMaxComprado(precoMaxCompradoProduto);
		response.sendRedirect("listaProdutos");
		
	}
		
}

