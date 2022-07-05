package com.dh.meli.spring02.service;

import com.dh.meli.spring02.dto.VeiculoDto;
import com.dh.meli.spring02.model.Veiculo;

import java.util.List;

public interface VeiculoServiceInterface {
    VeiculoDto getVeiculo(String placa);
    List<VeiculoDto> getAllVeiculos();
    void saveVeiculo(Veiculo veiculo);
}
