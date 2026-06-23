package br.com.marcos.api.controller;

import br.com.marcos.api.model.Produto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @PostMapping
    public Produto salvar(@RequestBody Produto produto){
        System.out.println("Produto salvo com sucesso" + produto);
        return produto;
    }


}
