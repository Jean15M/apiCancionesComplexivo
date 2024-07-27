package com.ista.usuario.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="cancion", uniqueConstraints = { @UniqueConstraint(columnNames = { "id_lista", "id_cancion" })})
public class Cancion implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_cancion;
	
	private Long id_lista;
	
	private String title;
	private String artist;
	private String album;
	private Long year;
	public Long getId_cancion() {
		return id_cancion;
	}
	public void setId_cancion(Long id_cancion) {
		this.id_cancion = id_cancion;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public Long getYear() {
		return year;
	}
	public void setYear(Long year) {
		this.year = year;
	}
	public Long getId_lista() {
		return id_lista;
	}
	public void setId_lista(Long id_lista) {
		this.id_lista = id_lista;
	}
	
	
	
	

}
