package org.example.rickmotryapp.data.database

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSURL
import platform.Foundation.NSUserDomainMask

fun getDatabase(): RickMortyDatabase {  // sirve para crear la base de datos de Room en iOS
   val dbFile = "${fileDirectory()}/$DATABASE_NAME"  // se crea el archivo de la base de datos
    return Room.databaseBuilder<RickMortyDatabase>(name = dbFile) //retorna la base de datos de Room
        .setDriver(BundledSQLiteDriver()) // se setea el driver de la base de datos
        .setQueryCoroutineContext(Dispatchers.IO) // se setea el contexto de la query
        .build()
}

@OptIn(ExperimentalForeignApi::class)
fun fileDirectory(): String {  // creamos la ruta del archivo de la base de datos i la pasamos a string para retornarla a getDatabase
    val documentDirectory:NSURL? = NSFileManager.defaultManager.URLForDirectory(  // se obtiene el directorio de documentos
        directory = NSDocumentDirectory,  // se obtiene el directorio de documentos
        inDomain = NSUserDomainMask, //inDomain sirve para obtener el directorio de documentos
        appropriateForURL = null, //
        create = false,
        error = null
    )
    return  requireNotNull(documentDirectory).path!!
}
