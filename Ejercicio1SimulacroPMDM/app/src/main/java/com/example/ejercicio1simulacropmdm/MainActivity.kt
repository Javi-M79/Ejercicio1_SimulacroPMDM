package com.example.ejercicio1simulacropmdm

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejercicio1simulacropmdm.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.botonEntrar.setOnClickListener(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.botonEntrar.id -> {
                //Comprobamos que los datos estan rellenos.
                if (binding.editNombre.text.isNotEmpty()
                    || binding.editEdad.text.isNotEmpty()
                ) {
                    //Si estan rellenos:
                    val nombre: String = binding.editNombre.text.toString()
                    val edad: String = binding.editEdad.text.toString()
                    //Enviamos los datos a la otra activity
                    val intent: Intent = Intent(this, SecondActivity::class.java)
                        .putExtra("nombre", nombre)
                        .putExtra("edad", edad)
                    startActivity(intent)

                } else {
                    Snackbar.make(
                        binding.root,
                        "Rellene todos los campos por favor",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }

            }

        }
    }
}