package com.example.vicky.androidui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_principal.*

class PrincipalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        val requestObject = Usuario()
        var name =requestObject.nombre;
        println(name)
        nombreText.setText("Hola $name !!")

//        Toast.makeText(this , "Estas logeado "+name.toString(), Toast.LENGTH_LONG).show()
    }
}
