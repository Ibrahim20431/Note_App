package com.example.crudsqllite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.crudsqllite.databinding.ActivityMainBinding
import com.example.crudsqllite.model.NoteAdapter
import com.example.crudsqllite.model.NoteDBHelper

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var db : NoteDBHelper
    lateinit var notesAdapter : NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        floatingClick()

        db = NoteDBHelper(this)
        notesAdapter = NoteAdapter(db.getAllNotes(), this)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = notesAdapter
    }

    fun floatingClick(){
        binding.floatingAdd.setOnClickListener{
            val intent = Intent(this, AddNote_Activity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        notesAdapter.refresh(db.getAllNotes())
    }
}