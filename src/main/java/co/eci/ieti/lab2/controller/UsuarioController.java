package co.eci.ieti.lab2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;
import co.eci.ieti.lab2.model.Usuario;

import co.eci.ieti.lab2.service.UsuarioService;


@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> getUsuarios(){
        return new ResponseEntity<List<Usuario>>(usuarioService.findAll(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<?> getUsuario(@PathVariable("id") int id){
        if(!usuarioService.existsById(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Usuario>(usuarioService.findById(id), HttpStatus.ACCEPTED);
    }

    @PostMapping("/addUsuario")
    public ResponseEntity<?> addUsuario(Usuario usuario){
        try{
            usuarioService.save(usuario);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @PutMapping("/updateUsuario/{id}")
    public ResponseEntity<?> updateUsuario(@PathVariable("id") int id,Usuario usuario){
        if(usuarioService.existsById(id)){
            try{
                usuarioService.update(id,usuario);
                return new ResponseEntity<>(HttpStatus.ACCEPTED);
            }
            catch(Exception e){
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteUsuario/{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable("id") int id){
        if(usuarioService.existsById(id)){
            try{
                usuarioService.delete(id);
                return new ResponseEntity<>(HttpStatus.ACCEPTED);
            }
            catch(Exception e){
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
