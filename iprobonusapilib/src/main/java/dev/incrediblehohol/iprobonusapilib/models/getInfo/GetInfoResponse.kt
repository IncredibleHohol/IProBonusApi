package dev.incrediblehohol.iprobonusapilib.models.getInfo

import com.google.gson.annotations.SerializedName
import dev.incrediblehohol.iprobonusapilib.models.ResultOperation

internal data class GetInfoResponse(
    @SerializedName("resultOperation")
    val resultOperation: ResultOperation,
    @SerializedName("data")
    val data: UserInfo
)
