package co.ke.tickett.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import co.ke.tickett.data.db.AppDatabase
import co.ke.tickett.data.db.entity.Sell
import co.ke.tickett.data.db.entity.Summery
import co.ke.tickett.data.network.MyApi
import co.ke.tickett.data.network.SafeApiRequest
import co.ke.tickett.utils.Coroutines
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

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

        val response = apiRequest { api.getSell() }
        balances.postValue(response.Tickets)

    }



    private fun saveTickets(sell: List<Sell>) {
        Coroutines.io {
            db.getSellDao().saveAllEvents(sell)
        }
    }


}