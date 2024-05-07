package com.example.ejercicio1_pmdm

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejercicio1_pmdm.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Inflamos todo el xml de la activity.
        binding = ActivityMainBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)

        binding.btnEnviar.setOnClickListener(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


    }


    override fun onClick(v: View?) {

        //Cuando uno de los botones (que corresponde al View) con ese id es pulsado:
        when (v?.id) {

            binding.btnEnviar.id -> {

                if (binding.editNombre.text.isNotEmpty()
                    || binding.editEdad.text.isNotEmpty()
                ) {

                    val nombre: String = binding.editNombre.text.toString()
                    val edad: String = binding.editEdad.text.toString()

                    val intent: Intent = Intent(this, SecondActivity::class.java)
                        .putExtra("nombre", nombre)
                        .putExtra("edad", edad)
                    startActivity(intent)


                } else {

                    Snackbar.make(
                        binding.root,
                        "introduzca todos los campos",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }

            }


        }
    }
}