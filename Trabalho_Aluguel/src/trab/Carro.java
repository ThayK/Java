package trab;

public class Carro {

	 
	 private String modelo = null;
	 private String placa = null;
	 private String cor= null;
	 private int ano= 0;
	 private int codigo = 0;
	 private boolean alugado = false;

Carro(String modelo, String placa, String cor, int ano, int codigo, boolean alugado){
	this.modelo= modelo;
	this.placa = placa;
	this.cor = cor;
	this.ano = ano;
	this.alugado = false;
	this.codigo = 0;
}

public String getModelo() {
	return modelo;
}

public String getPlaca() {
	return placa;
}

public String getCor() {
	return cor;
}

public int getAno() {
	return ano;
}
public int getCodigo() {
	return codigo;
}

public boolean getAlugado() {
	return alugado;
}

public void setModelo(String modelo) {
	this.modelo = modelo;
}

public void setPlaca(String placa) {
	this.placa = placa;
}

public void setCor(String cor) {
	this.cor = cor;
}

public void setAno(int ano) {
	this.ano = ano;
}

public void setCodigo(int codigo) {
	this.codigo = codigo;
}

public void setAlugado(boolean alugado) {
	this.alugado = alugado;
}

}

