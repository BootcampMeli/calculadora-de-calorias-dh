package br.com.mercadolivre.calculadoradecaloriasdh.services;

import br.com.mercadolivre.calculadoradecaloriasdh.dtos.PratoDTO;
import br.com.mercadolivre.calculadoradecaloriasdh.dtos.ValorNutricionalDTO;

public interface PratoService {

    public ValorNutricionalDTO retornaValorNutricionalDoPrato(PratoDTO pratoDTO);
}
