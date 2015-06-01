package br.ufc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="comentario")
public class Comentario {
	
	//Comentario's attributes
	@Id
	@Column(name="id_comentario", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="id_noticia",referencedColumnName="id_noticia")
	private Noticia noticia;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="id_usuario",referencedColumnName="id_usuario")
	private Usuario usuario;
	
	@Column(name = "texto", nullable = false, length = 100) 
	private String texto;
               	
	//Constructors
	public Comentario(){
               		
	}
               	
	public Comentario(Long id, Noticia noticia, Usuario usuario, String texto) {
		super();
		this.id = id;
		this.noticia = noticia;
		this.usuario = usuario;
		this.texto = texto;
	}

	//Getters and Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Noticia getNoticia() {
		return noticia;
	}
	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
               	
	//ToString
	public String toString() {
		return "Comentario [id=" + id + ", noticia=" + noticia + ", usuario=" + usuario
               				+ ", texto=" + texto + "]";
	}

}
