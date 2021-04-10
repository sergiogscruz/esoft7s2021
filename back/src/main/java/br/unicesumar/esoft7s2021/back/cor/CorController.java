package br.unicesumar.esoft7s2021.back.cor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@RequestMapping("/api/cores")

public class CorController {
    private List<Cor> cores = new ArrayList<>();

    public CorController() {
        cores.add(new Cor("RX", "Roxo"));
        cores.add(new Cor("VM", "Vermelho"));
        cores.add(new Cor("VD", "Verde"));
        cores.add(new Cor("AZ", "Azul"));
    }

    @GetMapping
    public List<Cor> get() {
        return this.cores;
    }

    @GetMapping("/{idParaEditar}")
    public Cor getById(@PathVariable String idParaEditar) {
        return this.cores.stream().filter(cor -> cor.getId().equals(idParaEditar)).findFirst().orElseGet(Cor::new);
    }

    @PutMapping("/{id}")
    public void put(@PathVariable String id, @RequestBody Cor corEditada) {
         this.cores = this.cores.stream()
         .filter(cor -> !cor.getId().equals(id))
         .collect(Collectors.toList());
        this.cores.add(corEditada);
    }

    @PostMapping
    public String post(@RequestBody Cor novaCor) {
        this.cores.add(novaCor);
        return novaCor.getId();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        this.cores = this.cores.stream().filter(cor -> !cor.getId().equals(id)).collect(Collectors.toList());
    }


}
