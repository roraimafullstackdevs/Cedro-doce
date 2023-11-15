package com.cedrodoce.maqfacil.controllers;

import com.cedrodoce.maqfacil.DTO.MaquinarioDTO;
import com.cedrodoce.maqfacil.services.MaquinarioServices;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/maquinario")
public class MaquinarioController {

    @Autowired
    MaquinarioServices maquinarioServices;

    @GetMapping
    public ResponseEntity listarMaquinario() {
        var allProducts = maquinarioServices.listarMaquinas();
        return ResponseEntity.ok(allProducts);
    }

    @PostMapping
    public ResponseEntity<String> inserirMaquinario(@RequestBody @Valid MaquinarioDTO maquinario) {
        maquinarioServices.inserirMaquina(maquinario);
        return ResponseEntity.ok("Inserido com sucesso!");
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> deletarMaquinario(@PathVariable Long id) {
        maquinarioServices.deletarMaquina(id);
        return ResponseEntity.ok("Deletado com sucesso");
    }

    @PutMapping("/abastecer/{id}")
    @Transactional
    public ResponseEntity<String> abastecerMaquinario(@PathVariable Long id) {
        return maquinarioServices.abastecerMaquina(id);
    }

    @PutMapping("/manutencao/{id}")
    @Transactional
    public ResponseEntity<String> fazerManutencao(@PathVariable Long id) {
        return maquinarioServices.fazerManutencao(id);
    }

}
