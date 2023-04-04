package com.portfolio.Roman_Dario_Esquivel.Controller;

import com.portfolio.Roman_Dario_Esquivel.Dto.ProyectoDto;
import com.portfolio.Roman_Dario_Esquivel.Entity.Proyectos;
import com.portfolio.Roman_Dario_Esquivel.Security.Controller.Mensaje;
import com.portfolio.Roman_Dario_Esquivel.Service.ProyectosService;
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
@RequestMapping("/proyectos")
@CrossOrigin(origins = {"http://localhost:4200","https://romandarioesquivelportfolio.web.app"})
public class CProyecto {
    @Autowired
    ProyectosService sProyecto;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list(){
        List<Proyectos> list = sProyecto.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id){
        if(!sProyecto.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Proyectos proyecto = sProyecto.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sProyecto.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sProyecto.delete(id);
        return new ResponseEntity(new Mensaje("proyecto eliminado"), HttpStatus.OK);
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProyectoDto dtopro){      
        if(StringUtils.isBlank(dtopro.getNombreProyectos())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sProyecto.existsBynombreProyectos(dtopro.getNombreProyectos()))
            return new ResponseEntity(new Mensaje("Ese Proyecto existe"), HttpStatus.BAD_REQUEST);
        
       
        Proyectos experiencia = new Proyectos( 
                dtopro.getNombreProyectos(),
                dtopro.getDescripcionProyectos(),
                dtopro.getEnlaceProyecto(),
                dtopro.getImgProyecto());
        sProyecto.save(experiencia);
        
        return new ResponseEntity(new Mensaje("proyecto agregado"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ProyectoDto dtopro){
        //Validamos si existe el ID
        if(!sProyecto.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(sProyecto.existsBynombreProyectos(dtopro.getNombreProyectos()) && sProyecto.getBynombreProyectos(dtopro.getNombreProyectos()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtopro.getNombreProyectos())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        } else {
        }
        
        Proyectos proyecto = sProyecto.getOne(id).get();
        proyecto.setNombre_titulacion(dtopro.getNombreProyectos());
        proyecto.setDescripcionProyectos(dtopro.getDescripcionProyectos());
        proyecto.setEnlaceProyecto(dtopro.getEnlaceProyecto());
        proyecto.setImgProyecto(dtopro.getImgProyecto());
        
        sProyecto.save(proyecto);
        return new ResponseEntity(new Mensaje("proyecto actualizado"), HttpStatus.OK);
             
    }
}
