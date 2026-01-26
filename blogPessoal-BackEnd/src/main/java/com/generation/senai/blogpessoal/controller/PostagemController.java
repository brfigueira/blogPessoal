package com.generation.senai.blogpessoal.controller;

// Importações para listas, HTTP e REST
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.senai.blogpessoal.model.Postagem;
import com.generation.senai.blogpessoal.repository.PostagemRepository;

// Indica que esta classe responde requisições HTTP
@RestController

// Define a rota base: /postagens
@RequestMapping("/postagens")

// Libera acesso externo à API
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagemController {

    // Injeta automaticamente o PostagemRepository
    @Autowired
    private PostagemRepository postagemRepository;

    // GET /postagens → lista todas as postagens
    @GetMapping
    public ResponseEntity<List<Postagem>> getAll() {
        return ResponseEntity.ok(postagemRepository.findAll());
    }

    // POST /postagens → cria uma nova postagem
    // @RequestBody transforma o JSON em objeto Postagem
    @PostMapping
    public ResponseEntity<Postagem> postPostagem(@RequestBody Postagem postagem) {

        // Salva a postagem no banco e retorna o objeto criado
        return ResponseEntity.status(201).body(postagemRepository.save(postagem));
    }
}
