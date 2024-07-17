package com.foroHub.api.dto;

import org.antlr.v4.runtime.misc.NotNull;

public record DatosActualizarTopico(
        @NotNull
        Long idUsuario,
        String titulo,
        String mensaje

) {
}
