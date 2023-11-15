package com.cedrodoce.maqfacil.services;

import com.cedrodoce.maqfacil.DTO.OperadorDTO;
import com.cedrodoce.maqfacil.entities.HistoricoOperacoes;
import com.cedrodoce.maqfacil.entities.Operador;
import com.cedrodoce.maqfacil.repository.HistoricoRepository;
import com.cedrodoce.maqfacil.repository.MaquinarioRepository;
import com.cedrodoce.maqfacil.repository.OperadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Calendar;

@Service
public class OperadorServices {

    @Autowired
    OperadorRepository repository;
    @Autowired
    MaquinarioRepository maqRepository;
    @Autowired
    HistoricoRepository hisRepository;

    public void inserirOperador(@Validated OperadorDTO data){
        Operador operador = new Operador(data);
        repository.save(operador);
    }


    public void operarMaquina(Long id_usuario, Long id_maquina) {
        Calendar c = Calendar.getInstance();
        HistoricoOperacoes operacao = new HistoricoOperacoes(repository.getReferenceById(id_usuario),
                c.getTime(),
                maqRepository.getReferenceById(id_maquina));
                hisRepository.save(operacao);

    }

}
