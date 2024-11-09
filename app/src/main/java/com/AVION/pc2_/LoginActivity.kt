package com.AVION.pc2_

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etEmailLogin: EditText = findViewById(R.id.etCorreo)
        val etPasswordLogin: EditText = findViewById(R.id.etPassword)
        val btLogin: Button = findViewById(R.id.btnLogin)
        val auth = FirebaseAuth.getInstance()



        btLogin.setOnClickListener {
            val email = etEmailLogin.text.toString()
            val password = etPasswordLogin.text.toString()

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this){task->
                    if(task.isSuccessful){
                        //Inicio de sesión exitoso
                        Snackbar
                            .make(findViewById(android.R.id.content),
                                "Inicio de sesión exitoso",
                                Snackbar.LENGTH_SHORT).show()
                        //startActivity(Intent(this, ::class.java))
                    }else{
                        //Error en el inicio de sesión
                        Snackbar
                            .make(findViewById(android.R.id.content),
                                "Error con el inicio de sesión",
                                Snackbar.LENGTH_SHORT).show()
                    }

                }
        }
    }
}