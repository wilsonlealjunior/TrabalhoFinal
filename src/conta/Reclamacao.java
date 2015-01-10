package conta;

public class Reclamacao {
	private boolean status;
	private String descricao="";
	
	private TipoReclamacao tipo;
	private Contas conta;
	
	
	public Contas getConta() {
		return conta;
	}
	public void setConta(Contas conta) {
		this.conta = conta;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getDescricao() {
		if(descricao.equals("")){
			return null;
		}
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public TipoReclamacao getTipo() {
		return tipo;
	}
	public void setTipo(TipoReclamacao reclamacao) {
		this.tipo = reclamacao;
	}
	
	
	

}
