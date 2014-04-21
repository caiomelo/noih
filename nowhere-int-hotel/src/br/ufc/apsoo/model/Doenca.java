package br.ufc.apsoo.model;


@Entity
public class Doenca {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_doenca")
	private Long id;
	
	@NotEmpty(message="Campo obrigatório")
	@Column(name = "nome")
	private String nome;

	@Column(name = "especialista")
	private String especialista;

	@Column(name = "observacao")
	private String observacao;

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

	public String getEspecialista() {
		return especialista;
	}

	public void setEspecialista(String especialista) {
		this.especialista = especialista;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	}
