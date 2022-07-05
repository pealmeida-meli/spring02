package com.dh.meli.spring02.dto;

import com.dh.meli.spring02.model.Veiculo;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VeiculoDto {
    private String placa;
    private String modelo;
    private double valor;

    public VeiculoDto(Veiculo veiculo) {
        placa = veiculo.getPlaca();
        modelo = veiculo.getModelo();
        valor = veiculo.getValor();
    }
}
