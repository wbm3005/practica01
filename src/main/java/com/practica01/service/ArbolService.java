package com.practica01.service;

import com.practica01.domain.Arbol;

public interface ArbolService {
    
    // Se obtiene un Categoria, a partir del id de un categoria
    public Arbol getArboles(Arbol arbol);
    
    // Se inserta un nuevo categoria si el id del categoria esta vacío
    // Se actualiza un categoria si el id del categoria NO esta vacío
    public void save(Arbol arbol);
    
    // Se elimina el categoria que tiene el id pasado por parámetro
    public void delete(Arbol arbol);
    
}
