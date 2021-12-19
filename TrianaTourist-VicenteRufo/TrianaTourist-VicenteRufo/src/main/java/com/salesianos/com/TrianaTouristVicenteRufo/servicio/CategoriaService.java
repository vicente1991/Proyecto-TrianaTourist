package com.salesianos.com.TrianaTouristVicenteRufo.servicio;

import com.salesianos.com.TrianaTouristVicenteRufo.dto.categoriaDTO.ConverterDTOCategoria;
import com.salesianos.com.TrianaTouristVicenteRufo.dto.categoriaDTO.CreateDTOCategoria;
import com.salesianos.com.TrianaTouristVicenteRufo.dto.categoriaDTO.GetDTOCategoria;
import com.salesianos.com.TrianaTouristVicenteRufo.errores.excepciones.ListEntityNotFoundException;
import com.salesianos.com.TrianaTouristVicenteRufo.errores.excepciones.SingleEntityNotFoundException;
import com.salesianos.com.TrianaTouristVicenteRufo.modelo.Categoria;
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

    public void save(Categoria categoria){categoriaRepository.save(categoria);}


    public void delete(Long id) {

        if (categoriaRepository.findById(id).isEmpty()) {
            throw new SingleEntityNotFoundException(id.toString(), Categoria.class);
        } else {
            categoriaRepository.deleteById(id);;
        }

    }

    public Optional<GetDTOCategoria> edit(Long id, CreateDTOCategoria dto){
        return findById(id).map(nuevo->{
            nuevo.setName(dto.getName());
            save(nuevo);
            return converterDTOCategoria.createCategoriaToCategoriaDTO(nuevo);
        });
    }

}
