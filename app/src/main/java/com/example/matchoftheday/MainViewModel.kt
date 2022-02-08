package com.example.matchoftheday

import androidx.lifecycle.ViewModel

// 3º Se crea la clase ViewModel con las variables que queramos que preserven su estado
// Se le pone el setter privado para que sólo puedan ser modificadas desde dentro del ViewModel

class MainViewModel(): ViewModel() {

    var homeTeamPoints: Int = 0
        private set
    var visitingTeamPoints: Int = 0
        private set

    fun incrementHomePoints(points: Int) {
        homeTeamPoints += points
    }

    fun incrementVisitingPoints(points: Int) {
        visitingTeamPoints += points
    }

    fun resetPoints() {
        homeTeamPoints = 0
        visitingTeamPoints = 0
    }

}
