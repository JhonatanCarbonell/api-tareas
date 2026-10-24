package com.sena.auth_service.controller;

import com.sena.auth_service.dto.TareaDTO;
import com.sena.auth_service.entity.Tarea;
import com.sena.auth_service.service.TareaService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    @PostMapping
    public ResponseEntity<Tarea> crear(
            @Valid @RequestBody TareaDTO dto) {

        return ResponseEntity
                .status(201)
                .body(tareaService.crearTarea(dto));
    }

    @GetMapping
    public ResponseEntity<List<Tarea>> listar() {

        return ResponseEntity.ok(
                tareaService.listarTareas()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable Long id) {

        Optional<Tarea> tarea =
                tareaService.buscarPorId(id);

        if (tarea.isEmpty()) {
            return ResponseEntity.status(404)
                    .body("Tarea no encontrada");
        }

        return ResponseEntity.ok(tarea.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(
            @PathVariable Long id,
            @RequestBody TareaDTO dto) {

        Tarea tarea =
                tareaService.actualizarTarea(id, dto);

        if (tarea == null) {
            return ResponseEntity.status(404)
                    .body("Tarea no encontrada");
        }

        return ResponseEntity.ok(tarea);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(
            @PathVariable Long id) {

        boolean eliminada =
                tareaService.eliminarTarea(id);

        if (!eliminada) {
            return ResponseEntity.status(404)
                    .body("Tarea no encontrada");
        }

        return ResponseEntity.noContent().build();
    }

}