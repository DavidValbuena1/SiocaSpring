package com.david.ProyectoSioca.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

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

import com.david.ProyectoSioca.model.RecuperarContraseña;
import com.david.ProyectoSioca.model.Usuario;
import com.david.ProyectoSioca.service.RecuperarContraseñaService;
import com.david.ProyectoSioca.service.UsuarioService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping({ "/Sioca/Usuario" })
public class UsuarioController {

    @Autowired(required = true)
    private UsuarioService service;

    @Autowired(required = true)
    private RecuperarContraseñaService RecuperarService;

    @GetMapping(path = { "/listar" })
    public List<Usuario> listar() {
        return service.encontrarTodosLosUsuarios();
    }

    @GetMapping(path = { "/listarId/{id}" })
    public Usuario encontrarUsuario(@PathVariable("id") int id) {
        return service.encontrarUsuarioPorId(id);
    }
    
    @GetMapping(path = {"/rol/{id}"})
    public List<Usuario> usuariosPorRol(@PathVariable("id") int id){
    	return service.usuariosPorRol(id);
    }

    @PostMapping(path = { "/agregar" })
    public Usuario insertarUsuario(@RequestBody Usuario u) {
        return service.insertarUsuario(u);
    }

    @PutMapping(path = { "/editar/{id}" })
    public Usuario editarUsuario(@RequestBody Usuario u, @PathVariable("id") int id) {
        u.setId_usuario(id);
        return service.editarUsuario(u);
    }

    @DeleteMapping(path = { "/eliminar/{id}" })
    public Usuario eliminarUsuario(@PathVariable("id") int id) {
        return service.borrarUsuarioPorId(id);
    }

    @PostMapping(path = { "/verificar" })
    public Usuario verificar(@RequestBody Usuario u) {
        return service.verificar(u.getCorreo(), u.getContrasena());
    }

    @PostMapping(path = { "/recuperar" })
    public ResponseEntity<Usuario> recuperar(@RequestBody Usuario u) throws ParseException {
        String[] letters = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
                "S", "T", "U", "V", "W", "X", "Y", "Z" };
        String[] numbers = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
        String color = "";
        for (int i = 0; i < 3; i++) {
            color += letters[(int) Math.round(Math.random() * 25)];
            color += numbers[(int) Math.round(Math.random() * 9)];
        }
        u = service.recuperar(u.getCorreo(), color);
        if (u != null) {
            RecuperarContraseña r = new RecuperarContraseña();
            r.setUsuario(u);
            r.setCodigorecuperacion(color);
            r.setEstado((byte) 1);
            DateFormat hoy = new SimpleDateFormat("yyyy/MM/dd HH-mm-ss");  
            LocalDateTime datetime = LocalDateTime.now();
            Date ingresocodigo = Date.from(datetime.atZone(ZoneId.systemDefault()).toInstant());
            String fecha = hoy.format(ingresocodigo).toString();
            Date date;
            date = hoy.parse(fecha);
            r.setHoradecreacion(date);
            RecuperarService.insertar(r);
            return new ResponseEntity<Usuario>(u, null, HttpStatus.CREATED);
        }
        return new ResponseEntity<Usuario>(u, null, HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = { "/validarCodigo" })
    public Usuario validarCodigo(@RequestBody RecuperarContraseña r) {
        Usuario u = new Usuario();
        RecuperarContraseña recuperarContraseña = new RecuperarContraseña();
        recuperarContraseña = RecuperarService.validar(r.getCodigorecuperacion(), r.getUsuario().getCorreo());
        if (recuperarContraseña != null) {
            u = service.encontrarUsuarioPorId(recuperarContraseña.getUsuario().getId_usuario());
            recuperarContraseña.setEstado((byte) 0);
            RecuperarService.insertar(recuperarContraseña);
        } else {
            u = null;
        }
        return u;
    }

}
