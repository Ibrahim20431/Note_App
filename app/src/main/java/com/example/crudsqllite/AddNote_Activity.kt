package com.example.crudsqllite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.crudsqllite.databinding.ActivityAddNoteBinding
import com.example.crudsqllite.model.Note
import com.example.crudsqllite.model.NoteDBHelper

class AddNote_Activity : AppCompatActivity() {

    lateinit var binding : ActivityAddNoteBinding
    lateinit var db : NoteDBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NoteDBHelper(this)

        binding.imgDone.setOnClickListener{
            val title = binding.edtxtTitle.text.toString()
            val content = binding.edtxtContent.text.toString()
            val note = Note(0,title,content)
            db.insertNote(note)
            finish()
            Toast.makeText(this, "Note Saved", Toast.LENGTH_SHORT).show()
        }

    }
}