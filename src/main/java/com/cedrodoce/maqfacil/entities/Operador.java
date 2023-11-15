package com.cedrodoce.maqfacil.entities;

import com.cedrodoce.maqfacil.DTO.OperadorDTO;
import com.cedrodoce.maqfacil.repository.MaquinarioRepository;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;
import java.util.Calendar;
import java.util.Objects;

@Entity
public class Operador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String nome;
    @Column(length = 14)
    @NotNull
    private String telefone;


    public Operador() {
    }

    public Operador(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operador operador = (Operador) o;
        return Objects.equals(telefone, operador.telefone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(telefone);
    }

    @Override
    public String toString() {
        return "Operador{" +
                "nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }

    public Operador(OperadorDTO data){
        this.nome = data.nome();
        this.telefone = data.telefone();
    }

}
