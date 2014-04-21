package br.ufc.edeajr.model;

import java.util.Date;

import com.sun.istack.internal.NotNull;


@Entity
public class Propriedade{

	@Id	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_propriedade")
	private Long id;
	
	@NotEmpty(message="Campo obrigatório")
	@Column(name="nome")
	private String nome;
	
	@NotEmpty(message="Campo obrigatório")
	@Column(name="tipo")
	private String tipo;
	
	@Column(name="alugada")
	private boolean alugada;
	
	@NotEmpty(message="Campo obrigatório")
	@Column(name="proprietario")
	private String proprietario;
	
	@NotEmpty(message="Campo obrigatório")
	@Column(name="representante_legal")
	private String representanteLegal;
	
	@OneToOne(cascade=CascadeType.ALL)
	private TecnicoResponsavel tecnicoResponsavel;
	
	@NotEmpty(message="Campo obrigatório")
	@Column(name="endereco")
	private String endereco;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Municipio municipio;
	
	//Validar telefone
	@Column(name="telefone")
	private String telefone;
	
	//Validar celular
	@Column(name="celular")
	private String celular;
	
	//Validar email
	@Column(name="email")
	private String email;
	
	@JoinColumn(name="id_setor")
	//@OneToOne(cascade={CascadeType.ALL})
	private Setor setor;
	
	@NotEmpty(message="Campo obrigatório")
	@Column(name="q_ves")
	private String qVes;
	
	@NotNull(message="Campo obrigatório")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="inicio_ope")
	private Date inicioOpe;

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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean isAlugada() {
		return alugada;
	}

	public void setAlugada(boolean alugada) {
		this.alugada = alugada;
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public String getRepresentanteLegal() {
		return representanteLegal;
	}

	public void setRepresentanteLegal(String representanteLegal) {
		this.representanteLegal = representanteLegal;
	}

	public TecnicoResponsavel getTecnicoResponsavel() {
		return tecnicoResponsavel;
	}

	public void setTecnicoResponsavel(TecnicoResponsavel tecnicoResponsavel) {
		this.tecnicoResponsavel = tecnicoResponsavel;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public String getqVes() {
		return qVes;
	}

	public void setqVes(String qVes) {
		this.qVes = qVes;
	}

	public Date getInicioOpe() {
		return inicioOpe;
	}

	public void setInicioOpe(Date inicioOpe) {
		this.inicioOpe = inicioOpe;
	}

	@Override
	public String toString() {
		return "Propriedade [id=" + id + ", nome=" + nome + ", tipo=" + tipo
				+ ", alugada=" + alugada + ", proprietario=" + proprietario
				+ ", representanteLegal=" + representanteLegal
				+ ", tecnicoResponsavel=" + tecnicoResponsavel + ", endereco="
				+ endereco + ", municipio=" + municipio + ", telefone="
				+ telefone + ", celular=" + celular + ", email=" + email
				+ ", setor=" + setor + ", qVes=" + qVes + ", inicioOpe="
				+ inicioOpe + "]";
	}

	
}
