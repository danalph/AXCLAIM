package my.axcom.axclaim.services

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GeneralService {

        @GET("auth/encryption/{password}")
        fun getPasswordEncrypt(@Path("password") password: String): Single<PasswordEncryptResponse>

}