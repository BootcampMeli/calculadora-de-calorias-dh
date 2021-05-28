package br.com.mercadolivre.calculadoradecaloriasdh.resources;

import br.com.mercadolivre.calculadoradecaloriasdh.dtos.PratoDTO;
import br.com.mercadolivre.calculadoradecaloriasdh.dtos.ValorNutricionalDTO;
import br.com.mercadolivre.calculadoradecaloriasdh.services.PratoService;
import br.com.mercadolivre.calculadoradecaloriasdh.services.impl.PratoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prato")
public class PratoController {

    @Autowired
    PratoServiceImpl service;

    @PostMapping
    public ValorNutricionalDTO inserePrato(@RequestBody PratoDTO prato){
        return service.retornaValorNutricionalDoPrato(prato);
    }
}
