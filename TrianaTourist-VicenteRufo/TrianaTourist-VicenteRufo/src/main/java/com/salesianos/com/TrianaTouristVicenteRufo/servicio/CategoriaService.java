package com.salesianos.com.TrianaTouristVicenteRufo.servicio;

import com.salesianos.com.TrianaTouristVicenteRufo.dto.categoriaDTO.ConverterDTOCategoria;
import com.salesianos.com.TrianaTouristVicenteRufo.dto.categoriaDTO.CreateDTOCategoria;
import com.salesianos.com.TrianaTouristVicenteRufo.dto.categoriaDTO.GetDTOCategoria;
import com.salesianos.com.TrianaTouristVicenteRufo.dto.routeDTO.CreateDTORoutes;
import com.salesianos.com.TrianaTouristVicenteRufo.errores.excepciones.EntityNotFoundException;
import com.salesianos.com.TrianaTouristVicenteRufo.errores.excepciones.ListEntityNotFoundException;
import com.salesianos.com.TrianaTouristVicenteRufo.errores.excepciones.SingleEntityNotFoundException;
import com.salesianos.com.TrianaTouristVicenteRufo.modelo.Categoria;
import com.salesianos.com.TrianaTouristVicenteRufo.modelo.Route;
import com.salesianos.com.TrianaTouristVicenteRufo.repositorio.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
@RequiredArgsConstructor
public class CategoriaService {


    private final CategoriaRepository categoriaRepository;
    private final ConverterDTOCategoria converterDTOCategoria;

    public List<Categoria> findAlll(){

        if( categoriaRepository.findAll().isEmpty()){
            throw new ListEntityNotFoundException(Categoria.class);
        }else{
            return categoriaRepository.findAll();
        }
    }

    public Optional<Categoria> findById(Long id) {
        if (categoriaRepository.findById(id).isEmpty()) {
            throw new SingleEntityNotFoundException(id.toString(), Categoria.class);
        } else {
            return categoriaRepository.findById(id);
        }
    }

    public Categoria save(Categoria categoria){;
        categoriaRepository.save(categoria);
        return categoria;
    }


    public void delete(Long id) {

        if (categoriaRepository.findById(id).isEmpty()) {
            throw new SingleEntityNotFoundException(id.toString(), Categoria.class);
        } else {
            categoriaRepository.deleteById(id);;
        }

    }

    public Categoria edit(Long id, CreateDTOCategoria dto){
        Optional<Categoria> c= categoriaRepository.findById(id);

        if(c.isEmpty()){
            throw new EntityNotFoundException(id,Categoria.class);
        }
        return c.map(nuevo->{
            nuevo.setName(dto.getName());
            categoriaRepository.save(nuevo);
            return nuevo;
        }).get();
    }

}
