package com.dh.meli.spring02.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo implements Comparable<Veiculo> {
    private String placa;
    private String modelo;
    private String renavam;
    private double valor;

    @Override
    public int compareTo(Veiculo o) {
        return Double.compare(getValor(), o.getValor());
    }
}
