package com.example.mysqlite.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.githubapp.database.DatabaseContract
import com.example.githubapp.database.DatabaseContract.NoteColums.Companion.TABLE_NAME

internal class DatabaseHelper (context : Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object{
        private const val DATABASE_NAME = "dbgitbit"

        private const val DATABASE_VERSION = 1

        private val SQL_CREATE_TABLE_NOTE = "CREATE TABLE $TABLE_NAME " +
                "(${DatabaseContract.NoteColums._ID} INTEGER PRIMARY KEY, " +
                "${DatabaseContract.NoteColums.USERNAME} TEXT NO NULL, " +
                "${DatabaseContract.NoteColums.PROFILE} TEXT NO NULL)"
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_TABLE_NOTE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }
}