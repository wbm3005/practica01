package com.practica01.service;

import com.practica01.domain.Arbol;
import java.util.List;

public interface ArbolService {
    
    List<Arbol> findAll();
    Arbol findById(Long id);
    Arbol save(Arbol arbol);
    void delete(Long id);
    
}
