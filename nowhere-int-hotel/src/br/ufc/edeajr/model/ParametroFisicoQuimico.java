package br.ufc.edeajr.model;

import java.util.Date;

@Entity
public class ParametroFisicoQuimico {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_parametro_fisico_quimico")
	private Long id;
	
	@JoinColumn(name="id_propriedade")
	private Propriedade propriedade;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data")
	private Date data;
	
	@Column(name="oxi_min")
	private float oxiMin;
	
	@Column(name="oxi_max")
	private float oxiMax;
	
	@Column(name="temperatura_min")
	private float temperaturaMin;
	
	@Column(name="temperatura_max")
	private float temperaturaMax;
	
	@Column(name="ph")
	private float ph;
	
	@Column(name="salinidade")
	private int salinidade;
	
	@Column(name="transparencia")
	private int transparencia;
	
	@Column(name="analise_quimica")
	private boolean analiseQuimica;
	
	@Column(name="frequencia")
	private String frequencia;
	
	@Column(name="observacao")
	private String observacao;

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

	public float getOxiMin() {
		return oxiMin;
	}

	public void setOxiMin(float oxiMin) {
		this.oxiMin = oxiMin;
	}

	public float getOxiMax() {
		return oxiMax;
	}

	public void setOxiMax(float oxiMax) {
		this.oxiMax = oxiMax;
	}

	public float getTemperaturaMin() {
		return temperaturaMin;
	}

	public void setTemperaturaMin(float temperaturaMin) {
		this.temperaturaMin = temperaturaMin;
	}

	public float getTemperaturaMax() {
		return temperaturaMax;
	}

	public void setTemperaturaMax(float temperaturaMax) {
		this.temperaturaMax = temperaturaMax;
	}

	public float getPh() {
		return ph;
	}

	public void setPh(float ph) {
		this.ph = ph;
	}

	public int getSalinidade() {
		return salinidade;
	}

	public void setSalinidade(int salinidade) {
		this.salinidade = salinidade;
	}

	public int getTransparencia() {
		return transparencia;
	}

	public void setTransparencia(int transparencia) {
		this.transparencia = transparencia;
	}

	public boolean isAnaliseQuimica() {
		return analiseQuimica;
	}

	public void setAnaliseQuimica(boolean analiseQuimica) {
		this.analiseQuimica = analiseQuimica;
	}

	public String getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(String frequencia) {
		this.frequencia = frequencia;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}


}
