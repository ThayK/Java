package trab;

public class Locacao {
//	private Carro carro;
	private String horaSaida;
	private String horaVolta;
	private Cliente cliente;
	private double valorLocacao; 
	private int tipoLocacao;
	
	public Locacao( String horaSaida, String horaVolta, Cliente cliente, double valorLocacao) {
		
		this.horaSaida=horaSaida;
		this.horaVolta = horaVolta;
		this.cliente = cliente;
		this.valorLocacao= valorLocacao;
		
		
	}
	

	public String getHoraSaida() {
		return horaSaida;
	}
	public void setHoraSaida(String horaSaida){
		this.horaSaida = horaSaida;
	}
	public String getHora() {
		return horaVolta;
	}
	public void setHora(String horaVolta) {
		this.horaVolta = horaVolta;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public int getTipoLocacao() {
		return tipoLocacao;
	}
	public void setTipoLocacao(int tipoLocacao) {
		this.tipoLocacao = tipoLocacao;
	}
	public double getValorLocacao() {
		return valorLocacao;
	}
	public void setValorLocacao(double valorLocacao) {
		this.valorLocacao = valorLocacao;
	}
	
}


