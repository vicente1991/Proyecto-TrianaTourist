package com.salesianos.com.TrianaTouristVicenteRufo.servicio;

import com.salesianos.com.TrianaTouristVicenteRufo.errores.excepciones.EntityNotFoundException;
import com.salesianos.com.TrianaTouristVicenteRufo.errores.excepciones.ListEntityNotFoundException;
import com.salesianos.com.TrianaTouristVicenteRufo.modelo.POI;
import com.salesianos.com.TrianaTouristVicenteRufo.repositorio.POIRepository;
import com.salesianos.com.TrianaTouristVicenteRufo.servicio.base.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class POIService extends BaseService<POI,Long, POIRepository> {


    private final POIRepository poiRepository;


    public List<POI> findAll(){
        if (poiRepository.findAll().isEmpty()){
            throw new ListEntityNotFoundException(POIService.class);
        }else{
            return this.poiRepository.findAll();
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

    public POI edit(POI poi){return poiRepository.save(poi);}

}
