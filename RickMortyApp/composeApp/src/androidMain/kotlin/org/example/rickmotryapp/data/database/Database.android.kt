package org.example.rickmotryapp.data.database

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers

// Creacion de la base de datos de Room
fun getDatabase(context:Context):RickMortyDatabase{
    val dbFile = context.getDatabasePath(DATABASE_NAME)
    return Room.databaseBuilder<RickMortyDatabase>(context, dbFile.absolutePath)
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .addMigrations()
        .build()
}
