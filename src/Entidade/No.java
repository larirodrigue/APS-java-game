package Entidade;

public class No {
	
	private Corpo corpo;
	private No prox;
	
	public No(Corpo corpo){
		this.corpo = corpo;
		prox = null;
	}

	public Corpo getCorpo() {
		return corpo;
	}

	public void setCorpo(Corpo corpo) {
		this.corpo = corpo;
	}

	public No getProx() {
		return prox;
	}

	public void setProx(No prox) {
		this.prox = prox;
	}
}
