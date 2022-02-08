package com.example.matchoftheday


import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.matchoftheday.databinding.MainActivityBinding

    // 1º Hacer importaciones correspondientes (Está en Apuntes.txt)
    // 2º Crear el ViewModel

class MainActivity : AppCompatActivity() {

    private val binding: MainActivityBinding by lazy { MainActivityBinding.inflate(layoutInflater) }

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupViews()
    }

    private fun setupViews() {
        binding.btnHomeTeam3Points.setOnClickListener { incrementHomePoints(3) }
        binding.btnHomeTeam2Points.setOnClickListener { incrementHomePoints(2) }
        binding.btnHomeTeamFreeThrow.setOnClickListener { incrementHomePoints(1) }
        binding.btnVisitingTeam3Points.setOnClickListener { incrementsVisitingPoints(3) }
        binding.btnVisitingTeam2Points.setOnClickListener { incrementsVisitingPoints(2) }
        binding.btnVisitingTeamFreeThrow.setOnClickListener { incrementsVisitingPoints(1) }
        binding.btnReset.setOnClickListener { reset() }
        showHomePoints()
        showVisitingPoints()

    }

    // 4º Métodos para incrementar los puntos, en el setupViews se llama a estos métodos los cuales
    // incrementan los valores de las variables guardadas en el ViewModel para así preservar su estado

    // Hay que llamar a showHomePoints/showVisitingPoints ya que devuelven el texto del viewModel

    private fun incrementHomePoints(points: Int){
        viewModel.incrementHomePoints(points)
        showHomePoints()
    }

    private fun incrementsVisitingPoints(points: Int){
        viewModel.incrementVisitingPoints(points)
        showVisitingPoints()
    }
    private fun showHomePoints(){
        binding.lblHomeTeamPoints.text = viewModel.homeTeamPoints.toString()
    }

    private fun showVisitingPoints(){
        binding.lblVisitingTeamPoints.text = viewModel.visitingTeamPoints.toString()
    }

    private fun reset(){
        viewModel.resetPoints()
        showHomePoints()
        showVisitingPoints()
    }


}


