package com.dh.meli.spring02.controller;

import com.dh.meli.spring02.model.Veiculo;
import com.dh.meli.spring02.service.VeiculoServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {
    private final VeiculoServiceInterface service;

    public VeiculoController(VeiculoServiceInterface service) {
        this.service = service;
    }

    @GetMapping("/{placa}")
    public ResponseEntity<Veiculo> getVeiculo(@PathVariable String placa) {
        return ResponseEntity.ok(service.getVeiculo(placa));
    }

    @GetMapping
    public ResponseEntity<List<Veiculo>> getAllVeiculos() {
        var v = service.getAllVeiculos();
        return ResponseEntity.ok(v);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveVeiculo(@RequestBody Veiculo veiculo) {
        service.saveVeiculo(veiculo);
    }
}
