package com.mottu.controller;

import com.mottu.model.Galpao;
import com.mottu.repository.GalpaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
