package com.mottu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.mottu.model.Moto;
import com.mottu.repository.MotoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MotoService {

    @Autowired
    private MotoRepository motoRepository;

    @Cacheable("todas") 
    public List<Moto> listarTodas() {
        return motoRepository.findAll();
    }

    @Cacheable
    public Moto buscarPorId(Long id) {
        return motoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Moto não encontrada com ID: " + id));
    }


    public Moto cadastrarMoto(Moto moto) {
        return motoRepository.save(moto);
    }

    public Moto atualizarMoto(Long id, Moto novaMoto) {
        Moto motoExistente = buscarPorId(id);
        motoExistente.setModelo(novaMoto.getModelo());
        motoExistente.setPlaca(novaMoto.getPlaca());
        motoExistente.setDisponibilidade(novaMoto.getDisponibilidade());
        return motoRepository.save(motoExistente);
    }

    public void deletarMoto(Long id) {
        motoRepository.deleteById(id);
    }
}
