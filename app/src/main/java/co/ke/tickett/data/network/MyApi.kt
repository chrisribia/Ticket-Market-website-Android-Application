package co.ke.tickett.data.network

import co.ke.tickett.data.network.Response.*
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface MyApi {

    @FormUrlEncoded
    @POST("userLogin.php")
    suspend fun userLogin(
        @Field("email")
        email: String,
        @Field("passcode")
        password: String
    ) : Response<AuthResponse>


    @GET("qr_codes.php")
    suspend fun getEvents() : Response<EventsResponse>


    @GET("eventNames.php")
    suspend fun getSummery() : Response<BalanceResponse>

    @GET("getTicketTypesForSale.php")
    suspend fun getSell() : Response<SellResponse>


    @FormUrlEncoded
    @POST("confirm.php")
    suspend fun confirmTicket(
    @Field("qr_code")
    qr_code : String )  : Response<ConfirmResponse>

    @FormUrlEncoded
    @POST("confirmCode.php")
    suspend fun confirmTicketByCode(
        @Field("ticket_code")
        Ticket_code : String )  : Response<ConfirmResponse>



    @FormUrlEncoded
    @POST("ticketSale.php")
    suspend fun ticketSale(
        @Field("event") event: String,
        @Field("ticket_type") ticket_type: String,
        @Field("phone") phone: String,
        @Field("email") email: String,
        @Field("code") code: String
    ) : Response<AuthResponse>


    companion object{
        operator fun invoke(
            networkConnectionInterceptor: NetworkConnectionInterceptor
        ) : MyApi{

            val okkHttpclient = OkHttpClient.Builder()
                .addInterceptor(networkConnectionInterceptor)
                .build()
            return Retrofit.Builder()
                .client(okkHttpclient)
                .baseUrl("http://192.168.0.28/android/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }

}

