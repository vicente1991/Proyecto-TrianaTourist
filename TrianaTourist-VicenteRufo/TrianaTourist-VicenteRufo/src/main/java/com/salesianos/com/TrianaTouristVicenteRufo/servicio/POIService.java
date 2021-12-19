package com.salesianos.com.TrianaTouristVicenteRufo.servicio;

import com.salesianos.com.TrianaTouristVicenteRufo.dto.POIdto.ConverterPOIdto;
import com.salesianos.com.TrianaTouristVicenteRufo.dto.POIdto.CreatePOIdto;
import com.salesianos.com.TrianaTouristVicenteRufo.dto.POIdto.GetPOIdto;
import com.salesianos.com.TrianaTouristVicenteRufo.errores.excepciones.EntityNotFoundException;
import com.salesianos.com.TrianaTouristVicenteRufo.errores.excepciones.ListEntityNotFoundException;
import com.salesianos.com.TrianaTouristVicenteRufo.modelo.POI;
import com.salesianos.com.TrianaTouristVicenteRufo.repositorio.POIRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class POIService {


    private final POIRepository poiRepository;
    private final ConverterPOIdto converterPOIdto;
    private final CategoriaService categoriaService;


    public List<POI> findAll(){

        if (poiRepository.findAll().isEmpty()) {
            throw new ListEntityNotFoundException(POI.class);
        }else{
            return poiRepository.findAll();
        }
    }

    public Optional<POI> findById(Long id){
        if(poiRepository.findById(id).isEmpty()){
            throw new EntityNotFoundException(id,POI.class);
        }else{
            return this.poiRepository.findById(id);
        }
    }

    public POI save(POI poi){return poiRepository.save(poi);}

    public void deleteById(Long id){
        if (poiRepository.findById(id).isEmpty()){
            throw new EntityNotFoundException(id,POI.class);
        }else{
            poiRepository.deleteById(id);
        }
    }

    public Optional<GetPOIdto> edit(Long id, CreatePOIdto poi){
        return findById(id).map(nuevo ->{
            nuevo.setName(poi.getName());
            nuevo.setDescription(poi.getDescription());
            nuevo.setLocation(poi.getLocation());
            nuevo.setCategoria(categoriaService.findById(poi.getCategoria()).get());
            nuevo.setCoverPhoto(poi.getCoverPhoto());
            nuevo.setPhoto2(poi.getPhoto2());
            nuevo.setPhoto3(poi.getPhoto3());
            save(nuevo);
            return converterPOIdto.converterPOIToPOIdto(nuevo);
        });
    }

}
