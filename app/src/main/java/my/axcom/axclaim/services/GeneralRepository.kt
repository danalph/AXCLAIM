package my.axcom.axclaim.services

import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GeneralRepository @Inject constructor(private val api: GeneralService){

    fun getPasswordEncrypt(password: String): Single<PasswordEncryptResponse> = api.getPasswordEncrypt(password)

}