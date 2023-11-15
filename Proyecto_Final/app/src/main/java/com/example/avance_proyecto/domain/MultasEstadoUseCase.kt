package com.example.avance_proyecto.domain

import com.example.avance_proyecto.data.model.MultasEstado
import com.example.avance_proyecto.data.repository.MultasEstadoRepository

class MultasEstadoUseCase {

    private val repository = MultasEstadoRepository()

    suspend fun getSolicitudEstadoPendienteUC(): Result<MultasEstado> {
        return repository.getSolicitudesEstadoRepository()
    }


}