package com.dh.meli.spring02.repository;

import com.dh.meli.spring02.exception.NotFoundException;
import com.dh.meli.spring02.model.Veiculo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VeiculoRepository {
    private static final String dbFile = "src/main/resources/dados.json";

    public Veiculo getVeiculo(String placa) {
        return getAllVeiculos().stream()
                .filter(v -> v.getPlaca().equals(placa))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Veículo não localizado"));
    }

    public List<Veiculo> getAllVeiculos() {
        try {
            var mapper = new ObjectMapper();
            return new ArrayList<>(List.of(mapper.readValue(new File(dbFile), Veiculo[].class)));
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public void saveVeiculo(Veiculo veiculo) {
        try {
            var veiculos = getAllVeiculos();
            veiculos.add(veiculo);

            var mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(new File(dbFile), veiculos);
        } catch (IOException e) {
            System.err.println("Erro ao cadastrar veículo");
        }
    }
}
