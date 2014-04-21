package br.ufc.apsoo.model;


@Entity
public class Problema {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_problema")
	private Long id;

	@Column(name = "id_ocorrencia")
	@NotEmpty(message = "Campo Obrigatório")
	private String ocorrencia;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOcorrencia() {
		return ocorrencia;
	}

	public void setOcorrencia(String ocorrencia) {
		this.ocorrencia = ocorrencia;
	}

}
