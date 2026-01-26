package com.generation.senai.blogpessoal.controller;

// Importações necessárias para trabalhar com listas, HTTP e anotações REST
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.senai.blogpessoal.model.Autor;
import com.generation.senai.blogpessoal.repository.AutorRepository;

// @RestController indica que esta classe responde requisições HTTP
@RestController

// Define a rota base deste controller: /autores
@RequestMapping("/autores")

// Permite que aplicações externas (front-end) acessem a API
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AutorController {

    // @Autowired injeta automaticamente o AutorRepository
    // O Spring cria o objeto para nós
    @Autowired
    private AutorRepository autorRepository;

    // @GetMapping responde requisições GET em /autores
    // Retorna todos os autores do banco
    @GetMapping
    public ResponseEntity<List<Autor>> getAll() {
        return ResponseEntity.ok(autorRepository.findAll());
    }

    // @PostMapping responde requisições POST em /autores
    // @RequestBody transforma o JSON recebido em um objeto Autor
    @PostMapping
    public ResponseEntity<Autor> postAutor(@RequestBody Autor autor) {

        // Salva o autor no banco e retorna o objeto criado
        return ResponseEntity.status(201).body(autorRepository.save(autor));
    }
}
