
package com.tienda.tienda.services.impl;

import com.tienda.tienda.dao.CategoriaDao;
import com.tienda.tienda.domain.Categoria;
import com.tienda.tienda.services.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CategoriaServiceImpl
        implements CategoriaService{

    @Autowired
    private CategoriaDao categoriaDao;
    @Override
    public List<Categoria> getCategorias(boolean activos) {
        var lista = categoriaDao.findAll();
        
        if (activos) {
            //Solo se requieren los registros activos 
            lista.removeIf(c -> !c.isActivo());
        }
        return lista;
    }    
}
