package conta;

import java.util.Date;

public class Taloes {
	private boolean pago;
	private double valor;
	private Date data;
	private Contas conta;
	public Contas getConta() {
		return conta;
	}
	public void setConta(Contas conta) {
		this.conta = conta;
	}
	private int numero;
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public boolean getPago() {
		return pago;
	}
	public void setPago(boolean pago) {
		this.pago = pago;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}

	

}
