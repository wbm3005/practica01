package com.practica01.service.impl;

import com.practica01.dao.ArbolDao;
import com.practica01.service.ArbolService;
import com.practica01.domain.Arbol;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArbolServiceImpl implements ArbolService {
    
    @Autowired
    private ArbolDao arbolDao;


    @Override
    @Transactional(readOnly = true)
    public List<Arbol> findAll() {
        return arbolDao.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Arbol findById(Long id) {
        return arbolDao.findById(id).orElse(null);
    }
    
    @Override
    @Transactional
    public Arbol save(Arbol arbol) {
        return arbolDao.save(arbol);
    }
    
    @Override
    @Transactional
    public void delete(Long id) {
        arbolDao.deleteById(id);
    }
    
}
