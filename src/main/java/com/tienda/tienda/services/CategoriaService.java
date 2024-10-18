
package com.tienda.tienda.services;

import com.tienda.tienda.domain.Categoria;
import java.util.List;


public interface CategoriaService {
    
    
    //Se obtiene una list de elemetos categoria que son extraidos de 
    //de la tabla categorias
    //se obtienen todos o solo los que estan activos 
    
    public List<Categoria> getCategorias (boolean activos);
}
