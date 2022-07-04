package com.dh.meli.spring02.controller;

import com.dh.meli.spring02.model.Veiculo;
import com.dh.meli.spring02.repository.VeiculoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {
    private final VeiculoRepository repository;

    public VeiculoController(VeiculoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{placa}")
    public ResponseEntity<Veiculo> getVeiculo(@PathVariable String placa) {
        var v = repository.getVeiculo(placa);
        if (v == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(v);
    }

    @GetMapping
    public ResponseEntity<List<Veiculo>> getAllVeiculos() {
        var v = repository.getAllVeiculos();
        return ResponseEntity.ok(v);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveVeiculo(@RequestBody Veiculo veiculo) {
        repository.saveVeiculo(veiculo);
    }
}
