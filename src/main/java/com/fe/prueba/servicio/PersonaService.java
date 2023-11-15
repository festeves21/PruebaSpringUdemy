package com.fe.prueba.servicio;

import com.fe.prueba.domain.Persona;

import java.util.List;

public interface PersonaService {

    public List<Persona> listarPersona();

    public void guardar(Persona persona);

    public void eliminar(Persona persona);

    public Persona encontrarPersona(Persona persona);



}
