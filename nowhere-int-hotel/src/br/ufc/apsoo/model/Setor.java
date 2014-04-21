package br.ufc.apsoo.model;


@Entity
public class Setor {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_setor")
	private Long id;
	
	@Column(name="setor_bacia")
	@NotEmpty(message="Campo Obrigatório")
	private String setorBacia;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSetorBacia() {
		return setorBacia;
	}

	public void setSetorBacia(String setorBacia) {
		this.setorBacia = setorBacia;
	}

	
	}
