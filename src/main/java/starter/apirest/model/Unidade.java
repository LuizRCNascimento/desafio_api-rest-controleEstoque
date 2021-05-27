package starter.apirest.model;

public enum Unidade {
	KG("kg"),
	UN ("Unidade"),
	PC ("Peça"),
	L ("Litros"),
	CX ("Caixa");
	
	private final String unidade;

	private Unidade(String unidade) {
		this.unidade = unidade;
	}

	public String getUnidade() {
		return unidade;
	}
	
}
