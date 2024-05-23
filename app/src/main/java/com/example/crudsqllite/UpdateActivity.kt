package com.example.crudsqllite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.crudsqllite.databinding.ActivityUpdateBinding
import com.example.crudsqllite.model.Note
import com.example.crudsqllite.model.NoteAdapter
import com.example.crudsqllite.model.NoteDBHelper

class UpdateActivity : AppCompatActivity() {

    private lateinit var binding : ActivityUpdateBinding
    lateinit var db : NoteDBHelper
    private var noteId : Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadNote()
        saveUpdate()
    }

    fun loadNote(){
        db = NoteDBHelper(this)
        noteId = intent.getIntExtra("note_id" , -1)
        if (noteId == -1){
            finish()
            return
        }
        val note = db.getNoteById(noteId)
        binding.updateTitle.setText(note.title)
        binding.updateContent.setText(note.content)
    }

    fun saveUpdate(){
        binding.updateDone.setOnClickListener{
            val title = binding.updateTitle.text.toString()
            val content = binding.updateContent.text.toString()
            val note = Note(noteId,title,content)
            db.updateNote(note)
            finish()
            Toast.makeText(this, "Note Updated", Toast.LENGTH_SHORT).show()
        }
    }
}