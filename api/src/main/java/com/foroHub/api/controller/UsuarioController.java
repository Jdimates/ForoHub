package com.foroHub.api.controller;


import com.foroHub.api.dto.DatosDetalleUsuario;
import com.foroHub.api.dto.DatosRegistroUsuario;
import com.foroHub.api.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuarios")

public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @PostMapping
    public ResponseEntity<DatosDetalleUsuario> registrarUsuario(@RequestBody @Valid DatosRegistroUsuario datosRegistroUsuario,
                                                                UriComponentsBuilder uriComponentsBuilder){
        var passwEncript = usuarioService.encriptarPassword(datosRegistroUsuario.password());
        var usuario = usuarioService.crerUsuario(datosRegistroUsuario.nombre(), datosRegistroUsuario.email(), passwEncript);
        DatosDetalleUsuario datosDetalleUsuario = new DatosDetalleUsuario(usuario.getNombre(), usuario.getEmail());
        URI url = uriComponentsBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(url).body(datosDetalleUsuario);
    }

}