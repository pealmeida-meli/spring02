package com.dh.meli.spring02.service;

import com.dh.meli.spring02.dto.VeiculoDto;
import com.dh.meli.spring02.model.Veiculo;
import com.dh.meli.spring02.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VeiculoService implements VeiculoServiceInterface {
    private final VeiculoRepository repository;

    public VeiculoService(VeiculoRepository repository) {
        this.repository = repository;
    }

    @Override
    public VeiculoDto getVeiculo(String placa) {
        return new VeiculoDto(repository.getVeiculo(placa));
    }

    @Override
    public List<VeiculoDto> getAllVeiculos() {
        return repository.getAllVeiculos().stream().map(VeiculoDto::new).collect(Collectors.toList());
    }

    @Override
    public List<VeiculoDto> getAllOrderByValor() {
        return repository.getAllVeiculos().stream().sorted().map(VeiculoDto::new).collect(Collectors.toList());
    }

    @Override
    public List<VeiculoDto> getAllOrderByModelo() {
        return repository.getAllVeiculos().stream()
                .sorted(Comparator.comparing(Veiculo::getModelo))
                .map(VeiculoDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<VeiculoDto> getAllByModelo(String modelo) {
        return repository.getAllVeiculos().stream()
                .map(VeiculoDto::new)
                .filter(v -> v.getModelo().equalsIgnoreCase(modelo))
                .collect(Collectors.toList());
    }

    @Override
    public void saveVeiculo(Veiculo veiculo) {
        repository.saveVeiculo(veiculo);
    }
}
