package com.example.avance_proyecto.network
import com.example.avance_proyecto.data.model.EstadoMulta
import com.example.avance_proyecto.data.model.MultasEstado
import retrofit2.http.GET


interface ApiService {

    @GET("/estado_multas")
    suspend fun listEstadoMultaApiService( ): EstadoMulta

    @GET("/casa_infraccion")
    suspend fun listMultasEstadoApiService( ): MultasEstado

}