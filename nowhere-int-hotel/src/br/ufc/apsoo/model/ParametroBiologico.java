package br.ufc.apsoo.model;

import java.util.Date;

@Entity
public class ParametroBiologico {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_parametro_biologico")
	private Long id;
	
	@JoinColumn(name="id_propriedade")
	private Propriedade propriedade;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data")
	private Date data;

	@Column(name="fito_analise")
	private boolean fito;
	
	@Column(name="fitoplancton")
	private float fitoplancton;

	@Column(name="zoo_analise")
	private boolean zoo;
	
	@Column(name="zooplancton")
	private float zooplancton;
	
	@Column(name="bacteriologica_analise")
	private boolean bacteriologica;

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

	public boolean isFito() {
		return fito;
	}

	public void setFito(boolean fito) {
		this.fito = fito;
	}

	public float getFitoplancton() {
		return fitoplancton;
	}

	public void setFitoplancton(float fitoplancton) {
		this.fitoplancton = fitoplancton;
	}

	public boolean isZoo() {
		return zoo;
	}

	public void setZoo(boolean zoo) {
		this.zoo = zoo;
	}

	public float getZooplancton() {
		return zooplancton;
	}

	public void setZooplancton(float zooplancton) {
		this.zooplancton = zooplancton;
	}

	public boolean isBacteriologica() {
		return bacteriologica;
	}

	public void setBacteriologica(boolean bacteriologica) {
		this.bacteriologica = bacteriologica;
	}



}
