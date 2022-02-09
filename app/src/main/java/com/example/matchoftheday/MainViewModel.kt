package com.example.matchoftheday

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

// 3º Se crea la clase ViewModel con las variables que queramos que preserven su estado
// Se le pone el setter privado para que sólo puedan ser modificadas desde dentro del ViewModel

private const val STATE_HOME_TEAM_POINTS: String = "STATE_HOME_TEAM_POINTS"
private const val STATE_VISITING_TEAM_POINTS: String = "STATE_VISITING_TEAM_POINTS"

// 4º Se le pasa al constructor el savedStateHandle para preservar los datos que son destruidos en el cambio de configuración
class MainViewModel(savedStateHandle: SavedStateHandle): ViewModel() {

    // 5º Se crea el LiveData, el _homeTeamPoints es el MutableLiveData que se usará para cambiar los valores
    private val _homeTeamPoints: MutableLiveData<Int> = savedStateHandle.getLiveData(STATE_HOME_TEAM_POINTS, 0)
    val homeTeamPoints: LiveData<Int>
        get() = _homeTeamPoints // el homeTeamPoints es un getter para que no puedan ser modificados los valores fuera del ViewModel
    private val _visitingTeamPoints: MutableLiveData<Int> = savedStateHandle.getLiveData(STATE_VISITING_TEAM_POINTS, 0)
    val visitingTeamPoints: LiveData<Int>
        get() = _visitingTeamPoints

    // 6º Métodos que cambian los valores de los puntos en el LiveData que serán observados en el MainActivity
    fun incrementHomePoints(points: Int){
        val currentPoints = _homeTeamPoints.value ?: 0
        _homeTeamPoints.value = currentPoints + points
    }

    fun incrementVisitingPoints(points: Int){
        val currentPoints = _visitingTeamPoints.value ?: 0
        _visitingTeamPoints.value = currentPoints + points
    }

    fun resetPoints(){
        _homeTeamPoints.value = 0
        _visitingTeamPoints.value = 0
    }



}
