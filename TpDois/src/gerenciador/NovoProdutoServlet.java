package gerenciador;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;  

@WebServlet("/novoProduto")
public class NovoProdutoServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		System.out.println("Cadastrando novo produto...");
		
		String nomeProduto = request.getParameter("nome");
		String descricaoProduto = request.getParameter("descricao");
		String paramUnidadeCompraProduto = request.getParameter("unidadeCompra");
		Integer unidadeCompraProduto = Integer.valueOf(paramUnidadeCompraProduto);
		String paramQtdePrevistoMesProduto = request.getParameter("qtdePrevistoMes");
		Double qtdePrevistoMesProduto = Double.valueOf(paramQtdePrevistoMesProduto);
		String paramPrecoMaxCompradoProduto = request.getParameter("precoMaxComprado");
		Double precoMaxCompradoProduto = Double.valueOf(paramPrecoMaxCompradoProduto);
		
		Produto produto = new Produto();
		produto.setNome(nomeProduto);
		produto.setDescricao(descricaoProduto);
		produto.setUnidadeCompra(unidadeCompraProduto);
		produto.setQtdePrevistoMes(qtdePrevistoMesProduto);
		produto.setPrecoMaxComprado(precoMaxCompradoProduto);
		
		Banco banco = new Banco();
		banco.adiciona(produto);
		
		request.setAttribute("produto", produto.getNome());
		
		response.sendRedirect("listaProdutos");
	}
	

}

