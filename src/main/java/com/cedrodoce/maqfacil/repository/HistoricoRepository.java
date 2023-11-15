package com.cedrodoce.maqfacil.repository;

import com.cedrodoce.maqfacil.entities.HistoricoOperacoes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricoRepository extends JpaRepository<HistoricoOperacoes, Long> {
}
