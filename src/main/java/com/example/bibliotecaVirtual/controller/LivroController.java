package com.example.bibliotecaVirtual.controller; // Declaração do pacote onde este controlador está localizado.

import java.util.List; // Importa a classe List para trabalhar com coleções de classes.
import java.util.Optional; // Importa a classe Optional para tratar valores possivelmente nulos.
import org.springframework.beans.factory.annotation.Autowired; // Importa a anotação para injetar dependências.
import org.springframework.http.HttpStatus; // Importa a classe HttpStatus para definir códigos de status HTTP.
import org.springframework.http.ResponseEntity; // Importa a classe ResponseEntity para encapsular respostas HTTP.
import org.springframework.web.bind.annotation.*; // Importa as anotações para mapear endpoints HTTP.
import com.example.bibliotecaVirtual.model.Livro; // Importa a classe de modelo Class.
import com.example.bibliotecaVirtual.repository.LivroRepository; // Importa o repositório de classes.



@CrossOrigin(origins = "http://localhost:8081") // Permite solicitações de origens diferentes.
@RestController // Indica que esta classe é um controlador REST.
@RequestMapping("/api") // Mapeia todas as URLs para "/api".

public class LivroController {

    @Autowired // Injeta o repositório de classes.
    private LivroRepository livroRepository;

    @PostMapping("/livros")
    public ResponseEntity<Livro> criarLivro(@RequestBody Livro livro) {
        Livro novoLivro = livroRepository.save(livro);
        return new ResponseEntity<>(novoLivro, HttpStatus.CREATED);
    }

    @GetMapping("/livros")
    public ResponseEntity<List<Livro>> listarLivros() {
        List<Livro> livros = livroRepository.findAll();
        return new ResponseEntity<>(livros, HttpStatus.OK);
    }

    @GetMapping("livros/{id}")
    public ResponseEntity<?> buscarLivroPorId(@PathVariable Long id) {
        Optional<Livro> livro = livroRepository.findById(id);
        if (livro.isPresent()) {
            return new ResponseEntity<>(livro.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Livro não encontrado com o id " + id, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/livros/{id}")
    public ResponseEntity<?> atualizarLivro(@PathVariable Long id, @RequestBody Livro livroAtualizado) {
        Optional<Livro> livroExistente = livroRepository.findById(id);
        if (livroExistente.isPresent()) {
            Livro livro = livroExistente.get();
            livro.setTitulo(livroAtualizado.getTitulo());
            livro.setAutor(livroAtualizado.getAutor());
            livro.setIsbn(livroAtualizado.getIsbn());
            livro.setAnoPublicacao(livroAtualizado.getAnoPublicacao());
            Livro livroAtualizadoResult = livroRepository.save(livro);
            return new ResponseEntity<>(livroAtualizadoResult, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Livro não encontrado com o id " + id, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/livros/{id}")
    public ResponseEntity<?> deletarLivro(@PathVariable Long id) {
        Optional<Livro> livro = livroRepository.findById(id);
        if (livro.isPresent()) {
            livroRepository.delete(livro.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>("Livro não encontrado com o id " + id, HttpStatus.NOT_FOUND);
        }
    }
}