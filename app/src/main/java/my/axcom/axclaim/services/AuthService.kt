package my.axcom.axclaim.services

import my.axcom.axclaim.models.Auth
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface AuthService {

    @GET("auth/encryption/{key}")
    fun getAuth(@Path("key") key : String) : Call<List<Auth>>

    /*@GET("employees")
    fun getEmployeeList() : Call<List<Auth>>*/

}