package dev.incrediblehohol.iprobonusapilib.models.getToken

import com.google.gson.annotations.SerializedName
import dev.incrediblehohol.iprobonusapilib.models.ResultOperation


internal data class AccessToken(
    @SerializedName("result")
    val result: ResultOperation,
    @SerializedName("accessToken")
    val accessToken: String
)