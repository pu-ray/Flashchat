package com.gamecodeschool.flashchat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_registration.*

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)



        btnLogin.setOnClickListener {
            var email: String = etEmail.text.toString()
            var password: String = etPassword.text.toString()
            Toast.makeText(baseContext, email, Toast.LENGTH_LONG).show()

            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Log.d("Login", "Login was succeful")

                        val user = auth.currentUser



                        var intent = Intent(this, ChatActivity::class.java)
                        startActivity(intent)

                    }
                    else{
                        Log.w("Login","Login failed", task.exception)
                        Toast.makeText(baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()

                    }





                }
        }


    }
}
