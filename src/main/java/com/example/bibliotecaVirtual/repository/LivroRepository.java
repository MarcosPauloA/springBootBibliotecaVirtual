package com.example.bibliotecaVirtual.repository;

import java.util.List; // Importa a classe List para trabalhar com coleções de classes.
import org.springframework.data.jpa.repository.JpaRepository; // Importa a interface JpaRepository do Spring Data JPA.
import com.example.bibliotecaVirtual.model.Livro; // Importa a classe de modelo Class para especificar a entidade relacionada.

public interface LivroRepository extends JpaRepository<Livro, Long> {
    // Declaração da interface ClassRepository que estende JpaRepository para operações CRUD em Class.

    List<Livro> findByTitulo(String titulo);
    // Método de busca personalizado que retorna uma lista de Class com base no status "taught" (lecionada).

    List<Livro> findByAutor(String autor);
}