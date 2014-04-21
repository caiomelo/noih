package br.ufc.apsoo.model;

@Entity
public class TecnicoResponsavel {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_tecnico_responsavel")
	private Long id;
	
	@Column(name="nome")
	@NotEmpty(message="Campo Obrigatório")
	private String nome;

	@OneToOne(cascade=CascadeType.ALL)
	//@Column(name="id_formacao")
	private Formacao formacao ;
	
	@OneToOne(cascade=CascadeType.ALL)
	//@Column(name="id_especialidade1")
	private Especialidade especialidade1;
	
	@OneToOne(cascade=CascadeType.ALL)
	//@Column(name="id_especialidade2")
	private Especialidade especialidade2;
		
	@Column(name="telefone")
	//@NotEmpty(message="Campo Obrigatório")
	private String telefone;
	
	@Column(name="email")
	//@NotEmpty(message="Campo Obrigatório")
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Formacao getFormacao() {
		return formacao;
	}

	public void setFormacao(Formacao formacao) {
		this.formacao = formacao;
	}

	public Especialidade getEspecialidade1() {
		return especialidade1;
	}

	public void setEspecialidade1(Especialidade especialidade1) {
		this.especialidade1 = especialidade1;
	}

	public Especialidade getEspecialidade2() {
		return especialidade2;
	}

	public void setEspecialidade2(Especialidade especialidade2) {
		this.especialidade2 = especialidade2;
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

	@Override
	public String toString() {
		return "TecnicoResponsavel [id=" + id + ", nome=" + nome
				+ ", formacao=" + formacao.toString() + ", especialidade1="
				+ especialidade1.toString() + ", especialidade2=" + especialidade2.toString()
				+ ", telefone=" + telefone + ", email=" + email + "]";
	}
	
		
}