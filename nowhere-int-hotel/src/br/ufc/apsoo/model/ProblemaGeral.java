package br.ufc.apsoo.model;


@Entity
public class ProblemaGeral {
	
	@Id	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_problema_geral")
	private Long id;

	
	@Column(name = "nome")
	@NotEmpty(message="Campo obrigatório")
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
