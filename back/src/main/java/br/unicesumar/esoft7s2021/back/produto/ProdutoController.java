package br.unicesumar.esoft7s2021.back.produto;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private List<Produto> produtos = new ArrayList();

    ProdutoController() {
        produtos.add(new Produto("livro AA"));
        produtos.add(new Produto("livro BB"));
    }

    @GetMapping()
    public List<Produto> get() {
        return this.produtos;
    }

    @GetMapping("/{id}")
    public Produto getById(@PathVariable String id) {
        return this.produtos.stream()
        .filter(produto -> produto.getId().equals(id))
        .findFirst().orElseGet(Produto::new);
    }

    @PutMapping("/{id}")
    public void put(@PathVariable String id, @RequestBody Produto produtoEditado) {
        this.produtos = this.produtos.stream()
        .filter(produto -> !produto.getId().equals(id))
        .collect(Collectors.toList());
        this.produtos.add(produtoEditado);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id){
        this.produtos = this.produtos.stream()
        .filter(produto -> !produto.getId().equals(id))
        .collect(Collectors.toList());
        return "Successfully deleted";
    }
}