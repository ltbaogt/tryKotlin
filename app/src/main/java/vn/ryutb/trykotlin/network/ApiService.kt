package vn.ryutb.trykotlin.network

import com.google.gson.JsonObject
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST
import vn.ryutb.trykotlin.model.ObjectResponse
import vn.ryutb.trykotlin.model.SignInModel

/**
 * Created by MyPC on 15/09/2017.
 */
interface ApiService {
    @POST("users/signIn")
    fun login(@Body body:JsonObject) : Observable<ObjectResponse<SignInModel>>
}