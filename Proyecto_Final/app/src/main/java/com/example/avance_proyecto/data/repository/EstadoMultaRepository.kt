package com.example.avance_proyecto.data.repository

import com.example.avance_proyecto.data.model.EstadoMulta
import com.example.avance_proyecto.network.ApiInstance

class EstadoMultaRepository {

    private val service = ApiInstance.apiInstance

    suspend fun getEstadoSolicitudRepository() : Result<EstadoMulta>{
        return try {
            val response = service.listEstadoMultaApiService()
            Result.success(response)
        }catch (e: Exception){
            Result.failure(e)
        }
    }
}