package my.axcom.axclaim.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Auth (
    @SerializedName("status")
    @Expose
    var status: Boolean,
    @SerializedName("message")
    @Expose
    var message: String
    /*@SerializedName("data")
    @Expose
    var data: Array<String>*/
)

/*data class Data(
    @SerializedName("keys")
    @Expose
    var keys: String
)*/

/*data class Auth(
    @SerializedName("id")
    @Expose
    var id: Int,
    @SerializedName("employee_name")
    @Expose
    var employee_name: String
)*/