package com.mottu.DTO;

import java.util.List;

import jakarta.validation.constraints.NotBlank;

public class GalpaoDTO {

    private Long id;

    @NotBlank(message = "O nome do galpão é obrigatório")
    private String nome;

    @NotBlank(message = "O endereço do galpão é obrigatório")
    private String endereco;
    
	private List<MotoDTO> motos;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<MotoDTO> getMotos() {
		return motos;
	}

	public void setMotos(List<MotoDTO> motos) {
		this.motos = motos;
	}


    
}
