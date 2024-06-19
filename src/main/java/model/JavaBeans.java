package model;

public class JavaBeans {
	private Long id;
	private String codigo;
	private String nome;
	private Double preco;
	
	public JavaBeans() {}
	
	public JavaBeans(Long id, String codigo, String nome, Double preco) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
}
