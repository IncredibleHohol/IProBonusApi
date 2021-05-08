package dev.incrediblehohol.iprobonusapilib.models.getInfo

import com.google.gson.annotations.SerializedName

data class UserInfo(
    @SerializedName("typeBonusName")
    val typeBonusName: String? = null,
    @SerializedName("currentQuantity")
    val currentQuantity: Long? = null,
    @SerializedName("forBurningQuantity")
    val forBurningQuantity: Long? = null,
    @SerializedName("dateBurning")
    val dateBurning: String? = null
)