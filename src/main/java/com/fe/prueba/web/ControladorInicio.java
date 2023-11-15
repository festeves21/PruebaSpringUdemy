
package com.fe.prueba.web;

import com.fe.prueba.dao.IPersonaDao;
import com.fe.prueba.domain.Persona;
import java.util.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@Slf4j
public class ControladorInicio {
    @Value("${index.saludo}")
    private String saludo;
    
    @Autowired
    private IPersonaDao personaDao;
    
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
        var personas = personaDao.findAll();
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("saludo", saludo);
        //model.addAttribute("persona", persona);
        model.addAttribute("personas", personas);

        return "index";
    }
           

}
