package com.exemple.forohub.service;

import com.exemple.forohub.DTO.DatosRegistroUsuario;
import com.exemple.forohub.model.Usuario;
import com.exemple.forohub.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired 
    private IUsuarioRepository usuarioRepo;
    
    public Usuario registrarUsuario(DatosRegistroUsuario datosRegistroUsuario) {
       
        Usuario usuario = new Usuario(datosRegistroUsuario);
        return usuarioRepo.save(usuario);
    }    

    public Usuario obtenerPorCorreoElectronico(String username) {
       return (Usuario) usuarioRepo.findByCorreoElectronico(username);
    }
}
