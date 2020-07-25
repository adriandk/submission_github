package com.adrian.cunsumerapp

import android.database.Cursor
import com.example.githubapp.favorite.FavoriteData
import com.example.githubapp.database.DatabaseContract
import com.example.githubapp.main.Data

object MappingHelper {

    fun mapCursorToarrayList(notesCursor: Cursor?) : ArrayList<Data>{
        val notesList = ArrayList<Data>()

        notesCursor?.apply {
            while (moveToNext()){
                val id = getInt(getColumnIndexOrThrow(DatabaseContract.NoteColums._ID))
                val username = getString(getColumnIndexOrThrow(DatabaseContract.NoteColums.USERNAME))
                val image= getString(getColumnIndexOrThrow(DatabaseContract.NoteColums.PROFILE))
                notesList.add(Data(id, username, image))
            }
        }

        return notesList
    }

    fun mapCursorToObject(notesCursor: Cursor?) : Data {
        var note = Data()

        notesCursor?.apply {
            moveToFirst()
            val id = getInt(getColumnIndexOrThrow(DatabaseContract.NoteColums._ID))
            val username = getString(getColumnIndexOrThrow(DatabaseContract.NoteColums.USERNAME))
            val image= getString(getColumnIndexOrThrow(DatabaseContract.NoteColums.PROFILE))
            note = Data(id, username, image)
        }

        return note
    }

}