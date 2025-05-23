package com.mottu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mottu.model.Galpao;
import com.mottu.repository.GalpaoRepository;

@RestController
@RequestMapping("/galpoes")
public class GalpaoController {

    @Autowired
    private GalpaoRepository galpaoRepository;

    @GetMapping
    public List<Galpao> listarTodos() {
        return galpaoRepository.findAll();
    }

    @PostMapping
    public Galpao criar(@RequestBody Galpao galpao) {
        return galpaoRepository.save(galpao);
    }

    @PutMapping("/{id}")
    public Galpao atualizar(@PathVariable Long id, @RequestBody Galpao galpao) {
        galpao.setId(id);
        return galpaoRepository.save(galpao);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        galpaoRepository.deleteById(id);
    }
}
