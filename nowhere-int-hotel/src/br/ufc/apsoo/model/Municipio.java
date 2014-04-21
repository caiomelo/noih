package br.ufc.apsoo.model;


@Entity
public class Municipio {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_municipio")
	private Long id;
	
	//@OneToOne(cascade=CascadeType.ALL) 
	//Deu problema: quando o Municipio foi deletado a UF também foi deletada
	//Agora está funcionando de boa na lagoa. FESHOW
	@JoinColumn(name="id_uf")
	private Uf uf;

	@NotEmpty(message="Campo obrigatório")
	@Column(name="nome")
	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Uf getUf() {
		return uf;
	}

	public void setUf(Uf uf) {
		this.uf = uf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Municipio [Id=" + id + ", uf=" + uf + ", nome=" + nome + "]";
	}
	

}
