package com.foroHub.api.service;


import com.foroHub.api.model.Usuario;
import com.foroHub.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service

public class UsuarioService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UsuarioRepository usuarioRepository;


    //Metodo para encriptar con BCrypt el password del nuevo usuario
    public String encriptarPassword(String password) {
        return passwordEncoder.encode(password);
    }


    //Metodo para guardar el nuevo usuario en la BD
    public Usuario crerUsuario(String nombre, String email, String password){
        Usuario nuevoUsuario = new Usuario(nombre, email, password);
        return usuarioRepository.save(nuevoUsuario);
    }

}
