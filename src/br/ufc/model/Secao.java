package br.ufc.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="secao")
public class Secao {

	//Secao's attributes
	@Id
	@Column(name = "id_secao", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "titulo", nullable = false, length = 20) 
	private String titulo;
	
	@Column(name = "descricao", nullable = false, length = 100) 
	private String descricao;
	
	@OneToMany(mappedBy="secao",targetEntity=Noticia.class,fetch=FetchType.EAGER)
	private List<Noticia> noticias;
	
	//Constructors
	public Secao(){
		
	}
	
	public Secao(String titulo, String descricao){
		this.titulo = titulo;
		this.descricao = descricao;
	}
	
	
	public List<Noticia> getNoticias() {
		return noticias;
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
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	//ToString
	public String toString() {
		return "Secao [id=" + id + ", titulo=" + titulo + ", descricao="
				+ descricao + "]";
	}
}
