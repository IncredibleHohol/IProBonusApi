package dev.incrediblehohol.iprobonusapilib.models.getInfo

data class UserInfo(
    val typeBonusName: String,
    val currentQuantity: Long,
    val forBurningQuantity: Long,
    val dateBurning: String
)