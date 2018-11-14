package trab;

import java.awt.List;

public class Cliente {
	
	private String nome;
	private String numeroHabilitacao;
	private int telefone;
	private int codigoCliente;
	
	
	public Cliente(String nome, String numeroHabilitacao, int telefone, int codigoCliente) {
		this.nome = nome;
		this.numeroHabilitacao = numeroHabilitacao;
		this.telefone = telefone;
		this.codigoCliente= codigoCliente;;
		
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNumeroHabilitacao() {
		return numeroHabilitacao;
	}
	public void setNumeroHabilitacao(String numeroHabilitacao) {
		this.numeroHabilitacao = numeroHabilitacao;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	public int getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	
	
}
