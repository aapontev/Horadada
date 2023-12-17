package com.projecto.Horadada.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.projecto.Horadada.Entity.TransportistaEntity;

public interface TransportistaService {

    public abstract List<TransportistaEntity> findByAll();

    public abstract TransportistaEntity findByidtransportista(int id);

    public abstract TransportistaEntity save(TransportistaEntity transportista);

    public abstract void delete(int id);

    public Page<TransportistaEntity> findAll(Pageable pageable);

    public abstract TransportistaEntity findByidsituaciontransportista(int i);
}
