package com.example.avance_proyecto.domain

import com.example.avance_proyecto.data.model.EstadoMulta
import com.example.avance_proyecto.data.repository.EstadoMultaRepository

class MultaSolicitudUseCase {

    private val repository = EstadoMultaRepository()

    suspend fun getEstadoSolicitudUC(): Result<EstadoMulta> {
        return repository.getEstadoSolicitudRepository()
    }
}