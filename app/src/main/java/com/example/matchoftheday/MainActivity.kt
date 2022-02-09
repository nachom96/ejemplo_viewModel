package com.example.matchoftheday

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.matchoftheday.databinding.MainActivityBinding

    // 1º Hacer importaciones correspondientes (Está en Apuntes.txt), si da error al ejecutar es porque no las estamos usando
    // 2º Crear el ViewModel

class MainActivity : AppCompatActivity() {

    private val binding: MainActivityBinding by lazy { MainActivityBinding.inflate(layoutInflater) }

    private val viewModel: MainViewModel by viewModels()

    // 9º Llamamos al setupViews y al observePoints
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupViews()
        observePoints()
    }

    // 8º Creamos los clickListener para pasar los valores con los que se actualizará el mardcador
    private fun setupViews() {
        binding.btnHomeTeam3Points.setOnClickListener { viewModel.incrementHomePoints(3) }
        binding.btnHomeTeam2Points.setOnClickListener { viewModel.incrementHomePoints(2) }
        binding.btnHomeTeamFreeThrow.setOnClickListener { viewModel.incrementHomePoints(1) }
        binding.btnVisitingTeam3Points.setOnClickListener { viewModel.incrementVisitingPoints(3)}
        binding.btnVisitingTeam2Points.setOnClickListener { viewModel.incrementVisitingPoints(2) }
        binding.btnVisitingTeamFreeThrow.setOnClickListener { viewModel.incrementVisitingPoints(1) }
        binding.btnReset.setOnClickListener { viewModel.resetPoints() }

    }

    // 7º Nos suscribimos al LiveData para que cada vez que cambie el valor se entregue,
    // Al hacerlo, se llaman a los métodos showHome/VisitingPoints

    private fun observePoints(){
        viewModel.homeTeamPoints.observe(this) { showHomePoints(it)} // El it se puede usar porque reciben un único parámetro
        viewModel.visitingTeamPoints.observe(this) { showVisitingPoints(it)}
    }

    private fun showHomePoints(points: Int){
        binding.lblHomeTeamPoints.text = points.toString()
    }

    private fun showVisitingPoints(points: Int){
        binding.lblVisitingTeamPoints.text = points.toString()
    }


}


