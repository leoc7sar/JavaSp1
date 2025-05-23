package com.mottu.DTO;

import com.mottu.repository.GalpaoRepository;
import com.mottu.repository.MotoRepository;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class MotoDTO {

	private Long id;

	@NotBlank(message = "O modelo é obrigatório")
	private String modelo;

	@Pattern(regexp = "^[A-Z]{3}\\d{4}$", message = "A placa deve seguir o formato correto (AAA1234)")
	@NotBlank(message = "A placa é obrigatória")
	private String placa;

	@NotNull(message = "A disponibilidade deve ser informada")
	private Boolean disponivel;

	@NotNull(message = "O ID do galpão é obrigatório")
	private Long galpaoId;

	private MotoRepository motoRepository;

	private GalpaoRepository galpaoRepository;

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

	public Boolean getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(Boolean disponivel) {
		this.disponivel = disponivel;
	}

	public Long getGalpaoId() {
		return galpaoId;
	}

	public void setGalpaoId(Long galpaoId) {
		this.galpaoId = galpaoId;
	}

	public MotoRepository getMotoRepository() {
		return motoRepository;
	}

	public void setMotoRepository(MotoRepository motoRepository) {
		this.motoRepository = motoRepository;
	}

	public GalpaoRepository getGalpaoRepository() {
		return galpaoRepository;
	}

	public void setGalpaoRepository(GalpaoRepository galpaoRepository) {
		this.galpaoRepository = galpaoRepository;
	}

}
