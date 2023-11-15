
package com.fe.prueba.web;

import com.fe.prueba.dao.IPersonaDao;
import com.fe.prueba.domain.Persona;
import java.util.*;

import com.fe.prueba.servicio.PersonaService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@Slf4j
public class ControladorInicio {
    @Value("${index.saludo}")
    private String saludo;
    
    @Autowired
    private PersonaService personaService;
    
    @GetMapping("/")
    public String inicio(Model model){
        var mensaje = "Hola Mundo con Thymeleaf";
        log.info("Ejecutando Controlador");
        
        var persona = new Persona();
        persona.setApellido("Esteves");
        persona.setNombre("Franklin");
        persona.setEmail("festeves@mail.com");
        persona.setTelefono("09899523");
        
        var persona2 = new Persona();
        persona2.setApellido("Jennifer");
        persona2.setNombre("Sanchez");
        persona2.setEmail("jsnchez@mail.com");
        persona2.setTelefono("09899523");
        
        //Maneras de crear un arreglo de personas

        //Manera 1
        /* var personas = new ArrayList();
        personas.add(persona);
        personas.add(persona2);*/
       
        //Manera 2
       //var personas = Arrays.asList(persona, persona2);
       
       //
        var personas = personaService.listarPersona();
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("saludo", saludo);
        //model.addAttribute("persona", persona);
        model.addAttribute("personas", personas);

        return "index";
    }


    @GetMapping("/agregar")
    public String agregar(Persona persona){
        return "modificar";

    }

    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors errores){
        if(errores.hasErrors()){
            return "modificar";
        }
        personaService.guardar(persona);
        return "redirect:/";
    }

    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model){
        persona =personaService.encontrarPersona(persona);
        model.addAttribute("persona",persona);

        return "modificar";
    }

    @GetMapping("/eliminar")
    public String eliminar(Persona persona){
        personaService.eliminar(persona);
        return "redirect:/";
    }


}
