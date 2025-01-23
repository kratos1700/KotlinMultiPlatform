package org.example.rickmotryapp.data.remote.response

import kotlinx.serialization.Serializable

@Serializable // sirve para que se pueda serializar y deserializar el objeto de la petición
data class InfoResponse(
    val pages:Int,
    val next:String?,
    val prev:String?
)
