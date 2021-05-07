package dev.incrediblehohol.iprobonusapilib.models.getToken

internal data class GetAccessTokenBody(
    val idClient: String,
    val paramValue: String,
)