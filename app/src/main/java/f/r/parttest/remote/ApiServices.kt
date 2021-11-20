package f.r.parttest.remote

import com.google.gson.GsonBuilder
import f.r.parttest.dataClass.ResponseUserList
import f.r.parttest.helper.ConstantValue

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiServices @Inject constructor() {

    interface DataApi {

        @GET("users?page=2")
        @Headers("Accept: application/json")
        suspend fun getUserList(): Response<ResponseUserList>

    }


    val interceptor = HttpLoggingInterceptor().apply {
        this.level = HttpLoggingInterceptor.Level.BODY
    }

    val client = OkHttpClient.Builder().apply {
        this.addInterceptor(interceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(25, TimeUnit.SECONDS)
    }.build()

    fun getApi(): DataApi =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .baseUrl(ConstantValue.SERVER_ADDRESS + "api/")
            .client(client)
            .build()
            .create(DataApi::class.java)

    /*  val okHttpClient: OkHttpClient = OkHttpClient.Builder()
          .connectTimeout(120, TimeUnit.SECONDS)
          .readTimeout(120, TimeUnit.SECONDS)
          .build()*/
}