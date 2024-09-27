package com.example.apirestpart2bruno.services;

import com.example.apirestpart2bruno.entities.Persona;

import java.util.List;

public interface PersonaService extends BaseService<Persona, Long>{
    List<Persona> search(String filtro) throws Exception;

}
