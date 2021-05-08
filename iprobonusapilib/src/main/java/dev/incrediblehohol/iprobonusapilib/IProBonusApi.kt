package dev.incrediblehohol.iprobonusapilib

import dev.incrediblehohol.iprobonusapilib.models.getInfo.UserInfo

interface IProBonusApi {

    /**
     *  Get user info wrapped in UserInfo class
     */
    suspend fun getGeneralInfo(): UserInfo?

    companion object {
        /**
         * @param clientId pass client id
         * @param deviceId pass device id
         * BaseUrl and AccessKey in build.gradle
         */
        fun newInstance(clientId: String, deviceId: String): IProBonusApi {
            return IProBonusApiImpl(clientId, deviceId)
        }
    }
}