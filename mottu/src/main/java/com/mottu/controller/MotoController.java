package com.mottu.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mottu.DTO.MotoDTO;
import com.mottu.model.Galpao;
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
	
	private MotoService motoService;
	@Autowired
	public MotoController(MotoRepository motoRepository, GalpaoRepository galpaoRepository) {
		this.motoRepository = motoRepository;
		this.galpaoRepository = galpaoRepository;
		this.motoService = motoService;
	}

	@GetMapping
	public ResponseEntity<Page<Moto>> listarMotos(@RequestParam(required = false) String modelo, Pageable pageable) {
		Page<Moto> motos = (modelo == null || modelo.isBlank()) ? motoRepository.findAll(pageable)
				: motoRepository.findByModeloContainingIgnoreCase(modelo, pageable);
		return ResponseEntity.ok(motos);
	}

	public List<MotoDTO> listar(@RequestParam(required = false) String modelo) {
		return null;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Moto> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(motoService.buscarPorId(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Moto> atualizarMoto(@PathVariable Long id, @RequestBody Moto moto) {
		return ResponseEntity.ok(motoService.atualizarMoto(id, moto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarMoto(@PathVariable Long id) {
		motoService.deletarMoto(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping
	public ResponseEntity<Moto> criar(@RequestBody @Valid MotoDTO dto) {
		Moto moto = new Moto();
		moto.setModelo(dto.getModelo());
		moto.setPlaca(dto.getPlaca());
		moto.setDisponibilidade(dto.getDisponivel());
		Galpao galpao = galpaoRepository.findById(dto.getGalpaoId())
				.orElseThrow(() -> new RuntimeException("Galpão cheio"));
		moto.setGalpao(galpao);
		Moto salva = motoRepository.save(moto);
		return ResponseEntity.status(HttpStatus.CREATED).body(salva);
	}


}