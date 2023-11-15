package com.cedrodoce.maqfacil.controllers;

import com.cedrodoce.maqfacil.DTO.OperadorDTO;
import com.cedrodoce.maqfacil.entities.Maquinario;
import com.cedrodoce.maqfacil.entities.Operador;
import com.cedrodoce.maqfacil.repository.MaquinarioRepository;
import com.cedrodoce.maqfacil.repository.OperadorRepository;
import com.cedrodoce.maqfacil.services.OperadorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/operador")
public class OperadorController {


    @Autowired
    OperadorServices services;

    @PostMapping
    public ResponseEntity<String> inserirOperador(@RequestBody OperadorDTO operadorDTO) {
        services.inserirOperador(operadorDTO);
        return ResponseEntity.ok("Operador cadastrado com sucesso.");
    }

    @PostMapping("/{id_operador}/{id_maquinario}")
    public void operarMaquinario(@PathVariable(name = "id_operador") Long id_operador,
                                 @PathVariable(name = "id_maquinario") Long id_maquinario) {
        services.operarMaquina(id_operador, id_maquinario);
    }

}
