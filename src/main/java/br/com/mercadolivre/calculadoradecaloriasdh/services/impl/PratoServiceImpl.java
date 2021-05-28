package br.com.mercadolivre.calculadoradecaloriasdh.services.impl;

import br.com.mercadolivre.calculadoradecaloriasdh.dtos.IngredienteDTO;
import br.com.mercadolivre.calculadoradecaloriasdh.dtos.PratoDTO;
import br.com.mercadolivre.calculadoradecaloriasdh.dtos.ValorNutricionalDTO;
import br.com.mercadolivre.calculadoradecaloriasdh.services.PratoService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.annotation.Resources;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PratoServiceImpl implements PratoService {
    @Override
    public ValorNutricionalDTO retornaValorNutricionalDoPrato(PratoDTO pratoDTO) {
        ValorNutricionalDTO valorNutricional = new ValorNutricionalDTO();

        List<String> nomesIngredientesDoPrato = pratoDTO.getIngredientes();
        List<IngredienteDTO> ingredientesDoJson = retornaIngredientesDoJson();
        List<IngredienteDTO> ingredientesFiltrados = ingredientesDoJson.stream().filter(ingredienteDTO -> nomesIngredientesDoPrato.contains(ingredienteDTO.getNome())).collect(Collectors.toList());

        double caloriaTotal = ingredientesFiltrados.stream().mapToDouble(IngredienteDTO::getPeso).sum();
        IngredienteDTO ingredienteDTO = ingredientesFiltrados.stream().max(Comparator.comparingDouble(IngredienteDTO::getPeso)).get();

        valorNutricional.setIngredientes(ingredientesFiltrados);
        valorNutricional.setCaloriasTotais(caloriaTotal);
        valorNutricional.setIngredienteComMaisCalorias(ingredienteDTO);

        return valorNutricional;
    }

    private List<IngredienteDTO> retornaIngredientesDoJson(){
        List<IngredienteDTO> ingredienteDTOS = null;

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<IngredienteDTO>> typeReference = new TypeReference<List<IngredienteDTO>>(){};
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:food.json");
            ingredienteDTOS = objectMapper.readValue(file, typeReference);
        } catch (IOException e){
            e.printStackTrace();
        }

        return ingredienteDTOS;
    }

}
