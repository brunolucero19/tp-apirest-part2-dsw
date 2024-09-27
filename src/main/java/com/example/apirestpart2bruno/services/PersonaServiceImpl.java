package com.example.apirestpart2bruno.services;

import com.example.apirestpart2bruno.entities.Persona;
import com.example.apirestpart2bruno.repositories.BaseRepository;
import com.example.apirestpart2bruno.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl extends BaseServiceImpl<Persona, Long> implements PersonaService{

    @Autowired
    private PersonaRepository personaRepository; //Se pueden acceder a todos los métodos de personaRepository

    public PersonaServiceImpl(BaseRepository<Persona, Long> baseRepository){
        super(baseRepository);
    }


    @Override
    public List<Persona> search(String filtro) throws Exception {
        try {
            //Con el metodo de Query
//            List <Persona> personas = personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro);
            //Con el search usando JPQL
//            List <Persona> personas = personaRepository.search(filtro);
            //Con el search usando SQL pelado
            List <Persona> personas = personaRepository.searchNativo(filtro);
            return personas;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
