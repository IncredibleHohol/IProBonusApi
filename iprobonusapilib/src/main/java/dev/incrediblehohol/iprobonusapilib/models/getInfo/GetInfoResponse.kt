package dev.incrediblehohol.iprobonusapilib.models.getInfo

import dev.incrediblehohol.iprobonusapilib.models.ResultOperation

internal data class GetInfoResponse(
    val resultOperation: ResultOperation,
    val data: UserInfo
)
