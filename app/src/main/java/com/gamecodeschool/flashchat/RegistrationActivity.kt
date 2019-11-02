package com.gamecodeschool.flashchat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        auth = FirebaseAuth.getInstance()

        btnRegister.setOnClickListener {
            var email: String = etEmail.text.toString()
            var password: String = etPassword.text.toString()
            Toast.makeText(baseContext, email, Toast.LENGTH_LONG).show()

            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Log.d("Register", "Register was succeful")

                        val user = auth.currentUser

                        var intent = Intent(this, ChatActivity::class.java)
                        startActivity(intent)


                    } else {

                        Log.w("Register", "Register failed", task.exception)
                        Toast.makeText(
                            baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT
                        ).show()

                    }
//                    val intent = Intent(this, ChatActivity::class.java)
//                    startActivity(intent)

                        val intent = Intent(this@RegistrationActivity, LoginActivity::class.java)
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        startActivity(intent)


                    }

        }
    }

}






