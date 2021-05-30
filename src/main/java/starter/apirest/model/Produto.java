package starter.apirest.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotNull;

@Entity
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull(message = "Campo do produto deve ser preenchido")
	private String nome;
	@NotNull(message = "Campo descrição do produto deve ser preenchido")
	private String descricao;
	@NotNull(message = "Campo unidade do produto não deve ser preenchido")	
	@Enumerated(EnumType.STRING)
	private Unidade unidade;
	
//	@OneToOne(mappedBy = "produto", cascade = CascadeType.ALL)
	@OneToOne(mappedBy = "produto")
	@PrimaryKeyJoinColumn
	private Estoque estoque;
	
	//Construtores
	public Produto() {
	}

	public Produto(long id, String nome, String descricao, Unidade unidade) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.unidade = unidade;
	}

	//Getters and Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", unidade=" + unidade + "]";
	}
	
}
