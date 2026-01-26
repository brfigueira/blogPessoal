package com.generation.senai.blogpessoal.repository;

// Importa a interface JpaRepository do Spring Data JPA
import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.senai.blogpessoal.model.Autor;

// Esta interface herda todos os métodos prontos de acesso ao banco
// findAll(), findById(), save(), delete(), etc.
public interface AutorRepository extends JpaRepository<Autor, Long> {

    // <Autor, Long> significa:
    // Autor -> entidade que será manipulada
    // Long  -> tipo da chave primária (id)

}
