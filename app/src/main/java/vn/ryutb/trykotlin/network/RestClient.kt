package vn.ryutb.trykotlin.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import vn.ryutb.trykotlin.BuildConfig

/**
 * Created by MyPC on 15/09/2017.
 */

class RestClient {

    companion object {
        private val sLoginIntercept: HttpLoggingInterceptor by lazy {
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        }
        private val sClient: OkHttpClient by lazy {
            OkHttpClient.Builder().addInterceptor(sLoginIntercept).build() }

        private val sGsonFactory: GsonConverterFactory by lazy {
            GsonConverterFactory.create(GsonBuilder().create())
        }

        fun provideRestClient(): ApiService {

//            val sLoginIntercept: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
//                level = HttpLoggingInterceptor.Level.BODY
//            }
//            val sClient: OkHttpClient = OkHttpClient.Builder().addInterceptor(sLoginIntercept).build()
//            val sGsonFactory: GsonConverterFactory = GsonConverterFactory.create(GsonBuilder().create())
            return Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .client(sClient)
                    .addConverterFactory(sGsonFactory)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build().create(ApiService::class.java)
        }
    }


}