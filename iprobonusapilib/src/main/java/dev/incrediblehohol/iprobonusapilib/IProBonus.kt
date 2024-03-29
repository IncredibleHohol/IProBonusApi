package dev.incrediblehohol.iprobonusapilib

import dev.incrediblehohol.iprobonusapilib.models.ResponseWrapper
import dev.incrediblehohol.iprobonusapilib.models.getInfo.GetInfoResponse
import dev.incrediblehohol.iprobonusapilib.models.getInfo.UserInfo
import dev.incrediblehohol.iprobonusapilib.models.getToken.AccessToken
import dev.incrediblehohol.iprobonusapilib.models.getToken.GetAccessTokenBody
import retrofit2.http.*

internal interface IProBonus {

    @Headers("Content-Type: text/json")
    @POST("/api/v3/clients/accesstoken")
    suspend fun getAccessToken(@Body body: GetAccessTokenBody): ResponseWrapper<String>

    @GET("/api/v3/ibonus/generalinfo/{accessToken}")
    suspend fun getInfo(@Path("accessToken") token: String): ResponseWrapper<UserInfo>
}