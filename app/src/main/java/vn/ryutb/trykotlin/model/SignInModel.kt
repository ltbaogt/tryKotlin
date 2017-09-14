package vn.ryutb.trykotlin.model

import com.google.gson.annotations.SerializedName
import vn.ryutb.trykotlin.model.base.BaseData

/**
 * Created by MyPC on 15/09/2017.
 */
data class SignInModel(@SerializedName("name") val name: String) : BaseData() {
}