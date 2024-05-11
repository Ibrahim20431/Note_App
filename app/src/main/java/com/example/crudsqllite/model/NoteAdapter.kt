package com.example.crudsqllite.model

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.crudsqllite.R
import com.example.crudsqllite.UpdateActivity

class NoteAdapter(private var notes : List<Note>, context : Context)
    : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

        class NoteViewHolder(view : View) : RecyclerView.ViewHolder(view){
            val titleView : EditText = view.findViewById(R.id.txt_title)
            val contentView : EditText = view.findViewById(R.id.txt_content)
            val updateButton : ImageView = view.findViewById(R.id.update_note)
        }

    override fun onCreateViewHolder(parent: ViewGroup , viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.note_item, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]
        holder.titleView.setText(note.title)
        holder.contentView.setText(note.content)

        holder.updateButton.setOnClickListener {
            val intent = Intent(holder.itemView.context, UpdateActivity::class.java)
                .apply {
                    putExtra("note_id", note.id)
                }
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = notes.size

    @SuppressLint("NotifyDataSetChanged")
    fun refresh(newNotes : List<Note>){
        notes = newNotes
        notifyDataSetChanged()
    }
}