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
import org.hibernate.validator.constraints.br.CNPJ;

@Entity
public class Fornecedor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@UniqueElements(message = "CNPJ já existente. Favor verificar")
	@CNPJ(message = "Verifique se o campo CNPJ está correto")
	private String cnpj;
	@NotNull(message = "O nome do Fornecedor deve ser preenchido")
	private String nome;
	@Pattern(regexp="(\\d{2})\\d{4}-\\d{4}$")
	private String telefone;
	@Email
	private String email;
	
	@Embedded
	private Endereco endereco;

	//Constructors
	public Fornecedor(@CNPJ String cnpj, @NotNull(message = "O nome do Fornecedor deve ser preenchido") String nome,
			@Pattern(regexp = "(\\d{2})\\d{4}-\\d{4}$") String telefone, @Email String email, Endereco endereco) {
		super();
		this.cnpj = cnpj;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
	}

	public Fornecedor() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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
