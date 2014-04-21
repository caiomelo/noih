package br.ufc.edeajr.model;

import java.util.Date;

import com.sun.istack.internal.NotNull;

@Entity
public class Amostragem {

	@Id	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_amostragem")
	private Long id;

	@OneToOne(cascade=CascadeType.ALL)	
	private Propriedade propriedade;

	@NotNull(message="Campo obrigatório")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data")
	private Date data;

	@NotEmpty(message="Campo obrigatório")
	@Column(name = "unidade_prod")
	private String unidadeProducao;
	
	@NotEmpty(message="Campo obrigatório")
	@Column(name = "amostra_lote")
	private String amostraLote;
	
	@NotEmpty(message="Campo obrigatório")
	@Column(name = "tecnica")
	private String tecnica;

	@Column(name = "observacao")
	private String observacao;

	@Column(name = "erro")
	private String erro;

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

	public String getUnidadeProducao() {
		return unidadeProducao;
	}

	public void setUnidadeProducao(String unidadeProducao) {
		this.unidadeProducao = unidadeProducao;
	}

	public String getAmostraLote() {
		return amostraLote;
	}

	public void setAmostraLote(String amostraLote) {
		this.amostraLote = amostraLote;
	}

	public String getTecnica() {
		return tecnica;
	}

	public void setTecnica(String tecnica) {
		this.tecnica = tecnica;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	@Override
	public String toString() {
		return "Amostragem [id=" + id + ", propriedade=" + propriedade
				+ ", data=" + data + ", unidadeProducao=" + unidadeProducao
				+ ", amostraLote=" + amostraLote + ", tecnica=" + tecnica
				+ ", observacao=" + observacao + ", erro=" + erro + "]";
	}

}
