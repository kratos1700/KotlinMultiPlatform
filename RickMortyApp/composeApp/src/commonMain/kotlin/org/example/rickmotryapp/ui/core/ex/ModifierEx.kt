package org.example.rickmotryapp.ui.core.ex

import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout

// esta extension nos permite centrar un elemento verticalmente en un contenedor padre
fun Modifier.vertical() = layout { measurable, constraints ->
    val placeable = measurable.measure(constraints)
    layout(placeable.width, placeable.height) {
        placeable.place( //colocamos el elemento en el centro vertical, dividiendo la altura del contenedor padre entre 2 y restando la mitad de la altura del elemento
            x = -((placeable.width / 2) - (placeable.height / 2)), //centramos el elemento verticalmente
            y = -((placeable.height / 2) - (placeable.width / 2)) //centramos el elemento horizontalmente

        )
    }
}