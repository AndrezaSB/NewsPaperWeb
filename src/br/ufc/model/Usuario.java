package br.ufc.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
     
	//user's attributes
	@Id
	@Column(name = "id_usuario", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "login", nullable = false, length = 20)
	private String login;
	
	@Column(name = "senha", nullable = false, length = 20)
	private String senha;
	
	@Column(name = "nome", nullable = false, length = 50)
	private String nome;
	
	@Column(name = "email", nullable = false, length = 50)
	private String email;
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "usuario_role", joinColumns = @JoinColumn(name = "id_usuario" , 
        referencedColumnName="id_usuario"), inverseJoinColumns = @JoinColumn(name="id_role", 
        referencedColumnName="id_role"))
	private List<Role> funcoes;
	
	@OneToMany(mappedBy = "usuario", targetEntity = Noticia.class)
	private List<Noticia> noticias;
	
	@OneToMany(mappedBy = "usuario", targetEntity = Comentario.class)
	private List<Comentario> comentarios;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="autor", targetEntity=Classificado.class)
	private Classificado classificado;
	
	
	//Constructors
	public Usuario() {

	}

	public Usuario(Long id, String login, String senha, String nome,
			String email, Role role) {
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.email = email;
		this.funcoes.add(role);
	}

	//Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Role> getFuncoes() {
		return funcoes;
	}

	public void setFuncoes(Role funcao) {
		this.funcoes.add(funcao);
	}

	//ToString to test 
	public String toString() {
		return "Usuario [id=" + id + ", login=" + login + ", senha=" + senha
				+ ", nome=" + nome + ", email=" + email + ", funcoes=" + funcoes
				+ "]";
	}
}