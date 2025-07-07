package org.example.dragonball.data.remote.response

import kotlinx.serialization.Serializable
import org.example.dragonball.domain.model.TransformationModel

@Serializable
data class TransformationResponse(
    val name: String,
    val image: String,
    val ki: String
){

    fun toDomain():TransformationModel{
        return TransformationModel(
            name = name,
            image = image,
            ki = ki
        )
    }
}
