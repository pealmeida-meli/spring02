package com.dh.meli.spring02.controller;

import com.dh.meli.spring02.dto.VeiculoDto;
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
    public ResponseEntity<VeiculoDto> getVeiculo(@PathVariable String placa) {
        return ResponseEntity.ok(service.getVeiculo(placa));
    }

    @GetMapping
    public ResponseEntity<List<VeiculoDto>> getAllVeiculos() {
        return ResponseEntity.ok(service.getAllVeiculos());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveVeiculo(@RequestBody Veiculo veiculo) {
        service.saveVeiculo(veiculo);
    }
}
