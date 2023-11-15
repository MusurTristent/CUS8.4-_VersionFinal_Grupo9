package com.example.avance_proyecto.data.repository

import com.example.avance_proyecto.data.model.MultasEstado
import com.example.avance_proyecto.network.ApiInstance

class MultasEstadoRepository {

    private val service = ApiInstance.apiInstance

    suspend fun getSolicitudesEstadoRepository() : Result<MultasEstado>{
        return try {
            val response = service.listMultasEstadoApiService()
            Result.success(response)
        }catch (e: Exception){
            Result.failure(e)
        }
    }

}