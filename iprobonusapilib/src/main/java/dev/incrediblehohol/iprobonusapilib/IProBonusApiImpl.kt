package dev.incrediblehohol.iprobonusapilib

import android.util.Log
import dev.incrediblehohol.iprobonusapilib.models.getInfo.UserInfo
import dev.incrediblehohol.iprobonusapilib.models.getToken.GetAccessTokenBody
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * @param clientId pass client id
 * @param deviceId pass device id
 * BaseUrl and AccessKey in build.gradle
 */
internal class IProBonusApiImpl(private val clientId: String, private val deviceId: String) :
    IProBonusApi {

    private val service = NetworkService(BuildConfig.API_URL, BuildConfig.ACCESS_KEY)
    private val api = service.createService(IProBonus::class.java)

    private var accessToken: String = ""


    /**
     *  Get user info wrapped in UserInfo class
     */
    override suspend fun getGeneralInfo(): UserInfo? =
        withContext(Dispatchers.IO) {
            val accessToken = getAccessToken()
            if (accessToken != null) {
                service.safeApiCall {
                    api.getInfo(accessToken)
                }?.getDataIf()
            } else {
                Log.i(
                    javaClass.simpleName,
                    "accessToken: $accessToken"
                )
                null
            }
        }

    private suspend fun getAccessToken(): String? =
        withContext(Dispatchers.IO) {
            service.safeApiCall {
                api.getAccessToken(GetAccessTokenBody(clientId, deviceId))
            }?.getDataIf()
        }
}