package br.ufc.apsoo.model;

import java.util.Date;

import com.sun.istack.internal.NotNull;

@Entity
public class Biopatometria {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_biopatometria")
	private Long id;

	@JoinColumn(name = "id_propriedade")
	private Propriedade propriedade;

	@NotNull(message="Campo obrigatório")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data")
	private Date data;

	@Column(name = "up")
	private int up;

	@Column(name = "qtd_amostra")
	private int qtdAmostra;

	@Column(name = "grama")
	private double grama;
	
	@Column(name = "qtd_afetado")
	private int qtdAfetado;

	@JoinColumn(name="id_problema")
	private Problema problema;

	@Column(name = "grau_de_severidade")
	private int grauSeveridade;

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

	public int getUp() {
		return up;
	}

	public void setUp(int up) {
		this.up = up;
	}

	public int getQtdAmostra() {
		return qtdAmostra;
	}

	public void setQtdAmostra(int qtdAmostra) {
		this.qtdAmostra = qtdAmostra;
	}

	public double getGrama() {
		return grama;
	}

	public void setGrama(double grama) {
		this.grama = grama;
	}

	public int getQtdAfetado() {
		return qtdAfetado;
	}

	public void setQtdAfetado(int qtdAfetado) {
		this.qtdAfetado = qtdAfetado;
	}

	public Problema getProblema() {
		return problema;
	}

	public void setProblema(Problema problema) {
		this.problema = problema;
	}

	public int getGrauSeveridade() {
		return grauSeveridade;
	}

	public void setGrauSeveridade(int grauSeveridade) {
		this.grauSeveridade = grauSeveridade;
	}

}
