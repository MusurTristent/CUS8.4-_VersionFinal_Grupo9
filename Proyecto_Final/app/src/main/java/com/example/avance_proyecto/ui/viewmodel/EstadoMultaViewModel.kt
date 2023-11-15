package com.example.avance_proyecto.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.avance_proyecto.data.model.EstadoMulta
import com.example.avance_proyecto.domain.MultaSolicitudUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EstadoMultaViewModel : ViewModel() {

    val obtenerDatosUseCase = MultaSolicitudUseCase()

    private val _estadosolicitudResult = MutableLiveData<EstadoMulta>()
    val estadosolicitudResult: LiveData<EstadoMulta> = _estadosolicitudResult

    private val _isError = mutableStateOf(false)
    val isError: State<Boolean> = _isError

    private val _isMessageError = mutableStateOf("Error: No se pudo cargar los datos")
    val isMessageError: State<String> = _isMessageError

    private val _isLoading = mutableStateOf(true)
    val isLoading: State<Boolean> = _isLoading

    fun updateIsError(value: Boolean) {
        _isError.value = value
    }

}