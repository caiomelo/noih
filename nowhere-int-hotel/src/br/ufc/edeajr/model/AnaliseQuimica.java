package br.ufc.edeajr.model;

import java.util.Date;

import com.sun.istack.internal.NotNull;

@Entity
public class AnaliseQuimica {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_analise_quimica")
	private Long id;

	@OneToOne(cascade=CascadeType.ALL)	
	private Propriedade propriedade;

	@NotNull(message="Campo obrigatório")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data")
	private Date data;
	
	@Column(name="amonia")
	private String amonia;
	
	@Column(name="nitrito")
	private String nitrito;
	
	@Column(name="nitrato")
	private String nitrato;
	
	@Column(name="ntotal")
	private String nTotal;
	
	@Column(name="fosforo")
	private String fosforo;
	
	@Column(name="dbo")
	private String dbo;
	
	@Column(name="alcalinidade")
	private String alcalinidade;
	
	@Column(name="solidos_susp")
	private String solidosSusp;

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

	public String getAmonia() {
		return amonia;
	}

	public void setAmonia(String amonia) {
		this.amonia = amonia;
	}

	public String getNitrito() {
		return nitrito;
	}

	public void setNitrito(String nitrito) {
		this.nitrito = nitrito;
	}

	public String getNitrato() {
		return nitrato;
	}

	public void setNitrato(String nitrato) {
		this.nitrato = nitrato;
	}

	public String getnTotal() {
		return nTotal;
	}

	public void setnTotal(String nTotal) {
		this.nTotal = nTotal;
	}

	public String getFosforo() {
		return fosforo;
	}

	public void setFosforo(String fosforo) {
		this.fosforo = fosforo;
	}

	public String getDbo() {
		return dbo;
	}

	public void setDbo(String dbo) {
		this.dbo = dbo;
	}

	public String getAlcalinidade() {
		return alcalinidade;
	}

	public void setAlcalinidade(String alcalinidade) {
		this.alcalinidade = alcalinidade;
	}

	public String getSolidosSusp() {
		return solidosSusp;
	}

	public void setSolidosSusp(String solidosSusp) {
		this.solidosSusp = solidosSusp;
	}
	
	
	
	

}
