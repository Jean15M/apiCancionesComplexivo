package com.ista.usuario.entity;

import java.io.Serializable;
import java.util.List;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="listarep")
public class ListaReproducción implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_lista;
	
	
	private String name;
	private String descripcion;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="id_lista")
	private List<Cancion> listaCanciones;

	public Long getId_lista() {
		return id_lista;
	}

	public void setId_lista(Long id_lista) {
		this.id_lista = id_lista;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Cancion> getListaCanciones() {
		return listaCanciones;
	}

	public void setListaCanciones(List<Cancion> listaCanciones) {
		this.listaCanciones = listaCanciones;
	}
	
	

}
