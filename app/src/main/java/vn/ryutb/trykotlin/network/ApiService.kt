package vn.ryutb.trykotlin.network

import com.google.gson.JsonObject
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import vn.ryutb.trykotlin.model.Movie
import vn.ryutb.trykotlin.model.ObjectResponse
import vn.ryutb.trykotlin.model.SignInModel
import vn.ryutb.trykotlin.model.base.ListData

/**
 * Created by MyPC on 15/09/2017.
 */
interface ApiService {
    @POST("movie/popular")
    fun login(@Query("page") page: Int, @Body body: JsonObject): Observable<ObjectResponse<SignInModel>>

    @GET("movie/popular")
    fun getMovieList(@Query("page") page: Int): Observable<ListData<Movie>>

    @POST("users/sendCode")
    fun signIn(@Body body: JsonObject) : Observable<ObjectResponse<SignInModel>>
}

