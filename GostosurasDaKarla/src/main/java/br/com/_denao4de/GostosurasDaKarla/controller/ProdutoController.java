package br.com._denao4de.GostosurasDaKarla.controller;


import br.com._denao4de.GostosurasDaKarla.repository.ProdutoRepository;
import br.com._denao4de.GostosurasDaKarla.repository.UsuarioRepository;
import br.com._denao4de.GostosurasDaKarla.model.Produto;
import br.com._denao4de.GostosurasDaKarla.model.Usuario;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class ProdutoController {

    private final ProdutoRepository repository;

    public ProdutoController(ProdutoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Produto> listar() {
        return repository.findAll();
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Produto>buscarPorId(@PathVariable Long id){
        
        Optional<Produto> produtoBuscado = repository.findById(id);

        if (produtoBuscado.isPresent()) {
            return ResponseEntity.ok(produtoBuscado.get());
            
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto criar(@RequestBody @Valid Produto produto) {
        return repository.save(produto);

    }

    @PutMapping("/{id}")
    public Produto atualizar(
            @PathVariable Long id,
            @RequestBody @Valid Produto produto) {

        Produto produtoExistente = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Produto não encontrado"));

        produtoExistente.setNome(produto.getNome());
        produtoExistente.setPreco(produto.getPreco());
        produtoExistente.setDescricao(produto.getDescricao());
        produtoExistente.setDataValidade(produto.getDataValidade());

        return repository.save(produtoExistente);
    }

    @DeleteMapping ("/{id}")
    @ResponseStatus     (HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Produto não encontrado");
        }

        repository.deleteById(id);
    }


}