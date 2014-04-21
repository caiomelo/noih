package br.ufc.edeajr.model;

import java.util.Date;

@Entity
public class MortalidadeRegistrada {
	
	@Id	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_mortalidade_registrada")
	private Long id;

	@JoinColumn(name = "id_propriedade")
	private Propriedade propriedade;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data")
	private Date data;
	
	@Column(name="mes")
	private int mes;
	
	@Column(name="ano")
	private int ano;
	
	@Column(name="qtd_ves_problema")
	private int qtdVesProblema;
	
	@Column(name="grau_problema")
	private int grauProblema;
	
	@Column(name="idade_animal")
	private String idadeAnimal;
	
	@Column(name="densidade_povoamento")
	private int densidadePovoamento;
	
	@JoinColumn(name="id_laboratorio_origem")
	private Laboratorio laboratorio;
	
	@JoinColumn(name="id_produto_racao")
	private Produto produto;
	
	@JoinColumn(name="id_problema_geral")
	private ProblemaGeral problemaGeral;
	
	@Column(name="epoca_climatica")
	private String epocaClimatica;
	
	@Column(name="salinidade_ves")
	private String salinidadeVes;
	
	@Column(name="temperatura_min")
	private String temperaturaMin;
	
	@Column(name="prejuizo_estimado")
	private int prejuizoEstimado;

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

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getQtdVesProblema() {
		return qtdVesProblema;
	}

	public void setQtdVesProblema(int qtdVesProblema) {
		this.qtdVesProblema = qtdVesProblema;
	}

	public int getGrauProblema() {
		return grauProblema;
	}

	public void setGrauProblema(int grauProblema) {
		this.grauProblema = grauProblema;
	}

	public String getIdadeAnimal() {
		return idadeAnimal;
	}

	public void setIdadeAnimal(String idadeAnimal) {
		this.idadeAnimal = idadeAnimal;
	}

	public int getDensidadePovoamento() {
		return densidadePovoamento;
	}

	public void setDensidadePovoamento(int densidadePovoamento) {
		this.densidadePovoamento = densidadePovoamento;
	}

	public Laboratorio getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public ProblemaGeral getProblemaGeral() {
		return problemaGeral;
	}

	public void setProblemaGeral(ProblemaGeral problemaGeral) {
		this.problemaGeral = problemaGeral;
	}

	public String getEpocaClimatica() {
		return epocaClimatica;
	}

	public void setEpocaClimatica(String epocaClimatica) {
		this.epocaClimatica = epocaClimatica;
	}

	public String getSalinidadeVes() {
		return salinidadeVes;
	}

	public void setSalinidadeVes(String salinidadeVes) {
		this.salinidadeVes = salinidadeVes;
	}

	public String getTemperaturaMin() {
		return temperaturaMin;
	}

	public void setTemperaturaMin(String temperaturaMin) {
		this.temperaturaMin = temperaturaMin;
	}

	public int getPrejuizoEstimado() {
		return prejuizoEstimado;
	}

	public void setPrejuizoEstimado(int prejuizoEstimado) {
		this.prejuizoEstimado = prejuizoEstimado;
	}

}
