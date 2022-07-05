package com.dh.meli.spring02.service;

import com.dh.meli.spring02.model.Veiculo;

import java.util.List;

public interface VeiculoServiceInterface {
    Veiculo getVeiculo(String placa);
    List<Veiculo> getAllVeiculos();
    void saveVeiculo(Veiculo veiculo);
}
