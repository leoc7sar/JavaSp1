package com.mottu.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "motos")
public class Moto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String modelo;
	private String placa;
	private Boolean disponibilidade;

	@ManyToOne
	@JoinColumn(name = "galpao_id")
	@JsonBackReference
	@JsonIgnoreProperties("motos")
	private Galpao galpao;

	public Moto() {
	}

	public Moto(Long id, String modelo, String placa, Boolean disponibilidade, Galpao galpao) {
		this.id = id;
		this.modelo = modelo;
		this.placa = placa;
		this.disponibilidade = disponibilidade;
		this.galpao = galpao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Boolean getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(Boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public Galpao getGalpao() {
		return galpao;
	}

	public void setGalpao(Galpao galpao) {
		this.galpao = galpao;
	}
}
