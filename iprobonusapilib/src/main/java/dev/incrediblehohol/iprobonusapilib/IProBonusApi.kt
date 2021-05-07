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
class IProBonusApi(private val clientId: String, private val deviceId: String) {

    private val service = NetworkService(BuildConfig.API_URL, BuildConfig.ACCESS_KEY)
    private val api = service.createService(IProBonus::class.java)

    private var accessToken: String = ""

    private suspend fun getAccessToken(): String =
        withContext(Dispatchers.IO) {
            val token = service.safeApiCall {
                api.getAccessToken(GetAccessTokenBody(clientId, deviceId))
            }
            if (token?.result?.status == 0)
                accessToken = token.accessToken
            accessToken
        }

    /**
     *  Get user info wrapped in UserInfo class
     */
    suspend fun getGeneralInfo(): UserInfo? =
        withContext(Dispatchers.IO) {
            val info = service.safeApiCall {
                api.getInfo(getAccessToken())
            }

            info?.let {
                if (it.resultOperation.status == 0)
                    it.data
                else {
                    Log.i(
                        javaClass.simpleName,
                        "status: ${it.resultOperation.status}, accessToken: $accessToken, idLog: ${it.resultOperation.idLog}"
                    )
                    null
                }
            }
        }
}