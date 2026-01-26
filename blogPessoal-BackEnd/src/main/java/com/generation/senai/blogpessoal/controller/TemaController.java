package com.generation.senai.blogpessoal.controller;

// Importações necessárias para listas, HTTP e REST
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.senai.blogpessoal.model.Tema;
import com.generation.senai.blogpessoal.repository.TemaRepository;

// @RestController indica que esta classe responde requisições HTTP
@RestController

// Define a rota base deste controller: /temas
@RequestMapping("/temas")

// Permite que aplicações externas acessem a API
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TemaController {

    // @Autowired injeta automaticamente o TemaRepository
    @Autowired
    private TemaRepository temaRepository;

    // @GetMapping responde requisições GET em /temas
    // Retorna todos os temas do banco
    @GetMapping
    public ResponseEntity<List<Tema>> getAll() {
        return ResponseEntity.ok(temaRepository.findAll());
    }

    // @PostMapping responde requisições POST em /temas
    // @RequestBody transforma o JSON recebido em um objeto Tema
    @PostMapping
    public ResponseEntity<Tema> postTema(@RequestBody Tema tema) {

        // Salva o tema no banco e retorna o objeto criado
        return ResponseEntity.status(201).body(temaRepository.save(tema));
    }
}
