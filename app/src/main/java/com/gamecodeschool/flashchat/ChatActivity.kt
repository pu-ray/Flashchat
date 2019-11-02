package com.gamecodeschool.flashchat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_chat.*
import kotlinx.android.synthetic.main.activity_registration.*

class ChatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("message")

        myRef.setValue("Hello, World!")

    }

    override fun onResume() {
        super.onResume()
        btnsend.setOnClickListener {
            var message: String = etmessage.text.toString()
            var sender: String? = FirebaseDatabase.getInstance().currentUser?.displayNames
            var chat: Chat = Chat(sender as String, message)

        }
    }


}
