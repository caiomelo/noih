package br.ufc.apsoo.model;


@Entity
public class Produto {
	
	@Id	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_produto")
	private Long id;

	@Column(name = "nome_comercial")
	private String nomeComercial;
	
	@Column(name = "nome_tecnico")
	private String nomeTecnico;
	
	@Column(name = "uso")
	private String uso;

	@Column(name = "codigo")
	private String codigo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeComercial() {
		return nomeComercial;
	}

	public void setNomeComercial(String nomeComercial) {
		this.nomeComercial = nomeComercial;
	}

	public String getNomeTecnico() {
		return nomeTecnico;
	}

	public void setNomeTecnico(String nomeTecnico) {
		this.nomeTecnico = nomeTecnico;
	}

	public String getUso() {
		return uso;
	}

	public void setUso(String uso) {
		this.uso = uso;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
}
