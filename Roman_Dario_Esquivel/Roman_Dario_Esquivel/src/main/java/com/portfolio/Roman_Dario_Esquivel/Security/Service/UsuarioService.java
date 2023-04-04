package com.portfolio.Roman_Dario_Esquivel.Security.Service;

import com.portfolio.Roman_Dario_Esquivel.Security.Entity.usuario;
import com.portfolio.Roman_Dario_Esquivel.Security.Repository.IUsuarioRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {
     @Autowired
    IUsuarioRepository iusuarioRepository;
    
    public Optional<usuario> getByNombreUsuario(String nombreUsuario) {
        return iusuarioRepository.findByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByNombreUsuario(String nombreUsuario) {
        return iusuarioRepository.existsByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByEmail(String email) {
        return iusuarioRepository.existsByEmail(email);
    }
    
    public void save(usuario usuario) {
        iusuarioRepository.save(usuario);
    }
}
