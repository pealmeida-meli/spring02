package com.dh.meli.spring02.service;

import com.dh.meli.spring02.model.Veiculo;
import com.dh.meli.spring02.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService implements VeiculoServiceInterface {
    private final VeiculoRepository repository;

    public VeiculoService(VeiculoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Veiculo getVeiculo(String placa) {
        return repository.getVeiculo(placa);
    }

    @Override
    public List<Veiculo> getAllVeiculos() {
        return repository.getAllVeiculos();
    }

    @Override
    public void saveVeiculo(Veiculo veiculo) {
        repository.saveVeiculo(veiculo);
    }
}
