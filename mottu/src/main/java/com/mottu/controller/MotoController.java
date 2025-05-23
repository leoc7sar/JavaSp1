package com.mottu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mottu.DTO.MotoDTO;
import com.mottu.mapper.MotoMapper;
import com.mottu.model.Moto;
import com.mottu.repository.GalpaoRepository;
import com.mottu.repository.MotoRepository;
import com.mottu.service.MotoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/motos")
public class MotoController {

	private final MotoRepository motoRepository;
	private final GalpaoRepository galpaoRepository;
	private final MotoService motoService;

	@Autowired
	public MotoController(MotoRepository motoRepository, GalpaoRepository galpaoRepository, MotoService motoService) {
		this.motoRepository = motoRepository;
		this.galpaoRepository = galpaoRepository;
		this.motoService = motoService;
	}

	@GetMapping
	public ResponseEntity<List<MotoDTO>> listarMotos(@RequestParam(required = false) String modelo, Pageable pageable) {
		List<Moto> motos = (modelo == null || modelo.isBlank()) ? motoRepository.findAll()
				: motoRepository.findByModeloContainingIgnoreCase(modelo, pageable).getContent();

		List<MotoDTO> dtos = motos.stream().map(MotoMapper::toDTO).toList();
		return ResponseEntity.ok(dtos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<MotoDTO> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(motoService.buscarPorId(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<MotoDTO> atualizarMoto(@PathVariable Long id, @RequestBody MotoDTO dto) {
		return ResponseEntity.ok(motoService.atualizarMoto(id, dto));
	}

	@PostMapping
	public ResponseEntity<MotoDTO> criar(@RequestBody @Valid MotoDTO dto) {
		MotoDTO salva = motoService.salvarMoto(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(salva);
	}
}