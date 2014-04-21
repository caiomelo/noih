package br.ufc.edeajr.model;

import java.util.Date;

@Entity
public class ManejoUnidadeProducao {
	
	@Id	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_manejo_unidade_producao")
	private Long id;
	
	@JoinColumn(name="id_propriedade")
	private Propriedade propriedade;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data")
	private Date data;
	
	@Column(name="up")
	private String up;
	
	@Column(name="cv_bombas")
	private int cvBombas;
	
	@Column(name="bombeamento")
	private float bombeamento;
	
	@Column(name="fertilizacao_inorganica")
	private boolean fertilizacaoInorganica;
	
	@Column(name="fertilizacao_organica")
	private boolean fertilizacaoOrganica;
	
	@Column(name="frequencia")
	private String frequencia;
	
	@Column(name="uso_quimico")
	private String usoQuimico;
	
	@Column(name="uso_bacteria")
	private String usoBacteria;
	
	@Column(name="uso_inmunoest")
	private boolean usoInmunoest;

	@Column(name="medicamento")
	private boolean medicamento;
	
	@Column(name="alimento")
	private int alimento;
	
	@Column(name="arracoamentos")
	private int arracoamentos;
	
	@Column(name="numero_bandeija")
	private int numeroBandeija;
	
	@Column(name="aeracao")
	private float aeracao;
	
	@Column(name="frequencia_biom")
	private String frequenciaBiom;

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

	public String getUp() {
		return up;
	}

	public void setUp(String up) {
		this.up = up;
	}

	public int getCvBombas() {
		return cvBombas;
	}

	public void setCvBombas(int cvBombas) {
		this.cvBombas = cvBombas;
	}

	public float getBombeamento() {
		return bombeamento;
	}

	public void setBombeamento(float bombeamento) {
		this.bombeamento = bombeamento;
	}

	public boolean isFertilizacaoInorganica() {
		return fertilizacaoInorganica;
	}

	public void setFertilizacaoInorganica(boolean fertilizacaoInorganica) {
		this.fertilizacaoInorganica = fertilizacaoInorganica;
	}

	public boolean isFertilizacaoOrganica() {
		return fertilizacaoOrganica;
	}

	public void setFertilizacaoOrganica(boolean fertilizacaoOrganica) {
		this.fertilizacaoOrganica = fertilizacaoOrganica;
	}

	public String getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(String frequencia) {
		this.frequencia = frequencia;
	}

	public String getUsoQuimico() {
		return usoQuimico;
	}

	public void setUsoQuimico(String usoQuimico) {
		this.usoQuimico = usoQuimico;
	}

	public String getUsoBacteria() {
		return usoBacteria;
	}

	public void setUsoBacteria(String usoBacteria) {
		this.usoBacteria = usoBacteria;
	}

	public boolean isUsoInmunoest() {
		return usoInmunoest;
	}

	public void setUsoInmunoest(boolean usoInmunoest) {
		this.usoInmunoest = usoInmunoest;
	}

	public boolean isMedicamento() {
		return medicamento;
	}

	public void setMedicamento(boolean medicamento) {
		this.medicamento = medicamento;
	}

	public int getAlimento() {
		return alimento;
	}

	public void setAlimento(int alimento) {
		this.alimento = alimento;
	}

	public int getArracoamentos() {
		return arracoamentos;
	}

	public void setArracoamentos(int arracoamentos) {
		this.arracoamentos = arracoamentos;
	}

	public int getNumeroBandeija() {
		return numeroBandeija;
	}

	public void setNumeroBandeija(int numeroBandeija) {
		this.numeroBandeija = numeroBandeija;
	}

	public float getAeracao() {
		return aeracao;
	}

	public void setAeracao(float aeracao) {
		this.aeracao = aeracao;
	}

	public String getFrequenciaBiom() {
		return frequenciaBiom;
	}

	public void setFrequenciaBiom(String frequenciaBiom) {
		this.frequenciaBiom = frequenciaBiom;
	}

	
}
