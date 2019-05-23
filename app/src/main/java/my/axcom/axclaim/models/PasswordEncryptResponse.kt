package my.axcom.axclaim.services

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Addam on 12/1/2019.
 */
data class PasswordEncryptResponse (
    @SerializedName("status")
    @Expose
    var status: Boolean,
    @SerializedName("message")
    @Expose
    var message: String,
    @SerializedName("data")
    @Expose
    var data: Data
)

data class Data(
    @SerializedName("keys")
    @Expose
    var keys: String
)