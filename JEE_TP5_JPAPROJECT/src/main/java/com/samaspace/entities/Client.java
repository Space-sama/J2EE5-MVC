package com.samaspace.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "client")
public class Client implements Serializable {
	
	private int id;
	private String nom;
	
	
	public Client() {
		super();
	}
	private String ville;
	
	
	public Client(String nom, String ville) {
		super();
		this.nom = nom;
		this.ville = ville;
	}
	
	public Client(int id, String nom, String ville) {
		super();
		this.id = id;
		this.nom = nom;
		this.ville = ville;
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "name", nullable = false)
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@Column(name = "town", nullable = false)
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}

}
