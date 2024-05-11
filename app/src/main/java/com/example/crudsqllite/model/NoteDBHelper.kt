package com.example.crudsqllite.model

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class NoteDBHelper(context : Context)
    : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object{
        private const val DATABASE_NAME = "notesapp.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "allnotes"
        private const val COLUMN_ID = "id"
        private const val COLUMN_TITLE = "title"
        private const val COLUMN_CONTENT = "content"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val sqlData = "CREATE TABLE ${TABLE_NAME} (" +
                "${COLUMN_ID} INTEGER PRIMARY KEY," +
                "${COLUMN_TITLE} TEXT," +
                "${COLUMN_CONTENT} TEXT" +
                ")"
        db?.execSQL(sqlData)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        //drop table = delete table
        val dropTable = "DROP TABLE IF EXISTS ${TABLE_NAME}"
        db?.execSQL(dropTable)
        onCreate(db)
    }

    fun insertNote(note : Note){
        val db = writableDatabase
        val value = ContentValues().apply {
            put(COLUMN_TITLE, note.title)
            put(COLUMN_CONTENT, note.content)
        }
        db.insert(TABLE_NAME, null, value)
        db.close()
    }

    fun getAllNotes() : List<Note> {
        val notesList = mutableListOf<Note>()
        val db = readableDatabase
        val query = "SELECT * FROM ${TABLE_NAME}"
        val cursor = db.rawQuery(query , null)

        while (cursor.moveToNext()){
            val id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID))
            val title = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TITLE))
            val content = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CONTENT))

            val note = Note(id , title , content)
            notesList.add(note)
        }
        cursor.close()
        db.close()
        return notesList
    }
}