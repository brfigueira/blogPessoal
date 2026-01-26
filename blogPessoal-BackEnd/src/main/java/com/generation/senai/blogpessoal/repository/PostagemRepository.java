package com.generation.senai.blogpessoal.repository;

// Importa a interface JpaRepository
import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.senai.blogpessoal.model.Postagem;

// Herda métodos prontos para manipular postagens no banco
public interface PostagemRepository extends JpaRepository<Postagem, Long> {

    // Postagem -> entidade manipulada
    // Long      -> tipo da chave primária (id)

}
