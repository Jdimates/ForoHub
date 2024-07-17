package com.foroHub.api.dto;

import com.foroHub.api.model.Curso;
import com.foroHub.api.model.Topico;

import java.time.LocalDateTime;

public record DatosListadoTopico(

        Long id,
        Curso nombreCurso,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String autor,
        String estado

) {

    public DatosListadoTopico(Topico topico){
        this(
                topico.getId(),
                topico.getNombreCurso(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getAutor().getNombre(),
                topico.getEstado() ? "Abierto" : "Cerrado"
        );
    }
}
