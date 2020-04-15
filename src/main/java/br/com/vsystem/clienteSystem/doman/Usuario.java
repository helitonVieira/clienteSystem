package br.com.vsystem.clienteSystem.doman;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @Column(name="cod_usuario", nullable=false, unique=true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod_usuario;
     
	@NotNull(message="Nome não pode ser nulo")
	@NotEmpty(message="Nome não pode ser vazio")
    @Column(name="nom_usuario", nullable=false, unique=true)
    private String nom_usuario;	
    
    public Usuario() {
    	
    }
    
	public Usuario(Long cod_usuario, String nom_usuario) {
		super();
		this.cod_usuario = cod_usuario;
		this.nom_usuario = nom_usuario;
	}

	public Long getCod_usuario() {
		return cod_usuario;
	}

	public void setCod_usuario(Long cod_usuario) {
		this.cod_usuario = cod_usuario;
	}

	public String getNom_usuario() {
		return nom_usuario;
	}

	public void setNom_usuario(String nom_usuario) {
		this.nom_usuario = nom_usuario;
	}

	@Override
	public String toString() {
		return "Usuario [cod_usuario=" + cod_usuario + ", nom_usuario=" + nom_usuario + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod_usuario == null) ? 0 : cod_usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (cod_usuario == null) {
			if (other.cod_usuario != null)
				return false;
		} else if (!cod_usuario.equals(other.cod_usuario))
			return false;
		return true;
	}

	
    
  }
