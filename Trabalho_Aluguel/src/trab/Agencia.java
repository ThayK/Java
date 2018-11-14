package trab;

import java.util.ArrayList;
import java.util.List;

public class Agencia {
	
	private String nome = null;
	private int codigo = 0;
	private String localidade = null;
	private List<Carro> carros;
	private List<Cliente> cliente; 
	private List<Locacao> locacao;
	
	Agencia (String nome, int codigo, String localidade){
		this.nome = nome;
		this.codigo = codigo;
		this.localidade = localidade;
		this.carros= new ArrayList<Carro>();
		this.cliente = new ArrayList<Cliente>();
		this.locacao = new ArrayList<Locacao>();
	}
	Agencia(){
		super();
	}

	public String getNome() {
		return nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getLocalidade() {
		return localidade;
	}

	public List<Carro> getCarros() {
		return carros;
	}

	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public List<Cliente> getCliente() {
		return cliente;
	}

	public void setCliente(List<Cliente> cliente) {
		this.cliente = cliente;
	}

	public List<Locacao> getLocacao() {
		return locacao;
	}

	public void setLocacao(List<Locacao> locacao) {
		this.locacao = locacao;
	}
	
}
