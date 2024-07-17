package gerenciador;  
public class Produto {

	private Integer id;
	private Integer unidadeCompra;
	private String nome;
	private String descricao;
	private Double qtdePrevistoMes;
	private Double precoMaxComprado;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getUnidadeCompra() {
		return unidadeCompra;
	}
	public void setUnidadeCompra(Integer unidadeCompra) {
		this.unidadeCompra = unidadeCompra;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Double getQtdePrevistoMes() {
		return qtdePrevistoMes;
	}
	public void setQtdePrevistoMes(Double qtdePrevistoMes) {
		this.qtdePrevistoMes = qtdePrevistoMes;
	}

	public Double getPrecoMaxComprado() {
		return precoMaxComprado;
	}
	public void setPrecoMaxComprado(Double precoMaxComprado) {
		this.precoMaxComprado = precoMaxComprado;
	}
	
}
