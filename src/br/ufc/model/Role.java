package br.ufc.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {
	
	@Id
	@Column(name = "id_role", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "role", nullable = false, length = 20)
	private String role;
	
	@ManyToMany(mappedBy="funcoes")
	private List<Usuario> usuarios;
	
	//Constructors
	public Role(){
		
	}
	
	public Role(Long id, String role) {
		this.id = id;
		this.role = role;
	}

	//Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	//ToString
	public String toString() {
		return "Role [id=" + id + ", role=" + role + "]";
	}

}
