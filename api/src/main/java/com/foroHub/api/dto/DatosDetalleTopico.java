package com.foroHub.api.dto;

import com.foroHub.api.model.Curso;
import com.foroHub.api.model.Topico;

import java.time.LocalDateTime;

public record DatosDetalleTopico(

        Long id,
        Curso nombreCurso,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String estado

) {
    public DatosDetalleTopico(Topico topico){
        this(
                topico.getId(),
                topico.getNombreCurso(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getEstado() ? "Abierto" : "Cerrado"
        );
    }

}
