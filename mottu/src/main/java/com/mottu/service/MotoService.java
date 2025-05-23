package com.mottu.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.mottu.DTO.MotoDTO;
import com.mottu.mapper.MotoMapper;
import com.mottu.model.Galpao;
import com.mottu.model.Moto;
import com.mottu.repository.GalpaoRepository;
import com.mottu.repository.MotoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MotoService {

    @Autowired
    private GalpaoRepository galpaoRepository;

    @Autowired
    private MotoRepository motoRepository;

    @Cacheable("motosCache")
    public List<MotoDTO> listarTodas() {
        return motoRepository.findAll().stream()
                .map(MotoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public MotoDTO salvarMoto(MotoDTO motoDTO) {
        Galpao galpao = galpaoRepository.findById(motoDTO.getGalpaoId())
                .orElseThrow(() -> new EntityNotFoundException("Galpão não encontrado com ID: " + motoDTO.getGalpaoId()));

        Moto moto = MotoMapper.toEntity(motoDTO, galpao);
        return MotoMapper.toDTO(motoRepository.save(moto));
    }

    @Cacheable("motoPorId")
    public MotoDTO buscarPorId(Long id) {
        Moto moto = motoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Moto não encontrada com ID: " + id));
        return MotoMapper.toDTO(moto);
    }

    public MotoDTO atualizarMoto(Long id, MotoDTO novaMotoDTO) {
        Moto existente = motoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Moto não encontrada com ID: " + id));

        existente.setModelo(novaMotoDTO.getModelo());
        existente.setPlaca(novaMotoDTO.getPlaca());
        existente.setDisponibilidade(novaMotoDTO.getDisponivel());

        if (novaMotoDTO.getGalpaoId() != null) {
            Galpao galpao = galpaoRepository.findById(novaMotoDTO.getGalpaoId())
                    .orElseThrow(() -> new EntityNotFoundException("Galpão não encontrado"));
            existente.setGalpao(galpao);
        }

        return MotoMapper.toDTO(motoRepository.save(existente));
    }

    public void deletarMoto(Long id) {
        if (!motoRepository.existsById(id)) {
            throw new EntityNotFoundException("Moto com ID " + id + " não encontrada para exclusão.");
        }
        motoRepository.deleteById(id);
    }
}
