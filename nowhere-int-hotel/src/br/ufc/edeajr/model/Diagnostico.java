package br.ufc.edeajr.model;


@Entity
public class Diagnostico {

	@Id	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_diagnostico")
	private Long id;

	@JoinColumn(name="id_amostragem")
	private Amostragem amostragem;
	
	@JoinColumn(name = "id_orgao_tecido")
	private String orgaoTecido;

	@JoinColumn(name = "id_problema")
	private Problema problema;
	
	@Column(name = "grau_afetacao")
	private int grauAfetacao;

	@JoinColumn(name="id_patogeno")
	private Patogeno patogeno;
	
	//tecido danificado ou vazio
	@Column(name = "nome_pat_observacao")
	private String observacao;

	@JoinColumn(name = "id_doenca")
	private Doenca doenca;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Amostragem getAmostragem() {
		return amostragem;
	}

	public void setAmostragem(Amostragem amostragem) {
		this.amostragem = amostragem;
	}

	public String getOrgaoTecido() {
		return orgaoTecido;
	}

	public void setOrgaoTecido(String orgaoTecido) {
		this.orgaoTecido = orgaoTecido;
	}

	public Problema getProblema() {
		return problema;
	}

	public void setProblema(Problema problema) {
		this.problema = problema;
	}

	public int getGrauAfetacao() {
		return grauAfetacao;
	}

	public void setGrauAfetacao(int grauAfetacao) {
		this.grauAfetacao = grauAfetacao;
	}

	public Patogeno getPatogeno() {
		return patogeno;
	}

	public void setPatogeno(Patogeno patogeno) {
		this.patogeno = patogeno;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Doenca getDoenca() {
		return doenca;
	}

	public void setDoenca(Doenca doenca) {
		this.doenca = doenca;
	}

		
}
