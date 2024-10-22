package com.example.bibliotecaVirtual.model; // Declaração do pacote onde esta classe está localizada.

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity // Anotação que indica que a classe é uma entidade JPA, ou seja, será mapeada para uma tabela no banco de dados.
@Table(name = "livros") // Especifica o nome da tabela no banco de dados para a entidade "Class".

public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Campo que representa o ID da classe na tabela do banco de dados.

    @Column(name = "titulo") // Especifica que o campo x está mapeado para a coluna x na tabela do banco de dados.
    private String titulo;

    @Column(name = "autor") // Especifica que o campo x está mapeado para a coluna x na tabela do banco de dados.
    private String autor;

    @Column(name = "isbn") // Especifica que o campo x está mapeado para a coluna x na tabela do banco de dados.
    private String isbn;

    @Column(name = "anoPublicacao") // Especifica que o campo x está mapeado para a coluna x na tabela do banco de dados.
    private Integer anoPublicacao;

    public Livro() {
        // Construtor padrão vazio, necessário para o JPA.
    }

    public Livro(String titulo, String autor, String isbn, Integer anoPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anoPublicacao = anoPublicacao;
    }

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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
}
