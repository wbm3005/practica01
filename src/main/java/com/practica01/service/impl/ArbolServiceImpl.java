package com.practica01.service.impl;

import com.practica01.dao.ArbolDao;
import com.practica01.service.ArbolService;
import com.practica01.domain.Arbol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArbolServiceImpl implements ArbolService {
    
    @Autowired
    private ArbolDao arbolDao;
    
    
    @Override
    @Transactional
    public void save(Arbol arbol) {
        arbolDao.save(arbol);
    }

    @Override
    @Transactional
    public void delete(Arbol arbol) {
        arbolDao.deleteById();
    }

    @Override
    public Arbol getArboles(Arbol arbol) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
