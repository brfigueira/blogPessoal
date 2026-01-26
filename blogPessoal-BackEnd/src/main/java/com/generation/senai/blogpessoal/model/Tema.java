// Define o pacote onde esta classe está localizada
package com.generation.senai.blogpessoal.model;

// Importa as anotações do JPA para mapeamento com o banco
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

// @Entity informa ao Spring que esta classe representa uma tabela no banco
@Entity

// @Table define o nome real da tabela no MySQL
@Table(name = "tema")
public class Tema {

    // @Id define este campo como chave primária da tabela
    @Id

    // @GeneratedValue define que o valor será gerado automaticamente pelo banco
    // IDENTITY usa o auto_increment do MySQL
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @NotBlank impede que o campo seja nulo ou vazio
    @NotBlank(message = "A descrição é obrigatória")

    // @Size define tamanho mínimo e máximo do texto
    @Size(min = 3, max = 100)
    private String descricao;

    // Métodos getters e setters permitem ao Spring ler e alterar os valores

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
