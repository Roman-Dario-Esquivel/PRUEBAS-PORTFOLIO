package com.portfolio.Roman_Dario_Esquivel.Controller;


import com.portfolio.Roman_Dario_Esquivel.Dto.dtoEducacion;
import com.portfolio.Roman_Dario_Esquivel.Entity.Educacion;
import com.portfolio.Roman_Dario_Esquivel.Security.Controller.Mensaje;
import com.portfolio.Roman_Dario_Esquivel.Service.SEducacion;
import io.swagger.annotations.Api;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/educacion")
@Api(value = "API Example", description = "Example endpoints for my API")
@CrossOrigin(origins = {"http://localhost:4200","https://romandarioesquivelportfolio.web.app/"})
public class CEducacion {
    @Autowired
    SEducacion sEducacion;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = sEducacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id")int id){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Educacion educacion = sEducacion.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        sEducacion.delete(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoeducacion){
        if(StringUtils.isBlank(dtoeducacion.getNombreTitulacion())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sEducacion.existsBynombreTitulacion(dtoeducacion.getNombreTitulacion())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Educacion educacion = new Educacion(
                dtoeducacion.getNombre_institucion(),
                dtoeducacion.getNombreTitulacion(),
                dtoeducacion.getDescripcion_edu(),
                dtoeducacion.getLogoimg(),
                java.sql.Date.valueOf(dtoeducacion.getFecha_inicio()),
                java.sql.Date.valueOf(dtoeducacion.getFecha_fin()),
                Integer.valueOf(dtoeducacion.getActualmente())
            );
        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion creada"), HttpStatus.OK);
                
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoeducacion){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(sEducacion.existsBynombreTitulacion(dtoeducacion.getNombreTitulacion()) && sEducacion.getBynombreTitulacion(dtoeducacion.getNombreTitulacion()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoeducacion.getNombreTitulacion())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Educacion educacion = sEducacion.getOne(id).get();
        
        educacion.setNombreTitulacion(dtoeducacion.getNombreTitulacion());
        educacion.setInstitucion(dtoeducacion.getNombre_institucion());
        educacion.setDescripcion_edu(dtoeducacion.getDescripcion_edu());
        educacion.setLogoimg(dtoeducacion.getLogoimg());
        educacion.setFecha_inicio(java.sql.Date.valueOf(dtoeducacion.getFecha_inicio()));
        educacion.setFecha_fin(java.sql.Date.valueOf(dtoeducacion.getFecha_fin()));
        educacion.setActualmente(Integer.valueOf(dtoeducacion.getActualmente()));
        
        sEducacion.save(educacion);
        
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
    }
}
