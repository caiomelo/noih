package br.ufc.edeajr.model;


@Entity
public class Tecido {
	
	@Id	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_tecido")
	private Long id;

	@NotEmpty(message="Campo obrigatório")
	@Column(name = "orgao_tecido")
	private String orgaoTecido;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrgaoTecido() {
		return orgaoTecido;
	}

	public void setOrgaoTecido(String orgaoTecido) {
		this.orgaoTecido = orgaoTecido;
	}

	

}
