package com.cedrodoce.maqfacil.services;

import com.cedrodoce.maqfacil.entities.Maquinario;
import com.cedrodoce.maqfacil.DTO.MaquinarioDTO;
import com.cedrodoce.maqfacil.repository.MaquinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Calendar;
import java.util.List;

@Service
public class MaquinarioServices {

    @Autowired
    MaquinarioRepository maquinarioRepository;

    public Maquinario inserirMaquina(@Validated MaquinarioDTO data) {
        Maquinario maquinario = new Maquinario(data);
        return maquinarioRepository.save(maquinario);
    }

    public List<Maquinario> listarMaquinas() {
        List<Maquinario> all = maquinarioRepository.findAll();
        return all;

    }

    public void deletarMaquina(Long id) {
        maquinarioRepository.deleteById(id);
    }

    public ResponseEntity<String> abastecerMaquina(Long id) {
        var maquina = maquinarioRepository.findById(id);
        if (maquina.isPresent()) {
            Maquinario maquinario = maquina.get();
            maquinario.getStatus().setNivel_combustivel(100);
            return ResponseEntity.ok("Tanque abastecido até a capacidade máxima.");
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<String> colocarOleo(Long id){
        var maquina = maquinarioRepository.findById(id);
        if(maquina.isPresent()){
            Maquinario maquinario = maquina.get();
            maquinario.getStatus().setNivel_oleo(1);
            return ResponseEntity.ok("Nível de óleo no máximo");
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<String> fazerManutencao(Long id){
        Calendar c = Calendar.getInstance();
        var maquina = maquinarioRepository.findById(id);
        if(maquina.isPresent()){
            Maquinario maquinario = maquina.get();
            maquinario.getStatus().setUltima_manutencao(c.getTime());
            return ResponseEntity.ok("Manutenção atualizada para a data de hoje.");
        }
        return ResponseEntity.notFound().build();
    }

}
