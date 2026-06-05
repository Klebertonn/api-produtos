package io.github.klebertonn.apiprodutos.controller;

import io.github.klebertonn.apiprodutos.model.Produto;
import io.github.klebertonn.apiprodutos.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;
import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto){
        System.out.println("Produto recebido" + produto);

        var id = UUID.randomUUID().toString();
        produto.setId(id);

        produtoRepository.save(produto);
        return produto;
    }


     @GetMapping("{id}")
    public Produto obterID(@PathVariable("id") String id){
        return produtoRepository.findById(id).orElse(null);
    }


    @GetMapping("/nome")
    public List<Produto> getNOme (@RequestParam String nome){

        return produtoRepository.findByNome(nome);

    }

    @GetMapping
    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }



    @PutMapping ("{id}")
    public void atualizar(@PathVariable("id")String id,@RequestBody Produto produto){

        produto.setId(id);

        produtoRepository.save(produto);
    }


    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String id){
         produtoRepository.deleteById(id);
    }



}



