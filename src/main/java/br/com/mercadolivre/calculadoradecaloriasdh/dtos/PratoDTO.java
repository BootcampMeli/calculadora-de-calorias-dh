package br.com.mercadolivre.calculadoradecaloriasdh.dtos;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PratoDTO {

    private String nome;
    private List<String> ingredientes = new ArrayList<>();
}
