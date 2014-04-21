package br.ufc.edeajr.model;

import java.util.Date;

@Entity
public class RegistroVisita {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_registro")
	private Long id;
	
	@JoinColumn(name="id_propriedade")
	private Propriedade propriedade;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data")
	private Date data;

	@Column(name="responsavel")
	private String responsavel;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Propriedade getPropriedade() {
		return propriedade;
	}

	public void setPropriedade(Propriedade propriedade) {
		this.propriedade = propriedade;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}


}
