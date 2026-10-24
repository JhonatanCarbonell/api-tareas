package com.sena.auth_service.service;

import com.sena.auth_service.dto.TareaDTO;
import com.sena.auth_service.entity.Tarea;
import com.sena.auth_service.repository.TareaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    public Tarea crearTarea(TareaDTO dto) {

        Tarea tarea = new Tarea();

        tarea.setTitulo(dto.getTitulo());
        tarea.setDescripcion(dto.getDescripcion());
        tarea.setFechaLimite(dto.getFechaLimite());
        tarea.setCompletada(dto.getCompletada());

        return tareaRepository.save(tarea);
    }

    public List<Tarea> listarTareas() {
        return tareaRepository.findAll();
    }

    public Optional<Tarea> buscarPorId(Long id) {
        return tareaRepository.findById(id);
    }

    public Tarea actualizarTarea(Long id, TareaDTO dto) {

        Tarea tarea = tareaRepository.findById(id).orElse(null);

        if (tarea == null) {
            return null;
        }

        tarea.setTitulo(dto.getTitulo());
        tarea.setDescripcion(dto.getDescripcion());
        tarea.setFechaLimite(dto.getFechaLimite());
        tarea.setCompletada(dto.getCompletada());

        return tareaRepository.save(tarea);
    }

    public boolean eliminarTarea(Long id) {

        if (!tareaRepository.existsById(id)) {
            return false;
        }

        tareaRepository.deleteById(id);
        return true;
    }

}