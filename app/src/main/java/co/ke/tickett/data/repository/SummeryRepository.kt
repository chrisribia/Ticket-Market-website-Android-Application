package co.ke.tickett.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import co.ke.tickett.data.db.AppDatabase
import co.ke.tickett.data.db.entity.Summery
import co.ke.tickett.data.network.MyApi
import co.ke.tickett.data.network.SafeApiRequest
import co.ke.tickett.utils.Coroutines
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SummeryRepository(private val api: MyApi,
                        private val db: AppDatabase  ) : SafeApiRequest() {


    private val balances = MutableLiveData<List<Summery>>()


    init {
        balances.observeForever {
            saveSummery(it)
        }
    }

    suspend fun getBalance(): LiveData<List<Summery>> {
        return withContext(Dispatchers.IO){
            fetchQuotes()
            db.getSummeryDao().summery()
        }
    }

    private suspend fun fetchQuotes() {

            val response = apiRequest { api.getSummery() }
            balances.postValue(response.Events)

    }



    private fun saveSummery(summery: List<Summery>) {
        Coroutines.io {
            db.getSummeryDao().saveAllSummery(summery)
        }
    }


}