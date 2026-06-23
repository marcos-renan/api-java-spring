package br.com.marcos.api.controller;

import br.com.marcos.api.model.Produto;
import br.com.marcos.api.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto){

        //setando id manualmente
        var id = UUID.randomUUID().toString();
        produto.setId(id);

        produtoRepository.save(produto);
        return produto;
    }

    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable("id") String id){

        //metodo completo
        //Optional<Produto> produto = produtoRepository.findById(id);
        //return produto.isPresent() ? produto.get() : null;

        //metodo otimizado
        return produtoRepository.findById(id).orElse(null);
    }
}
