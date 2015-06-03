package br.ufc.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table (name="noticia")
public class Noticia {
	
	
	//News' attributes
	@Id
	@Column(name = "id_noticia", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "titulo", nullable = false, length = 50)
	private String titulo;
	
	@Column(name = "subtitulo", nullable = false, length = 150)
	private String subtitulo;
	
	@Column(name = "texto", nullable = false, length = 500)
	private String texto;
	
	@Column(name = "data_noticia", nullable = false)
	private Date dataNoticia;
	
	@ManyToOne(optional=true)
	@JoinColumn(name="id_usuario",referencedColumnName="id_usuario")
	private Usuario usuario;

	@ManyToOne(optional=false)
	@JoinColumn(name="id_secao",referencedColumnName="id_secao")
	private Secao secao;
	
	@OneToMany(mappedBy = "noticia", targetEntity = Comentario.class)
	private List<Comentario> comentarios;
	
	
	//Constructors
	public Noticia(){
		
	}
	
	public Noticia(Long id, String titulo, String subtitulo, String texto,
			Usuario usuario, Date dataNoticia, Secao secao) {
		this.titulo = titulo;
		this.subtitulo = subtitulo;
		this.texto = texto;
		this.usuario = usuario;
		this.dataNoticia = dataNoticia;
		this.secao = secao;
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

	public String getSubtitulo() {
		return subtitulo;
	}

	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getDataNoticia() {
		return dataNoticia;
	}

	public void setDataNoticia(Date dataNoticia) {
		this.dataNoticia = dataNoticia;
	}

	public Secao getSecao() {
		return secao;
	}

	public void setSecao(Secao secao) {
		this.secao = secao;
	}

	//ToString
	public String toString() {
		return "Noticia [id=" + id + ", titulo=" + titulo + ", subtitulo="
				+ subtitulo + ", texto=" + texto + ", usuario=" + usuario
				+ ", dataNoticia=" + dataNoticia + ", secao=" + secao + "]";
	}

}
