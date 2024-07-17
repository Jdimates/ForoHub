package com.foroHub.api.model;


import com.foroHub.api.dto.DatosActualizarTopico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Curso nombreCurso;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private Boolean estado;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    public Topico(Curso nombreCurso, String titulo, String mensaje, Usuario autor){
        this.nombreCurso = nombreCurso;
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fechaCreacion = LocalDateTime.now();
        this.estado = true;
        this.autor = autor;
    }

    public void actualizarTopico(DatosActualizarTopico datosActualizarTopico){
        if (datosActualizarTopico.titulo() != null){
            this.titulo = datosActualizarTopico.titulo();
        }
        if (datosActualizarTopico.mensaje() != null){
            this.mensaje = datosActualizarTopico.mensaje();
        }
    }


}
