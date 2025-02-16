package org.example.rickmotryapp.ui.core.ex

import androidx.compose.foundation.border
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.dp
import org.example.rickmotryapp.ui.core.Green

// esta extension nos permite centrar un elemento verticalmente en un contenedor padre
fun Modifier.vertical() = layout { measurable, constraints ->
    val placeable = measurable.measure(constraints)
    layout(placeable.height, placeable.width) {
        placeable.place( //colocamos el elemento en el centro vertical, dividiendo la altura del contenedor padre entre 2 y restando la mitad de la altura del elemento
            x = -(placeable.width / 2 - placeable.height / 2), //centramos el elemento verticalmente
            y = -(placeable.height / 2 - placeable.width / 2) //centramos el elemento horizontalmente

        )
    }
}

// esta extension nos permite agregar un borde a un elemento, el color del borde depende de si el elemento esta vivo o no
fun Modifier.aliveBorder(isAlive: Boolean): Modifier {

    val color = if (isAlive) Green else Color.Red
    return border(4.dp, color, CircleShape)  //agregamos un borde al elemento

}
