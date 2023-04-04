package com.portfolio.Roman_Dario_Esquivel.Service;

import com.portfolio.Roman_Dario_Esquivel.Entity.Educacion;
import com.portfolio.Roman_Dario_Esquivel.Repository.REducacion;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SEducacion {
    @Autowired
    REducacion rEducacion;
    
    public List<Educacion> list(){
        return rEducacion.findAll();
    }
    
    public Optional<Educacion> getOne(int id){
        return rEducacion.findById(id);
    }
    
    public Optional<Educacion> getBynombreTitulacion(String nombreTitulacion){
        return rEducacion.findBynombreTitulacion(nombreTitulacion);
    }
    
    public void save(Educacion educacion){
        rEducacion.save(educacion);
    }
    
    public void delete(int id){
        rEducacion.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rEducacion.existsById(id);
    }
    
    public boolean existsBynombreTitulacion(String nombreTitulacion){
        return rEducacion.existsBynombreTitulacion(nombreTitulacion);
    }
}
