package com.salesianos.com.TrianaTouristVicenteRufo.servicio;

import com.salesianos.com.TrianaTouristVicenteRufo.errores.excepciones.EntityNotFoundException;
import com.salesianos.com.TrianaTouristVicenteRufo.errores.excepciones.ListEntityNotFoundException;
import com.salesianos.com.TrianaTouristVicenteRufo.modelo.Categoria;
import com.salesianos.com.TrianaTouristVicenteRufo.repositorio.CategoriaRepository;
import com.salesianos.com.TrianaTouristVicenteRufo.servicio.base.BaseService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CategoriaService extends BaseService<Categoria,Long, CategoriaRepository> {


    private final CategoriaRepository categoriaRepository;

    public List<Categoria> findAlll(){
        if( categoriaRepository.findAll().isEmpty()){
            throw new ListEntityNotFoundException(CategoriaService.class);
        }else{
            return this.categoriaRepository.findAll();
        }
    }

    public Optional<Categoria> findById(Long id){
        if(categoriaRepository.findById(id).isEmpty()){
            throw new EntityNotFoundException(id);
        }else{
            return this.categoriaRepository.findById(id);
        }
    }

    public Categoria save(Categoria categoria){return categoriaRepository.save(categoria);}

    public void deleteById(Long id){
        if( categoriaRepository.findById(id).isEmpty()){
            throw new EntityNotFoundException(id);
        }else{
            categoriaRepository.deleteById(id);
        }
    }

    public Categoria edit(Categoria categoria){return categoriaRepository.save(categoria);}

}
