package dev.incrediblehohol.iprobonusapilib.models.getToken

import dev.incrediblehohol.iprobonusapilib.models.ResultOperation

internal data class AccessToken(
    val result: ResultOperation,
    val accessToken: String
)