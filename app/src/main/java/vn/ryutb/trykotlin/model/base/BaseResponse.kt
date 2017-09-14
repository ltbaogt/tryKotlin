package vn.ryutb.trykotlin.model.base

import com.google.gson.annotations.SerializedName

/**
 * Created by MyPC on 15/09/2017.
 */
abstract class BaseResponse<M> : BaseModel() {

    @SerializedName("result")
    var result: Boolean = false

    @SerializedName("code")
    var code: Int = 0

    @SerializedName("message")
    var message: String? = null

    abstract val data : M
}