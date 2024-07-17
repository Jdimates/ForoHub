package com.foroHub.api.dto;

import com.foroHub.api.model.Curso;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
        @NotNull
        Long idUsuario,
        @NotNull
        Curso nombreCurso,
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje

) {
}
