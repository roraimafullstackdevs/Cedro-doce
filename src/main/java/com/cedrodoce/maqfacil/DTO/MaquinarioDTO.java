package com.cedrodoce.maqfacil.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record MaquinarioDTO(
        @NotNull
        String marca,
        @NotNull
        String modelo,
        @NotNull @NotBlank
        String porte
) {
}
