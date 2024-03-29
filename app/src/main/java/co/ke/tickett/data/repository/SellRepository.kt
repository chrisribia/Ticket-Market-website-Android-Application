package co.ke.tickett.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import co.ke.tickett.data.db.AppDatabase
import co.ke.tickett.data.db.entity.Sell
import co.ke.tickett.data.db.entity.Summery
import co.ke.tickett.data.network.MyApi
import co.ke.tickett.data.network.Response.AuthResponse
import co.ke.tickett.data.network.SafeApiRequest
import co.ke.tickett.utils.Coroutines
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class SellRepository(private val api: MyApi,
                     private val db: AppDatabase
) :
    SafeApiRequest()  {

    private val balances = MutableLiveData<List<Sell>>()


    init {
        balances.observeForever {
            saveTickets(it)
        }
    }

    suspend fun getBalance(): LiveData<List<Sell>> {
        return withContext(Dispatchers.IO){
            fetchQuotes()
            db.getSellDao().tickes()
        }
    }

    private suspend fun fetchQuotes() {
try{
        val response = apiRequest { api.getSell() }
        balances.postValue(response.Tickets)}
catch (e:Exception){
    e.printStackTrace()
}

    }



    private fun saveTickets(sell: List<Sell>) {
        Coroutines.io {
            db.getSellDao().saveAllEvents(sell)
        }
    }

    fun getDetailsForSale(id : String) = db.getSellDao().ticketForSale(id)



    suspend fun makeSales(
        event: String,
        ticket_type: String,
        phone: String,
        email: String,
        code: String

    ) : AuthResponse {
        return apiRequest{ api.ticketSale(event,ticket_type,phone, email, code)}
    }

}