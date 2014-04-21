package br.ufc.apsoo.model;


@Entity
public class Formacao {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_formacao")
	private Long id;
	
	@Column(name = "nome")
	@NotEmpty(message="Campo Obrigatório")
	private String nome;

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

	@Override
	public String toString() {
		return "Formacao [id=" + id + ", nome=" + nome + "]";
	}
	
}
