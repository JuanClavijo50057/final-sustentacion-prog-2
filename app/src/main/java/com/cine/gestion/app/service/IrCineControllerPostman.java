package com.cine.gestion.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cine.gestion.app.domain.IrCine;
import com.cine.gestion.app.repository.IrCineRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class IrCineControllerPostman {

    @Autowired
    private IrCineRepository irCineRepository;
    

    @PostMapping("/cines")
    public ResponseEntity<IrCine> postCine(@RequestBody IrCine ircine) {
        try {

            irCineRepository.save(ircine);
            return new ResponseEntity<>(ircine, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @GetMapping("/cines")
    public ResponseEntity<List<IrCine>> getAll() {
        try {
            List<IrCine> cines = irCineRepository.findAll();
            return new ResponseEntity<>(cines, HttpStatus.OK);
            
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/cines/{id}")
    public ResponseEntity<IrCine> getByid(@PathVariable("id") Long id) {
        Optional<IrCine> ircineData = irCineRepository.findById(id);

        try {
            if (ircineData.isPresent()) {
                return new ResponseEntity<>(ircineData.get(), HttpStatus.OK);
            }

            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @PutMapping("/cines/{id}")
    public ResponseEntity<IrCine> Edit(@PathVariable("id") Long id, @RequestBody IrCine ircine) {
        Optional<IrCine> ircineData = irCineRepository.findById(id);

        try {

            if (ircineData.isPresent()) {
                IrCine cine = ircineData.get();
                cine.setNombre(ircine.getNombre());
                cine.setApellido(ircine.getApellido());
                cine.setCorreo_electronico(ircine.getCorreo_electronico());
                cine.setPelicula_ver(ircine.getPelicula_ver());
                cine.setFecha(ircine.getFecha());
                cine.setHora(ircine.getHora());
                cine.setCantidad_adultos(ircine.getCantidad_adultos());
                cine.setCantidad_niños(ircine.getCantidad_niños());
                cine.setPreferencia_asientos(ircine.getPreferencia_asientos());
                cine.setNotificaciones(ircine.getNotificaciones());

                return new ResponseEntity<>(irCineRepository.save(cine), HttpStatus.OK);

            }
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @DeleteMapping("cines/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
        try {
            irCineRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
