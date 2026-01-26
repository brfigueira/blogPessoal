package com.generation.senai.blogpessoal.model;

// Importa classes para data e hora
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

// @Entity informa ao Spring que esta classe representa uma tabela no banco
@Entity

// @Table define o nome real da tabela no MySQL
@Table(name = "postagem")
public class Postagem {

    // @Id define este campo como chave primária
    @Id

    // @GeneratedValue define auto incremento
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @NotBlank impede campo vazio
    @NotBlank

    // @Size define limites do texto
    @Size(min = 3, max = 150)
    private String titulo;

    // @NotBlank impede texto vazio
    @NotBlank

    // @Column(columnDefinition = "TEXT") cria um campo TEXT no MySQL
    // Usado para textos longos
    @Column(columnDefinition = "TEXT")
    private String texto;

    // Armazena automaticamente a data de criação
    private LocalDateTime data = LocalDateTime.now();

    // @ManyToOne indica que muitas postagens pertencem a um autor
    @ManyToOne

    // @JoinColumn define o nome da chave estrangeira no banco
    @JoinColumn(name = "id_autor")
    private Autor autor;

    // @ManyToOne indica que muitas postagens pertencem a um tema
    @ManyToOne

    // Define a coluna id_tema como chave estrangeira
    @JoinColumn(name = "id_tema")
    private Tema tema;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }
}
