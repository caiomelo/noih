package br.ufc.apsoo.model;


@Entity
public class Patogeno {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_patogeno")
	private Long id;
	
	@Column(name="id_nome")
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

}
