package com.example.avance_proyecto.ui.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.avance_proyecto.data.model.MultasEstado
import com.example.avance_proyecto.data.model.MultasEstadoItem
import com.example.avance_proyecto.domain.MultasEstadoUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MultasEstadoViewModel : ViewModel() {

    val obtenerDatosUseCase = MultasEstadoUseCase()

    private val _multasEstadoResult = MutableStateFlow(MultasEstado())
    val solicitudesEstadoResult = _multasEstadoResult.asStateFlow()

    private val _solicitudesEstadoPendienteResult = MutableStateFlow(listOf<MultasEstadoItem>())
    val solicitudesEstadoPendienteResult = _solicitudesEstadoPendienteResult.asStateFlow()

    private val _filtradoPendiente = MutableStateFlow(listOf<MultasEstadoItem>())
    val filtradoPendiente = _filtradoPendiente.asStateFlow()

    private val _solicitudesEstadoCotizadoResult = MutableStateFlow(listOf<MultasEstadoItem>())
    val solicitudesEstadoCotizadoResult = _solicitudesEstadoCotizadoResult.asStateFlow()

    private val _filtradoCotizado = MutableStateFlow(listOf<MultasEstadoItem>())
    val filtradoCotizado = _filtradoCotizado.asStateFlow()

    private val _solicitudesEstadoObservadoResult = MutableStateFlow(listOf<MultasEstadoItem>())
    val solicitudesEstadoObservadoResult = _solicitudesEstadoObservadoResult.asStateFlow()

    private val _filtradoObservado = MutableStateFlow(listOf<MultasEstadoItem>())
    val filtradoObservado = _filtradoObservado.asStateFlow()

    private val _solicitudesEstadoAnuladoResult = MutableStateFlow(listOf<MultasEstadoItem>())
    val solicitudesEstadoAnuladoResult = _solicitudesEstadoAnuladoResult.asStateFlow()

    private val _filtradoAnulado = MutableStateFlow(listOf<MultasEstadoItem>())
    val filtradoAnulado = _filtradoAnulado.asStateFlow()

    private val _isError = mutableStateOf(false)
    val isError: State<Boolean> = _isError

    private val _isMessageError = mutableStateOf("Error: No se pudo cargar los datos")
    val isMessageError: State<String> = _isMessageError

    private val _isLoading = MutableStateFlow(true)
    val isLoading = _isLoading.asStateFlow()

    init{
        getSolicitudEstado()
    }

    private fun getSolicitudEstado(){
        viewModelScope.launch(Dispatchers.IO){
            obtenerDatosUseCase.getSolicitudEstadoPendienteUC().onSuccess {
                _multasEstadoResult.value = it
                println(it)
            }.onFailure {
                _isError.value = true
            }
            getSolicitudEstadoPendiente()
            _isLoading.value = false
        }
    }

    fun getSolicitudEstadoPendiente(){
        _solicitudesEstadoPendienteResult.value = _multasEstadoResult.value.filter { userData->
            userData.descripcion.lowercase().equals("pendiente")
        }
    }



    fun getFiltradoPendiente(search: String){
        _filtradoPendiente.value = _solicitudesEstadoPendienteResult.value.filter { userData->
            userData.nombres.lowercase().contains(search.toString().lowercase()) ||
                    userData.descripcion.lowercase().contains(search.toString().lowercase()) ||
                    userData.periodo.lowercase().contains(search.toString().lowercase()) ||
                    userData.ap_paterno.lowercase().contains(search.toString().lowercase())
        }
        println("data "+search+" "+_filtradoPendiente.value)
    }



    fun updateIsError(value: Boolean) {
        _isError.value = value
    }

    fun updateIsLoadingState(value: Boolean) {
        _isLoading.value = value
    }

}