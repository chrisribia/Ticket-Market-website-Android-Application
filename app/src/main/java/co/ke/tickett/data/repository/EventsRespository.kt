package co.ke.tickett.data.repository

import androidx.lifecycle.MutableLiveData
import co.ke.tickett.data.db.AppDatabase
import co.ke.tickett.data.db.entity.Events
import co.ke.tickett.data.db.entity.Stats
import co.ke.tickett.data.network.MyApi
import co.ke.tickett.data.network.Response.ConfirmResponse
import co.ke.tickett.data.network.SafeApiRequest
import co.ke.tickett.utils.Coroutines
import java.lang.Exception

class EventsRespository(private val api: MyApi,
                        private val db: AppDatabase) :
    SafeApiRequest() {

    private val events = MutableLiveData<List<Events>>()
    private val balance = MutableLiveData<List<Stats>>()


    init {
        events.observeForever {
            saveEvents(it)
        }

        balance.observeForever {
            saveBalance(it)
        }
    }

    suspend fun fetchTickets() {
            val response = apiRequest { api.getEvents() }
            events.postValue(response.Events)

    }
    private fun saveEvents(events: List<Events>) {
        Coroutines.io {
            db.getEventsDao().saveAllEvents(events)
        }
    }

    fun findEvent(qr: String) = db.getEventsDao().findEvent(qr)
    fun findEventByCode(ticketCode: String) = db.getEventsDao().findEventByCode(ticketCode)

    private fun saveBalance(stats : List<Stats>){
        Coroutines.io {
            db.getStatsDao().saveBalance(stats)
        }
    }

    suspend fun confirmTicket(qr_code : String)  : ConfirmResponse{

        return apiRequest {  api.confirmTicket(qr_code)}
    }

}