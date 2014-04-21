package br.ufc.edeajr.model;


@Entity
public class Especialidade {
	
	@Id @CascadeOnDelete 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_especialidade")
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
		return "Especialidade [id=" + id + ", nome=" + nome + "]";
	}
	
	

}
