package com.AVION.pc2_.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.AVION.pc2_.R
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.type.Date

class RegistroMonto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registro_monto)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val db = Firebase.firestore
        val userId = "pc2@gmail.com"
        val userRef = db.collection("users").document(userId)

        userRef.get().addOnSuccessListener { document ->
            if (document != null && document.exists()) {
                // User data found
                val user = document.toObject(User::class.java)
            } else {
                // User data not found
            }
        }.addOnFailureListener { exception ->
            // Handle any errors
        }
        val btIngreso: Button = findViewById(R.id.btSubirIng)
        val btGasto: Button = findViewById(R.id.btSubirGasto)

        //btIngreso.setOnClickListener({
        //    val description = descriptionEditText.text.toString()
        //    val amount =amountEditText.text.toString().toDoubleOrNull() ?: 0.0 // Handle null or invalid input
//
        //          val db = Firebase.firestore
        //  val userId = "user123" // Replace with the actual user ID
//
        //          val financialMovement = FinancialMovement(
        //      description = description,
        //      amount = amount,
        //      date = Date()
        //  )
//////
            //      db.collection("users").document(userId)
            //  .collection("financialMovements")
            //  .add(financialMovement)
        //  .addOnSuccessListener { documentReference ->
        //          // Movement added successfully, clear input fields, show a toast, etc.
        //          descriptionEditText.text.clear()
        //          amountEditText.text.clear()
            //      }
        //  .addOnFailureListener { e ->
        //          // Handle any errors, show an error message, etc.
        //      }
        //})
    }
}