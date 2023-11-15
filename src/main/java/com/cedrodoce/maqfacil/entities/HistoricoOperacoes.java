package com.cedrodoce.maqfacil.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class HistoricoOperacoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "operador_id", referencedColumnName = "id")
    private Operador operador;
    private Date data;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "maquina_id", referencedColumnName = "id")

    private Maquinario maquina;


    public HistoricoOperacoes(Operador operador, Date data, Maquinario maquina) {
        this.operador = operador;
        this.data = data;
        this.maquina = maquina;
    }
}
