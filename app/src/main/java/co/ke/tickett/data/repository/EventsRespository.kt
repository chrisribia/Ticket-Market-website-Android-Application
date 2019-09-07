package co.ke.tickett.data.repository

import androidx.lifecycle.MutableLiveData
import co.ke.tickett.data.db.AppDatabase
import co.ke.tickett.data.db.entity.Events
import co.ke.tickett.data.network.MyApi
import co.ke.tickett.data.network.SafeApiRequest
import co.ke.tickett.utils.Coroutines

class EventsRespository(private val api: MyApi,
                        private val db: AppDatabase) : SafeApiRequest() {

    private val events = MutableLiveData<List<Events>>()


    init {
        events.observeForever {
            saveEvents(it)
        }
    }

    suspend fun fetchTickets() {
            val response = apiRequest { api.getEvents() }
            events.postValue(response.Tickets)

    }
    private fun saveEvents(events: List<Events>) {
        Coroutines.io {
            db.getEventsDao().saveAllEvents(events)
        }
    }

    fun findEvent(qr: String) = db.getEventsDao().findEvent(qr)
}