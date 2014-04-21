package br.ufc.apsoo.model;

@Entity
public class Uf {

	@Id	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_uf")
	private Long id;
	
	@Column(name="sigla")
	private String sigla;
	
	@Column(name="nome")
	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
