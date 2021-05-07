package dev.incrediblehohol.iprobonusapilib.models

internal data class ResultOperation(
    val status: Int,
    val message: String,
    val messageDev: String,
    val codeResult: Int,
    val duration: Int,
    val idLog: String
)