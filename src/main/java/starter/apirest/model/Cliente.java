package starter.apirest.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.UniqueElements;
import org.hibernate.validator.constraints.br.CPF;

@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@UniqueElements(message = "CPF já existente. Favor verificar")
	@CPF(message = "Verifique se o campo CPF está correto")
	private String cpf;
	@NotNull(message = "O nome do Cliente deve ser preenchido")
	private String nome;
	@Pattern(regexp="(\\d{2})\\d{4}-\\d{4}$")
	private String telefone;
	@Email
	private String email;
	
	@Embedded
	private Endereco endereco;

	//Constructors
	public Cliente(@CPF String cpf, @NotNull(message = "O nome do Cliente deve ser preenchido") String nome,
			@Pattern(regexp = "(\\d{2})\\d{4}-\\d{4}$") String telefone, @Email String email, Endereco endereco) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
	}

	public Cliente() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
}
