package br.ufc.edeajr.model;


@Entity
public class Laboratorio {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_laboratorio")
	private Long id;

	@Column(name = "nome")
	private String nome;
	
	@Column(name = "endereco")
	private String endereco;
	
	@Column(name = "representante_comercial")
	private String representanteComercial;
	
	@Column(name = "capacidade_prod")
	private String capacidadeProd;
	
	@Column(name = "proprietario")
	private String proprietario;
	
	@Column(name = "biosseguro")
	private boolean biosseguro;
	
	@Column(name = "prog_genetica")
	private boolean progGenetica;
	
	@Column(name = "sigla")
	private String sigla;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getRepresentanteComercial() {
		return representanteComercial;
	}

	public void setRepresentanteComercial(String representanteComercial) {
		this.representanteComercial = representanteComercial;
	}

	public String getCapacidadeProd() {
		return capacidadeProd;
	}

	public void setCapacidadeProd(String capacidadeProd) {
		this.capacidadeProd = capacidadeProd;
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public boolean isBiosseguro() {
		return biosseguro;
	}

	public void setBiosseguro(boolean biosseguro) {
		this.biosseguro = biosseguro;
	}

	public boolean isProgGenetica() {
		return progGenetica;
	}

	public void setProgGenetica(boolean progGenetica) {
		this.progGenetica = progGenetica;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	
	
	

}
