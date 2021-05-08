package dev.incrediblehohol.iprobonusapilib.models

import com.google.gson.annotations.SerializedName

internal data class ResponseWrapper<T>(
    @SerializedName("resultOperation")
    val resultOperation: ResultOperation? = null,
    @SerializedName("accessToken", alternate = ["data"])
    val data: T? = null
) {
    fun getDataIf(): T? {
        return data.takeIf { resultOperation?.status == 0 }
    }
}
