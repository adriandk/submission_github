package com.adrian.consumerapp.database

import android.database.Cursor
import com.adrian.consumerapp.Data

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