package com.portfolio.Roman_Dario_Esquivel.Security.Service;

import com.portfolio.Roman_Dario_Esquivel.Security.Entity.Rol;
import com.portfolio.Roman_Dario_Esquivel.Security.Enums.RolNombre;
import com.portfolio.Roman_Dario_Esquivel.Security.Repository.IRolRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
  @Autowired
    IRolRepository irolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return irolRepository.findByRolNombre(rolNombre);
    }
    public void save(Rol rol){
        irolRepository.save(rol);
    }  
}
