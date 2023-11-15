package com.cedrodoce.maqfacil.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record OperadorDTO(

        @NotNull
        String nome,
        @NotNull
        String telefone
) {
}
