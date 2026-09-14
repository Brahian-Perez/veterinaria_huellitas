package com.clinicaveterinaria.huellitas.service;

import com.clinicaveterinaria.huellitas.enums.ESPECIE;
import com.clinicaveterinaria.huellitas.model.Mascota;
import java.util.List;
import java.util.Optional;

public interface MascotaService {
    List<Mascota> obtenerTodas();
    List<Mascota>obtenerPorEspecie(ESPECIE especie);
    Optional<Mascota> obtenerPorId(Long id);
    Mascota guardar(Mascota mascota);
    Mascota actualizar(Long id, Mascota mascota);
    void eliminar(Long id);

}
