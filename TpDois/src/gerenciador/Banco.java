package gerenciador;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Banco {
	private static List<Produto> lista = new ArrayList<>();
	private static Integer chaveSequencial = 1;
	
	static {
		Produto produto = new Produto();
		produto.setId(chaveSequencial++);
		produto.setNome("Madeirite");
		produto.setDescricao("Feito de madeira");
		produto.setUnidadeCompra(3);
		produto.setQtdePrevistoMes((double) 6);
		produto.setPrecoMaxComprado((double) 30);
		Produto produto2 = new Produto();
		produto2.setId(chaveSequencial++);
		produto2.setNome("Cano PVC");
		produto2.setDescricao("Feito de PVC");
		produto2.setUnidadeCompra(4);
		produto2.setQtdePrevistoMes((double) 8);
		produto2.setPrecoMaxComprado((double) 40);
	}
	
	public void adiciona(Produto produto)
	{
		produto.setId(Banco.chaveSequencial++);
		Banco.lista.add(produto);
	}
	
	public List<Produto> getProdutos(){
		return Banco.lista;
	}
	
	public void removeProduto(Integer id) {
		Iterator<Produto> it = lista.iterator();
	
		while(it.hasNext()) {
			Produto pro = it.next();
			
			if(pro.getId()== id) {
				it.remove();
			}
		}
	}
	
	public Produto buscaProdutoPeloId(Integer id) {
		
		for (Produto produto: lista) {
			if(produto.getId()== id) {
				return produto;
			}
		}
		return null;
	}
}
