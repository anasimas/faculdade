package model;

public class Carro {
	
	protected String modelo;
	protected String cor;
	protected String ano;

	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String getCor() {
		return cor;
	}
	
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public String getAno() {
		return ano;
	}
	
	public void setAno(String ano) {
		this.ano = ano;
	}
		
	public void novoCarro(String modelo, String cor, String ano) {
		setModelo(modelo);
		setCor(cor);
		setAno(ano);
	}
}
