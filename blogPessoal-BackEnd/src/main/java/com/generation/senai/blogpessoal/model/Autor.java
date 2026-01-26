// Define em qual pacote esta classe está localizada
package com.generation.senai.blogpessoal.model;

// Importa as anotações do JPA que fazem o mapeamento com o banco de dados
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

// @Entity informa ao Spring que esta classe representa uma tabela do banco
@Entity

// @Table define explicitamente o nome da tabela no MySQL
@Table(name = "autor")
public class Autor {

    // @Id indica que este atributo será a chave primária da tabela
    @Id

    // @GeneratedValue define que o valor será gerado automaticamente pelo banco
    // GenerationType.IDENTITY usa o auto_increment do MySQL
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @NotBlank impede que o campo seja nulo ou vazio
    @NotBlank(message = "O nome é obrigatório")

    // @Size define o tamanho mínimo e máximo do texto
    @Size(min = 3, max = 100)
    private String nome;

    // Campo obrigatório
    @NotBlank(message = "O email é obrigatório")

    // @Email garante que o texto siga o formato de email
    @Email
    private String email;

    // Campo obrigatório
    @NotBlank(message = "A senha é obrigatória")

    // Define tamanho mínimo da senha
    @Size(min = 6)
    private String senha;

    // Métodos getters e setters permitem que o Spring leia e altere os valores

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
