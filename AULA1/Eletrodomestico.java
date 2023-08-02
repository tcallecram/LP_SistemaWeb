public class Eletrodomestico {
	private boolean ligado;
	private int voltagem;
	private int consumo;
	
	public Eletrodomestico (boolean ligado, int voltagem, int consumo) {
		this.ligado = ligado;
		this.voltagem = voltagem;
		this.consumo = consumo;
	}
	
	public boolean getLigado(){
		return ligado;
	}

	public int getVoltagem(){
		return voltagem;
	}

	public int getConsumo(){
		return consumo;
	}

	public void setLigado(boolean ligado){
		this.ligado = ligado;
	}

	public void setVoltagem(int voltagem){
		this.voltagem = voltagem;
	}

	public void setConsumo(int consumo){
		this.consumo = consumo;
	}

}