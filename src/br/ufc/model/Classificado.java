package br.ufc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="classificado")
public class Classificado {

	@Id
	@Column(name = "id_role", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "titulo", nullable = false, length = 50)
	private String titulo;
	
	@Column(name = "texto", nullable = false, length = 250)
	private String texto;
	
	@Column(name = "preco", precision = 2)
	private float preco;
	
	@Column(name = "telefone", nullable = false, length = 20)
	private String telefone;
	
	@Column(name = "melhor_oferta", precision = 2)
	private float melhorOferta;
	
	@Column(name = "data_oferta")
	private Date dataOferta;
	
	@OneToOne
	@JoinColumn(name = "id_usuario") 
	private Usuario autor;
	
	//Constructors
	public Classificado(){
		
	}
	
	public Classificado(Long id, String titulo, String texto, float preco,
			String telefone) {
		this.id = id;
		this.titulo = titulo;
		this.texto = texto;
		this.preco = preco;
		this.telefone = telefone;
	}

	//Getters and Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public float getMelhor_oferta() {
		return melhorOferta;
	}
	public void setMelhor_oferta(float melhor_oferta) {
		this.melhorOferta = melhor_oferta;
	}
	public Date getData_oferta() {
		return dataOferta;
	}
	public void setData_oferta(Date data_oferta) {
		this.dataOferta = data_oferta;
	}
	public Usuario getAutor() {
		return autor;
	}
	public void setAutor(Usuario autor) {
		this.autor = autor;
	}
	
	//ToString
	public String toString() {
		return "Classificado [id=" + id + ", titulo=" + titulo + ", texto=" + texto
				+ ", preco=" + preco + ", telefone=" + telefone
				+ ", melhorOferta=" + melhorOferta + ", dataOferta=" + dataOferta
				+ ", autor=" + autor + "]";
	}
	
}
