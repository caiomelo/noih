package br.ufc.edeajr.model;


@Entity
public class Usuario {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_usuario")
	private Integer id;

	@Column(name = "nome")
	@NotEmpty(message="Campo obrigatório")
	private String nome;

	@Column(name = "email")
	@NotEmpty(message="Campo obrigatório")
	private String email;

	@Column(name = "login")
	@NotEmpty(message="Campo obrigatório")
	private String login;

	@Column(name = "senha")
	@NotEmpty(message="Campo obrigatório")
	@Length(min=6, message="A senha deve ter no mínimo 6 caracteres")
	private String senha;

	@Column(name = "telefone1")
	@NotEmpty(message="Campo obrigatório")
	private String telefone1;

	@Column(name = "telefone2")
	private String telefone2;

	@Column(name = "ativo")
	private boolean ativo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}
