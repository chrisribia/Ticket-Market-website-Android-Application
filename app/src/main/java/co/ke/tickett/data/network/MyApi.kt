package co.ke.tickett.data.network

import co.ke.tickett.data.db.entity.Tickets
import co.ke.tickett.data.network.Response.AuthResponse
import co.ke.tickett.data.network.Response.TicketsResponse
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
interface MyApi {

    @FormUrlEncoded
    @POST("userlogin.php")
    suspend fun userLogin(
        @Field("email")
        email: String,
        @Field("passcode")
        password: String
    ) : Response<AuthResponse>

    @GET("qr_codes.php")
    suspend fun getTickets() : Response<TicketsResponse>


    companion object{
        operator fun invoke(
            networkConnectionInterceptor: NetworkConnectionInterceptor
        ) : MyApi{

            val okkHttpclient = OkHttpClient.Builder()
                .addInterceptor(networkConnectionInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okkHttpclient)
                .baseUrl("http://192.168.0.21/android/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }

}

