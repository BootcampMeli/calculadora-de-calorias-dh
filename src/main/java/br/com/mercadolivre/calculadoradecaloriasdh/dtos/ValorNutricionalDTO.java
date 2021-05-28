package br.com.mercadolivre.calculadoradecaloriasdh.dtos;

import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Data
public class ValorNutricionalDTO {

    private double caloriasTotais;
    private List<IngredienteDTO> ingredientes = new ArrayList<>();
    private IngredienteDTO ingredienteComMaisCalorias;
}
