
package com.fe.prueba.dao;

import com.fe.prueba.domain.Persona;
import org.springframework.data.repository.CrudRepository;


public interface IPersonaDao extends CrudRepository<Persona, Long> {
    
}
