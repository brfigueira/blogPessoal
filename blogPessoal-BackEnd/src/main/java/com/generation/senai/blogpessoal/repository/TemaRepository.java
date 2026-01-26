package com.generation.senai.blogpessoal.repository;

// Importa a interface JpaRepository do Spring Data JPA
import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.senai.blogpessoal.model.Tema;

// Esta interface herda todos os métodos prontos de acesso ao banco:
// save(), findAll(), findById(), delete(), etc.
public interface TemaRepository extends JpaRepository<Tema, Long> {

    // <Tema, Long> significa:
    // Tema -> entidade que será manipulada
    // Long -> tipo da chave primária (id)

}
