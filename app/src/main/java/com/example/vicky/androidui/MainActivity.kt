package com.example.vicky.androidui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import org.json.JSONObject
import java.io.IOException




class MainActivity : AppCompatActivity() {

    var txtPass: TextView? = null
    val client = OkHttpClient()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtPass= findViewById(R.id.password)
        login.setOnClickListener {
            if (username.text.toString().isNotEmpty() && password.text.toString().isNotEmpty())
                funcion(this@MainActivity, username.text.toString(), password.text.toString())
            else Toast.makeText(this@MainActivity, "Llene todos los campos", Toast.LENGTH_SHORT).show()

        }
    }

    fun funcion(activity: MainActivity, username: String, password: String) {
        run("http://5574cbfe.ngrok.io/ApiApp/login/"+username+"/"+password, activity)
    }

    fun run(url: String, activity: MainActivity) {
        val request = Request.Builder()
                .url(url)
                .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                this@MainActivity.runOnUiThread {
                    Toast.makeText(this@MainActivity, "Error de conexión", Toast.LENGTH_LONG).show()
                }
            }
            override fun onResponse(call: Call, response: Response) {

                if (!response.isSuccessful()) {
                    this@MainActivity.runOnUiThread {
                        Toast.makeText(this@MainActivity, "Error de conexión", Toast.LENGTH_LONG).show()
                    }
                }else{
                    val responseData = response.body()!!.string()
                    val json = JSONObject(responseData)
                    val owner = json.getString("estado")
                    if (owner == "Ok") {
                        val requestObject = Usuario()
                        requestObject.nombre = json.getString("nombre")
                        requestObject.apellido = json.getString("apellido")

                        this@MainActivity.runOnUiThread {
                            val intent: Intent = Intent(this@MainActivity, PrincipalActivity::class.java)
                            startActivity(intent)
                            }
                    }
                    else {
                        this@MainActivity.runOnUiThread {
                            password.setText("")
                            Toast.makeText(this@MainActivity, "Usuario o contraseña equivocados", Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }

        })
    }

    fun funcion2(owner: String,activity: MainActivity) {
         Toast.makeText(activity, "Good", Toast.LENGTH_SHORT).show()
    }

}