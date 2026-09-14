package com.clinicaveterinaria.huellitas.controller;

import com.clinicaveterinaria.huellitas.enums.ESPECIE;
import com.clinicaveterinaria.huellitas.model.Mascota;
import com.clinicaveterinaria.huellitas.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mascotas")
public class MascotaController{

    @Autowired

    private MascotaService mascotaService;

    @PostMapping
    public ResponseEntity<Mascota> guardar(@RequestBody Mascota mascota) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mascotaService.guardar(mascota));
    }
    @GetMapping("/ESPECIE/{especie}")
    public List<Mascota>ListarPorEspecie(@PathVariable ESPECIE especie){
        return mascotaService.obtenerPorEspecie(especie);
    }

    @GetMapping
    public ResponseEntity<List<Mascota>> obtenerTodas() {
        return ResponseEntity.ok(mascotaService.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mascota> obtenerPorId(@PathVariable Long id) {
        return mascotaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mascota> actualizar(@PathVariable Long id, @RequestBody Mascota mascota) {
        try {
            return ResponseEntity.ok(mascotaService.actualizar(id, mascota));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        mascotaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}